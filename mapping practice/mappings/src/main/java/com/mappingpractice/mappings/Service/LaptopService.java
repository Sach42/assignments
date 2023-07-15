package com.mappingpractice.mappings.Service;

import com.mappingpractice.mappings.Model.Laptop;
import com.mappingpractice.mappings.Repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(String id) {
        return laptopRepository.findById(id).orElse(null);
    }

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public Laptop updateLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public void deleteLaptop(String id) {
        laptopRepository.deleteById(id);

    }
}
