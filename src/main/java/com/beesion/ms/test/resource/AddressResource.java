// src/main/java/com/beesion/ms/test/resource/AddressResource.java
package com.beesion.ms.test.resource;

import com.beesion.ms.test.dto.AddressDto;
import com.beesion.ms.test.service.IAddressService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/address")
public class AddressResource {

    @Inject
    private IAddressService addressService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(AddressDto addressDto) {
        addressService.save(addressDto);
        return Response.ok("Address saved").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AddressDto> listAll() {
        return addressService.listAll();
    }
}