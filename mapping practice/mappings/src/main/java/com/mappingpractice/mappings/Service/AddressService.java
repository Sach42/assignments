package com.mappingpractice.mappings.Service;

import com.mappingpractice.mappings.Model.Address;
import com.mappingpractice.mappings.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public List<Address> getAllAddresss() {
        return addressRepository.findAll();
    }

    public Address getAddressById(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(String id) {
        addressRepository.deleteById(id);

    }
}
