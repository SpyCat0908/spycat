package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Localization;
import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Repositories.LocalizationRepositorie;
import Araiguma.SpyCat.Repositories.PetRepositorie;
import jakarta.transaction.Transactional;

@Service
public class PetService {
    @Autowired

    private PetRepositorie repository;
    @Autowired
    private LocalizationRepositorie localizationRepository;

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
