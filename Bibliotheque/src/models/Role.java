package models;

public enum Role {
    ADMINISTRATEUR("Administrateur"),
    LECTEUR("Lecteur");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
