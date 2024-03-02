package demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.MarqueDTO;
import demo.models.references.Marque;

@RestController
public class MarqueController {
    @GetMapping("/marques")
    public MarqueDTO get() {
        MarqueDTO personDTO = new MarqueDTO();
        try {
            personDTO.setMarques(new Marque().select());
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @GetMapping("/marques/{id}")
    public MarqueDTO getById(@PathVariable("id") Integer id) {
        MarqueDTO personDTO = new MarqueDTO();
        try {
            personDTO.setMarques(new Marque().selectWhere("id=" + id));
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @PostMapping("/marques")
    public MarqueDTO insert(@RequestBody Marque p) {
        MarqueDTO personDTO = new MarqueDTO();
        try {
            p.insert();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
            ;
        }
        return personDTO;
    }

    @PutMapping("/marques/{id}")
    public MarqueDTO putMethodName(@PathVariable("id") Integer id, @RequestBody Marque p) {
        MarqueDTO personDTO = new MarqueDTO();
        p.setIdlaptopmarque(id);
        try {
            p.updateById();
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }

    @DeleteMapping("/marques/{id}")
    public MarqueDTO delete(@PathVariable("id") Integer id, @RequestBody Marque p) {
        MarqueDTO personDTO = new MarqueDTO();
        p.setIdlaptopmarque(id);
        try {
            p.deleteWhere("id=" + id);
        } catch (Exception e) {
            personDTO.setErrors(e.getMessage());
        }
        return personDTO;
    }
}
