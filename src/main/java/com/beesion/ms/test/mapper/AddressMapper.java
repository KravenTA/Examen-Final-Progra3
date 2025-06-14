// src/main/java/com/beesion/ms/test/mapper/AddressMapper.java
package com.beesion.ms.test.mapper;

import com.beesion.ms.model.Address;
import com.beesion.ms.test.dto.AddressDto;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressMapper {
    public AddressDto toDto(Address address) {
        AddressDto dto = new AddressDto();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setCountry(address.getCountry());
        return dto;
    }

    public Address toEntity(AddressDto dto) {
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setCountry(dto.getCountry());
        return address;
    }
}