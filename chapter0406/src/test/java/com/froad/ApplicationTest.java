package com.froad;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.froad.redis.RedisDao;

/**
 * @author ZHUZIHUI
 * @date 2018年11月9日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Autowired
	private RedisDao redisDao;

	@Test
	public void testRedis() {
		redisDao.setKey("name", "zhuzihui");
		redisDao.setKey("age", "18");
		System.out.println("name:" + redisDao.getValue("name") + ",age:" + redisDao.getValue("age"));
	}

}
