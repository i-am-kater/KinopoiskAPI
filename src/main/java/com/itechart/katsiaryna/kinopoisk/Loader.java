package com.itechart.katsiaryna.kinopoisk;

import java.io.IOException;

public interface Loader {
    Film findMovie() throws IOException;
}
