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

import Araiguma.SpyCat.Models.Images;
import Araiguma.SpyCat.Services.ImagesService;


@RestController
@RequestMapping("/images")
public class ImagesController {
    
    @Autowired
    private ImagesService service;
    
    @PostMapping
    public ResponseEntity<Images> create(@RequestBody Images images){
        Images ImagesCriado = service.create(images);
        return new ResponseEntity<>(ImagesCriado, HttpStatus.CREATED);
    }
    @PutMapping
        public ResponseEntity<Images> update(@RequestBody Images images){
        Images imagesUpdate = service.update(images);
        return new ResponseEntity<>(imagesUpdate, HttpStatus.OK);
    }
    @GetMapping("/{id}")
        public ResponseEntity<Images> read (@PathVariable Long id){
            Images imagesBuscado = service.read(id);
            return new ResponseEntity<Images>(imagesBuscado,HttpStatus.OK);
    }
    @GetMapping
        public ResponseEntity<List<Images>> list(){
            List<Images> listImagess = service.list();
            return new ResponseEntity<List<Images>>(listImagess, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
        public ResponseEntity<Images> delete( @PathVariable Long id){
            service.delete(id);
            return new ResponseEntity<Images>(HttpStatus.NO_CONTENT);
        }
}
