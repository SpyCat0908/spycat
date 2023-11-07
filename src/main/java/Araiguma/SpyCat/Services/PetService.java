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
    public Pet create(PetInputDTO dto){

        Location location = new Location(dto.location());
        locationRepository.save(location);


        Pet pet = new Pet(dto);
        return repository.save(pet);
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
