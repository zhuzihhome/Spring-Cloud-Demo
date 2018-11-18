package com.froad.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.froad.entity.Blog;

/**
 * @author ZHUZIHUI
 * @date 2018年11月18日
 */
public interface BlogDao extends JpaRepository<Blog, Long> {

	List<Blog> findBlogs(String username);

}
