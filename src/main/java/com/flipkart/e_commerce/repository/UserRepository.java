package com.flipkart.e_commerce.repository;

import com.flipkart.e_commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // 1️⃣ Find User by Email using Native Query
    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User findUserByEmail(@Param("email") String email);

    @Query(value = "SELECT * from users where phone_no : phone_no",nativeQuery = true)
    User findUserByPhoneNo(@Param("phone_no") long phone_no);

    @Query(value = "Select * from users where username : username",nativeQuery = true)
    User findUserByUsername(@Param("username") String username);

//    @Query("create table department")
//    createEntity



}
