package com.stackroute.movieservice.service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exception.MovieAlreadyExistsException;
import com.stackroute.movieservice.exception.MovieNotFoundException;
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
    public Movie addMovie(Movie movie) throws MovieAlreadyExistsException {
        if (movieRepository.existsById(movie.getMovieId())){
            throw new MovieAlreadyExistsException("Movie Already Exists");
        }
        Movie addedMovie = movieRepository.save(movie);
        if(addedMovie==null){
            throw new MovieAlreadyExistsException("Movie Already Exists");
        }
        return addedMovie;
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
        Movie userUpdated = movieRepository.findById(id).get();
        userUpdated.setMovieTitle(movie.getMovieTitle());
        return movieRepository.save(userUpdated);
    }

    @Override
    public List<Movie> findByName(String name)throws MovieNotFoundException {
        List<Movie> mv = movieRepository.findByName(name);
        if(mv.isEmpty()){
            throw new MovieNotFoundException("Movie not found");
        }
        return mv;
    }

}
