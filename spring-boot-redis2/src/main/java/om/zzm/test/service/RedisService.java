package om.zzm.test.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Resource(name="stringRedisTemplate")
	private ValueOperations<String,String> valOpsStr;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Resource(name="redisTemplate")
	private ValueOperations<Object, Object> valOpsObj;
	
	public String getStr(String key){
		return valOpsStr.get(key);
	}
	
	public void setStr(String key ,String val){
		valOpsStr.set(key, val);
	}
	
	public void del(String key){
		stringRedisTemplate.delete(key);
	}
	
	public Object getObj(Object o){
		return valOpsObj.get(o);
	}
	
	public void setObj(Object o1,Object o2){
		valOpsObj.set(o1, o2);
	}
	
	public void delObj(Object o){
		redisTemplate.delete(o);
	}
	
}
