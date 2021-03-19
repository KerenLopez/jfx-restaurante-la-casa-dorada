package model;

public abstract class Person {
	private String name;
	private String lastName;
	private String id;
	private boolean enabled;
	
	private User creator;
	private User modifier;
	
	public Person(String name, String lastName, String id) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.enabled = true;
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
	
	
	
	
	
	
	
	
}
