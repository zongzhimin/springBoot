package com.zzm.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate1;
	
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate2;
	
	@Before
	public void init(){
		jdbcTemplate1.execute("truncate user");
		jdbcTemplate2.execute("truncate user");
	}
	
	@Test
	public void test(){
		jdbcTemplate1.update("insert into user (id,name,age) values (1,'源氏',8)");
		jdbcTemplate1.update("insert into user (id,name,age) values (2,'半藏',8)");
		
		jdbcTemplate2.update("insert into user (id,name,age) values (1,'大锤',12)");
		
		Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));
		Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));
	}
}
