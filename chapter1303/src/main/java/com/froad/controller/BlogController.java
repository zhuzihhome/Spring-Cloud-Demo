package com.froad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.froad.entity.Blog;
import com.froad.service.BlogService;

/**
 * @author ZHUZIHUI
 * @date 2018年10月20日
 */
@RequestMapping("/blogs")
@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;

	@GetMapping
	public ModelAndView list(Model model) {
		List<Blog> blogs = blogService.getBlogs();
		model.addAttribute("blogsList", blogs);
		return new ModelAndView("blogs/list", "blogModel", model);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	//@PreAuthorize("hasAnyRole('ADMIN')")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/{id}/deletion")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		blogService.deleteBlog(id);
		model.addAttribute("blogsList", blogService.getBlogs());
		return new ModelAndView("blogs/list", "blogModel", model);
	}

}
