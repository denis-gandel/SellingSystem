package org.example.Controller.Pages;

import org.example.Model.PagesModel.MainPageModel;
import org.example.View.Pages.MainPageView;
import java.awt.event.*;
public class MainPage {

    private MainPageView mainPageView;
    private MainPageModel mainPageModel;

    public MainPage() {
        this.mainPageModel = new MainPageModel();
        this.mainPageView = new MainPageView();
        actionsMenu();
    }

    public void actionsMenu() {
        mainPageView.getLogOut().addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        mainPageModel.logOutSession(mainPageView);
                    }
                }
        );
        mainPageView.getMenuButton().addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        mainPageView.changeVisibility();
                    }
                }
        );
    }

}
