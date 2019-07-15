package com.github.churakovIA.repository.jdbc;

import com.github.churakovIA.model.AbstractDocument;
import com.github.churakovIA.model.AnalyticsAdjustment;
import com.github.churakovIA.model.CoordinationStatus;
import com.github.churakovIA.utils.UuidUtils;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;

class RowMapperUtil {

    private static <T extends AbstractDocument> T fill(ResultSet rs, T doc) throws SQLException {
        doc.setRef(UuidUtils.asUuid(rs.getBytes("_IDRRef")));
        doc.setNumber(rs.getString("_Number"));
        doc.setDateTime(rs.getTimestamp("_Date_Time").toLocalDateTime()
                .minus(2000, ChronoUnit.YEARS));
        doc.setMarked(rs.getBytes("_Marked")[0] == 1);
        doc.setPosted(rs.getBytes("_Posted")[0] == 1);
        return doc;
    }

    static RowMapper<AnalyticsAdjustment> getAnaliticsAdjustmentRowMapper() {
        return (rs, rowNum) -> fill(rs, new AnalyticsAdjustment(rs.getString("_Fld11025")));
    }

    static RowMapper<CoordinationStatus> getCoordinationStatusesRowMapper() {
        return (rs, rowNum) -> {
            CoordinationStatus status = new CoordinationStatus();
            status.setPeriod(rs.getTimestamp("_Period").toLocalDateTime()
                    .minus(2000, ChronoUnit.YEARS));
            status.setDocument(UuidUtils.asUuid(rs.getBytes("_Fld31992_RRRef")));
            status.setStatus(rs.getString("_Description"));
            return status;
        };
    }

}
