package com.itechart.katsiaryna.kinopoisk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    @JsonProperty("data")
    private Film data;

    public Film getData(){
        return data;
    }
}
