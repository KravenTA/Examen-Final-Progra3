// src/main/java/com/beesion/ms/test/service/IPersonService.java
package com.beesion.ms.test.service;

import com.beesion.ms.test.dto.PersonDto;
import com.beesion.ms.model.Address;

import java.util.List;

public interface IPersonService {
	void save(PersonDto per);
	List<Address> getAddressesByPersonId(Long id);
}