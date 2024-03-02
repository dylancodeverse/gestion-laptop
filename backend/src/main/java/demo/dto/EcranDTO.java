package demo.dto;

import demo.models.references.Ecran;

public class EcranDTO {
    Ecran[] ecrans;
    String errors;

    public Ecran[] getEcrans() {
        return ecrans;
    }

    public void setEcrans(Ecran[] ecrans) {
        this.ecrans = ecrans;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
