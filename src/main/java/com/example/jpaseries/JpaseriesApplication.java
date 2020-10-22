package com.example.jpaseries;

import com.example.jpaseries.entity.Episode;
import com.example.jpaseries.entity.Genre;
import com.example.jpaseries.entity.Season;
import com.example.jpaseries.entity.Series;
import com.example.jpaseries.repository.EpisodeRepository;
import com.example.jpaseries.repository.SeasonRepository;
import com.example.jpaseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class JpaseriesApplication {


    @Autowired
    private SeriesRepository seriesRepository;


    public static void main(String[] args) {
        SpringApplication.run(JpaseriesApplication.class, args);
    }



    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        Set<Episode> episodeSet = new HashSet<>();
        return args -> {
            Episode episode = Episode.builder()
                    .name("first")
                    .part(3)
                    .releaseDate(LocalDate.of(2020,10,22))
                    .actor("John Doe")
                    .build();
            episodeSet.add(episode);

            Season season = Season.builder()
                    .numberOfSeason(2)
                    .releaseDate(LocalDate.of(2020,10,22))
                    .episodes(episodeSet)
                    .build();

            episode.setSeason(season);

            Series series = Series.builder()
                    .name("The Asd")
                    .releaseDate(LocalDate.of(2012,12,15))
                    .season(season)
                    .actor("John Doe")
                    .actor("Jane Doe")
                    .genre(Genre.DOCUMENTUM)
                    .build();
            season.setSeries(series);
            seriesRepository.save(series);

        };
    }

}


