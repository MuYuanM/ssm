package com.MuYuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MuYuan.mapper.CategoryMapper;
import com.MuYuan.pojo.Category;
import com.MuYuan.service.CategoryService;
import com.MuYuan.util.Page;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryMapper categoryMapper;

	public List<Category> list() {
		return categoryMapper.list();
	}

	@Override
	public List<Category> list(Page page) {
		// TODO Auto-generated method stub
		return categoryMapper.list(page);
	}

	@Override
	public int total() {
		return categoryMapper.total();
	}

	@Override
	public void add(Category c) {
		categoryMapper.add(c);

	}

	@Override
	public void update(Category c) {
		categoryMapper.update(c);
	}

	@Override
	public void delete(Category c) {
		categoryMapper.delete(c.getId());
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.get(id);
	};

}
