package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Location;
import Araiguma.SpyCat.Repositories.LocationRepository;
import jakarta.transaction.Transactional;

@Service
public class LocationService {
    @Autowired

    private LocationRepository repository;

    @Transactional
    public Location create(Location location){
        Location locationCriado = repository.save(location);
        return locationCriado;
    }

    @Transactional
    public Location update(Location location){
        if(repository.existsById(location.getId())){
            return repository.save(location);
            
        }
        else{
            return null;
        }
    } 
    
    public List<Location> list(){
        List<Location> list = (List<Location>) repository.findAll();
        return list;
    }

    public Location read(Long id){
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
