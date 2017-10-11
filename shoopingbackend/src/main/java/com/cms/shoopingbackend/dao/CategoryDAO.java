package com.cms.shoopingbackend.dao;

import java.util.List;

import com.cms.shoopingbackend.dto.Category;

public interface CategoryDAO {
	
 public	List<Category> list();
 
 Category get(int id);
 
 boolean add(Category category);

}
