package Araiguma.SpyCat.Repositories;

import org.springframework.data.repository.CrudRepository;

import Araiguma.SpyCat.Models.Comment;

public interface CommentRepositorie extends CrudRepository<Comment, Long> {
    
}
