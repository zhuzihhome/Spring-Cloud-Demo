package com.froad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.froad.client.AuthServiceClient;
import com.froad.dao.UserDao;
import com.froad.dto.LoginDTO;
import com.froad.dto.RespDTO;
import com.froad.entity.JsonWebToken;
import com.froad.entity.User;
import com.froad.exception.CommonException;
import com.froad.exception.ErrorCode;
import com.froad.util.BCryptEncoderUtil;

/**
 * @author ZHUZIHUI
 * @date 2018年10月29日
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private AuthServiceClient client;

	public UserDetails getUserInfo(String username) {
		return userDao.findByUsername(username);
	}

	public User createUser(User user) {
		return userDao.save(user);
	}

	public RespDTO login(String username, String password) {
		User user = userDao.findByUsername(username);
		if (null == user) {
			throw new CommonException(ErrorCode.USER_NOT_FOUND);
		}
		if (!BCryptEncoderUtil.matches(password, user.getPassword())) {
			throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
		}
		// 获取token
		JsonWebToken jwt = client.getToken("Basic c2VydmljZS1oaToxMjM0NTY=", "password", username, password);
		if (null == jwt) {
			throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
		}
		// 获取用户菜单
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUser(user);
		loginDTO.setToken(jwt.getAccess_token());
		return RespDTO.onSuc(loginDTO);
	}

}
