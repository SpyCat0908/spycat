package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Ong;
import Araiguma.SpyCat.Repositories.OngRepository;
import jakarta.transaction.Transactional;
import main.java.Araiguma.SpyCat.dtos.OngInputDTO;

@Service
public class OngService {
    @Autowired

    private OngRepository repository;
    
    @Transactional
    public Ong create(OngInputDTO dto){
        Ong ong = new Ong();

        ong.setTradingName(dto.tradingName());
        ong.setCnpj(dto.cnpj());
        ong.setPhone(dto.phone());
        ong.setEmail(dto.email());

        return repository.save(ong);
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
