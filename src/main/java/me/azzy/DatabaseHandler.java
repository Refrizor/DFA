package me.azzy;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class DatabaseHandler {

    private static final MysqlDataSource source = new MysqlDataSource();

    static {
        String address = DiamondFire.getConfiguration().getString("database-address");
        String database = DiamondFire.getConfiguration().getString("database");
        int gateway = DiamondFire.getConfiguration().getInt("gateway-port");
        source.setUrl("jdbc:mysql://" + address + "/" + database + "?useSSL=false&allowPublicKeyRetrieval=true");
        source.setPort(gateway);
        source.setUser(DiamondFire.getConfiguration().getString("database-user"));
        source.setPassword(DiamondFire.getConfiguration().getString("database-password"));
    }

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }
}