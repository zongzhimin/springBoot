package om.zzm.test.domain.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableCaching //启用缓存
public class CatchConfig extends CachingConfigurerSupport {
	
	/**
     * 自定义key. 这个可以不用
     * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
     */
/*    @Bean
    public KeyGenerator keyGenerator() {
       System.out.println("RedisCacheConfig.keyGenerator()");
       return new KeyGenerator() {
    	   @Override
    	   public Object generate(Object o, Method method, Object... objects) {
    		   // This will generate a unique key of the class name, the method name
    		   //and all method parameters appended.
    		   StringBuilder sb = new StringBuilder();
    		   sb.append(o.getClass().getName());
    		   sb.append(method.getName());
    		   for (Object obj : objects) {
    			   sb.append(obj.toString());
    		   }
    		   System.out.println("keyGenerator=" + sb.toString());
    		   return sb.toString();
    	   }
       };
    }
    */
	
	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
	    RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
	   /* //设置缓存过期时间
	    // rcm.setDefaultExpiration(60);//秒
	    //设置value的过期时间
	    Map<String,Long> map=new HashMap();
	    map.put("test",60L);
	    rcm.setExpires(map);*/
	    return rcm;
	}
	
	 /**
     * RedisTemplate配置
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        //定义key序列化方式
        //RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型会出现异常信息;需要我们上面的自定义key生成策略，一般没必要
        //定义value的序列化方式
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        
       // template.setKeySerializer(redisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
