package com.froad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.froad.client.UserServiceClient;
import com.froad.dao.BlogDao;
import com.froad.dto.BlogDetailDTO;
import com.froad.dto.RespDTO;
import com.froad.entity.Blog;
import com.froad.entity.User;
import com.froad.exception.CommonException;
import com.froad.exception.ErrorCode;
import com.froad.util.UserUtil;

/**
 * @author ZHUZIHUI
 * @date 2018年11月18日
 */
@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private UserServiceClient userServiceClient;
	
	public Blog postBlog(Blog blog) {
		return blogDao.save(blog);
	}
	
	public List<Blog> findBlogs(String username) {
		return blogDao.findBlogs(username);
	}
	
	public BlogDetailDTO findBlogDetail(Long id) {
		Blog blog = blogDao.findOne(id);
		if (null == blog) {
			throw new CommonException(ErrorCode.BLOG_IS_NOT_EXIST);
		}
		RespDTO<User> respDTO = userServiceClient.getUser(UserUtil.getCurrentToken(), blog.getUsername());
		if (null == respDTO) {
			throw new CommonException(ErrorCode.RPC_ERROR);
		}
		return new BlogDetailDTO(blog, respDTO.data);
	}
	
}
