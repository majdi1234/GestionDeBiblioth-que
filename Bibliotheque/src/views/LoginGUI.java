package views;

import controllers.UserController;
import models.Role;
import models.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {
    private UserController userController;

    public LoginGUI() {
        userController = new UserController();

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblNom = new JLabel("Nom:");
        JLabel lblRole = new JLabel("Rôle:");
        JTextField txtNom = new JTextField();
        String[] roles = {"Administrateur", "Lecteur"};
        JComboBox<String> cbRole = new JComboBox<>(roles);

        JButton btnLogin = new JButton("Connexion");
        JButton btnSignUp = new JButton("S'inscrire");

        panel.add(lblNom);
        panel.add(txtNom);
        panel.add(lblRole);
        panel.add(cbRole);

        add(panel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(btnLogin);
        btnPanel.add(btnSignUp);
        add(btnPanel, BorderLayout.SOUTH);

        // Action pour le bouton de connexion
        btnLogin.addActionListener((ActionEvent e) -> {
            String nom = txtNom.getText().trim();
            String role = cbRole.getSelectedItem().toString();

            if (nom.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le nom est requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (userController.utilisateurExiste(nom, role)) {
                JOptionPane.showMessageDialog(this, "Connexion réussie !", "Info", JOptionPane.INFORMATION_MESSAGE);
                if (role.equals("Administrateur")) {
                    new MainGUI(true).setVisible(true);
                } else {
                    new MainGUI(false).setVisible(true);
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Utilisateur introuvable. Veuillez vous inscrire.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action pour le bouton d'inscription
        btnSignUp.addActionListener((ActionEvent e) -> {
            String nom = txtNom.getText().trim();
            String role = cbRole.getSelectedItem().toString();

            if (nom.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Le nom est requis pour s'inscrire.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!userController.utilisateurExiste(nom, role)) {
                userController.ajouterUtilisateur(new Utilisateur(nom, role));
                JOptionPane.showMessageDialog(this, "Inscription réussie. Vous pouvez maintenant vous connecter.", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Utilisateur déjà existant.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGUI login = new LoginGUI();
            login.setVisible(true);
        });
    }
}
