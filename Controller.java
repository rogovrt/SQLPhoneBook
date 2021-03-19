package com.rogovrt;

import java.sql.SQLException;

public class Controller {
    public Controller(){}

    public static String sendUserRequest(String command, String name, String surname, String phone) throws SQLException, ClassNotFoundException {
        return Model.requestFromUser(command, name, surname, phone);
    }
}
