package com.froad.service;

import java.util.List;

import com.froad.entity.Blog;

/**
 * @author ZHUZIHUI
 * @date 2018年10月20日
 */
public interface BlogService {

	List<Blog> getBlogs();

	void deleteBlog(long id);

}
