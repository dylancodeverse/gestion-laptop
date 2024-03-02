package demo.models.references;

import orm.DynamicORM;

public class Ecran extends DynamicORM<Ecran> {
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
