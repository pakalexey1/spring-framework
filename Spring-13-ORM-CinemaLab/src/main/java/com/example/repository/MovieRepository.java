package com.example.repository;

import com.example.entity.Movie;
import com.example.enums.MovieState;
import com.example.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name

    Optional<Movie> findByName(String name);

    //Write a derived query to list all movies between a range of prices

    List<Movie> findAllByPriceBetween(BigDecimal priceFrom, int priceTo);

    //Write a derived query to list all movies where duration exists in the specific list of duration

    List<Movie> findByDurationIn(List<Integer> durations);

    //Write a derived query to list all movies with higher than a specific release date

    List<Movie> findByReleaseDateAfter(LocalDate date);

    //Write a derived query to list all movies with a specific state and type

    List<Movie> findAllByStateAndType(MovieState state, MovieType type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices

    @Query(value="SELECT m FROM Movie m WHERE m.price BETWEEN ?1 and ?2 ")
    List<Movie> getByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);

    //Write a JPQL query that returns all movie names

    @Query(value="SELECT m.name FROM Movie m")
    List<String> fetchAllMovieNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name

    @Query(value = "SELECT * FROM movie WHERE name = 1?",nativeQuery = true)
    Optional<Movie> getMovie(String name);

    //Write a native query that return the list of movies in a specific range of prices

    @Query(value = "SELECT * FROM movie  WHERE price BETWEEN 1? and 2?", nativeQuery = true)
    List<Movie> findMovieByPriceRange(BigDecimal startPrice, BigDecimal endPrice);

    //Write a native query to return all movies where duration exists in the range of duration

    @Query(value="SELECT * FROM movie WHERE duration in 1?",nativeQuery = true)
    List<Movie> findByDurationsIn(List<Integer> durations);

    //Write a native query to list the top 5 most expensive movies

    @Query(value="SELECT * FROM movie ORDER BY price DESC LIMIT 5",nativeQuery = true)
    List<Movie> listTop5ExpensiveMovies();

}
