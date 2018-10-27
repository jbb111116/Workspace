package models;

import java.util.Date;

public class ReimbursementRequest {
	private int reimbursement_id;
	private double amount;
	private Date submitted;
	private Date resolved;
	private String description;
	private int author_id;
	private int resolver_id;
	private int status; // Going to be an enum. Ones we're going to use: pending, approved, denied
	private int type_id;
	public int getReimbursement_id() {
		return reimbursement_id;
	}
	public void setReimbursement_id(int reimbursement_id) {
		this.reimbursement_id = reimbursement_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}
	public Date getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getResolver_id() {
		return resolver_id;
	}
	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + author_id;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reimbursement_id;
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + resolver_id;
		result = prime * result + status;
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + type_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementRequest other = (ReimbursementRequest) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author_id != other.author_id)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reimbursement_id != other.reimbursement_id)
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolver_id != other.resolver_id)
			return false;
		if (status != other.status)
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (type_id != other.type_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReimbursementRequest [reimbursement_id=" + reimbursement_id + ", amount=" + amount + ", submitted="
				+ submitted + ", resolved=" + resolved + ", description=" + description + ", author_id=" + author_id
				+ ", resolver_id=" + resolver_id + ", status=" + status + ", type_id=" + type_id + "]";
	}
	public ReimbursementRequest(int reimbursement_id, double amount, Date submitted, Date resolved, String description,
			int author_id, int resolver_id, int status, int type_id) {
		super();
		this.reimbursement_id = reimbursement_id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author_id = author_id;
		this.resolver_id = resolver_id;
		this.status = status;
		this.type_id = type_id;
	}
	public ReimbursementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
