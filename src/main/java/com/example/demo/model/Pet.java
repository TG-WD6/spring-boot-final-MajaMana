package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Pet {

    @Id
    @GeneratedValue
    private Long pet_id;
    private String name;


//    private String type;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable=false)
    private Customer owner;

    @Override
    public String toString() {
        return getName() + owner.getName();
    }
}
