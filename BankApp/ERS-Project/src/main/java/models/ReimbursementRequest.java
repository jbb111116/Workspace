package models;

import java.util.Date;

public class ReimbursementRequest {
	private Enum status; // Going to be an enum. Ones we're going to use: pending, approved, denied
	private double amount;
	private Date submitted;
	private Date resolved;
	private String description;
	private int author_id;
	private int reimb_type_id;
	public Enum getStatus() {
		return status;
	}
	public void setStatus(Enum status) {
		this.status = status;
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
	public int getReimb_type_id() {
		return reimb_type_id;
	}
	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
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
		result = prime * result + reimb_type_id;
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
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
		if (reimb_type_id != other.reimb_type_id)
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReimbursementRequest [status=" + status + ", amount=" + amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", description=" + description + ", author_id=" + author_id
				+ ", reimb_type_id=" + reimb_type_id + "]";
	}
	public ReimbursementRequest(Enum status, double amount, Date submitted, Date resolved, String description,
			int author_id, int reimb_type_id) {
		super();
		this.status = status;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author_id = author_id;
		this.reimb_type_id = reimb_type_id;
	}
	public ReimbursementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
