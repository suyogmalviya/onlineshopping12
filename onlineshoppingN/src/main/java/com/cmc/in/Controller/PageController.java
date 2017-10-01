package com.cmc.in.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value={"/","/index","/home"})
	public ModelAndView pagedisplay()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("hello","my first display message");
		return mv;	
	}
	

}
