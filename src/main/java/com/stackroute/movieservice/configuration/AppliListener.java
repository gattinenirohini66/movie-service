package com.stackroute.movieservice.configuration;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppliListener implements ApplicationListener<ContextRefreshedEvent> {
    private MovieRepository movieRepository;

    @Autowired
    Environment environment;
    @Value("${movieId1}")
    int movieId;

    @Autowired
    public AppliListener(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("application listener");
        movieRepository.save(new Movie(movieId,environment.getProperty("movieTitle1"),environment.getProperty("overview1")));
    }
}
