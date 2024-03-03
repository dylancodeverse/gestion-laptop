package demo.models.ordre;

import java.sql.Timestamp;

import orm.DynamicORM;
import orm.annotations.Id;

public class Affectation extends DynamicORM<Affectation> {
    @Id
    Integer idaffectationutilisateur;
    Integer idutilisateur;
    Integer idemplacement;
    Timestamp datedebut;
    Timestamp datefin;

    public Integer getIdaffectationutilisateur() {
        return idaffectationutilisateur;
    }

    public void setIdaffectationutilisateur(Integer idaffectationutilisateur) {
        this.idaffectationutilisateur = idaffectationutilisateur;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getIdemplacement() {
        return idemplacement;
    }

    public void setIdemplacement(Integer idemplacement) {
        this.idemplacement = idemplacement;
    }

    public Timestamp getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Timestamp datedebut) {
        this.datedebut = datedebut;
    }

    public Timestamp getDatefin() {
        return datefin;
    }

    public void setDatefin(Timestamp datefin) {
        this.datefin = datefin;
    }
}
