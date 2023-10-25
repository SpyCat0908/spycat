package Araiguma.SpyCat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Araiguma.SpyCat.Models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
