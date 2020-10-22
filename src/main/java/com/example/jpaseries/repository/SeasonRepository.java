package com.example.jpaseries.repository;

import com.example.jpaseries.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season,Long> {
}
