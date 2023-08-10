package com.itechart.katsiaryna.kinopoisk;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class FileLoader implements Loader {
    @Override
    public Film findMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название фильма: ");
        String movieName = sc.nextLine();
        System.out.println("Ищу фильм в файле...");
        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getResourceAsStream("/application.properties")) {
            properties.load(inputStream);
            String filename = properties.getProperty("filename");
            List<String> lines = Files.readAllLines(Path.of(filename), StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] filmData = line.split(";");
                String title = filmData[0].trim();
                if (title.equalsIgnoreCase(movieName)) {
                    return new Film(title, filmData[1].trim(), filmData[2].trim(), filmData[3].trim(), filmData[4].trim());
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }
}
