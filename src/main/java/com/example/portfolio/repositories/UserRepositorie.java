package com.example.portfolio.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.portfolio.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorie  extends  JpaRepository<User,Long> {
    User getUserByUsernameAndPassword(String username, String password);
    User getUserByUsername(String username);

}
