package demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.DisqueDurDTO;
import demo.models.references.DisqueDur;

@RestController
public class DisqueDurController {
    @GetMapping("/disquedurs")
    public DisqueDurDTO get() {
        DisqueDurDTO personDTO = new DisqueDurDTO();
        try {
            personDTO.setDisqueDurs(new DisqueDur().select());
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @GetMapping("/disquedurs/{id}")
    public DisqueDurDTO getById(@PathVariable("id") Integer id) {
        DisqueDurDTO personDTO = new DisqueDurDTO();
        try {
            personDTO.setDisqueDurs(new DisqueDur().selectWhere("id=" + id));
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @PostMapping("/disquedurs")
    public DisqueDurDTO insert(@RequestBody DisqueDur p) {
        DisqueDurDTO personDTO = new DisqueDurDTO();
        try {
            p.insert();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
            ;
        }
        return personDTO;
    }

    @PutMapping("/disquedurs/{id}")
    public DisqueDurDTO putMethodName(@PathVariable("id") Integer id, @RequestBody DisqueDur p) {
        DisqueDurDTO personDTO = new DisqueDurDTO();
        p.setIddisquedur(id);
        try {
            p.updateById();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @DeleteMapping("/disquedurs/{id}")
    public DisqueDurDTO delete(@PathVariable("id") Integer id, @RequestBody DisqueDur p) {
        DisqueDurDTO personDTO = new DisqueDurDTO();
        p.setIddisquedur(id);
        try {
            p.deleteWhere("id=" + id);
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }
}
