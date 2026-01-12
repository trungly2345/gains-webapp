package com.project.GainsDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTables {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/gainsdb";
        String username = "postgres";
        String password = "pass";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement statement = connection.createStatement();

            // TODO think of a data structure to store entities of table to create 
            String createUserQuery = """
                       CREATE TABLE users (
                     user_id BIGSERIAL PRIMARY KEY,
                    user_name TEXT NOT NULL,
                    email TEXT NOT NULL UNIQUE,
                    age INT NOT NULL,
                    gender CHAR(1) NOT NULL,
                    bodyweight DOUBLE PRECISION NOT NULL
                );
                    """;

            statement.execute(createUserQuery);
            var rs = statement.getResultSet();
            System.err.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
