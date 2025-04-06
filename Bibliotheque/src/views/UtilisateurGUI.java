package views;

import controllers.UserController;
import models.Role;
import models.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UtilisateurGUI extends JFrame {
    private UserController userController;

    public UtilisateurGUI() {
        userController = new UserController();

        setTitle("Gestion des Utilisateurs");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel actionsPanel = new JPanel(new FlowLayout());
        JButton btnAjouter = new JButton("Ajouter Utilisateur");
        JButton btnConsulter = new JButton("Consulter Utilisateurs");
        actionsPanel.add(btnAjouter);
        actionsPanel.add(btnConsulter);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        mainPanel.add(actionsPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel);

        btnAjouter.addActionListener(e -> {
            String nom = JOptionPane.showInputDialog(this, "Nom de l'Utilisateur :");
            String[] roles = {Role.ADMINISTRATEUR.getRoleName(), Role.LECTEUR.getRoleName()};
            String role = (String) JOptionPane.showInputDialog(this, "Rôle de l'Utilisateur :",
                    "Sélectionnez un rôle", JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]);

            if (nom != null && role != null) {
                userController.ajouterUtilisateur(new Utilisateur(nom, role));
                JOptionPane.showMessageDialog(this, "Utilisateur ajouté avec succès !");
            }
        });

        btnConsulter.addActionListener(e -> {
            ArrayList<Utilisateur> utilisateurs = userController.getUtilisateurs();
            StringBuilder result = new StringBuilder("Liste des Utilisateurs :\n");

            for (Utilisateur utilisateur : utilisateurs) {
                result.append("- ").append(utilisateur.getNom())
                      .append(" | Rôle: ").append(utilisateur.getRole())
                      .append("\n");
            }

            textArea.setText(result.toString());
        });
    }
}
