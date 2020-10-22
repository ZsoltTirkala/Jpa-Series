package com.example.jpaseries.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Season {

    @Id
    @GeneratedValue
    private long id;
    private int numberOfSeason;
    private LocalDate releaseDate;
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Episode> episodes;
}
