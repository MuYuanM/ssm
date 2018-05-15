package com.MuYuan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MuYuan.pojo.Category;
import com.MuYuan.pojo.Product;
import com.MuYuan.service.CategoryService;
import com.MuYuan.service.ProductService;
import com.MuYuan.util.Page;

@Controller
@RequestMapping("")
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	@RequestMapping("listProduct")
	public ModelAndView listProduct(Category category, Page page) {
		System.out.println(category);
		category = categoryService.get(category.getId());
		System.out.println(category);
		ModelAndView mav = new ModelAndView();
		Map m = new HashMap();
		m.put("category", category);
		m.put("page", page);
		List<Product> cs = productService.list(m);
		int total = productService.total(category);
		page.caculateLast(total);
		mav.addObject("ps", cs);
		mav.addObject("category", category);
		mav.setViewName("listProduct");
		return mav;

	}

	@RequestMapping("addProduct")
	public ModelAndView addProduct(Product product) {
		System.out.println(product);
		productService.add(product);
		ModelAndView mav = new ModelAndView("redirect:/listProduct?id=" + product.getCategory().getId());
		return mav;
	}

	@RequestMapping("deleteProduct")
	public ModelAndView deleteProduct(Product product) {
		product = productService.get(product.getId());
		productService.delete(product);
		ModelAndView mav = new ModelAndView("redirect:/listProduct?id=" + product.getCategory().getId());
		return mav;
	}

	@RequestMapping("editProduct")
	public ModelAndView editProduct(Product product) {
		Product p = productService.get(product.getId());
		ModelAndView mav = new ModelAndView("editProduct");
		mav.addObject("p", p);
		return mav;
	}

	@RequestMapping("updateProduct")
	public ModelAndView updateProduct(Product product) {
		productService.update(product);
		ModelAndView mav = new ModelAndView("redirect:/listProduct?id=" + product.getCategory().getId());
		return mav;

	}
}
