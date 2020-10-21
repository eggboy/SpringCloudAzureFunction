package com.microsoft.openhack;

import com.microsoft.openhack.domain.Ratings;
import com.microsoft.openhack.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;

@SpringBootApplication
public class RatingsApiApplication {

    @Autowired
    RatingsService ratingsService;

    public static void main(String[] args) {
        SpringApplication.run(RatingsApiApplication.class, args);
    }

    @Bean
    public Function<String, List<Ratings>> getRatings() {
        return userId -> ratingsService.getRatingsByUserId(userId);
    }

}
