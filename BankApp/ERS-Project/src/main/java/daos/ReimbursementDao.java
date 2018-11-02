package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.ReimbursementRequest;
import models.User;
import util.ConnectionUtil;

public class ReimbursementDao {
	
	/*
	 * extractCompletedRequest is supposed to extract only requests that have been 
	 * processed. We would automatically assign all the fields of the object from 
	 * the table data that is extracted. No presets are needed for our object.
	 */
	private ReimbursementRequest extractCompletedRequest(ResultSet rs) throws SQLException {
		ReimbursementRequest extracted = new ReimbursementRequest();
		extracted.setAmount(rs.getBigDecimal("reimb_amount"));
		extracted.setDescription(rs.getString("reimb_description"));
		extracted.setAuthor_id(rs.getInt("reim_author"));
		extracted.setResolver_id(rs.getInt("reimb_resolver"));
		extracted.setReimbursement_id(rs.getInt("reimb_id"));
		extracted.setSubmitted(rs.getDate("reimb_submitted"));
		extracted.setResolved(rs.getDate("reimb_resolved"));
		extracted.setStatus_id(rs.getInt("reimb_status_id"));
		extracted.setType_id(rs.getInt("reimb_type_id"));
		
		System.out.println("User extracted!");
		return extracted;
	}
	
	/*
	 * extractPendingRequest() is supposed to extract only request that have not been
	 * processed. We would have to assign all the null integers as '0' ourselves.
	 */
	private ReimbursementRequest extractPendingRequest(ResultSet rs) throws SQLException {
		ReimbursementRequest extracted = new ReimbursementRequest();
		extracted.setAmount(rs.getBigDecimal("reimb_amount"));
		extracted.setDescription(rs.getString("reimb_description"));
		extracted.setAuthor_id(rs.getInt("reim_author"));
		extracted.setResolver_id(0);
		extracted.setReimbursement_id(rs.getInt("reimb_id"));
		extracted.setSubmitted(rs.getDate("reimb_submitted"));
		extracted.setResolved(null);
		extracted.setStatus_id(rs.getInt("reimb_status_id"));
		extracted.setType_id(rs.getInt("reimb_type_id"));
		
		System.out.println("User extracted!");
		return extracted;
	}
		
	
	/*
	 * Works with extractCompletedRequest() to extract a list of reimbursements that have 
	 * been processed.
	 */
	public List<ReimbursementRequest> AllCompletedRequests(){
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM reimbursement WHERE reimb_status_id > 1;";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			List<ReimbursementRequest> requests = new ArrayList<>();
			while(rs.next()) {
				ReimbursementRequest request = extractCompletedRequest(rs);
				requests.add(request);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * Works with extractPendingRequests() to extract a list of reimbursements that have
	 * not been processed.
	 */
	public List<ReimbursementRequest> AllPendingRequests(){
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM reimbursement WHERE reimb_status_id = 1;";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			List<ReimbursementRequest> requests = new ArrayList<>();
			while(rs.next()) {
				ReimbursementRequest request = extractPendingRequest(rs);
				requests.add(request);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Creates a new request that just sends to the database.
	public ReimbursementRequest  createRequest(ReimbursementRequest request) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String query = "INSERT INTO reimbursement(reimb_amount,"
							+ "reimb_submitted,\r\n"
							+"reimb_resolved,"
							+ "reimb_description,"
							+ "reimb_receipt, "
							+ "reimb_author,"
							+ " \r\n" 
							+"reimb_status_id, "
							+ "reimb_type_id) \r\n"
							+"VALUES(?,CURRENT_TIMESTAMP,?,?,null,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setBigDecimal(1, request.getAmount());
			ps.setDate(2, request.getResolved());
			ps.setString(3, request.getDescription());
			ps.setInt(4,request.getAuthor_id());
//			ps.setInt(5,(Integer)null); // resolver_id
			ps.setInt(5, request.getStatus_id());
			ps.setInt(6, request.getType_id());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			request.setReimbursement_id(rs.getInt("reimb_id"));
			request.setSubmitted(rs.getDate("reimb_submitted"));
			return request;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Extracts all pending request of a User
	public List<ReimbursementRequest> UserPendingRequests(String username){
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description,reimb_author,reimb_resolver) \r\n" + 
					"FROM reimbursement LEFT JOIN users ON reimbursement.reimb_author = users.users_id WHERE username = ? AND reimbursement.reimb_status_id = 1;";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			List<ReimbursementRequest> requests = new ArrayList<>();
			while(rs.next()) {
				ReimbursementRequest request = extractPendingRequest(rs);
				requests.add(request);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Extracts all processed requests of a User
	public List<ReimbursementRequest> UserProcessedRequests(String username){
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description,reimb_author,reimb_resolver) \r\n" + 
					"FROM reimbursement LEFT JOIN users ON reimbursement.reimb_author = users.users_id WHERE username = ? AND reimbursement.reimb_status_id > 1;";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			List<ReimbursementRequest> requests = new ArrayList<>();
			while(rs.next()) {
				ReimbursementRequest request = extractCompletedRequest(rs);
				requests.add(request);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
