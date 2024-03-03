package demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.UtilisateurDTO;
import demo.models.infra.Utilisateur;

@RestController
public class UtilsateurController {
    @GetMapping("/utilisateurs")
    public UtilisateurDTO get() {
        UtilisateurDTO personDTO = new UtilisateurDTO();
        try {
            personDTO.setUtilisateurs(new Utilisateur().select());
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @GetMapping("/utilisateurs/{id}")
    public UtilisateurDTO getById(@PathVariable("id") Integer id) {
        UtilisateurDTO personDTO = new UtilisateurDTO();
        try {
            personDTO.setUtilisateurs(new Utilisateur().selectWhere("id=" + id));
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @PostMapping("/utilisateurs")
    public UtilisateurDTO insert(@RequestBody Utilisateur p) {
        UtilisateurDTO personDTO = new UtilisateurDTO();
        try {
            p.insert();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
            ;
        }
        return personDTO;
    }

    @PutMapping("/utilisateurs/{id}")
    public UtilisateurDTO putMethodName(@PathVariable("id") Integer id, @RequestBody Utilisateur p) {
        UtilisateurDTO personDTO = new UtilisateurDTO();
        p.setIdutilisateur(id);
        try {
            p.updateById();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @DeleteMapping("/utilisateurs/{id}")
    public UtilisateurDTO delete(@PathVariable("id") Integer id, @RequestBody Utilisateur p) {
        UtilisateurDTO personDTO = new UtilisateurDTO();
        p.setIdutilisateur(id);
        try {
            p.deleteWhere("id=" + id);
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }
}
