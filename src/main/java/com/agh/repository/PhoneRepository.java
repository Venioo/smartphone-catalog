package com.agh.repository;

import com.agh.jpa.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {

    @Query("SELECT distinct brand FROM Phone")
    List<String> findBrands();

    @Query("SELECT distinct model FROM Phone WHERE brand = :brand")
    List<String> findModelsByBrand(@Param("brand") String brand);

    @Query("SELECT p FROM Phone p WHERE brand = :brand AND model = :model")
    Phone findPhoneByBrandAndModel(@Param("brand") String brand, @Param("model") String model);

    @Query("SELECT p FROM Phone p WHERE LOWER(brand) LIKE %:searchInput% OR LOWER(model) LIKE %:searchInput%")
    Page<Phone> findPhonesByBrandOrModel(@Param("searchInput") String searchInput, Pageable pageable);

    Page<Phone> findAll(Pageable pageable);


}