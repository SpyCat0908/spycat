package Araiguma.SpyCat.Comment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import Araiguma.SpyCat.Models.Comment;
import Araiguma.SpyCat.Models.Pet;
import Araiguma.SpyCat.Repositories.CommentRepository;
import Araiguma.SpyCat.Services.CommentService;
import Araiguma.SpyCat.dtos.CommentInputDTO;
import Araiguma.SpyCat.dtos.CommentOutputDTO;
import Araiguma.SpyCat.dtos.UserInputDTO;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {
    @InjectMocks
    private CommentService service;

    @Mock
    private CommentRepository repository;

    @Test
    public void SuccessfullycreateComment() throws IOException{

        UserInputDTO dtoUser = new UserInputDTO("username", "password", "email");
        Pet pet = new Pet();
        pet.setId(1l);
        CommentInputDTO dtoComment = new CommentInputDTO(dtoUser, "text", LocalDateTime.now(), pet);

        Comment comment = new Comment(dtoComment);

        when(repository.save(comment)).thenReturn(comment);

        CommentOutputDTO result = service.create(dtoComment);

        assertNotNull(result);
        assertEquals(result.text(), dtoComment.text());
    }
}
