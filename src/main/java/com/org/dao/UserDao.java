package com.org.dao;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.org.model.Users;;

public interface UserDao extends JpaRepository<Users, Long>{
    Optional<Users> findByUserName(String username);
}