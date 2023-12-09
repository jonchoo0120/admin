package universityfoodorderingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// AdminPage class representing the admin page
public class AdminPageGUI extends JFrame {

    public AdminPageGUI() {
        setTitle("Admin Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create buttons
        JButton modifyBtn = new JButton("Modify");
        JButton topUpBtn = new JButton("Top-Up");
        JButton logoutBtn = new JButton("Log-Out");

        // Add action listeners to the buttons
        modifyBtn.addActionListener(new ButtonClickListener("Modify"));
        topUpBtn.addActionListener(new ButtonClickListener("Top-Up"));
        logoutBtn.addActionListener(new ButtonClickListener("Log-Out"));

        // Add buttons to the frame
        add(modifyBtn);
        add(topUpBtn);
        add(logoutBtn);

        // Set frame properties
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Action listener class for button clicks
    private class ButtonClickListener implements ActionListener {
        private String operation;

        public ButtonClickListener(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (operation.equals("Modify")) {
                // Open the AdminManageGUI when "Modify" button is clicked
                new AdminManageGUI();
            } else {
                JOptionPane.showMessageDialog(null, "Executing " + operation + " operation...");
            }
        }
    }

    public static void main(String[] args) {
        new AdminPageGUI();
    }
}

