package Araiguma.SpyCat.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Services.PetService;
import Araiguma.SpyCat.dtos.PetInputDTO;
import Araiguma.SpyCat.dtos.PetOutputDTO;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/pets")
@CrossOrigin("*")
public class PetController {
    @Autowired

    private PetService service;
    
    @PostMapping
    public ResponseEntity<Pet> create(@Valid @RequestBody PetInputDTO pet){
        Pet PetCriado = service.create(pet);
        return new ResponseEntity<Pet>(PetCriado, HttpStatus.CREATED);
    }
    @PutMapping
        public ResponseEntity<PetOutputDTO> update(@Valid @RequestBody PetInputDTO pet){
        PetOutputDTO petUpdate = service.update(pet);
        return new ResponseEntity<>(petUpdate, HttpStatus.OK);
    }
    @GetMapping("/{id}")
        public ResponseEntity<Pet> read (@PathVariable Long id){
            Pet petBuscado = service.read(id);
            return new ResponseEntity<Pet>(petBuscado,HttpStatus.OK);
    }
    @GetMapping
        public ResponseEntity<List<Pet>> list(Pet pet){
            List<Pet> listPets = service.list(pet);
            return new ResponseEntity<List<Pet>>(listPets, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<Pet> delete( @PathVariable Long id){
            service.delete(id);
            return new ResponseEntity<Pet>(HttpStatus.NO_CONTENT);
        }
}
