package demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.RamDTO;
import demo.models.references.Ram;

@RestController
public class RamController {
    @GetMapping("/rams")
    public RamDTO get() {
        RamDTO personDTO = new RamDTO();
        try {
            personDTO.setRams(new Ram().select());
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @GetMapping("/rams/{id}")
    public RamDTO getById(@PathVariable("id") Integer id) {
        RamDTO personDTO = new RamDTO();
        try {
            personDTO.setRams(new Ram().selectWhere("id=" + id));
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @PostMapping("/rams")
    public RamDTO insert(@RequestBody Ram p) {
        RamDTO personDTO = new RamDTO();
        try {
            p.insert();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
            ;
        }
        return personDTO;
    }

    @PutMapping("/rams/{id}")
    public RamDTO putMethodName(@PathVariable("id") Integer id, @RequestBody Ram p) {
        RamDTO personDTO = new RamDTO();
        p.setIdramtype(id);
        try {
            p.updateById();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @DeleteMapping("/rams/{id}")
    public RamDTO delete(@PathVariable("id") Integer id, @RequestBody Ram p) {
        RamDTO personDTO = new RamDTO();
        p.setIdramtype(id);
        try {
            p.deleteWhere("id=" + id);
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }
}
