package demo.models.references;

import orm.DynamicORM;
import orm.annotations.Id;

public class Processeur extends DynamicORM<Processeur> {
    @Id
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
