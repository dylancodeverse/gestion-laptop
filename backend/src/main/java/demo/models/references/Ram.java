package demo.models.references;

import orm.DynamicORM;

public class Ram extends DynamicORM<Ram> {
    Integer idramtype;
    String ram;

    public Integer getIdramtype() {
        return idramtype;
    }

    public void setIdramtype(Integer idramtype) {
        this.idramtype = idramtype;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }
}
