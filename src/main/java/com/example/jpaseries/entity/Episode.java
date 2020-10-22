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
public class Episode {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int part;
    @ElementCollection
    @Singular
    private Set<String> actors;
    private LocalDate releaseDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Season season;
}
