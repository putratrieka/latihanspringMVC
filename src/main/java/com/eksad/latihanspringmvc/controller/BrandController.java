package com.eksad.latihanspringmvc.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eksad.latihanspringmvc.model.Brand;
import com.eksad.latihanspringmvc.model.Product;
import com.eksad.latihanspringmvc.repository.BrandDao;

@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	BrandDao brandDao;
	
	@RequestMapping("")
	public String Index(Model model) {
		List<Brand> list = brandDao.findAll();
		
		model.addAttribute("listBrand", list);
		
		return "listBrand";
	}
	
	@RequestMapping("/add")
	public String addBrand(Model model) {
		Brand brand = new Brand();
		model.addAttribute("brand", brand); 

		return "brandAdd";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Brand brand) {
		brandDao.save(brand);
		
		return "redirect:/brand";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		Brand brand = new Brand();
		brand = brandDao.findById(id);	
		brandDao.delete(brand);
		return "redirect:/brand";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, Model model) {
		Brand brand = brandDao.findOne(id);
		System.out.println(brand);
		model.addAttribute("brand", brand);
		
		return "edit";
	}

}
