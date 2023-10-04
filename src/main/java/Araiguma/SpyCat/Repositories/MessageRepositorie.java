package Araiguma.SpyCat.Repositories;

import org.springframework.data.repository.CrudRepository;

import Araiguma.SpyCat.Models.Message;

public interface MessageRepositorie extends CrudRepository<Message, Long> {
    
}
