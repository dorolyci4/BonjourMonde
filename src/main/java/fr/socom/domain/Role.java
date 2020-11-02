package fr.socom.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;	

	Role() { 
	} 

	public Role(String name) { 
		this.name = name; 
	} 


	public String getName() { 
		return name; 
	} 

	public void setName(String name) { 
		this.name = name; 
	} 
}
