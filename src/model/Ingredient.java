package model;

import java.io.Serializable;

public class Ingredient implements Serializable {
	
	private static final long serialVersionUID = 1;
	private int id;
	private String name;
	private boolean enabled;
	private User creator;
	private User modifier;
	
	public Ingredient(String name, User creator, int id) {
		this.name = name;
		this.enabled = true;
		this.creator = creator;
		this.modifier = creator;
		this.id = id; 
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		String status = "";
		if(enabled==false) {
			status = "Deshabilitado";
		}else {
			status = "Habilitado";
		}
		return status;
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
}
