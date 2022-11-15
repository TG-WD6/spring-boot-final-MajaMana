package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet_types")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class PetType {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy="type", fetch = FetchType.EAGER)
    private List<Pet> petList;


    @Override
    public String toString() {
        return " the " + getName();
    }
}
