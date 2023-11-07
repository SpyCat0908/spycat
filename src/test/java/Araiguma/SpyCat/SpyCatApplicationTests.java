// package Araiguma.SpyCat;

// import static org.mockito.ArgumentMatchers.any;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.boot.test.context.SpringBootTest;

// import Araiguma.SpyCat.Models.Pet;
// import Araiguma.SpyCat.Repositories.PetRepository;
// import Araiguma.SpyCat.Services.PetService;
// import Araiguma.SpyCat.dtos.PetInputDTO;

// @ExtendWith(MockitoExtension.class)
// @SpringBootTest
// class PetServiceTest {
    
//     @InjectMocks
//     private PetService service;

//     @Mock
//     private PetRepository repository;

//     @Test
//     private void SuccessfulPetUpdate(){

//      PetInputDTO petInput = new PetInputDTO(null, null, null, null, null, null);   

//      Pet pet = new Pet(petInput);

//      when(repository.save(any())).thenReturn(pet);
    
//     }

// }
