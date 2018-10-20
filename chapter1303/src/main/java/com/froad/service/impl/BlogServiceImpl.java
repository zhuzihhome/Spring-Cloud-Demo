package com.froad.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.froad.entity.Blog;
import com.froad.service.BlogService;

/**
 * @author ZHUZIHUI
 * @date 2018年10月20日
 */
@Service
public class BlogServiceImpl implements BlogService {

	private static List<Blog> list = new ArrayList<>();

	static {
		list.add(new Blog(1L, "spring in action", "good!"));
		list.add(new Blog(2L, "spring boot in action", "nice!"));
	}

	@Override
	public List<Blog> getBlogs() {
		return list;
	}

	@Override
	public void deleteBlog(long id) {
		Iterator<Blog> iter = list.iterator();
		while (iter.hasNext()) {
			Blog blog = (Blog) iter.next();
			if (blog.getId() == id) {
				iter.remove();
				break;
			}
		}
	}

}
