package demo.models.infra;

import orm.DynamicORM;
import orm.annotations.Id;

public class Utilisateur extends DynamicORM<Utilisateur> {
    @Id
    Integer idutilisateur;
    String utilisateur;
    String mail;

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
