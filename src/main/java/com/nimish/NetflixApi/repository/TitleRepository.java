package com.nimish.NetflixApi.repository;

import com.nimish.NetflixApi.repository.entity.TitleEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TitleRepository extends R2dbcRepository<TitleEntity, Integer> {


    @Query("""
                SELECT * FROM netflix_title
                WHERE show_id = :showId
            """)
    Mono<TitleEntity> getByShowId(@Param("showId") String showId);

    @Query("""
                SELECT * FROM netflix_title
                WHERE UPPER(country) = UPPER(:country) AND UPPER(listed_in) LIKE CONCAT('%',UPPER(:movieType),'%')
            """)
    Flux<TitleEntity> filterByCountryAndGenre(
            @Param("country") String country, @Param("movieType") String movieType
    );

    @Query("""
                SELECT * FROM netflix_title
                WHERE UPPER(listed_in) LIKE CONCAT('%',UPPER(:movieType),'%')
            """)
    Flux<TitleEntity> filterByGenre(@Param("movieType") String movieType);

    @Query("""
                SELECT * FROM netflix_title
                WHERE UPPER(country) = UPPER(:country)
            """)
    Flux<TitleEntity> filterByCountry(@Param("country") String country);


}
