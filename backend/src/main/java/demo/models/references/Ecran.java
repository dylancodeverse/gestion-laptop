package demo.models.references;

import orm.DynamicORM;
import orm.annotations.Id;

public class Ecran extends DynamicORM<Ecran> {
    @Id
    Integer idecran;
    String ecran;

    public Integer getIdecran() {
        return idecran;
    }

    public void setIdecran(Integer idecran) {
        this.idecran = idecran;
    }

    public String getEcran() {
        return ecran;
    }

    public void setEcran(String ecran) {
        this.ecran = ecran;
    }
}
