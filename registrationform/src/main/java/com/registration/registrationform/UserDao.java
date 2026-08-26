package com.registration.registrationform;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class UserDao {
    public void save(User user) {
        String sql = "INSERT INTO users (name, email, address, password, gender) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            if (connection == null) {
                log.error("Database connection is null! Check DBConnection.");

            }

            statement.setString(1, user.name());
            statement.setString(2, user.email());
            statement.setString(3, user.address());
            statement.setString(4, user.password());
            statement.setString(5, user.gender());

            int rowsAffected = statement.executeUpdate();
            log.info("User registered successfully, rows inserted: {}", rowsAffected);
        } catch (SQLException e) {
            log.error("SQL Error while saving user: ", e);
            e.printStackTrace();

        }
    }
    public User getUserByName(String name) {
        String sql = "SELECT name, email, address, password, gender FROM users WHERE name = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            if (connection == null) {
                log.error("Database connection is null!");
                return null;
            }

            statement.setString(1, name);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("address"),
                            resultSet.getString("password"),
                            resultSet.getString("gender")
                    );
                }
            }
        } catch (SQLException e) {
            log.error("SQL Error while fetching user by name: ", e);
            e.printStackTrace();
        }

        return null; // Returns null if user is not found or if an exception occurs
    }
}