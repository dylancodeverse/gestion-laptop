package demo.models.laptops;

import java.sql.Connection;

import orm.DynamicORM;

public class ModelLaptop extends DynamicORM<ModelLaptop> {
    Integer idmodellaptop;
    Integer laptopid;

    public Integer getIdmodellaptop() {
        return idmodellaptop;
    }

    public void setIdmodellaptop(Integer idmodellaptop) {
        this.idmodellaptop = idmodellaptop;
    }

    public Integer getLaptopid() {
        return laptopid;
    }

    public void setLaptopid(Integer laptopid) {
        this.laptopid = laptopid;
    }

    public void setIdmodellaptop(String laptop, Connection connection) throws Exception {
        setIdmodellaptop(Integer.parseInt(laptop));
        ModelLaptop[] ms = selectWhere(connection, true, "idmodellaptop=" + getIdmodellaptop());
        if (ms.length == 0) {
            throw new Exception("Ce modele de laptop est introuvable");
        }
        setLaptopid(ms[0].getLaptopid());
    }
}
