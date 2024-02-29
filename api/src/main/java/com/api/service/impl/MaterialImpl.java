package com.api.service.impl;

import com.api.model.Entity.Material;
import com.api.model.dao.Materialdao;
import com.api.service.IMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialImpl implements IMaterial {

    @Autowired
    private Materialdao materialdao;

    @Transactional
    @Override
    public List listall() {
        return (List) materialdao.findAll();
    }


    @Transactional
    @Override
    public Material save(Material material) {
        return materialdao.save(material);
    }


    @Transactional
    @Override
    public Material findById(Integer id) {
        return materialdao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Material material) {
        materialdao.delete(material);

    }
}
