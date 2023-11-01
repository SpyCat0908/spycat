package Araiguma.SpyCat.Services;

import Araiguma.SpyCat.Repositories.ImagesRepository;
import Araiguma.SpyCat.dtos.ImagesInputDTO;
import Araiguma.SpyCat.dtos.ImagesOutputDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Images;
import jakarta.transaction.Transactional;

@Service
public class ImagesService {
    @Autowired

    private ImagesRepository repository;

    @Transactional
    public ImagesOutputDTO create(ImagesInputDTO dto){
        Images images = new Images(dto);
        repository.save(images);
        ImagesOutputDTO imagesAuxiliar = new ImagesOutputDTO(images);
        return imagesAuxiliar;
    }

    @Transactional
    public Images update(Images images){
        if(repository.existsById(images.getId())){
            return repository.save(images);
            
        }
        else{
            return null;
        }
    } 
    
    public List<Images> list(){
        List<Images> list = (List<Images>) repository.findAll();
        return list;
    }

    public Images read(Long id){
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
