package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Message;
import Araiguma.SpyCat.Repositories.MessageRepository;
import jakarta.transaction.Transactional;

@Service
public class MessageService {
    @Autowired

    private MessageRepository repository;

    @Transactional
    public Message create(Message message){
        Message messageCriado = repository.save(message);
        return messageCriado;
    }

    @Transactional
    public Message update(Message message){
        if(repository.existsById(message.getId())){
            return repository.save(message);
            
        }
        else{
            return null;
        }
    } 
    
    public List<Message> list(){
        List<Message> list = (List<Message>) repository.findAll();
        return list;
    }

    public Message read(Long id){
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
