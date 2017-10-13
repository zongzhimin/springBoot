package com.zzm.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zzm.test.domain.entity.UserEntity;
import com.zzm.test.domain.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new UserEntity("男", "李雷"));
		userMapper.insert(new UserEntity("女", "韩梅梅"));
		userMapper.insert(new UserEntity("男", "小明"));

		Assert.assertEquals(3, userMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = userMapper.getAll();
		System.out.println(users.toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = userMapper.getOne(2L);
		System.out.println(user.toString());
		user.setNickName("neo");
		userMapper.update(user);
		Assert.assertTrue(("neo".equals(userMapper.getOne(2l).getNickName())));
	}
}
