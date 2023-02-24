package org.example.View.Pages;

import org.example.Utils.Colors.ColorsApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class MainPageView extends JFrame {

    private JPanel headerPanel, menuPanel, centralPanel;
    private JScrollPane scrollPane;
    private JLabel iconEnterprise;
    private JButton employees, logOut, menuButton;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int WIDTH = screenSize.width, HEIGHT = screenSize.height;

    public MainPageView(){
        createHeaderPanel();
        createEmployeesPanel();
        createMenuPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
        setMinimumSize(new Dimension(WIDTH/2, HEIGHT/2));
        setLayout(new BorderLayout());
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(menuPanel, BorderLayout.WEST);
    }

    public void createHeaderPanel(){

        Image icon = new ImageIcon("img/logo_gandel.png").getImage();
        Image logOutIcon = new ImageIcon("img/logout.png").getImage();
        Image employeeIcon = new ImageIcon("img/employee.png").getImage();
        Image menuButtonIcon = new ImageIcon("img/menu.png").getImage();

        iconEnterprise = new JLabel();
        iconEnterprise.setPreferredSize(new Dimension(60, 60));
        iconEnterprise.setIcon(new ImageIcon(icon.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        iconEnterprise.setHorizontalAlignment(JLabel.CENTER);
        iconEnterprise.setVerticalAlignment(JLabel.CENTER);

        employees = new JButton();
        employees.setPreferredSize(new Dimension(60, 60));
        employees.setIcon(new ImageIcon(employeeIcon.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        employees.setBackground(ColorsApp.RED);
        employees.setFocusable(false);
        employees.setBorderPainted(false);
        employees.setFocusPainted(false);
        employees.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {
                        employees.setBackground(ColorsApp.RED_SELECT);
                    }
                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {
                        employees.setBackground(ColorsApp.RED);
                    }
                }
        );

        menuButton = new JButton();
        menuButton.setPreferredSize(new Dimension(50, 50));
        menuButton.setIcon(new ImageIcon(menuButtonIcon.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        menuButton.setBackground(ColorsApp.RED);
        menuButton.setBorder(null);
        menuButton.setFocusPainted(false);
        menuButton.setBorderPainted(false);
        menuButton.setFocusable(false);
        menuButton.setForeground(ColorsApp.RED);

        logOut = new JButton();
        logOut.setPreferredSize(new Dimension(50, 50));
        logOut.setIcon(new ImageIcon(logOutIcon.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        logOut.setBackground(ColorsApp.RED);
        logOut.setBorder(null);
        logOut.setFocusPainted(false);
        logOut.setBorderPainted(false);
        logOut.setFocusable(false);
        logOut.setForeground(ColorsApp.RED);

        headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(WIDTH, 100));
        headerPanel.setBackground(ColorsApp.RED);
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        headerPanel.add(iconEnterprise, BorderLayout.CENTER);
        headerPanel.add(menuButton, BorderLayout.WEST);
        headerPanel.add(logOut, BorderLayout.EAST);
    }

    public void createEmployeesPanel(){
        centralPanel = new JPanel();
        centralPanel.setBackground(ColorsApp.BLACK_BACKGROUND);

        scrollPane = new JScrollPane(centralPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);
    }

    public void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(ColorsApp.RED);
        menuPanel.setPreferredSize(new Dimension(400, HEIGHT));
        menuPanel.setVisible(false);
    }

    public JButton getLogOut() {
        return logOut;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public JButton getMenuButton() {
        return menuButton;
    }

    public void changeVisibility() {
        menuPanel.setVisible(!menuPanel.isVisible());
        revalidate();
    }
}
