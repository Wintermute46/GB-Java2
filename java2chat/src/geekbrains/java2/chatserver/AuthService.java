package geekbrains.java2.chatserver;

import java.sql.*;

public class AuthService {
    private Connection connection;
    private Statement statement;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:db.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNickByAuth(String login, String pass) {
        try {
            ResultSet rs = statement.executeQuery("SELECT nick FROM ch_users WHERE login = '" + login + "' AND password = '" + pass + "';");
            if (rs.next()) return rs.getString("nick");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
