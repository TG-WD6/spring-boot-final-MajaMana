package com.example.demo.response;

import com.example.demo.dto.PetDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class CustomerResponse {

    private String name;
    private List<PetDTO> pets;

}
