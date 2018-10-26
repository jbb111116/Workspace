package daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import launcher.Logistics;
import models.ReimbursementRequest;

public class ReimbursementDao {
	private ReimbursementRequest extractRequest(ResultSet rs) throws SQLException {
		ReimbursementRequest extracted = new ReimbursementRequest();
		extracted.setAmount(rs.getDouble("reimb_amount"));
		extracted.setSubmitted(Logistics.sqlTimeToJavaTime(rs.getTimestamp("reimb_submitted")));
		extracted.setResolved(Logistics.sqlTimeToJavaTime(rs.getTimestamp("reimb_resolved")));
		extracted.setDescription(rs.getString("reimb_description"));
		extracted.setAuthor_id(rs.getInt("reim_author"));
		extracted.setReimb_type_id(rs.getInt("reimb_type_id"));
		
		return extracted;
	}
		
}
