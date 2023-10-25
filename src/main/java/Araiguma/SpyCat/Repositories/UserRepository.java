package Araiguma.SpyCat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Araiguma.SpyCat.Models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
