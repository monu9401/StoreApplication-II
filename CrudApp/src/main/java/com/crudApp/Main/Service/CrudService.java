package com.crudApp.Main.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudApp.Main.Dao.CrudDao;
import com.crudApp.Main.Entity.Product;

@Service
public class CrudService {
	
	@Autowired
	CrudDao crudDao;
	
	public Product insert(Product p) {
		Product product = crudDao.save(p);
		return product;
	}
	
	public Product update(Product p) {
		Product product = crudDao.save(p);
		return product;
	}
	
	public List<Product> getAll(){
		List<Product> list = (List<Product>)crudDao.findAll();
		return list;
	}
	
	public Product getSingleProduct(int id) {
		Optional<Product> opt = crudDao.findById(id);
		return opt.get();
	}
	
	public void deleteProduct(int id) {
		crudDao.deleteById(id);
	}
	
}
