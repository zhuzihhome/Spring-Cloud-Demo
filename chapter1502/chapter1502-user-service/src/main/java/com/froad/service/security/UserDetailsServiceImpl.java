package com.froad.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.froad.client.AuthServiceClient;
import com.froad.dao.UserDao;
import com.froad.dto.UserLoginDTO;
import com.froad.entity.JsonWebToken;
import com.froad.entity.User;
import com.froad.exception.UserLoginException;
import com.froad.util.BCryptEncoderUtil;

/**
 * @author ZHUZIHUI
 * @date 2018年10月29日
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private AuthServiceClient client;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.findByUsername(username);
	}

	public User insertUser(User user) {
		user.setPassword(BCryptEncoderUtil.BCryptPassword(user.getPassword()));
		return userDao.save(user);
	}
	
	public UserLoginDTO login(String username, String password) {
		User user = userDao.findByUsername(username);
		if (null == user) {
			throw new UserLoginException("error username");
		}
		if (!BCryptEncoderUtil.matches(password, user.getPassword())) {
			throw new UserLoginException("error password");
		}
		// 获取token
		JsonWebToken jwt = client.getToken("Basic c2VydmljZS1oaToxMjM0NTY=", "password", username, password);
		if (null == jwt) {
			throw new UserLoginException("error internal");
		}
		// 获取用户菜单 TODO
		return new UserLoginDTO(jwt, user);
	}

}
