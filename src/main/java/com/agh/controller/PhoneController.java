package com.agh.controller;

import com.agh.jpa.Phone;
import com.agh.repository.PhoneRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/phones/{id}")
    public Optional<Phone> getPhone(@PathVariable Long id) {
        return phoneRepository.findById(id);
    }

    @GetMapping("/phones/comparison")
    public Phone getPhoneByBrandAndModel(@RequestParam("brand") String brand, @RequestParam("model") String model) {
        return phoneRepository.findPhoneByBrandAndModel(brand, model);
    }

    @GetMapping("/phones/brands")
    public List<String> getBrands() {
        return phoneRepository.findBrands();
    }

    @GetMapping("/phones/models")
    public List<String> getModels(@RequestParam("brand") String brand) {
        return phoneRepository.findModelsByBrand(brand);
    }

    @GetMapping("/phones/page")
    public Page<Phone> getPhonesModels(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return phoneRepository.findAll(pageable);
    }
}