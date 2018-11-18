package com.froad.dto;

import com.froad.entity.Blog;
import com.froad.entity.User;

/**
 * @author ZHUZIHUI
 * @date 2018年11月18日
 */
public class BlogDetailDTO {

	private Blog blog;
	private User user;

	public BlogDetailDTO() {
		super();
	}

	public BlogDetailDTO(Blog blog, User user) {
		super();
		this.blog = blog;
		this.user = user;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
