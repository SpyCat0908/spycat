package Araiguma.SpyCat.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Araiguma.SpyCat.Models.Image;
import Araiguma.SpyCat.Repositories.ImageRepository;
import Araiguma.SpyCat.dtos.ImageInputDTO;
import Araiguma.SpyCat.dtos.ImageOutputDTO;
import jakarta.transaction.Transactional;

@Service
public class ImageService {
    
    @Autowired
    private ImageRepository repository;

    @Transactional
    public ImageOutputDTO create(ImageInputDTO dto){
        Image image = new Image(dto);
        repository.save(image);
        ImageOutputDTO imageCreate = new ImageOutputDTO(image);
        return imageCreate;
    }

    
    public List<Image> list(){
        List<Image> list = (List<Image>) repository.findAll();
        return list;
    }


    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
    
}
