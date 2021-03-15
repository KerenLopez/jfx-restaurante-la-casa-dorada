package model;

public class Ingredient {
	private String name;
	private boolean enabled;
	
	private User creator;
	private User modifier;
	public Ingredient(String name, User creator) {
		super();
		this.name = name;
		this.enabled = true;
		this.creator = creator;
		this.modifier = creator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
