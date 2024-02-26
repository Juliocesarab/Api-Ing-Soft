package com.api.service;

import com.api.model.Entity.Cliente;

import java.util.List;

public interface ICliente {

    Cliente save(Cliente cliente);

    Cliente findById(Integer id);

    void delete(Cliente cliente);

    List<Cliente> listall();

}
