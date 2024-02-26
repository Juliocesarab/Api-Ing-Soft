package com.api.model.dao;

import com.api.model.Entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface Clientedao extends CrudRepository<Cliente, Integer> {
}
