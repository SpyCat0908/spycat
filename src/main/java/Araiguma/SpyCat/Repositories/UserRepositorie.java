package Araiguma.SpyCat.Repositories;

import org.springframework.data.repository.CrudRepository;

import Araiguma.SpyCat.Models.User;

public interface UserRepositorie extends CrudRepository<User, Long>{
    
}
