package com.MuYuan.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MuYuan.mapper.ProductMapper;
import com.MuYuan.pojo.Category;
import com.MuYuan.pojo.Product;
import com.MuYuan.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> list(Map m) {
		return productMapper.list(m);
	}

	@Override
	public int total(Category c) {
		// TODO Auto-generated method stub
		return productMapper.total(c);
	}

	@Override
	public void add(Product c) {
		// TODO Auto-generated method stub
		productMapper.add(c);

	}

	@Override
	public void update(Product c) {
		// TODO Auto-generated method stub
		productMapper.update(c);
	}

	@Override
	public void delete(Product c) {
		// TODO Auto-generated method stub
		productMapper.delete(c.getId());

	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return productMapper.get(id);
	}

}
