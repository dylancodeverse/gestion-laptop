package demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.ProcesseurDTO;
import demo.models.references.Processeur;

@RestController
public class ProcesseurController {
    @GetMapping("/processeurs")
    public ProcesseurDTO get() {
        ProcesseurDTO personDTO = new ProcesseurDTO();
        try {
            personDTO.setProcesseurs(new Processeur().select());
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @GetMapping("/processeurs/{id}")
    public ProcesseurDTO getById(@PathVariable("id") Integer id) {
        ProcesseurDTO personDTO = new ProcesseurDTO();
        try {
            personDTO.setProcesseurs(new Processeur().selectWhere("id=" + id));
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @PostMapping("/processeurs")
    public ProcesseurDTO insert(@RequestBody Processeur p) {
        ProcesseurDTO personDTO = new ProcesseurDTO();
        try {
            p.insert();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
            ;
        }
        return personDTO;
    }

    @PutMapping("/processeurs/{id}")
    public ProcesseurDTO putMethodName(@PathVariable("id") Integer id, @RequestBody Processeur p) {
        ProcesseurDTO personDTO = new ProcesseurDTO();
        p.setIdprocesseurtype(id);
        try {
            p.updateById();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @DeleteMapping("/processeurs/{id}")
    public ProcesseurDTO delete(@PathVariable("id") Integer id, @RequestBody Processeur p) {
        ProcesseurDTO personDTO = new ProcesseurDTO();
        p.setIdprocesseurtype(id);
        try {
            p.deleteWhere("id=" + id);
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }
}
