package com.learning.academy.location.country;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 2)
    private String isoAlpha2;

    @Column(nullable = false, length = 3)
    private String isoAlpha3;

    @Column(nullable = false)
    private Integer isoNumeric;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false, length = 3)
    private String currencyCode;

    @Column(nullable = false)
    private String officialLanguage;

    @Column(nullable = false)
    private String timeZone;

    @Column(nullable = false)
    private String dateFormat;

    @Column(nullable = false)
    private String measurementSystem;

    @Column(nullable = false)
    private String phonePrefix;

    @Column(nullable = false)
    private String topLevelDomain;
}

