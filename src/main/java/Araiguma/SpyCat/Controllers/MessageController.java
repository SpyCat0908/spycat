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

import Araiguma.SpyCat.Models.Message;
import Araiguma.SpyCat.Services.MessageService;


@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired

    private MessageService service;
    
    @PostMapping
    public ResponseEntity<Message> create(@RequestBody Message message){
        Message MessageCriado = service.create(message);
        return new ResponseEntity<>(MessageCriado, HttpStatus.CREATED);
    }
    @PutMapping
        public ResponseEntity<Message> update(@RequestBody Message message){
        Message messageUpdate = service.update(message);
        return new ResponseEntity<>(messageUpdate, HttpStatus.OK);
    }
    @GetMapping("/{id}")
        public ResponseEntity<Message> read (@PathVariable Long id){
            Message messageBuscado = service.read(id);
            return new ResponseEntity<Message>(messageBuscado,HttpStatus.OK);
    }
    @GetMapping
        public ResponseEntity<List<Message>> list(){
            List<Message> listMessages = service.list();
            return new ResponseEntity<List<Message>>(listMessages, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<Message> delete( @PathVariable Long id){
            service.delete(id);
            return new ResponseEntity<Message>(HttpStatus.NO_CONTENT);
        }
}
