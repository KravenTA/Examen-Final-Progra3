// src/main/java/com/beesion/ms/test/resource/PersonaResource.java
package com.beesion.ms.test.resource;

import com.beesion.ms.model.Address;
import com.beesion.ms.test.dto.PersonDto;
import com.beesion.ms.test.service.IPersonService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/Person")
public class PersonaResource {

	@Inject
	private IPersonService personService;

	@POST
	public Response save(PersonDto per) {
		// Delegamos la lógica de mapeo y persistencia al servicio
		personService.save(per);
		return Response.ok("Elemento guardado").build();
	}

	@GET
	@Path("{id}/addresses")
	public Response getAddresses(@PathParam("id") Long id) {
		List<Address> addresses = personService.getAddressesByPersonId(id);
		return Response.ok(addresses).build();
	}
}