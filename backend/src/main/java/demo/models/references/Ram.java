package demo.models.references;

import orm.DynamicORM;
import orm.annotations.Id;

public class Ram extends DynamicORM<Ram> {
    @Id
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
