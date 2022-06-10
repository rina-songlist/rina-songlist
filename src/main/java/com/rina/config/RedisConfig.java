package com.rina.config;

import com.rina.util.CommonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis的配置类
 * @author arvin
 * @date 2022/06/03
 */
@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);

		// Json序列化配置
		final Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(CommonUtil.objectMapper());
		// String的序列化
		final StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

		// 具体的序列化方式
		// key用string
		template.setKeySerializer(stringRedisSerializer);
		template.setHashKeySerializer(stringRedisSerializer);

		// value用json
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.setHashValueSerializer(jackson2JsonRedisSerializer);

		template.afterPropertiesSet();
		return template;
	}

}
