package com.example.dbmongo.contoller;


import com.example.dbmongo.model.Pet;
import com.example.dbmongo.model.PetRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    // GET
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Pet>> getAllPet() {
        return new ResponseEntity<>(petRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pet> getPetById(@PathVariable("id") ObjectId id) {
        return new ResponseEntity<>(petRepository.findBy_id(id), HttpStatus.OK);
    }

    // POST
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Pet createPet(@Valid @RequestBody Pet pet) {
        pet.set_id(ObjectId.get());
        petRepository.save(pet);
        return pet;
    }

    // PUT
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pet pet) {
        pet.set_id(id);
        petRepository.save(pet);
    }

    // DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        petRepository.delete(petRepository.findBy_id(id));
    }

}
