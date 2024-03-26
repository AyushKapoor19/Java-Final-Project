package com.algonquin.cst8288.db;

public class Queries {
    public static final String ADD_USER = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
    public static final String VALIDATE_USER = "SELECT * FROM users WHERE username = ? AND password = ?";
}
