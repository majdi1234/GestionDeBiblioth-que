package controllers;

import models.Livre;
import java.util.ArrayList;

public class BibliothequeController {
    private ArrayList<Livre> livres;

    public BibliothequeController() {
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public ArrayList<Livre> getLivres() {
        return livres;
    }

   

    public boolean supprimerLivre(String titre) {
        return livres.removeIf(livre -> livre.getTitre().equalsIgnoreCase(titre));
    }
}
