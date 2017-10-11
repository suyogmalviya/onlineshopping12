package com.cms.shoopingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cms.shoopingbackend.dao.CategoryDAO;
import com.cms.shoopingbackend.dto.Category;

@Repository("CategoryDAO")
public class CategoryDAOimpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	static{
		/*
		 * TV category
		 * */
		Category category = new Category();
		category.setId(1);
		category.setName("TV");
		category.setDescription("tv for wataching purpose");
		category.setImageURL("IMG_1.png");
		
		categories.add(category);
		
		Category	category1 = new Category();
		category1.setId(2);
		category1.setName("Mobile");
		category1.setDescription("mobile for wataching purpose");
		category1.setImageURL("IMG_1.png");
		categories.add(category1);
		Category category2 = new Category();
		category2.setId(3);
		category2.setName("music");
		category2.setDescription("music  for wataching purpose");
		category2.setImageURL("IMG_1.png");
		categories.add(category2);
		
	}
	
	
	
	
	@Override
	public List<Category> list() {

		
		
		return categories;
	}




	@Override
	public Category get(int id) {

		for(Category category:categories)
		{
			if(category.getId()== id)
				return category;
		}
		
		return null;
	}




	@Override
	@Transactional
	public boolean add(Category category) {

		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		
		catch (Exception ex) {

				ex.printStackTrace();
			
			return false;
		}
		
	}

}
