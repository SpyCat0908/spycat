package Araiguma.SpyCat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Araiguma.SpyCat.Models.Message;

public interface MessageRepositorie extends JpaRepository<Message, Long> {
    
}
