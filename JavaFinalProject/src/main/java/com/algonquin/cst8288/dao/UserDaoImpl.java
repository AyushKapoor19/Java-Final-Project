//package com.algonquin.cst8288.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.algonquin.cst8288.db.DBUtil;
//import com.algonquin.cst8288.db.Queries;
//
//public class UserDaoImpl implements UserDao {
//
//    @Override
//    public boolean addUser(User user) {
//        String query = Queries.ADD_USER;
//
//        try (Connection connection = DBUtil.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getEmail());
//            preparedStatement.setString(3, user.getPassword());
//
//            int rowsAffected = preparedStatement.executeUpdate();
//
//            return rowsAffected > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public boolean isValidUser(String username, String password) {
//        String query = Queries.VALIDATE_USER;
//        try (Connection connection = DBUtil.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            return resultSet.next();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
//
package com.algonquin.cst8288.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.algonquin.cst8288.db.DBUtil;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean isValidUser(String email, String password) {
        // Logic to check if the user is valid (usually involves querying the database)
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection(); // Assuming you have a DBConnection class that handles database connections
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, email);
            stmt.setString(2, password); // Here you should hash the password before checking
            
            rs = stmt.executeQuery();
            if (rs.next()) {
                // User exists
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources (omitted for brevity)
        }

        return false;
    }

    @Override
    public boolean addUser(User user) {
        // Logic to add the new user (involves inserting into the database)
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO users (name, email, password, userType) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword()); // Here you should hash the password before storing
            stmt.setString(4, user.getUserType());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources (omitted for brevity)
        }

        return false;
    }
}

