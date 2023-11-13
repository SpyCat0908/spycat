package Araiguma.SpyCat.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.BDDMockito.Then;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;

import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Models.User;
import Araiguma.SpyCat.Repositories.UserRepository;
import Araiguma.SpyCat.Services.UserService;
import Araiguma.SpyCat.dtos.UserInputDTO;
import Araiguma.SpyCat.dtos.UserOutputDTO;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repositorie;

    @Test
    public void readNotFound() throws IOException{
        Long id = (long) 1;
        when(repositorie.existsById(id)).thenReturn(false);

        //when(repositorie.findById(id)).thenReturn(Optional.empty());

        User resultado = service.read(id);
        assertNull(resultado);
    }

    @Test
    public void readFound() throws IOException{
        Long id = (long) 1;


        User user = new User();
        user.setEmail("ASFASFASFASF");
        var optional = Optional.of(user);

        when(repositorie.existsById(id)).thenReturn(true);
        when(repositorie.findById(id)).thenReturn(optional);
        User resultado = service.read(id);


        assertNotNull(resultado);
    }

    @Test
    public void createUser() throws IOException{

        UserInputDTO dto = new UserInputDTO( 1l,"Caio", "Caio123", "caio@gmail.com");

        User user = new User(dto);

        when(repositorie.save(user)).thenReturn(user);

        UserOutputDTO resultado = service.create(dto);

        assertNotNull(resultado);
        assertEquals(dto.email(), resultado.email());
    }


    @Test
    public void updateUser() throws IOException{

        UserInputDTO dto = new UserInputDTO( 1l,"Nome", "Senha", "email@email.com");
        User userUpdate = new User(dto);

        when(repositorie.existsById(anyLong())).thenReturn(true);
        when(repositorie.save(userUpdate)).thenReturn(userUpdate);

        UserOutputDTO resultado = service.update(dto);

        assertNotNull(resultado);
        assertEquals(userUpdate.getUsername(), resultado.username());

    }

    @Test 
    public void deleteUser() throws IOException{

        UserInputDTO dto = new UserInputDTO(1l, "Nome", "Senha", "email@email.com");
        User userDelete = new User(dto);

        when(repositorie.existsById(anyLong())).thenReturn(true);
        doNothing().when(repositorie).deleteById(anyLong());

        service.delete(userDelete.getId());

       verify(repositorie, times(1)).deleteById(anyLong());
    }


}


