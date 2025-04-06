package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {
    public MainGUI(boolean isAdmin) {
        setTitle("Système de Gestion de Bibliothèque");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout());
        JButton btnLivres = new JButton("Gérer les Livres");
        JButton btnUtilisateurs = new JButton("Gérer les Utilisateurs");

        panel.add(btnLivres);

        if (isAdmin) {
            panel.add(btnUtilisateurs);
        }

        add(panel, BorderLayout.CENTER);

        btnLivres.addActionListener((ActionEvent e) -> {
            new LivreGUI().setVisible(true);
        });

        btnUtilisateurs.addActionListener((ActionEvent e) -> {
            new UtilisateurGUI().setVisible(true);
        });
    }
}
