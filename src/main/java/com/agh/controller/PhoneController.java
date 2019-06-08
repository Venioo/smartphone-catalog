package com.agh.controller;

import com.agh.ahp.PairwisePhones;
import com.agh.ahp.PhoneAHP;
import com.agh.jpa.Phone;
import com.agh.repository.PhoneRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/phones/page/search")
    public Page<Phone> getPhonesModelsSearched(@RequestParam String searchInput, @RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return phoneRepository.findPhonesByBrandOrModel(searchInput.toLowerCase(), pageable);
    }

    @RequestMapping(value = "/phones/pwcomparison", method = {RequestMethod.POST}, consumes = {"application/json"})
    public List<Phone> getPhonePwComparison(@RequestBody PairwisePhones pwc) throws IllegalArgumentException {
        List<Phone> phones = new ArrayList<>();
        if (pwc.getPhonesList().isEmpty()) {
            phones = getPhones();
        } else {
            for (Long id : pwc.getPhonesList()) {
                phones.add(getPhone(id).orElseThrow(() -> new IllegalArgumentException("Wrong id")));
            }
        }
        PhoneAHP phoneAHP = new PhoneAHP();
        phoneAHP.setMinCost(pwc.getMinCost());
        phoneAHP.setMaxCost(pwc.getMaxCost());
        phoneAHP.setMinDisplaySize(pwc.getMinDisplay());
        phoneAHP.setMaxDisplaySize(pwc.getMaxDisplay());
        phoneAHP.setMinYear(pwc.getMinYear());
        phoneAHP.setMinRAM(pwc.getMinRam());
        phoneAHP.setTheOS(pwc.getOS());

        double[] compareValues = pwc.setWeights();

        return phoneAHP.findBestPhones(phones, compareValues);
    }
}