package com.softserve.repository;

import com.softserve.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);


    @Query(value = "SELECT u FROM User u " +
            "WHERE u.firstName LIKE '%' || :keyword || '%' " +
            "OR u.email LIKE '%' || :keyword || '%' " +
            "OR u.lastName LIKE '%' || :keyword || '%'")
    List<User> search(@Param("keyword")String keyword);
}
