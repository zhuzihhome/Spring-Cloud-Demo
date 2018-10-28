package com.froad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.froad.dao.UserDao;
import com.froad.entity.User;
import com.froad.service.UserService;

/**
 * @author ZHUZIHUI
 * @date 2018年10月28日
 */
@Service
public class UserServiceImpl implements UserService {

	private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

	@Autowired
	private UserDao userDao;

	@Override
	public User create(User user) {
		user.setPassword(ENCODER.encode(user.getPassword()));
		return userDao.save(user);
	}

}
