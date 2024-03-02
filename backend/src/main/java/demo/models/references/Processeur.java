package demo.models.references;

import orm.DynamicORM;

public class Processeur extends DynamicORM<Processeur> {
    Integer idprocesseurtype;
    String processeur;

    public Integer getIdprocesseurtype() {
        return idprocesseurtype;
    }

    public void setIdprocesseurtype(Integer idprocesseurtype) {
        this.idprocesseurtype = idprocesseurtype;
    }

    public String getProcesseur() {
        return processeur;
    }

    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }
}
