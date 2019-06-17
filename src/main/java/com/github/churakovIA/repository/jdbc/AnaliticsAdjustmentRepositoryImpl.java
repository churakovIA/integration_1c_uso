package com.github.churakovIA.repository.jdbc;

import com.github.churakovIA.model.AnalyticsAdjustment;
import com.github.churakovIA.model.CoordinationStatus;
import com.github.churakovIA.repository.AnaliticsAdjustmentRepository;
import com.github.churakovIA.repository.CoordinationStatusesRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.github.churakovIA.repository.jdbc.RowMapperUtil.getAnaliticsAdjustmentRowMapper;
import static com.github.churakovIA.utils.UuidUtils.asBytes;

@Repository
public class AnaliticsAdjustmentRepositoryImpl implements AnaliticsAdjustmentRepository {

    private final JdbcTemplate jdbcTemplate;

    private final CoordinationStatusesRepository coordinationStatusesRepository;

    public AnaliticsAdjustmentRepositoryImpl(JdbcTemplate jdbcTemplate, CoordinationStatusesRepository coordinationStatusesRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.coordinationStatusesRepository = coordinationStatusesRepository;
    }

    @Override
    public List<AnalyticsAdjustment> getAll(int rowStart, int pageSize) {

        List<AnalyticsAdjustment> docs = jdbcTemplate.query(
                "select * from _Document482 order by _Date_Time desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY",
                getAnaliticsAdjustmentRowMapper(), rowStart, pageSize);
        setSatus(docs);
        return docs;
    }

    @Override
    public List<AnalyticsAdjustment> getAllFiltered(int rowStart, int pageSize, String filter) {
        String s = "%" + filter + "%";
        List<AnalyticsAdjustment> docs = jdbcTemplate.query(
                "select * from _Document482 " +
                        "where (_Number like ? or _Fld11025 like ?)" +
                        "order by _Date_Time desc " +
                        "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY",
                getAnaliticsAdjustmentRowMapper(), s, s, rowStart, pageSize);
        setSatus(docs);
        return docs;
    }

    @Override
    public AnalyticsAdjustment get(UUID uuid) {
        return DataAccessUtils.singleResult(jdbcTemplate.query(
                "SELECT * FROM _Document482 WHERE _IDRRef = ?",
                getAnaliticsAdjustmentRowMapper(),
                new SqlParameterValue(Types.BINARY, asBytes(uuid))));
    }

    private void setSatus(List<AnalyticsAdjustment> docs) {
        Map<UUID, CoordinationStatus> statuses = coordinationStatusesRepository.getLastByDocuments(docs).stream()
                .collect(Collectors.toMap(CoordinationStatus::getDocument, Function.identity()));
        docs.forEach(d -> statuses.computeIfPresent(d.getRef(), (k, v) -> {
            d.setStatus(v);
            return v;
        }));
    }

}
