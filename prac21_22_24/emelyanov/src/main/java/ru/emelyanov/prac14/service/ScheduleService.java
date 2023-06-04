package ru.emelyanov.prac14.service;


import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private List<String> resultSetArray = new ArrayList<>();

    //@Scheduled(cron = "0 * * * * *")
    @Scheduled(fixedRate = 10000)
    public void scheduleFixedDelayTask() throws Exception {
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);

        FileUtils.cleanDirectory(new File("src/main/myTests"));

        String url = "jdbc:postgresql://localhost:5432/post";
        String password = "1234";
        String username = "postgres";

        Connection connection = DriverManager.getConnection(url, username, password);

        fetchDataFromDatabase("SELECT * FROM post", connection);
        String csvFilePathForPost = "src/main/myTests/1.csv";
        printToCsv(resultSetArray, csvFilePathForPost);

        fetchDataFromDatabase("SELECT * FROM user", connection);
        String csvFilePathForUser = "src/main/myTests/2.csv";
        printToCsv(resultSetArray, csvFilePathForUser);

    }

    private void fetchDataFromDatabase(String selectQuery, Connection connection) throws Exception {
        try {


            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            int numCols = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                StringBuilder sb = new StringBuilder();

                for (int i = 1; i <= numCols; i++) {
                    sb.append(String.format(String.valueOf(rs.getString(i))) + " ");

                }
                resultSetArray.add(sb.toString());

            }

        } catch (SQLException e) {
            System.out.println("Sql exception " + e.getMessage());
        }

    }

    public static void printToCsv(List<String> resultArray, String path) throws Exception {

        File csvOutputFile = new File(path);
        FileWriter fileWriter = new FileWriter(csvOutputFile, false);


        for (String mapping : resultArray) {
            fileWriter.write(mapping + "\n");
        }

        fileWriter.close();

    }


}