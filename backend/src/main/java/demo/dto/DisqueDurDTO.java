package demo.dto;

import demo.models.references.DisqueDur;

public class DisqueDurDTO {
    DisqueDur[] disqueDurs;
    String errors;

    public DisqueDur[] getDisqueDurs() {
        return disqueDurs;
    }

    public void setDisqueDurs(DisqueDur[] disqueDurs) {
        this.disqueDurs = disqueDurs;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
