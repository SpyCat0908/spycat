package Araiguma.SpyCat.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Araiguma.SpyCat.Models.Localization;
import Araiguma.SpyCat.Services.LocalizationService;


@RestController
@RequestMapping("/localizations")
public class LocalizationController {
    @Autowired

    private LocalizationService service;
    
    @PostMapping
    public ResponseEntity<Localization> create(@RequestBody Localization localization){
        Localization LocalizationCriado = service.create(localization);
        return new ResponseEntity<>(LocalizationCriado, HttpStatus.CREATED);
    }
    @PutMapping
        public ResponseEntity<Localization> update(@RequestBody Localization localization){
        Localization localizationUpdate = service.update(localization);
        return new ResponseEntity<>(localizationUpdate, HttpStatus.OK);
    }
    @GetMapping("/{id}")
        public ResponseEntity<Localization> read (@PathVariable Long id){
            Localization localizationBuscado = service.read(id);
            return new ResponseEntity<Localization>(localizationBuscado,HttpStatus.OK);
    }
    @GetMapping
        public ResponseEntity<List<Localization>> list(){
            List<Localization> listLocalizations = service.list();
            return new ResponseEntity<List<Localization>>(listLocalizations, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<Localization> delete( @PathVariable Long id){
            service.delete(id);
            return new ResponseEntity<Localization>(HttpStatus.NO_CONTENT);
        }
}
