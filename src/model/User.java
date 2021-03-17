package model;

public class User extends Employee {
	private String userName;
	private String password;
	
	public User(String name, String lastName, String id, String userName, String password) {
		super(name, lastName, id);
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
