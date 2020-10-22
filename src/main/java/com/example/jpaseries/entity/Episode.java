package com.example.jpaseries.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Episode {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int part;
    private LocalDate releaseDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Season season;
}
