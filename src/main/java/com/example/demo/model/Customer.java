package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Customer {

    @Id
    @GeneratedValue
    private long customer_id;
    private String name;
    private String username;
    private String password;

    @OneToMany(mappedBy="owner", fetch = FetchType.EAGER)
    private List<Pet> petList;

    @Override
    public String toString() {
        return "The owner is " + getName() + " and their pets are " + getPetList().stream().map(Pet::getName)
                .collect(Collectors.joining(", "));
    }
}
