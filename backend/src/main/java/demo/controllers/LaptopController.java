package demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.LaptopDTO;
import demo.models.laptops.Laptop;

@RestController
public class LaptopController {
    @GetMapping("/laptops")
    public LaptopDTO get() {
        LaptopDTO personDTO = new LaptopDTO();
        try {
            personDTO.setLaptops(new Laptop().select());
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @GetMapping("/laptops/{id}")
    public LaptopDTO getById(@PathVariable("id") Integer id) {
        LaptopDTO personDTO = new LaptopDTO();
        try {
            personDTO.setLaptops(new Laptop().selectWhere("id=" + id));
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @PostMapping("/laptops")
    public LaptopDTO insert(@RequestBody Laptop p) {
        LaptopDTO personDTO = new LaptopDTO();
        try {
            p.insert();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
            ;
        }
        return personDTO;
    }

    @PutMapping("/laptops/{id}")
    public LaptopDTO putMethodName(@PathVariable("id") Integer id, @RequestBody Laptop p) {
        LaptopDTO personDTO = new LaptopDTO();
        p.setLaptopid(id);
        try {
            p.updateById();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @DeleteMapping("/laptops/{id}")
    public LaptopDTO delete(@PathVariable("id") Integer id, @RequestBody Laptop p) {
        LaptopDTO personDTO = new LaptopDTO();
        p.setLaptopid(id);
        try {
            p.deleteWhere("id=" + id);
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }
}
