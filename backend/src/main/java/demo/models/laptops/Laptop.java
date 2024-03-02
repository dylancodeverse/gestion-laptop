package demo.models.laptops;

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

}
