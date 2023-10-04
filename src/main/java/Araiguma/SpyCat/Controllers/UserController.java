package Araiguma.SpyCat.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Araiguma.SpyCat.Models.User;
import Araiguma.SpyCat.Services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired

    private UserService service;
    
    @PostMapping("/postUser")
    public ResponseEntity<User> create(@RequestBody User user){
        User userCriado = service.create(user);
        ResponseEntity<User> resposta = new ResponseEntity<>(userCriado, HttpStatus.CREATED);
        return resposta;
    }
}
