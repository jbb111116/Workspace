package models;

public class JunctionTable {
	private long account_id;
	private String username;
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (account_id ^ (account_id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		JunctionTable other = (JunctionTable) obj;
		if (account_id != other.account_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JunctionTable [account_id=" + account_id + ", username=" + username + "]";
	}
	public JunctionTable(long account_id, String username) {
		super();
		this.account_id = account_id;
		this.username = username;
	}
	public JunctionTable() {
		super();
	}
	
	
}
