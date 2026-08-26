package com.registration.registrationform;

import lombok.extern.log4j.Log4j2;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
@Log4j2
public class DBConnection {
    public static Connection getConnection(){
        Connection connection = null;
        // Load dynamically from src/main/resources via classpath
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                log.error("Unable to find application.properties in classpath");
                return null;
            }

            Properties properties = new Properties();
            properties.load(input);

            // Ensure the JDBC driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password") // Fixed key name
            );
        }catch(Exception e){
            log.error("The error occurred while trying to get the connection");
            e.printStackTrace();
        }
        return connection;
    }
}
