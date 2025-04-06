package models;

public class Livre {
    private String titre;
    private String auteur;
    private String genre;
   private boolean estDisponible;

    public Livre(String titre, String auteur, String genre) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
       this.estDisponible = true; // Par défaut, un nouveau livre est disponible
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isDisponible() {
        return estDisponible;
    }

   /* public void setDisponible(boolean disponible) {
        this.estDisponible = disponible;
    } */
}
