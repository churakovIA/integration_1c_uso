package com.github.churakovIA.repository.jdbc;

import com.github.churakovIA.model.CanCoordinated;
import com.github.churakovIA.model.CoordinationStatus;
import com.github.churakovIA.repository.CoordinationStatusesRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.churakovIA.repository.jdbc.RowMapperUtil.getCoordinationStatusesRowMapper;
import static com.github.churakovIA.utils.UuidUtils.asBytes;

@Repository
public class CoordinationStatusesRepositoryImpl implements CoordinationStatusesRepository {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CoordinationStatusesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public List<CoordinationStatus> getLastByDocuments(List<? extends CanCoordinated> docs) {
        if (docs == null || docs.size() == 0) {
            return Collections.emptyList();
        }
        String sql = "SELECT\n" +
                "    _Period, _Fld31992_RRRef, _Fld31993RRef, _Reference31577._Description\n" +
                "FROM _InfoRg31991 AS InfoRg\n" +
                "INNER JOIN (\n" +
                "    select MAX(_Period) AS MaxPeriod,\n" +
                "           _Fld31992_RRRef AS ref\n" +
                "    from _InfoRg31991\n" +
                "GROUP BY _Fld31992_RRRef) AS MaxPeriods\n" +
                "ON InfoRg._Fld31992_RRRef = MaxPeriods.ref\n" +
                "AND InfoRg._Period = MaxPeriods.MaxPeriod\n" +
                "INNER JOIN _Reference31577 ON InfoRg._Fld31993RRef = _Reference31577._IDRRef\n" +
                "WHERE _Fld31992_RRRef IN (:docs)";

        SqlParameterSource namedParameters = new MapSqlParameterSource("docs", docs.stream()
                .map((CanCoordinated d) -> new SqlParameterValue(Types.BINARY, asBytes(d.getRef())))
                .collect(Collectors.toList()));

        return namedParameterJdbcTemplate
                .query(sql, namedParameters, getCoordinationStatusesRowMapper());
    }
}
