package com.api.model.dao;

import com.api.model.Entity.Material;
import org.springframework.data.repository.CrudRepository;

public interface Materialdao extends CrudRepository<Material, Integer> {
}
