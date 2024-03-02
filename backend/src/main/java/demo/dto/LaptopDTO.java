package demo.dto;

import demo.models.laptops.Laptop;

public class LaptopDTO {
    Laptop[] laptops;
    String errors;

    public Laptop[] getLaptops() {
        return laptops;
    }

    public void setLaptops(Laptop[] laptops) {
        this.laptops = laptops;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
