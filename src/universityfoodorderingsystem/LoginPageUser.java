package universityfoodorderingsystem;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class LoginPageUser extends JFrame {
    private JTextField userIDField;
    private JPasswordField passwordField;

    public LoginPageUser() {
        // Set up the JFrame
        setTitle("Main Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        // Create the main panel with GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        mainPanel.setBackground(Color.decode("#E6E6FA"));

        // Create a slogan panel with a label
        JPanel sloganPanel = new JPanel(new BorderLayout());
        sloganPanel.setBackground(Color.decode("#E6E6FA"));
        JLabel sloganLabel = new JLabel("Welcome to University Food Ordering System", SwingConstants.CENTER);
        sloganLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        sloganPanel.add(sloganLabel, BorderLayout.NORTH);
        mainPanel.add(sloganPanel, gbc);

        // Create labels for User ID and Password
        JLabel userIDLabel = new JLabel("User ID:");
        userIDField = new JTextField(20);
        userIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        // Create Login and Exit buttons
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#3EB489"));
        loginButton.setForeground(Color.white);
        loginButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.decode("#CB4154"));
        exitButton.setForeground(Color.white);
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // Add action listener for the Login button
        loginButton.addActionListener(e -> {
            String userID = userIDField.getText();
            String password = new String(passwordField.getPassword());

            if (checkLogin(userID, password)) {
                // Redirect to the appropriate page based on user type
                navigateToUserPage(userID);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid user ID or password. Please try again.");
            }
        });

        // Add action listener for the Exit button
        exitButton.addActionListener(e -> System.exit(0));

        // Add components to the main panel
        mainPanel.add(userIDLabel, gbc);
        mainPanel.add(userIDField, gbc);
        mainPanel.add(passwordLabel, gbc);
        mainPanel.add(passwordField, gbc);

        // Create a button panel for Login and Exit buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.decode("#E6E6FA"));
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);

        // Add the main panel and button panel to the JFrame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set JFrame visibility
        setVisible(true);
    }

    private boolean checkLogin(String userID, String password) {
    try (Scanner scanner = new Scanner(new File("User.txt"))) {
        while (scanner.hasNext()) {
            String timeAndDate = scanner.nextLine();
            String userType = scanner.nextLine();
            String storedUserID = scanner.nextLine();
            String username = scanner.nextLine();
            String storedPassword = scanner.nextLine();
            String contactNumber = scanner.nextLine();

            // Skip the space line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            if (storedUserID.equals(userID) && storedPassword.equals(password)) {
                return true;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while reading user data.");
    }

    return false;
}

    private void navigateToUserPage(String userID) {
        // Implement navigation to the user's page based on the user ID
        // You can open a new window or perform any other actions here.
        JOptionPane.showMessageDialog(null, "Welcome, User " + userID + "!");
    }
}