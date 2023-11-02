package Araiguma.SpyCat.Models;

import java.util.ArrayList;
import java.util.List;

import Araiguma.SpyCat.dtos.UserInputDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    // @Column(nullable = false)
    private String city;
    // @Column(nullable = false)
    private String state;
    @OneToMany(mappedBy = "user")
    private List<Pet> pets = new ArrayList<Pet>();
    private String icon;

    public User (UserInputDTO dto){
        this.username = dto.username();
        this.password = dto.password();
        this.email = dto.email();

    }
    


}
