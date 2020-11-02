package fr.socom.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L; 
	private Collection<? extends GrantedAuthority> authorities;
	private User user; 
	
	public CustomUserDetails(User user) { 
		this.user = user; 
		this.authorities = translate(user.getRoles()); 
	} 


	private Collection<? extends GrantedAuthority> translate(List<Role> roles) { 
		List<GrantedAuthority> authorities = new ArrayList<>(); 
		for (Role role : roles) { 
			String name = role.getName().toUpperCase(); 
			
			authorities.add(new SimpleGrantedAuthority(name)); 
		} 
		return authorities; 
	} 

	@Override 
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		return authorities; 
	} 

	
	@Override 
	public boolean isAccountNonExpired() { 
		return true; 
	} 

	@Override 
	public boolean isAccountNonLocked() { 
		return true; 
	} 

	@Override 
	public boolean isCredentialsNonExpired() { 
		return true; 
	} 

	@Override 
	public boolean isEnabled() { 
		return true; 
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getUser().getPassword();
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getUser().getUsername();
	} 
	
}
