package models;

public class Utilisateur {
    private String nom;
    private String role;

    public Utilisateur(String nom, String role) {
        this.nom = nom;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
