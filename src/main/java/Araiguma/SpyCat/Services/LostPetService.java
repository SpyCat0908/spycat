package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.LostPet;
import Araiguma.SpyCat.Repositories.LostPetRepository;
import Araiguma.SpyCat.dtos.LostPetInputDTO;
import jakarta.transaction.Transactional;

@Service
public class LostPetService {
    @Autowired

    private LostPetRepository repository;

    @Transactional
    public LostPet create(LostPetInputDTO dto){
        LostPet lostPet = new LostPet();
        
        lostPet.setDescription(dto.description());
        lostPet.setCity(dto.city());
        lostPet.setState(dto.state());
        lostPet.setPhone(dto.phone());
        lostPet.setEmail(dto.email());

        return repository.save(lostPet) ;
    }

    @Transactional
    public LostPet update(LostPet lostPet){
        if(repository.existsById(lostPet.getId())){
            return repository.save(lostPet);
            
        }
        else{
            return null;
        }
    } 
    
    public List<LostPet> list(){
        List<LostPet> list = (List<LostPet>) repository.findAll();
        return list;
    }

    public LostPet read(Long id){
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
