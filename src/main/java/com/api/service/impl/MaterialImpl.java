package com.api.service.impl;

import com.api.model.Entity.Material;
import com.api.model.dao.Materialdao;
import com.api.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteImpl implements ICliente {

    @Autowired
    private Materialdao clientedao;

    @Transactional
    @Override
    public List<Material> listall() {
        return (List) clientedao.findAll();
    }


    @Transactional
    @Override
    public Material save(Material material) {
        return clientedao.save(material);
    }


    @Transactional
    @Override
    public Material findById(Integer id) {
        return clientedao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Material material) {
        clientedao.delete(material);

    }
}
