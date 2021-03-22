package model;

public abstract class Person {
	private String name;
	private String lastName;
	private String id;
	private boolean enabled;
	
	private User creator;
	private User modifier;
	
	public Person(String name, String lastName, String id, User creator) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.enabled = true;
		this.creator=creator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		String name;
		if(creator==null) {
			name="-";
		}else {
			name = creator.getUserName();
		}
		return name;
	}
	
	public String getModifierName() {
		String name;
		if(modifier==null) {
			name="-";
		}else {
			name = modifier.getUserName();
		}
		return name;
	}	
	
	public String toString() {
		return name+" "+lastName+"|"+id;
	}
}
