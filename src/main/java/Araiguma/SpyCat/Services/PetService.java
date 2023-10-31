package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Repositories.PetRepository;
import Araiguma.SpyCat.dtos.PetInputDTO;
import Araiguma.SpyCat.dtos.PetOutputDTO;
import jakarta.transaction.Transactional;

@Service
public class PetService {
    @Autowired

    private PetRepository repository;

    @Transactional
    public PetOutputDTO create(PetInputDTO dto){
        Pet pet = new Pet(dto);
        repository.save(pet);
        PetOutputDTO petAuxiliar = new PetOutputDTO(pet);
        return petAuxiliar;
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
