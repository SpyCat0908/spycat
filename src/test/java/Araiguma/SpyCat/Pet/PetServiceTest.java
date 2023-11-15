package Araiguma.SpyCat.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import Araiguma.SpyCat.Enum.Status;
import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Models.User;
import Araiguma.SpyCat.Repositories.PetRepository;
import Araiguma.SpyCat.Services.PetService;
import Araiguma.SpyCat.dtos.LocationInputDTO;
import Araiguma.SpyCat.dtos.PetInputDTO;
import Araiguma.SpyCat.dtos.PetOutputDTO;
import Araiguma.SpyCat.dtos.UserInputDTO;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PetServiceTest {
    
    @InjectMocks
    public PetService service;

    @Mock
    public PetRepository repository;

    @Test
    public void SuccesfulPetCreate(){
        User user = new User();
        user.setId(1);
        user.setUsername("Caio");
        LocationInputDTO dtoLocation = new LocationInputDTO( 1d, 1d, LocalDateTime.now());
        PetInputDTO dtoPet = new PetInputDTO(0l, null, null, null, null, null, null, null, dtoLocation, user);
        Pet pet = new Pet(dtoPet);
        when(repository.save(pet)).thenReturn(pet);

        PetOutputDTO resultado = service.create(dtoPet);
        assertNotNull(resultado);


    }

    @Test
    public void SuccessfulPetUpdate(){
    User user = new User();
    user.setId(1);   
    LocationInputDTO dtoLocation = new LocationInputDTO((double) 1, (double) 1, LocalDateTime.now());
    PetInputDTO dto = new PetInputDTO((long) 0, "amarelo", null, null, null, null, null, null, dtoLocation, user);

     Pet pet = new Pet(dto);
     pet.setId(1l);//pq no constructor n tem id então tem que colcoar 1 pra esse teste (na aula do marcola)
     pet.setColor("Laranja");
     when(repository.existsById(anyLong())).thenReturn(true);
     when(repository.save(any())).thenReturn(pet);
     
    PetOutputDTO petAtualizado = service.update(dto);

    assertEquals(pet.getId(), petAtualizado.id());
    assertNotNull(petAtualizado);
    }
    
    @Test
    public void readFoundPet() throws IOException{
        Long id = (long) 1;
        User user = new User();
        user.setId(1);   

        Pet pet = new Pet();
        pet.setUser(user);
        pet.setColor("Amarelo");


        var optional = Optional.of(pet);

        when(repository.existsById(anyLong())).thenReturn(true);

        when(repository.findById(anyLong())).thenReturn(optional);
        
        PetOutputDTO resultado = service.read(id);


        assertNotNull(resultado);
        assertEquals(resultado.color(), pet.getColor());
    }

}
