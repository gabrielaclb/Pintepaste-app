package models;

public class SessionModel extends ModelClass {
	private String name, username, email;
	private int id;
	private boolean blocked_status;
	
	public boolean isBlocked_status() {
		return blocked_status;
	}
	
	public void setBlocked_status(boolean blocked_status) {
		this.blocked_status = blocked_status;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
