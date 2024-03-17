package com.nimish.NetflixApi.service.impl;

import com.nimish.NetflixApi.dto.TitleDto;
import com.nimish.NetflixApi.repository.TitleRepository;
import com.nimish.NetflixApi.repository.entity.TitleEntity;
import com.nimish.NetflixApi.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleRepository titleRepository;

    @Override
    public Flux<TitleDto> getAllTitles() {
        return this.titleRepository.findAll().map(titleEntity -> new TitleDto(
                titleEntity.getId(),
                titleEntity.getShowId(),
                titleEntity.getType(),
                titleEntity.getTitle(),
                titleEntity.getCast(),
                titleEntity.getDirector(),
                titleEntity.getCountry(),
                titleEntity.getDateAdded(),
                titleEntity.getReleaseYear(),
                titleEntity.getDuration(),
                titleEntity.getListedIn(),
                titleEntity.getDescription()));
    }

    @Override
    public Mono<TitleDto> getTitle(Integer id) {
        return this.titleRepository.findById(id).map(titleEntity -> new TitleDto(
                titleEntity.getId(),
                titleEntity.getShowId(),
                titleEntity.getType(),
                titleEntity.getTitle(),
                titleEntity.getCast(),
                titleEntity.getDirector(),
                titleEntity.getCountry(),
                titleEntity.getDateAdded(),
                titleEntity.getReleaseYear(),
                titleEntity.getDuration(),
                titleEntity.getListedIn(),
                titleEntity.getDescription()));
    }

    @Override
    public Mono<Void> deleteTitle(Integer id) {
        return this.titleRepository.deleteById(id);
    }

    @Override
    public Mono<TitleDto> updateReleaseYearByShowId(Integer releaseYear, String showId) {
        return this.titleRepository.getByShowId(showId).flatMap(titleEntity -> {
            titleEntity.setReleaseYear(releaseYear);
            return this.titleRepository.save(titleEntity);
        }).map(titleEntity -> new TitleDto(
                titleEntity.getId(),
                titleEntity.getShowId(),
                titleEntity.getType(),
                titleEntity.getTitle(),
                titleEntity.getCast(),
                titleEntity.getDirector(),
                titleEntity.getCountry(),
                titleEntity.getDateAdded(),
                titleEntity.getReleaseYear(),
                titleEntity.getDuration(),
                titleEntity.getListedIn(),
                titleEntity.getDescription()));
    }

    @Override
    public Mono<TitleDto> createTitle(TitleDto titleDto) {
        return this.titleRepository.save(TitleEntity.builder()
                        .showId(titleDto.showId())
                        .type(titleDto.type())
                        .title(titleDto.title())
                        .director(titleDto.director())
                        .cast(titleDto.cast())
                        .country(titleDto.country())
                        .dateAdded(titleDto.dateAdded())
                        .releaseYear(titleDto.releaseYear())
                        .duration(titleDto.duration())
                        .listedIn(titleDto.listedIn())
                        .description(titleDto.description())
                        .build())
                .map(titleEntity -> new TitleDto(titleEntity.getId(),
                        titleEntity.getShowId(),
                        titleEntity.getType(),
                        titleEntity.getTitle(),
                        titleEntity.getCast(),
                        titleEntity.getDirector(),
                        titleEntity.getCountry(),
                        titleEntity.getDateAdded(),
                        titleEntity.getReleaseYear(),
                        titleEntity.getDuration(),
                        titleEntity.getListedIn(),
                        titleEntity.getDescription()));
    }

}
