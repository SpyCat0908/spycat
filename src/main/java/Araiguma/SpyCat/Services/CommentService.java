package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Repositories.CommentRepositorie;
import jakarta.transaction.Transactional;


@Service
public class CommentService {
    @Autowired

    private CommentRepositorie repository;

    @Transactional
    public Comment create(Comment comment){
        Comment commentCriado = repository.save(comment);
        return commentCriado;
    }

    @Transactional
    public Comment update(Comment comment){
        if(repository.existsById(comment.getId())){
            return repository.save(comment);
            
        }
        else{
            return null;
        }
    } 
    
    public List<Comment> list(){
        List<Comment> list = (List<Comment>) repository.findAll();
        return list;
    }

    public Comment read(Long id){
        return repository.findById(id).get();
    }


    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
