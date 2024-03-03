package demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.AffectationDTO;
import demo.models.ordre.Affectation;

@RestController
public class AffectationController {
    @GetMapping("/affectations")
    public AffectationDTO get() {
        AffectationDTO personDTO = new AffectationDTO();
        try {
            personDTO.setAffectations(new Affectation().select());
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @GetMapping("/affectations/{id}")
    public AffectationDTO getById(@PathVariable("id") Integer id) {
        AffectationDTO personDTO = new AffectationDTO();
        try {
            personDTO.setAffectations(new Affectation().selectWhere("id=" + id));
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @PostMapping("/affectations")
    public AffectationDTO insert(@RequestBody Affectation p) {
        AffectationDTO personDTO = new AffectationDTO();
        try {
            p.insert();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
            ;
        }
        return personDTO;
    }

    @PutMapping("/affectations/{id}")
    public AffectationDTO putMethodName(@PathVariable("id") Integer id, @RequestBody Affectation p) {
        AffectationDTO personDTO = new AffectationDTO();
        p.setIdaffectationutilisateur(id);
        try {
            p.updateById();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @DeleteMapping("/affectations/{id}")
    public AffectationDTO delete(@PathVariable("id") Integer id, @RequestBody Affectation p) {
        AffectationDTO personDTO = new AffectationDTO();
        p.setIdaffectationutilisateur(id);
        try {
            p.deleteWhere("id=" + id);
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }
}
