package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Ong;
import Araiguma.SpyCat.Repositories.OngRepositorie;
import jakarta.transaction.Transactional;

@Service
public class OngService {
    @Autowired

    private OngRepositorie repository;
    
    @Transactional
    public Ong create(Ong ong){
        Ong ongCriado = repository.save(ong);
        return ongCriado;
    }

    @Transactional
    public Ong update(Ong ong){
        if(repository.existsById(ong.getId())){
            return repository.save(ong);
            
        }
        else{
            return null;
        }
    } 
    
    public List<Ong> list(){
        List<Ong> list = (List<Ong>) repository.findAll();
        return list;
    }

    public Ong read(Long id){
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
