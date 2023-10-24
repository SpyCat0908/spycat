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

import Araiguma.SpyCat.Models.User;
import Araiguma.SpyCat.Services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired

    private UserService service;
    
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User UserCriado = service.create(user);
        return new ResponseEntity<>(UserCriado, HttpStatus.CREATED);
    }
    @PutMapping
        public ResponseEntity<User> update(@RequestBody User user){
        User userUpdate = service.update(user);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }
    @GetMapping("/{id}")
        public ResponseEntity<User> read (@PathVariable Long id){
            User userBuscado = service.read(id);
            return new ResponseEntity<User>(userBuscado,HttpStatus.OK);
    }
    @GetMapping
        public ResponseEntity<List<User>> list(){
            List<User> listUsers = service.list();
            return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<User> delete( @PathVariable Long id){
            service.delete(id);
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
}
