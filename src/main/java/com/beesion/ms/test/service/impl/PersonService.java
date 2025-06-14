package com.beesion.ms.test.service.impl;

import com.beesion.ms.model.Person;
import com.beesion.ms.model.Address;
import com.beesion.ms.test.dto.PersonDto;
import com.beesion.ms.test.mapper.PersonMapper;
import com.beesion.ms.test.repository.impl.IPersonRepo;
import com.beesion.ms.test.service.IPersonService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PersonService implements IPersonService {

	@Inject
	private IPersonRepo personRepo;

	@Inject
	private PersonMapper personMapper;

	@Override
	public void save(PersonDto per) {
		// Usamos el mapper para convertir el DTO a entidad
		Person person = personMapper.toEntity(per);
		personRepo.save(person);
	}

	@Override
	public List<Address> getAddressesByPersonId(Long id) {
		Person person = personRepo.findById(id);
		return person != null ? person.getAddresses() : List.of();
	}
}