package com.nimish.NetflixApi.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TitleDto(
                Integer id,
                String showId,
                TitleType type,
                String title,
                String cast,
                String director,
                String country,
                @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dateAdded,
                Integer releaseYear,
                String duration,
                String listedIn,
                String description

) {
}