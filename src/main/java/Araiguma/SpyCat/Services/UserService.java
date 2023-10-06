package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Araiguma.SpyCat.Models.User;
import Araiguma.SpyCat.Repositories.UserRepositorie;

@Service
public class UserService {
    @Autowired
    private UserRepositorie repository;

    @Transactional
    public User create(User user){
        User userCriado = repository.save(user);
        return userCriado;
    }

    @Transactional
    public User update(User user){
        if(repository.existsById(user.getId())){
            return repository.save(user);
            
        }
        else{
            return null;
        }
    } 
    
    public List<User> list(){
        List<User> list = repository.findAll();
        return list;
    }

    public User read(Long id){
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
