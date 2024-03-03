package demo.dto;

import demo.models.infra.Utilisateur;

public class UtilisateurDTO {
    Utilisateur[] utilisateurs;
    String errors;

    public Utilisateur[] getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Utilisateur[] utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
