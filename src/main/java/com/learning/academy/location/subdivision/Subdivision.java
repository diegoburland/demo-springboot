package com.learning.academy.location.subdivision;

import com.learning.academy.location.country.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subdivision")
public class Subdivision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String capital;

    @Column(nullable = false)
    private Long population;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private Double gdp;

    @Column(nullable = false)
    private Double gdpPerCapita;

    @Column(nullable = false)
    private String timezone;

    @ElementCollection
    @Column(nullable = false)
    private List<String> languages;

    @ElementCollection
    @Column(nullable = false)
    private List<String> currencies;

    @ElementCollection
    @Column(nullable = false)
    private List<String> neighbors;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
