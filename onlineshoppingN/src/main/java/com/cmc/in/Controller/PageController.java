package com.cmc.in.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cms.shoopingbackend.dao.CategoryDAO;
import com.cms.shoopingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	CategoryDAO Categorydao;
	
	@RequestMapping(value={"/","/index","/home"})
	public ModelAndView pagedisplay()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("hello","my first display message");
		mv.addObject("categories",Categorydao.list());
		
		mv.addObject("userClickHome",true);
		
		mv.addObject("title","suyog Home");
		return mv;	
	}
	
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickabout",true);
		mv.addObject("title","About Us");
		return mv;	
	}
	
	

	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickContact",true);
		mv.addObject("title","Contact Us");
		return mv;	
	}
	
	@RequestMapping(value="/listProducts")
	public ModelAndView viewProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickproduct",true);
		mv.addObject("title","All Products");
		return mv;	
	}
	
	
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam("greeting")String greeting)
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("hello",greeting);
		return mv;	
	}
	/*
	 * 
	 * methods to load all the products based on category
	 * 
	 * */
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("hello","my first display message");
		mv.addObject("categories",Categorydao.list());
		
		mv.addObject("userClickAllProducts",true);
		
		mv.addObject("title","All Products");
		return mv;	
	}
	
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		Category category=null;
		category = Categorydao.get(id);
		mv.addObject("title",category.getName());
		
		mv.addObject("categories",Categorydao.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		
		return mv;	
	}
	
}
