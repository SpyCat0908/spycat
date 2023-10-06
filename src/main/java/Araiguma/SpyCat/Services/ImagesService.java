package Araiguma.SpyCat.Services;

import Araiguma.SpyCat.Repositories.ImagesRepositorie;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.Images;
import Araiguma.SpyCat.Repositories.CommentRepositorie;
import jakarta.transaction.Transactional;


public class ImagesService {
    @Autowired

    private ImagesRepositorie repository;

    @Transactional
    public Images create(Images images){
        Images imagesCriado = repository.save(images);
        return imagesCriado;
    }

    @Transactional
    public Images update(Images images){
        if(repository.existsById(images.getId())){
            return repository.save(images);
            
        }
        else{
            return null;
        }
    } 
    
    public List<Images> list(){
        List<Images> list = (List<Images>) repository.findAll();
        return list;
    }

    public Images read(Long id){
        if(repository.existsById(id)){
            return repository.findById(id).get();
        }
        else{
            return null;
        }
          }


    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}