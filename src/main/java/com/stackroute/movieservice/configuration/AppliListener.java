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

/* *Running Logic on Startup in Spring. Create seed data to pre-fill the database with movie information whenever the application starts.
        * Use both approaches:
            Approach 1: ApplicationListener<ContextRefreshedEvent>
            Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)

    *Remove all hard coded data from the application code to application.properties
    a)by using @Value.
    b)by using @PropertySource
    c)by using Environment (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.htm
*/

@Component
@PropertySource("classpath:application.properties")
public class AppliListener implements ApplicationListener<ContextRefreshedEvent> {
    private MovieRepository movieRepository;

    // using propertysource and value for cdata
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
        movieRepository.save(new Movie(movieId, environment.getProperty("movieTitle1"), environment.getProperty("overview1")));
    }
}
