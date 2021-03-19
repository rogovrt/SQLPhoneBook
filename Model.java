package com.rogovrt;

import com.sun.javafx.charts.ChartLayoutAnimator;

import java.sql.*;

public class Model {
    private static final String driver = "org.h2.Driver";
    private static final String url = "jdbc:h2:E:\\work\\PhoneBook\\db\\test";

    public Model() {
    }

    public static String requestFromUser(String command, String name, String surname, String phone) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        String out = "";
        Connection connection = DriverManager.getConnection(url);
        if ((name == null) && (surname == null) && (phone == null)) {
            return "Type something in fields\n";
        }

        if (command.equals("Find")) {
            Statement statement = connection.createStatement();
            String request = "SELECT * FROM PHONEBOOK WHERE ";
            if (name != null) request = request + "NAME = '" + name + "' AND ";
            if (surname != null) request = request + "SURNAME = '" + surname + "' AND ";
            if (phone != null) request = request + "PHONE = '" + phone + "' AND ";
            request = request.substring(0, request.length() - 4);
            System.out.println(request);
            ResultSet resultSet = statement.executeQuery(request);
            /*if (!resultSet.next())
                out = "No such record\n";
            else {*/
                while (resultSet.next()) {
                    out = out + resultSet.getString("NAME") + ' ' + resultSet.getString("SURNAME") + " : " + resultSet.getString("PHONE") + '\n';
                    //System.out.printf("%s %s : %s\n", resultSet.getString("NAME"), resultSet.getString("SURNAME"), resultSet.getString("PHONE"));
                }
            //}
            statement.close();
        }

        if (command.equals("Add")) {
            Statement statement = connection.createStatement();
            String request = "INSERT INTO PHONEBOOK(NAME, SURNAME"; //this columns are not null
            if (phone != null) {
                request = request + ", PHONE) VALUES('" + name + "', '" + surname + "', '" + phone + "')";
            }
            else {
                request = request + ", PHONE) VALUES('" + name + "', '" + surname + "')";
            }
            if (statement.executeUpdate(request) != 0) out = "Record added\n";
            else out = "Record didn't added\n";
            statement.close();
        }

        if (command.equals("Delete")) {
            Statement statement = connection.createStatement();
            String request = "DELETE FROM PHONEBOOK WHERE ";
            if (name != null) request = request + "NAME = '" + name + "' AND ";
            if (surname != null) request = request + "SURNAME = '" + surname + "' AND ";
            if (phone != null) request = request + "PHONE = '" + phone + "' AND ";
            request = request.substring(0, request.length() - 4);
            out = "Delete request done\n";
            statement.close();
        }
        connection.close();
        return out;
    }

}
