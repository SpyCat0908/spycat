package Araiguma.SpyCat.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Araiguma.SpyCat.Models.Localization;
import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Services.PetService;
import Araiguma.SpyCat.Services.UserService;


@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired

    private PetService service;
    
    @PostMapping("/create")
    public ResponseEntity<Pet> create(@RequestBody Pet pet){
        Pet PetCriado = service.create(pet);
        ResponseEntity<Pet> resposta = new ResponseEntity<>(PetCriado, HttpStatus.CREATED);
        return resposta;
    }
}
