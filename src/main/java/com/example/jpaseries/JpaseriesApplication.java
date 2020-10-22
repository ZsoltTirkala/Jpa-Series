package com.example.jpaseries;

import com.example.jpaseries.entity.Episode;
import com.example.jpaseries.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class JpaseriesApplication {

    @Autowired
    private EpisodeRepository episodeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaseriesApplication.class, args);
    }



    @Bean
    public CommandLineRunner init() {
        return args -> {
            Episode episode = Episode.builder()
                    .name("first")
                    .part(3)
                    .releaseDate(LocalDate.of(2020,10,22))
                    .build();
            episodeRepository.save(episode);
        };
    }

}


