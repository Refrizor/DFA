package com.mcdiamondfire;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class DatabaseHandler {

    private static final MysqlDataSource source = new MysqlDataSource();

    static {
        source.setUrl("jdbc:mysql://localhost/mcdiamondfire?useSSL=false&allowPublicKeyRetrieval=true");
        source.setUser(DiamondFire.getFileConfig().getString("database_user"));
        source.setPassword(DiamondFire.getFileConfig().getString("database_password"));
    }

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }
}