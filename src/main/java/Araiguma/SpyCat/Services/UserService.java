package Araiguma.SpyCat.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Araiguma.SpyCat.Models.User;
import Araiguma.SpyCat.Repositories.UserRepository;
import Araiguma.SpyCat.dtos.UserInputDTO;
import Araiguma.SpyCat.dtos.UserOutputDTO;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public UserOutputDTO create(UserInputDTO dto){
        User user = new User(dto);
        repository.save(user);
        UserOutputDTO userAuxiliar = new UserOutputDTO(user);
        return userAuxiliar;
    }

    @Transactional
    public UserOutputDTO update(UserInputDTO user){
        User userUpdate = new User(user);
        if(repository.existsById(userUpdate.getId())){
            return new UserOutputDTO( repository.save(userUpdate));
            
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

    // public Boolean login(String email, String password){
    //     User userLogado = repository.findBy(email);

    //     if(userLogado.getEmail() == email && userLogado.getPassword() == password){
    //         return true;
    //     }
    //     else{
    //         return false;
    //     }

    // }
    public Optional<User> findByEmail(String email){
        return repository.findByEmail(email);
     }
 
    
}
