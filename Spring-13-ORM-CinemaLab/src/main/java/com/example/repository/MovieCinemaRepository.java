package com.example.repository;

import com.example.entity.Movie;
import com.example.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id


    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id

    Integer countByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id

    Integer countByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date

    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime dateTime);

    //Write a derived query to find the top 3 expensive movies

    List<MovieCinema> findTop3ByOrderByMoviePriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name

    List<MovieCinema> findAllByMovieNameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location name

    List<MovieCinema> findAllByCinemaLocationName(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query(value="SELECT mc FROM MovieCinema mc WHERE mc.dateTime > '?1'")
    List<MovieCinema> getAllCinemaAfterDateTime(LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id

    @Query(value="SELECT COUNT(*) FROM MovieCinema WHERE cinema_id ='?1'",nativeQuery = true)
    Integer countByCinemaId(Long cinemaId);

    //Write a native query that returns all movie cinemas by location name

    @Query(value="SELECT * FROM " +
            " movie_cinema mc JOIN cinema c ON mc.cinema_id = c.id" +
            " JOIN location l ON c.location_id=l.id" +
            " WHERE l.name = '1?'",nativeQuery = true)
    List<MovieCinema> findAllMovieCinemaByLocationName(String locationName);
}
