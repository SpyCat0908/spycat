package Araiguma.SpyCat.Services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.User;
import Araiguma.SpyCat.Repositories.CommentRepository;
import Araiguma.SpyCat.Repositories.UserRepository;
import Araiguma.SpyCat.dtos.UserInputDTO;
import Araiguma.SpyCat.dtos.UserOutputDTO;
import Araiguma.SpyCat.dtos.UserUpdateInputDTO;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public UserOutputDTO create(UserInputDTO dto){
        String password = new BCryptPasswordEncoder().encode(dto.password());
        User user = new User(dto);
        user.setPassword(password);
        repository.save(user);
        UserOutputDTO userAuxiliar = new UserOutputDTO(user);
        return userAuxiliar;
    }

    @Transactional
    public UserOutputDTO update(UserUpdateInputDTO user){
        User userUpdate = new User(user);
        if(repository.existsById(userUpdate.getId())){
            return new UserOutputDTO( repository.save(userUpdate));
            
        }
        else{
            return null;
        }
    } 
    
    public List<UserOutputDTO> list(){
        List<UserOutputDTO> list = repository.findAll().stream().map(user -> new UserOutputDTO(user)).toList();
        return list;
    }

    public UserOutputDTO read(Long id){
        if(repository.existsById(id)){
            return new UserOutputDTO(repository.findById(id).get());
        }
        else{
            return null;
        }
      
    }


    public void delete(Long id, String password){
        if(repository.existsById(id)){
       
            
            User user = repository.findById(id).get();
            if(user.getPassword().equals(password)){
                
                repository.deleteById(id);

            }
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


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if(user != null){
            return org.springframework.security.core.userdetails.User.builder()
                .password(user.getPassword())
                .username(user.getUsername())
            .build();
        }else{
            throw new UsernameNotFoundException("");
        }
    }
 
    
}
