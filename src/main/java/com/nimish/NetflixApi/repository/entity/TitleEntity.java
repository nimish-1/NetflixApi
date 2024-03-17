package com.nimish.NetflixApi.repository.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nimish.NetflixApi.dto.TitleType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Table("netflix_title")
public class TitleEntity {
    @Id
    Integer id;

    @Column("show_id")
    String showId;

    @Column("type")
    TitleType type;

    String title;

    @Column("title_cast")
    String cast;
    String director;
    String country;

    @Column("date_added")
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateAdded;

    @Column("release_year")
    Integer releaseYear;
    String duration;

    @Column("listed_in")
    String listedIn;
    String description;
}
