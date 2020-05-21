package com.example.OAuth2Example.DAO;

import com.example.OAuth2Example.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Artur
 */
public interface UserRepository extends JpaRepository<User, String>{
    
}
