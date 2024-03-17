package com.nimish.NetflixApi.controller;

import com.nimish.NetflixApi.dto.TitleDto;
import com.nimish.NetflixApi.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("titles")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping
    public Flux<TitleDto> getAllTitles() {
        return this.titleService.getAllTitles();
    }

    @GetMapping("/{titleId}")
    public Mono<TitleDto> getTitle(@PathVariable("titleId") Integer titleId) {
        return this.titleService.getTitle(titleId);
    }

    @PostMapping
    public Mono<TitleDto> createTitle(@RequestBody TitleDto titleDto) {
        return this.titleService.createTitle(titleDto);
    }

    @DeleteMapping("/{titleId}")
    public Mono<Void> deleteTitle(@PathVariable("titleId") Integer titleId) {
        return this.titleService.deleteTitle(titleId);
    }

    @PutMapping("update-release-year/{showId}")
    public Mono<TitleDto> updateTitle(
            @PathVariable("showId") String showId,
            @RequestParam(value = "releaseYear") Integer releaseYear) {
        return this.titleService.updateReleaseYearByShowId(releaseYear, showId);
    }
}
