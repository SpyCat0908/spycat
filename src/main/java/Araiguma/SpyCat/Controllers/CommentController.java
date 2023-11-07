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

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Services.CommentService;
import Araiguma.SpyCat.dtos.CommentInputDTO;
import Araiguma.SpyCat.dtos.CommentOutputDTO;


@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired

    private CommentService service;
    
    @PostMapping
    public ResponseEntity<CommentOutputDTO> create(@RequestBody CommentInputDTO comment){
        CommentOutputDTO CommentCriado = service.create(comment);
        return new ResponseEntity<CommentOutputDTO>(CommentCriado, HttpStatus.CREATED);
    }
    @PutMapping
        public ResponseEntity<Comment> update(@RequestBody Comment comment){
        Comment commentUpdate = service.update(comment);
        return new ResponseEntity<>(commentUpdate, HttpStatus.OK);
    }
    @GetMapping("/{id}")
        public ResponseEntity<Comment> read (@PathVariable Long id){
            Comment commentBuscado = service.read(id);
            return new ResponseEntity<Comment>(commentBuscado,HttpStatus.OK);
    }
    @GetMapping
        public ResponseEntity<List<Comment>> list(){
            List<Comment> listComments = service.list();
            return new ResponseEntity<List<Comment>>(listComments, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<Comment> delete( @PathVariable Long id){
            service.delete(id);
            return new ResponseEntity<Comment>(HttpStatus.NO_CONTENT);
        }
}