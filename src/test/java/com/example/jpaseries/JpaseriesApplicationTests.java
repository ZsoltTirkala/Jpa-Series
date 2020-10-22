package com.example.jpaseries;

import com.example.jpaseries.entity.Episode;
import com.example.jpaseries.entity.Season;
import com.example.jpaseries.entity.Series;
import com.example.jpaseries.repository.EpisodeRepository;
import com.example.jpaseries.repository.SeasonRepository;
import com.example.jpaseries.repository.SeriesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaseriesApplicationTests {




    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeriesRepository seriesRepository;


    @Test
    void savedOneEpisodeElement() {
        Episode episode = Episode.builder().build();
        episodeRepository.save(episode);
        List<Episode> episodeList = episodeRepository.findAll();
        assertThat(episodeList).hasSize(1);
    }


    @Test
    void saveOneSeasonElement() {
        Season season = Season.builder().build();
        seasonRepository.save(season);
        List<Season> seasonList = seasonRepository.findAll();
        assertThat(seasonList).hasSize(1);
    }

    @Test
    void savedOneSeriesElement() {
        Series series = Series.builder().build();
        seriesRepository.save(series);
        List<Series> seriesList = seriesRepository.findAll();
        assertThat(seriesList).hasSize(1);
    }


}
