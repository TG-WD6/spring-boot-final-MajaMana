package com.example.demo.repository;

import com.example.demo.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    Optional<Pet> findById(Long id);

    List<Pet> findAll();

    List<Pet> findByName(String name);

    void deleteById(Long id);

    Pet save(Pet pet);
}
