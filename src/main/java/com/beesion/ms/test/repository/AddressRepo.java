package com.beesion.ms.test.repository;

import com.beesion.ms.model.Address;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AddressRepo {

    @Inject
    private EntityManager em;

    @Transactional
    public void save(Address address) {
        em.persist(address);
    }

    public List<Address> listAll() {
        return em.createQuery("SELECT a FROM Address a", Address.class).getResultList();
    }
}