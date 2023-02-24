package org.example.Model.PagesModel;

import org.example.Controller.SesionController.LogIn;
import org.example.Model.SesionsModel.LogInModel;
import org.example.View.Pages.MainPageView;

import javax.swing.*;

public class MainPageModel {

    private LogInModel logInModel;

    public MainPageModel() {
        this.logInModel = new LogInModel();
    }

    public void logOutSession(JFrame page) {
        page.dispose();
        new LogIn();
        //logInModel.resetUser();
    }

}
