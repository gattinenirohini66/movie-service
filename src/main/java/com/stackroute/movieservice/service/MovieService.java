package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    public Movie addMovie(Movie movie);
    public List<Movie> getAllMovies();
    public Optional<Movie> getMovieById(int id);
    public void delById(int id);
    public Movie update(Movie movie,int id);
}
