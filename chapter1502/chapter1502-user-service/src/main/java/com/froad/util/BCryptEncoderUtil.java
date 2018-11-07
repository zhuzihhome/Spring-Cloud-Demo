package com.froad.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ZHUZIHUI
 * @date 2018年10月29日
 */
public class BCryptEncoderUtil {

	private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

	public static String BCryptPassword(String password) {
		return ENCODER.encode(password);
	}

	public static boolean matches(CharSequence rawPassword, String encodedPassword) {
		return ENCODER.matches(rawPassword, encodedPassword);
	}
}
