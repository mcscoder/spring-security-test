package com.spring.boot.mysql.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.spring.boot.mysql.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
