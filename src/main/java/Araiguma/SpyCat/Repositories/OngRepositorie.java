package Araiguma.SpyCat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Araiguma.SpyCat.Models.Ong;

public interface OngRepositorie  extends JpaRepository<Ong, Long>{
    
}
