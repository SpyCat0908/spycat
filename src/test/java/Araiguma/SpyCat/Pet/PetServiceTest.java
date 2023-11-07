package Araiguma.SpyCat.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Repositories.PetRepository;
import Araiguma.SpyCat.Services.PetService;
import Araiguma.SpyCat.dtos.PetInputDTO;
import Araiguma.SpyCat.dtos.PetOutputDTO;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PetServiceTest {
    
    @InjectMocks
    private PetService service;

    @Mock
    private PetRepository repository;

    @Test
    private void SuccessfulPetUpdate(){

     Pet pet = new Pet();   

    //  Pet pet = new Pet(petInput);
     pet.setId(1l);//pq no constructor n tem id então tem que colcoar 1 pra esse teste (na aula do marcola)
     pet.setColor("Laranja");
     when(repository.existsById(anyLong())).thenReturn(true);
     when(repository.save(any())).thenReturn(pet);
     
    Pet petAtualizado = service.update(pet);

    assertEquals(pet.getId(), petAtualizado.getId());

    }

}
