package com.example.repository;

import com.example.entity.Ticket;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought (by user id)

    Integer countTicketsBy(Long id);

    //Write a derived query to list all tickets by specific email

    List<Ticket> findAllByUserAccount_Email (String email);

    //Write a derived query to count how many tickets are sold for a specific movie name

    Integer countTicketsByMovieName(String name);

    //Write a derived query to list all tickets between a range of dates

    List<Ticket> findAllByDateTimeBetween(LocalDateTime date1, LocalDateTime date2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user (userId
    @Query(value="SELECT t from Ticket t WHERE t.userAccount.id =?1 ")
    List<Ticket> findAllByUserAccount(Long userId);

    //Write a JPQL query that returns all tickets between a range of dates

    @Query(value = "SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 AND ?2")
    List<Ticket> findAllByDateRange(LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query(value="SELECT COUNT(*) FROM ticket WHERE user_account_id = ?1",nativeQuery = true)
    Integer countNumberOfTickets(Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates

    @Query (value = "SELECT COUNT(*) from ticket WHERE id = ?1 date_time BETWEEN ?2 and ?3", nativeQuery = true)
    Integer countAllTicketsBetweenDates(Long id, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);

    //Write a native query to distinct all tickets by movie name

    @Query(value = "SELECT DISTINCT m.name " +
            "FROM ticket t JOIN movie_cinema mc ON t.movie_cinema_id " +
            "JOIN movie m ON mc.movie_id = m.id WHERE m.name = ?1", nativeQuery = true)
    List<String> findDistinctTicketsByMovieName();

    //Write a native query to find all tickets by user email

    @Query(value = "SELECT * FROM ticket t " +
            "JOIN user_account ua on t.user_account_id = t.id " +
            "WHERE email = ?1", nativeQuery = true)
    List<Ticket> findAllByUserEmail(String email);

    //Write a native query that returns all tickets

    @Query(value="SELECT * FROM ticket",nativeQuery = true)
    List<Ticket> findAllTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name

    @Query(value = "SELECT * FROM ticket t JOIN movie_cinema mc on t.movie_cinema_id = mc.id " +
            "JOIN movie m on mc.movie_id = m.id " +
            "JOIN user_account ua on t.user_account_id = ua.id " +
            "JOIN account_details ad on ua.account_details_id = ad.id " +
            "WHERE ua.username ILIKE concat('%','?1','%') " +
            "OR ad.name ILIKE concat ('%','?1','%') " +
            "OR m.name ILIKE concat('%','?1','%')",nativeQuery = true)
    List<Ticket> findAllTicketUserNameOrNameOrMovieNameContain(String someName);
}
