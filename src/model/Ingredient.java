package model;

public class Ingredient {
	
	private int id;
	private String name;
	private boolean enabled;
	private User creator;
	private User modifier;
	
	public Ingredient(String name, User creator) {
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
	
	public String getStatus() {
		String status = "";
		if(enabled==true) {
			status = "Habilitado";
		}else {
			status = "Deshabilitado";
		}
		return status;
	}
	
	public boolean getEnabled() {
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
	
	public String getCreatorName() {
		String name = creator.getName();
		return name;
	}
	
	public User getModifier() {
		return modifier;
	}
	
	public void setModifier(User modifier) {
		this.modifier = modifier;
	}
	
	public String getModifierName() {
		String name = modifier.getName();
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
