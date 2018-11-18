package com.froad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.froad.annotation.SysLogger;
import com.froad.dto.BlogDetailDTO;
import com.froad.dto.RespDTO;
import com.froad.entity.Blog;
import com.froad.exception.CommonException;
import com.froad.exception.ErrorCode;
import com.froad.service.BlogService;
import com.froad.util.UserUtil;

import io.swagger.annotations.ApiOperation;

/**
 * @author ZHUZIHUI
 * @date 2018年11月18日
 */
@RequestMapping("/blog")
@RestController
public class BlogController {

	@Autowired
	private BlogService blogService;

	@ApiOperation(value = "发布博客", notes = "发布博客")
	@SysLogger("postBlog")
	@PreAuthorize("hasRole('USER')")
	@PostMapping("")
	public RespDTO postBlog(@RequestBody Blog blog) {
		Blog result = blogService.postBlog(blog);
		return RespDTO.onSuc(result);
	}

	@ApiOperation(value = "根据用户ID获取所有博客", notes = "根据用户ID获取所有博客")
	@SysLogger("getBlogs")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/{username}")
	public RespDTO getBlogs(@PathVariable String username) {
		if (!UserUtil.isMyself(username)) {
			throw new CommonException(ErrorCode.TOKEN_IS_NOT_MATCH_USER);
		}
		List<Blog> blogs = blogService.findBlogs(username);
		return RespDTO.onSuc(blogs);
	}

	@ApiOperation(value = "获取博文详细信息", notes = "获取博文详细信息")
	@SysLogger("getBlogDetail")
	@PreAuthorize("hasAuthrity('ROLE_USER')")
	@GetMapping("/{id}/detail")
	public RespDTO getBlogDetail(@PathVariable Long id) {
		BlogDetailDTO blogDetail = blogService.findBlogDetail(id);
		return RespDTO.onSuc(blogDetail);
	}

}
