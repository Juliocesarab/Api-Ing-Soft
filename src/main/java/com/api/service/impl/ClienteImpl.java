package com.api.service.impl;

import com.api.model.Entity.Cliente;
import com.api.model.dao.Clientedao;
import com.api.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteImpl implements ICliente {

    @Autowired
    private Clientedao clientedao;

    @Override
    public List<Cliente> listall() {
        return (List) clientedao.findAll();
    }


    @Override
    public Cliente save(Cliente cliente) {
        return clientedao.save(cliente);
    }


    @Override
    public Cliente findById(Integer id) {
        return clientedao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cliente cliente) {
        clientedao.delete(cliente);

    }
}
