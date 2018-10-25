package models;

import java.util.Date;

public class ReimbursementRequest {
	private String type;
	private String status; // Going to be an enum. Ones we're going to use: pending, approved, denied
	private double amount;
	private Date submitted;
	private Date resolved;
	private String description;
	
}
