package demo.models.infra;

import orm.DynamicORM;
import orm.annotations.Id;

public class Emplacement extends DynamicORM<Emplacement> {
    @Id
    Integer idemplacement;
    String emplacement;
    Integer hierarchie;

    public Integer getIdemplacement() {
        return idemplacement;
    }

    public void setIdemplacement(Integer idemplacement) {
        this.idemplacement = idemplacement;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public Integer getHierarchie() {
        return hierarchie;
    }

    public void setHierarchie(Integer hierarchie) {
        this.hierarchie = hierarchie;
    }
}
