package com.nimish.NetflixApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TitleType {
    MV("MV"),
    TV("TV");

    private final String value;
}
