package com.seguoer.controller;

import com.seguoer.po.Person;
import com.seguoer.po.Pet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    @RequestMapping(value = "/pet")
    Pet getPetJson(){
        return new Pet("asd",2);
    }

    @PostMapping(value = "/person")
    Person getPerson(Person person){
        return person;
    }

}
