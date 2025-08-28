package com.crudApp.Main.Dao;

import org.springframework.data.repository.CrudRepository;

import com.crudApp.Main.Entity.Product;

public interface CrudDao extends CrudRepository<Product, Integer>{

}
