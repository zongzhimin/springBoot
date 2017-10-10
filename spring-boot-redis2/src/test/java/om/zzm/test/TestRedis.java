package om.zzm.test;

import om.zzm.test.domain.entity.User;
import om.zzm.test.service.RedisService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestRedis {
	
	@Autowired
	private RedisService redisService;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void test(){
		System.out.println("设值。。。。。。");
		redisService.setStr("name", "zzm");
	}
	
	@Test
	public void test2(){
		System.out.println("取值。。。。。");
		System.out.println(redisService.getStr("name"));
	}
	
//	@Test
//	public void test3(){
//		System.out.println("删除。。。");
//		redisService.del("name");
//	}
	
	@Test
	public void test4(){
		System.out.println("设值.......obj");
		User u1 = new User("me", "zzm");
		redisService.setObj("me", u1);
	}
	
	@Test
	public void test5(){
		System.out.println("取值。。。。。。obj");
		System.out.println(redisService.getObj("me"));
	}
	
//	@Test
//	public void test6(){
//		System.out.println("删除。。。obj");
//		redisService.delObj(1);
//	}
}
