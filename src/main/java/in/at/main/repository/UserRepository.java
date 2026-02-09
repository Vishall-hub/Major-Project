package in.at.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.at.main.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

	
    
    
}

