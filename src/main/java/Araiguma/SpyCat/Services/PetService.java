package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Repositories.PetRepositorie;
import jakarta.transaction.Transactional;

@Service
public class PetService {
    @Autowired

    private PetRepositorie repository;

    @Transactional
    public Pet create(Pet pet){
        Pet petCriado = repository.save(pet);
        return petCriado;
    }

    @Transactional
    public Pet update(Pet pet){
        if(repository.existsById(pet.getId())){
            return repository.save(pet);
            
        }
        else{
            return null;
        }
    } 
    
    public List<Pet> list(){
        List<Pet> list = (List<Pet>) repository.findAll();
        return list;
    }

    public Pet read(Long id){
        return repository.findById(id).get();
    }


    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
