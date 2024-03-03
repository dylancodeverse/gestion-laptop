package demo.dto;

import demo.models.infra.Emplacement;

public class EmplacementDTO {
    Emplacement[] emplacements;
    String errors;

    public Emplacement[] getEmplacements() {
        return emplacements;
    }

    public void setEmplacements(Emplacement[] emplacements) {
        this.emplacements = emplacements;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
