package org.example.View.SesionsView;

import org.example.Utils.Colors.ColorsApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogInView extends JFrame {

    private JPanel generalPanel, formPanel, errorPanel;
    private JLabel titleLabel, usernameLabel, passwordLabel, errorMessage;
    private JTextField username;
    private JPasswordField password;
    private JButton submit;
    private int WIDTH = 800, HEIGHT = 800;
    private GridBagConstraints gridBagConstraintsForm, gridBagConstraintsError;

    public LogInView(){
        createGeneralPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(WIDTH, HEIGHT));
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
        this.add(generalPanel);
    }

    private void createGeneralPanel(){
        createForm();
        createErrorPanel();

        generalPanel = new JPanel();
        generalPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        generalPanel.setBackground(ColorsApp.BLACK_BACKGROUND);
        generalPanel.setLayout(new GridBagLayout());
        gridBagConstraintsForm = new GridBagConstraints();
        gridBagConstraintsForm.gridy = 0;
        gridBagConstraintsForm.weightx = 0.4;
        gridBagConstraintsForm.insets = new Insets(0, 0, 0, 0);
        generalPanel.add(formPanel, gridBagConstraintsForm);
        gridBagConstraintsError = new GridBagConstraints();
        gridBagConstraintsError.gridy = 1;
        gridBagConstraintsError.weightx = 0.4;
        gridBagConstraintsError.insets = new Insets(10, 10, 10, 10);
        generalPanel.add(errorPanel, gridBagConstraintsError);
    }

    private void createForm(){
        titleLabel = new JLabel("INICIAR SESIÓN");
        titleLabel.setForeground(ColorsApp.RED);
        titleLabel.setPreferredSize(new Dimension(600, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        usernameLabel = new JLabel("NOMBRE DE USUARIO:");
        usernameLabel.setPreferredSize(new Dimension(500, 40));
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        username = new JTextField();
        username.setPreferredSize(new Dimension(550, 40));
        username.setMargin(new Insets(5, 5, 5, 5));

        passwordLabel = new JLabel("CONTRASEÑA:");
        passwordLabel.setPreferredSize(new Dimension(500, 40));
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        password = new JPasswordField();
        password.setPreferredSize(new Dimension(550, 40));
        password.setMargin(new Insets(5, 5, 5, 5));

        submit = new JButton("INGRESAR");
        submit.setPreferredSize(new Dimension(400, 40));
        submit.setBackground(ColorsApp.RED);
        submit.setBorder(null);
        submit.setBorderPainted(false);
        submit.setFocusPainted(false);
        submit.setFocusable(false);
        submit.setForeground(ColorsApp.WHITE);
        submit.setSelected(false);
        submit.setEnabled(false);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        flowLayout.setVgap(30);

        formPanel = new JPanel();
        formPanel.setPreferredSize(new Dimension(600, 500));
        formPanel.setBackground(ColorsApp.WHITE);
        formPanel.setLayout(flowLayout);
        formPanel.add(titleLabel);
        formPanel.add(usernameLabel);
        formPanel.add(username);
        formPanel.add(passwordLabel);
        formPanel.add(password);
        formPanel.add(submit);
    }

    public void createErrorPanel(){
        errorMessage = new JLabel();
        errorMessage.setPreferredSize(new Dimension(500, 30));
        errorMessage.setForeground(ColorsApp.WHITE);
        errorMessage.setHorizontalAlignment(JLabel.CENTER);
        errorMessage.setVerticalAlignment(JLabel.CENTER);

        errorPanel = new JPanel();
        errorPanel.setBackground(ColorsApp.RED);
        errorPanel.setPreferredSize(new Dimension(600, 40));
        errorPanel.setVisible(false);
        errorPanel.add(errorMessage);
    }

    public JPanel getErrorPanel() {
        return errorPanel;
    }

    public JTextField getUsername() {
        return username;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setErrorMessage(String message){
        errorMessage.setText(message);
    }
}
