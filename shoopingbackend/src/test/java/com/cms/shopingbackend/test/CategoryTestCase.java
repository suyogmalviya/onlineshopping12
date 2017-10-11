package com.cms.shopingbackend.test;


import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cms.shoopingbackend.dao.CategoryDAO;
import com.cms.shoopingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.cms.shoopingbackend");
		context.refresh();
		categoryDAO =(CategoryDAO)context.getBean("CategoryDAO");
	}

	
	@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("washing machine");
		category.setDescription("how to work washing machine");
		category.setImageURL("IMG_3.png");
		assertEquals("successfully added a category inside the table",true,categoryDAO.add(category));
		
	}

}
 