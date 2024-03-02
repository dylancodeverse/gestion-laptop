package demo.models.references;

import orm.DynamicORM;

public class Marque extends DynamicORM<Marque> {
    Integer idlaptopmarque;
    String laptopmarque;

    public Integer getIdlaptopmarque() {
        return idlaptopmarque;
    }

    public void setIdlaptopmarque(Integer idlaptopmarque) {
        this.idlaptopmarque = idlaptopmarque;
    }

    public String getLaptopmarque() {
        return laptopmarque;
    }

    public void setLaptopmarque(String laptopmarque) {
        this.laptopmarque = laptopmarque;
    }
}
