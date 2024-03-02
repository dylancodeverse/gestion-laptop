package demo.dto;

import demo.models.references.Ram;

public class RamDTO {
    Ram[] rams;
    String errors;

    public Ram[] getRams() {
        return rams;
    }

    public void setRams(Ram[] rams) {
        this.rams = rams;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
