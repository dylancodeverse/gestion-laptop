package demo.dto;

import demo.models.references.Processeur;

public class ProcesseurDTO {
    Processeur[] processeurs;
    String errors;

    public Processeur[] getProcesseurs() {
        return processeurs;
    }

    public void setProcesseurs(Processeur[] processeurs) {
        this.processeurs = processeurs;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
