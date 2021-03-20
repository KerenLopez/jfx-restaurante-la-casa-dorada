package model;

public class User {
	private String id;
	private Employee employee;
	private String userName;
	private String password;
	private User creator;
	private User modifier;
	private boolean enabled;
	
	public User(Employee employee,String userName, String password) {
		this.employee=employee;
		this.userName = userName;
		this.password = password;
		this.id=employee.getId();
		this.enabled=true;
		
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

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getModifier() {
		return modifier;
	}

	public void setModifier(User modifier) {
		this.modifier = modifier;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getEmployeeName() {
		return employee.getName();
	}
	
	public String getEmployeeLastName() {
		return employee.getLastName();
	}
	
	public String getStatus() {
		String status = "";
		if(enabled) {
			status = "Habilitado";
		}else {
			status = "Deshabilitado";
		}
		return status;
	}
	
	public String getCreatorName() {
		String name = creator.getUserName();
		return name;
	}
	
	public String getModifierName() {
		String name = modifier.getUserName();
		return name;
	}
	
	
}
