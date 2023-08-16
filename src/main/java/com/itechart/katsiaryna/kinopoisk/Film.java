package com.itechart.katsiaryna.kinopoisk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {
    @JsonProperty("nameRu")
    private String nameRu;
    @JsonProperty("year")
    private String year;
    @JsonProperty("filmLength")
    private String filmLength;
    @JsonProperty("genres")
    private ArrayList genres;
    @JsonProperty("description")
    private String description;

    public Film() {
    }

    public Film(String nameRu, String year, String filmLength, String description) {
        this.nameRu = nameRu;
        this.year = year;
        this.filmLength = filmLength;
        this.description = description;
    }

    public String getNameRu() {
        return nameRu;
    }

    public String getYear() {
        return year;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public String getDescription() {
        return description;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Название: " + nameRu + "\n" +
                "Год выпуска: " + year + "\n" +
                "Длительность фильма: " + filmLength + "\n" +
                "Описание фильма: " + description;
    }

}
