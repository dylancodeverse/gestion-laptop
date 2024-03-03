package demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.EmplacementDTO;
import demo.models.infra.Emplacement;

@RestController
public class EmplacementController {
    @GetMapping("/emplacements")
    public EmplacementDTO get() {
        EmplacementDTO personDTO = new EmplacementDTO();
        try {
            personDTO.setEmplacements(new Emplacement().select());
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @GetMapping("/emplacements/{id}")
    public EmplacementDTO getById(@PathVariable("id") Integer id) {
        EmplacementDTO personDTO = new EmplacementDTO();
        try {
            personDTO.setEmplacements(new Emplacement().selectWhere("id=" + id));
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @PostMapping("/emplacements")
    public EmplacementDTO insert(@RequestBody Emplacement p) {
        EmplacementDTO personDTO = new EmplacementDTO();
        try {
            p.insert();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
            ;
        }
        return personDTO;
    }

    @PutMapping("/emplacements/{id}")
    public EmplacementDTO putMethodName(@PathVariable("id") Integer id, @RequestBody Emplacement p) {
        EmplacementDTO personDTO = new EmplacementDTO();
        p.setIdemplacement(id);
        try {
            p.updateById();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @DeleteMapping("/emplacements/{id}")
    public EmplacementDTO delete(@PathVariable("id") Integer id, @RequestBody Emplacement p) {
        EmplacementDTO personDTO = new EmplacementDTO();
        p.setIdemplacement(id);
        try {
            p.deleteWhere("id=" + id);
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }
}
