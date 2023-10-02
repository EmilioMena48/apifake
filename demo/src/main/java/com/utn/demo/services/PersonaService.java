package com.utn.demo.services;

import com.utn.demo.entities.Persona;
import com.utn.demo.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonaService implements BaseService<Persona>{

    @Autowired
    private PersonaRepository personaRepository;
    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try {
            List<Persona> entities = personaRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Persona findById(Long Id) throws Exception {
        try {
            Optional<Persona> entityOptional = personaRepository.findById(Id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
            entity = personaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Persona update(Long Id, Persona entity) throws Exception {
        try {
            Optional<Persona> entityOpcional = personaRepository.findById(Id);
            Persona persona = entityOpcional.get();
            persona = personaRepository.save(entity);
            return persona;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public boolean delete(Long Id) throws Exception {
        try {
            if(personaRepository.existsById(Id)){
                personaRepository.deleteById(Id);
                return true;
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
