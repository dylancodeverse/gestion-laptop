package demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.EcranDTO;
import demo.models.references.Ecran;

@RestController
public class EcranController {
    @GetMapping("/ecrans")
    public EcranDTO get() {
        EcranDTO personDTO = new EcranDTO();
        try {
            personDTO.setEcrans(new Ecran().select());
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @GetMapping("/ecrans/{id}")
    public EcranDTO getById(@PathVariable("id") Integer id) {
        EcranDTO personDTO = new EcranDTO();
        try {
            personDTO.setEcrans(new Ecran().selectWhere("id=" + id));
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @PostMapping("/ecrans")
    public EcranDTO insert(@RequestBody Ecran p) {
        EcranDTO personDTO = new EcranDTO();
        try {
            p.insert();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
            ;
        }
        return personDTO;
    }

    @PutMapping("/ecrans/{id}")
    public EcranDTO putMethodName(@PathVariable("id") Integer id, @RequestBody Ecran p) {
        EcranDTO personDTO = new EcranDTO();
        p.setIdecran(id);
        try {
            p.updateById();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @DeleteMapping("/ecrans/{id}")
    public EcranDTO delete(@PathVariable("id") Integer id, @RequestBody Ecran p) {
        EcranDTO personDTO = new EcranDTO();
        p.setIdecran(id);
        try {
            p.deleteWhere("id=" + id);
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }
}
