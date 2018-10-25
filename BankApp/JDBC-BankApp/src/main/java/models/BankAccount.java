package models;

public class BankAccount {
	private long account_id;
	private boolean joint_account;
	private float balance;
	private boolean approved;
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public boolean isJoint_account() {
		return joint_account;
	}
	public void setJoint_account(boolean joint_account) {
		this.joint_account = joint_account;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (account_id ^ (account_id >>> 32));
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(balance);
		result = prime * result + (joint_account ? 1231 : 1237);
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
		BankAccount other = (BankAccount) obj;
		if (account_id != other.account_id)
			return false;
		if (approved != other.approved)
			return false;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		if (joint_account != other.joint_account)
			return false;
		return true;
	}
	public BankAccount(long account_id, boolean joint_account, float balance, boolean approved) {
		super();
		this.account_id = account_id;
		this.joint_account = joint_account;
		this.balance = balance;
		this.approved = approved;
	}
	public BankAccount() {
		super();
	}
	@Override
	public String toString() {
		return "BankAccount [account_id=" + account_id + ", joint_account=" + joint_account + ", balance=" + balance
				+ ", approved=" + approved + "]";
	}
	
	
}
