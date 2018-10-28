package com.froad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.froad.entity.User;

/**
 * @author ZHUZIHUI
 * @date 2018年10月28日
 */
public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
