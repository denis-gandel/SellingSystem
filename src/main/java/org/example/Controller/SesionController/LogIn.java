package org.example.Controller.SesionController;

import org.example.Controller.Pages.MainPage;
import org.example.Model.SesionsModel.LogInModel;
import org.example.View.Pages.MainPageView;
import org.example.View.SesionsView.LogInView;

import javax.swing.*;
import java.awt.event.*;

public class LogIn {

    private LogInView logInView;
    private LogInModel logInModel;

    public LogIn(){
        logInView = new LogInView();
        logInModel = new LogInModel();
        logInView.getUsername().addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent keyEvent) {
                        logInModel.verifyFields(logInView.getUsername(), logInView.getPassword(), logInView.getSubmit());
                    }
                }
        );
        logInView.getPassword().addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent keyEvent) {
                        logInModel.verifyFields(logInView.getUsername(), logInView.getPassword(), logInView.getSubmit());
                    }
                }
        );
        logInView.getSubmit().addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        if (logInView.getSubmit().isEnabled()){
                            logInModel.connectSesion(logInView.getUsername(), logInView.getPassword());
                            if (logInModel.verifyUser()){
                                logInView.getErrorPanel().setVisible(true);
                                logInView.setErrorMessage("USUARIO NO EXISTENTE, REVISA EL USUARIO O LA CONTRASEÑA");
                                logInView.getUsername().setText("");
                                logInView.getPassword().setText("");
                                logInView.getSubmit().setEnabled(false);
                            } else {
                                nextPage();
                            }
                        }
                    }
                }
        );
    }

    public void nextPage(){
        if (!logInModel.getUser().isEmpty() && !logInModel.getPassword().isEmpty()) {
            logInView.dispose();
            System.out.println(logInModel.getType());
            if (logInModel.getType().equals("Vendedor")) {
                new MainPage();
            }
        }
    }

}
