package views;

import controllers.BibliothequeController;
import models.Livre;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LivreGUI extends JFrame {
    private BibliothequeController bibliothequeController;

    public LivreGUI() {
        bibliothequeController = new BibliothequeController();

        setTitle("Gestion des Livres");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel actionsPanel = new JPanel(new FlowLayout());
        JButton btnAjouter = new JButton("Ajouter Livre");
        JButton btnConsulter = new JButton("Consulter Livres");
        JButton btnSupprimer = new JButton("Supprimer Livre");
        actionsPanel.add(btnAjouter);
        actionsPanel.add(btnConsulter);
        actionsPanel.add(btnSupprimer);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        mainPanel.add(actionsPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel);

        btnAjouter.addActionListener(e -> {
            String titre = JOptionPane.showInputDialog(this, "Titre du Livre :");
            String auteur = JOptionPane.showInputDialog(this, "Auteur du Livre :");
            String genre = JOptionPane.showInputDialog(this, "Genre du Livre :");

            if (titre != null && auteur != null && genre != null) {
                bibliothequeController.ajouterLivre(new Livre(titre, auteur, genre));
                JOptionPane.showMessageDialog(this, "Livre ajouté avec succès !");
            }
        });

        btnConsulter.addActionListener(e -> {
            ArrayList<Livre> livres = bibliothequeController.getLivres();
            StringBuilder result = new StringBuilder("Liste des Livres :\n");

            for (Livre livre : livres) {
                result.append("- ").append(livre.getTitre())
                      .append(" | Auteur: ").append(livre.getAuteur())
                      .append(" | Genre: ").append(livre.getGenre())
                      .append("\n");
            }

            textArea.setText(result.toString());
        });

        btnSupprimer.addActionListener(e -> {
            String titre = JOptionPane.showInputDialog(this, "Titre du Livre à supprimer :");

            if (titre != null && bibliothequeController.supprimerLivre(titre)) {
                JOptionPane.showMessageDialog(this, "Livre supprimé avec succès !");
            } else {
                JOptionPane.showMessageDialog(this, "Livre introuvable !");
            }
        });
    }
}
