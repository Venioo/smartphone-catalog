package com.agh.controller;

import com.agh.jpa.Phone;
import com.agh.repository.PhoneRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Getter
@Setter
@CrossOrigin(origins = "http://localhost:4200")
public class PhoneController {

    private final PhoneRepository phoneRepository;

    public PhoneController(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @GetMapping("/phones")
    public List<Phone> getPhones() {
        return (List<Phone>) phoneRepository.findAll();
    }
}