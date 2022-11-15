package com.example.demo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class PetRequest {

//    private Long id;
    private String name;
    private String type;
    private Long customer_id;

}
