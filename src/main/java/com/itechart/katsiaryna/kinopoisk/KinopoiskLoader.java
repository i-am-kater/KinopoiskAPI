package com.itechart.katsiaryna.kinopoisk;

import java.io.IOException;
import java.util.Scanner;

public class KinopoiskLoader {
    public static void main(String[] args) throws IOException {

        System.out.println("Выберите способ поиска фильма: ");
        Scanner sc = new Scanner(System.in);
        KinoFactory kinoFactory = new KinoFactory();
        String type = sc.nextLine();

        Loader loader = kinoFactory.getLoader(SearchType.valueOf(type));

        Film film = loader.findMovie();
        System.out.println(film);

    }
}