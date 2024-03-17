package com.nimish.NetflixApi.service;

import com.nimish.NetflixApi.dto.TitleDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TitleService {
    Flux<TitleDto> getAllTitles();

    Mono<TitleDto> getTitle(Integer id);

    Mono<Void> deleteTitle(Integer id);

    Mono<TitleDto> updateReleaseYearByShowId(Integer releaseYear, String showId);

    Mono<TitleDto> createTitle(TitleDto titleDto);

}
