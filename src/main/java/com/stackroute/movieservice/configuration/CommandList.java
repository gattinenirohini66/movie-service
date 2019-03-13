package com.stackroute.movieservice.configuration;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandList implements CommandLineRunner {
    private String name;
    private MovieRepository movieRepository;

    @Autowired
    public CommandList(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("command line");
        movieRepository.save(new Movie(2,"mari","movie-data-2"));
    }
}
