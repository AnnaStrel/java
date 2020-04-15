package ru.sgu.presentation.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {

    protected Connection connection;

    private final String url = "jdbc:postgresql://localhost/bank-db";

    private final String user = "postgres";

    private final String password = "1234";

    public Dao() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }

}

