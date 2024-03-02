package demo.dto;

import demo.models.references.Marque;

public class MarqueDTO {
    Marque[] marques;
    String errors;

    public Marque[] getMarques() {
        return marques;
    }

    public void setMarques(Marque[] marques) {
        this.marques = marques;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
