package com.api.service;

import com.api.model.Entity.Material;

import java.util.List;

public interface ICliente {

    Material save(Material material);

    Material findById(Integer id);

    void delete(Material material);

    List<Material> listall();

}
