package demo.dto;

import demo.models.ordre.Affectation;

public class AffectationDTO {
    Affectation[] affectations;
    String errors;

    public Affectation[] getAffectations() {
        return affectations;
    }

    public void setAffectations(Affectation[] affectations) {
        this.affectations = affectations;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
