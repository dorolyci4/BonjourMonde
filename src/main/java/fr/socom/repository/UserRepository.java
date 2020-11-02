package fr.socom.repository;

import org.springframework.data.repository.CrudRepository;

import fr.socom.domain.User;

 public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	
}