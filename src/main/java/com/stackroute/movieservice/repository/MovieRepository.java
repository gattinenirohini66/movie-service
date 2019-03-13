package com.stackroute.movieservice.repository;

import com.stackroute.movieservice.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {

   /*Add an endpoint to search trackByName.
   Understand @Query and parameter passing to @Query
   */
   @Query(value = "select movie.movieTitle from Movie movie where movie.movieTitle = ?1")
    public List<Movie> findByName(String name);
}
