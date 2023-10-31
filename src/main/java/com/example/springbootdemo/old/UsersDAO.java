package com.example.springbootdemo.old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersDAO {


    private static final String USER_DB = "root";
    private static final String USER_PWD = "";
    private static final String USER_URL = "jdbc:mysql://localhost:3308/web_users_db";


    Connection con = null;
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(USER_URL, USER_DB, USER_PWD);
            System.out.println(con + " is open");

                } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertUser() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(USER_URL, USER_DB, USER_PWD);
            System.out.println(con + " is open");

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Users .");
            pstmt.setString(1, "John");
            pstmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
                System.out.println(con + " is closed");
            }
        }

    }



}
