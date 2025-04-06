package controllers;

import models.Utilisateur;

import java.util.ArrayList;

public class UserController {
    private ArrayList<Utilisateur> utilisateurs;

    public UserController() {
        utilisateurs = new ArrayList<>();
        // Ajouter un utilisateur administrateur par défaut (optionnel)
        utilisateurs.add(new Utilisateur("admin", "Administrateur"));
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public boolean utilisateurExiste(String nom, String role) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getNom().equalsIgnoreCase(nom) && utilisateur.getRole().equals(role)) {
                return true;
            }
        }
        return false;
    }
}
