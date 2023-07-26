package com.itechart.katsiaryna.kinopoisk;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileLoader implements Loader {
    @Override
    public Film findMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название фильма: ");
        String movieName = sc.nextLine();
        System.out.println("Ищу фильм в файле...");

        try {
            InputStream inputStream = getClass().getResourceAsStream("/movies.txt");
            InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);

            /*
            List<String> lines = Files.readAllLines((Path) inputStream, StandardCharsets.UTF_8)
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] filmData = line.split(";");
                String title = filmData[0].trim();
                if (title.equalsIgnoreCase(movieName)) {
                    Film film = new Film(title, filmData[1].trim(), filmData[2].trim(), filmData[3].trim(), filmData[4].trim());
                    System.out.println(film.toString());
                    break;
                }
            }*/

            String line;
            while ((line = reader.readLine()) != null) {
                String[] filmData = line.split(";");
                String title = filmData[0].trim();
                if (title.equalsIgnoreCase(movieName)) {
                    Film film = new Film(title, filmData[1].trim(), filmData[2].trim(), filmData[3].trim(), filmData[4].trim());
                    System.out.println("Информация о фильме:");
                    System.out.println(film.toString());
                    break;
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }
}
