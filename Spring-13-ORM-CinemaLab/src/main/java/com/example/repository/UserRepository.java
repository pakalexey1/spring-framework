package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<User> findByEmail(String email);

    //Write a derived query to read a user with a username?
    Optional<User> findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> findAllByAccountNameContaining (String accountName);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findAllByAccountNameContainingIgnoreCase (String accountName);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccountAgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findUserByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM User u WHERE u.username=?1")
    Optional<User> findUserByUsername(String username);

    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM User u")
    List<User> fetchMeAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?

    @Query(value="SELECT * FROM user_account u JOIN account_details a " +
            "ON u.accound_details_id = a.id " +
            "WHERE a.name ILIKE ('%'+?1+'%')", nativeQuery = true)
    List<User> fetchAllUsersByName(String name);

    //Write a native query that returns all users?
    @Query(value="SELECT * FROM user_account",nativeQuery = true)
    List<User> fetchAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(value="SELECT * FROM user_account u JOIN account_detail a " +
            "ON u.account_details_id = a.id " +
            "WHERE a.age BETWEEN ?1 AND ?2",nativeQuery = true)
    List<User> fetchAllUsersWithinAgeRange(Integer ageFrom, Integer ageTo);

    //Write a native query to read a user by email?
    @Query(value="SELECT * FROM user_account u WHERE a.email = ?1",nativeQuery = true)
    List<User> fetchAllUsersByEmail(String email);
}
