package org.parkinglot;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final Dotenv dotenv=Dotenv.load();
    private static final String DB_URL=dotenv.get("DB_URL");
    private static final String DB_PASSWORD=dotenv.get("DB_PASSWORD");
    private static final String USER=dotenv.get("DB_USER");


    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Postgres driver not found!");
        }
        return DriverManager.getConnection(DB_URL,USER,DB_PASSWORD);
    }
    public static String getDbUrl(){
        return dotenv.get("db_url");
    }
}
