/**
 * @author ZHUZIHUI
 * @date 2018年9月28日
 */
package com.froad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.froad.dao.UserDao;
import com.froad.entity.User;

/**
 * @author ZHUZIHUI
 * @date 2018年9月28日
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
