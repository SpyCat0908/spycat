package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Location;
import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Repositories.LocationRepository;
import Araiguma.SpyCat.Repositories.PetRepository;
import Araiguma.SpyCat.dtos.PetInputDTO;
import Araiguma.SpyCat.dtos.PetOutputDTO;
import jakarta.transaction.Transactional;

@Service
public class PetService {
    @Autowired
    private PetRepository repository;

    @Autowired
    private LocationRepository locationRepository;

    @Transactional
    public PetOutputDTO create(PetInputDTO dto){
        Pet pet = new Pet(dto);
        return new PetOutputDTO(repository.save(pet));
    }

    @Transactional
    public PetOutputDTO update(PetInputDTO pet){
        Pet petUpdated = new Pet(pet);
        if(repository.existsById(petUpdated.getId())){
            PetOutputDTO resposta = new PetOutputDTO (repository.save(petUpdated));
            return resposta;
        }
        else{
            return null;
        }
    } 
    
    public List<PetOutputDTO> list(){
        // repository.findAll(Example.of(pet));
        List<PetOutputDTO> list = repository.findAll().stream().map( pet -> new PetOutputDTO(pet)).toList();
        return list;
    }

    public PetOutputDTO read(Long id){
        if(repository.existsById(id)){
            return new PetOutputDTO(repository.findById(id).get()); 
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
