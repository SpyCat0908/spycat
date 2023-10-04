package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Localization;
import Araiguma.SpyCat.Repositories.LocalizationRepositorie;
import jakarta.transaction.Transactional;

@Service
public class LocalizationService {
    @Autowired

    private LocalizationRepositorie repository;

    @Transactional
    public Localization create(Localization localization){
        Localization localizationCriado = repository.save(localization);
        return localizationCriado;
    }

    @Transactional
    public Localization update(Localization localization){
        if(repository.existsById(localization.getId())){
            return repository.save(localization);
            
        }
        else{
            return null;
        }
    } 
    
    public List<Localization> list(){
        List<Localization> list = (List<Localization>) repository.findAll();
        return list;
    }

    public Localization read(Long id){
        return repository.findById(id).get();
    }


    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
