package com.rogovrt;

import java.sql.*;

public class Model {
    private static final String driver = "org.h2.Driver";
    private static final String url = "jdbc:h2:E:\\work\\PhoneBook\\db\\test";

    public Model() {
    }

    public static String requestFromUser(String command, String name, String surname, String phone) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        String out = "";
        String empty = "";
        Connection connection = DriverManager.getConnection(url);
        if ((name.equals(empty)) && (surname.equals(empty)) && (phone.equals(empty))) {
            return "Type something in fields\n";
        }

        if (command.equals("Find")) {
            Statement statement = connection.createStatement();
            String request = "SELECT * FROM PHONEBOOK WHERE ";
            if (!name.equals(empty)) request = request + "NAME = '" + name + "' AND ";
            if (!surname.equals(empty)) request = request + "SURNAME = '" + surname + "' AND ";
            if (!phone.equals(empty)) request = request + "PHONE = '" + phone + "' AND ";
            request = request.substring(0, request.length() - 4);
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                    out = out + resultSet.getString("NAME") + ' ' + resultSet.getString("SURNAME") + " : " + resultSet.getString("PHONE") + '\n';
            }
            if (out.equals(empty)) out = "No such record\n";
            statement.close();
        }

        if (command.equals("Add")) {
            Statement statement = connection.createStatement();
            String request = "INSERT INTO PHONEBOOK(NAME, SURNAME"; //this columns are not null
            if (!phone.equals(empty)) {
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
            if (!name.equals(empty)) request = request + "NAME = '" + name + "' AND ";
            if (!surname.equals(empty)) request = request + "SURNAME = '" + surname + "' AND ";
            if (!phone.equals(empty)) request = request + "PHONE = '" + phone + "' AND ";
            request = request.substring(0, request.length() - 4);
            if (statement.execute(request)) out = "Delete request done\n";
            else out = "Delete request failed\n";
            statement.close();
        }
        connection.close();
        return out;
    }

}
