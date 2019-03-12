package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public void delById(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie update(Movie movie, int id) {
        Movie movieUpdated = movieRepository.findById(id).get();
        movieUpdated.setMovieTitle(movie.getMovieTitle());
        return movieRepository.save(movieUpdated);
    }
}
