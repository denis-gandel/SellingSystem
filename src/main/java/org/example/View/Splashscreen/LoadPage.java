package org.example.View.Splashscreen;

import org.example.Controller.SesionController.LogIn;
import org.example.Utils.Colors.ColorsApp;
import org.example.View.SesionsView.LogInView;

import javax.swing.*;
import java.awt.*;

public class LoadPage extends JFrame {

    private JPanel generalPanel, infoPanel, loadPanel;
    private JProgressBar loadApp;
    private JLabel iconEnterprise, nameEnterprise;
    private int WIDTH = 600;
    private GridBagConstraints gridBagConstraints;

    public LoadPage(){
        createGeneralPanel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setSize(WIDTH, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        this.add(generalPanel);
        loadApp();
    }

    private void createGeneralPanel(){
        createInfoPanel();
        createLoadApp();
        generalPanel = new JPanel();
        generalPanel.setSize(WIDTH, 400);
        generalPanel.setBackground(ColorsApp.BLACK_BACKGROUND);
        generalPanel.add(infoPanel);
        generalPanel.add(loadPanel);
    }

    private void createInfoPanel(){
        Image icon = new ImageIcon("img/logo_gandel.png").getImage();

        iconEnterprise = new JLabel();
        iconEnterprise.setPreferredSize(new Dimension(250, 300));
        iconEnterprise.setIcon(new ImageIcon(icon.getScaledInstance(250, 250, Image.SCALE_SMOOTH)));

        nameEnterprise = new JLabel("GANDEL DEVS");
        nameEnterprise.setForeground(ColorsApp.WHITE);
        nameEnterprise.setFont(new Font("Arial", Font.PLAIN, 28));
        nameEnterprise.setPreferredSize(new Dimension(300, 40));
        nameEnterprise.setHorizontalAlignment(JLabel.CENTER);
        nameEnterprise.setVerticalAlignment(JLabel.CENTER);

        infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(WIDTH, 300));
        infoPanel.setBackground(ColorsApp.BLACK_BACKGROUND);
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        infoPanel.add(iconEnterprise);
        infoPanel.add(nameEnterprise);
        infoPanel.repaint();
        infoPanel.revalidate();
    }

    private void createLoadApp(){
        loadApp = new JProgressBar();
        loadApp.setPreferredSize(new Dimension(400, 20));
        loadApp.setBackground(ColorsApp.WHITE);
        loadApp.setForeground(ColorsApp.RED);
        loadApp.setBorderPainted(false);
        loadApp.setBorder(null);

        loadPanel = new JPanel();
        loadPanel.setPreferredSize(new Dimension(WIDTH, 100));
        loadPanel.setBackground(ColorsApp.LIGHT_BLACK);
        loadPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        loadPanel.add(loadApp, gridBagConstraints);
    }

    private void loadApp() {
        for (int percent = 0; percent <= 100; percent+=10){
            loadApp.setValue(percent);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        dispose();
        new LogIn();
    }



}
