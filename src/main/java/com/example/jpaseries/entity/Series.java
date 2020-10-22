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
public class Series {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Singular
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Season> seasons;

}
