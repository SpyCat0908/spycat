package Araiguma.SpyCat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Araiguma.SpyCat.Models.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}
