package com.utn.demo.services;

import java.util.List;

public interface BaseService<E>{
    public List<E> findAll() throws Exception;
    public E findById(Long Id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(Long Id, E entity) throws Exception;
    public boolean delete(Long Id) throws Exception;
}
