package com.itechart.katsiaryna.kinopoisk;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

public class OnlineLoader implements Loader {
    @Override
    public Film findMovie() throws IOException {
        Properties properties = new Properties();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID фильма: ");
        int filmId = sc.nextInt();
        System.out.println("film id is " + filmId);

        BufferedReader reader = null;
        HttpURLConnection conn = null;

        try (InputStream inputStream = getClass().getResourceAsStream("/application.properties")) {
            properties.load(inputStream);
            String apiKey = properties.getProperty("apiKey");
            String apiUrl = properties.getProperty("apiUrl");

            System.out.println("Ищу фильм в интернете...");
            URL url = new URL(apiUrl + filmId);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept", "application/json");
            conn.setRequestProperty("X-API-KEY", apiKey);

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = reader.readLine();

            System.out.println("Загружаю фильм...");

            System.out.println(line);

            System.out.println("Характеристики фильма:");

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(line, Film.class);

        } catch (IOException ex) {
            System.out.println("Ошибка запроса: " + ex.getMessage());
            throw new RuntimeException(ex);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}

