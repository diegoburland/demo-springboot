package com.learning.academy.location.city;

import com.learning.academy.location.country.Country;
import com.learning.academy.location.subdivision.Subdivision;
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
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long population;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private String timezone;

    @Column(nullable = false)
    private Double elevation;

    @Column(nullable = false)
    private Double gdp;

    @Column(nullable = false)
    private Double gdpPerCapita;

    @ElementCollection
    @Column(nullable = false)
    private List<String> languages;

    @Column(nullable = false)
    private String currency;

    @ManyToOne
    @JoinColumn(name = "subdivision_id", nullable = false)
    private Subdivision subdivision;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
