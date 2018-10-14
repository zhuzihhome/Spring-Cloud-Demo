/**
 * @author ZHUZIHUI
 * @date 2018年9月28日
 */
package com.froad.service;

import java.util.List;

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

	public User save(User user) {
		return userDao.save(user);
	}

	public void delete(long id) {
		userDao.delete(id);
	}

	public User update(User user) {
		return userDao.saveAndFlush(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findById(long id) {
		return userDao.findOne(id);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
