package com.beesion.ms.test.service.impl;

import com.beesion.ms.model.Address;
import com.beesion.ms.model.Person;
import com.beesion.ms.test.dto.AddressDto;
import com.beesion.ms.test.mapper.AddressMapper;
import com.beesion.ms.test.repository.AddressRepo;
import com.beesion.ms.test.repository.impl.IPersonRepo;
import com.beesion.ms.test.service.IAddressService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AddressService implements IAddressService {

    @Inject
    private AddressRepo addressRepo;

    @Inject
    private AddressMapper addressMapper;

    @Inject
    private IPersonRepo personRepo;

    @Override
    public void save(AddressDto addressDto) {
        Address address = addressMapper.toEntity(addressDto);

        // Buscar la persona asociada por ID y establecer la relación
        Person person = personRepo.findById(addressDto.getId());
        if (person != null) {
            address.setPerson(person);
        }

        addressRepo.save(address);
    }

    @Override
    public List<AddressDto> listAll() {
        return addressRepo.listAll().stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
    }
}