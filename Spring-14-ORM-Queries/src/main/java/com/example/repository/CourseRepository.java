package com.example.repository;

import com.example.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category using derived query
    List<Course> findByCategory(String category);

    //find all courses by category and order entities by name
    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the provided name exists. return true if the course exists, false otherwise
    boolean existsByName(String name);

    //return a count of courses for the provided category
    int countByCategory(String category);

    //find all courses that start with provided course name
    List<Course> findByNameStartingWith(String name);

    //find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);

    @Query("SELECT c FROM Course c WHERE c.category=:category AND c.rating>:rating ")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);


}
