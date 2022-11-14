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
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Customer {

    @Id
    @GeneratedValue
    private int customer_id;
    private String name;
//    private String username;
//    private String password;

}
