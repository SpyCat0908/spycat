package Araiguma.SpyCat.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pet_id")
    private long id;
    private String characteristics;
    private String description;
    private String city;
    private String state;
    @Enumerated(EnumType.STRING)
    private Status status;
    //cria uma lista de localizações usando a anotação @OneToMany
    @OneToMany(mappedBy = "pet")
    private List<Localization> localizations;
    @OneToMany(mappedBy = "pet")
    private List<Images> images;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;
    @OneToOne(optional = true)
    private Comment comment;



}
