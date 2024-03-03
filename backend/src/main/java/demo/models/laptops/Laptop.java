package demo.models.laptops;

import java.sql.Connection;

import orm.DynamicORM;
import orm.annotations.Id;

public class Laptop extends DynamicORM<Laptop> {
    @Id
    Integer laptopid;
    Integer marque;
    String reference;
    Integer processeur;
    Integer ram;
    Integer ecran;
    Integer disquedur;

    public Integer getLaptopid() {
        return laptopid;
    }

    public void setLaptopid(Integer laptopid) {
        this.laptopid = laptopid;
    }

    public Integer getMarque() {
        return marque;
    }

    public void setMarque(Integer marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getProcesseur() {
        return processeur;
    }

    public void setProcesseur(Integer processeur) {
        this.processeur = processeur;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getEcran() {
        return ecran;
    }

    public void setEcran(Integer ecran) {
        this.ecran = ecran;
    }

    public Integer getDisquedur() {
        return disquedur;
    }

    public void setDisquedur(Integer disquedur) {
        this.disquedur = disquedur;
    }

    public void setLaptopid(String laptopid2, Connection connection) throws Exception {
        Integer i = Integer.parseInt(laptopid2);
        setLaptopid(i);
        Laptop[] ls = selectWhere(connection, true, "laptopid=" + getLaptopid());
        if (ls.length == 0) {
            throw new Exception("Ce laptop est introuvable : laptopid=" + getLaptopid());
        }
        setDisquedur(ls[0].getDisquedur());
        setEcran(ls[0].getEcran());
        setMarque(ls[0].getMarque());
        setProcesseur(ls[0].getProcesseur());
        setRam(ls[0].getRam());
        setReference(ls[0].getReference());
    }

}
