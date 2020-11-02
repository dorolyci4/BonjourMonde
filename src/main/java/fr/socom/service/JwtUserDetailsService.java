package fr.socom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.socom.domain.CustomUserDetails;
import fr.socom.domain.User;
import fr.socom.repository.UserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("UserName " + username + " not found");
		}

		return new CustomUserDetails(user);
	}

	public User save(User user) {
		return userRepository.save(user);

	}

}