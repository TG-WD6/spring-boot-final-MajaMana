package com.example.demo.dto;


import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class PetDTO {

    private String name;
//    private String type;
//    private String owner;
}
