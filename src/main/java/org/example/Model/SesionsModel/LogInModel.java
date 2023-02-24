package org.example.Model.SesionsModel;

import org.example.Database.DatabaseConnection;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class LogInModel {

    private String id, user, password, type, name, lastname;

    public LogInModel(){
        id = "";
        user = "";
        password = "";
        type = "";
        name = "";
        lastname = "";
    }

    public void connectSesion(JTextField user, JPasswordField password){
        String query = "SELECT * FROM Employee;";
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = DatabaseConnection.connectionDatabase().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString(2).equals(user.getText()) && resultSet.getString(3).equals(convertArrayToString(password.getPassword()))) {
                    this.id = resultSet.getInt(1)+"";
                    this.user = resultSet.getString(2);
                    this.password = resultSet.getString(3);
                    this.type = resultSet.getString(4);
                    this.name = resultSet.getString(5);
                    this.lastname = resultSet.getString(6);
                    System.out.println(id+"|"+this.user+"|"+this.password+"|"+type+"|"+name+"|"+lastname);
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private String convertArrayToString(char[] password){
        StringBuilder pass = new StringBuilder();
        for (Character character : password) {
            pass.append(character);
        }
        return pass.toString();
    }

    public void verifyFields(JTextField user, JPasswordField password, JButton submit){
        if (!user.getText().isEmpty() && password.getPassword().length > 0){
            submit.setEnabled(true);
        } else {
            submit.setEnabled(false);
        }
    }

    public void resetUser() {
        id = "";
        user = "";
        password = "";
        type = "";
        name = "";
        lastname = "";
    }

    public boolean verifyUser(){
        return user.isEmpty() && password.isEmpty();
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
