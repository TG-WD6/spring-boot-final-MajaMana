package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet_types")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class PetType {

    @Id
    @GeneratedValue
    private long type_id;
    private String name;
}
