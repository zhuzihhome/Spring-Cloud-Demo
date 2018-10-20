package com.froad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.froad.dao.UserDao;

/**
 * @author ZHUZIHUI
 * @date 2018年10月20日
 */
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserDao userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}
}
