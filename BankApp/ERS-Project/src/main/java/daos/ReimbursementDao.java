package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import launcher.Logistics;
import models.ReimbursementRequest;
import models.User;
import util.ConnectionUtil;

public class ReimbursementDao {
	private ReimbursementRequest extractRequest(ResultSet rs) throws SQLException {
		ReimbursementRequest extracted = new ReimbursementRequest();
		extracted.setAmount(rs.getFloat("reimb_amount"));
		extracted.setDescription(rs.getString("reimb_description"));
		extracted.setAuthor_id(rs.getInt("reim_author"));
		extracted.setType_id(rs.getInt("reimb_type_id"));
		
		return extracted;
	}
		
	public List<ReimbursementRequest> allRequests(){
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM reimbursement;";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			List<ReimbursementRequest> requests = new ArrayList<>();
			while(rs.next()) {
				ReimbursementRequest request = extractRequest(rs);
				requests.add(request);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ReimbursementRequest  createRequest(ReimbursementRequest request) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "INSERT INTO reimbursement(reimb_amount,reimb_submitted,\r\n"
							+"reimb_resolved,reimb_description,reimb_receipt, reimb_author, reimb_resolver,\r\n" 
							+"reimb_status_id, reimb_type_id) \r\n"
							+"VALUES(?,CURRENT_TIMESTAMP,null,?,null,?,null,1,?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, request.getAmount());
			ps.setString(2, request.getDescription());
			ps.setInt(3,request.getAuthor_id());
			ps.setInt(4,request.getType_id());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			request.setReimbursement_id(rs.getInt("reimb_id"));
			return request;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
