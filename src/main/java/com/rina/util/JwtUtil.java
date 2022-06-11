package com.rina.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * Jwt的工具类
 *
 * @author arvin
 * @date 2022/02/09
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {

	private final CommonUtil commonUtil;

	/**
	 * 使用的加密算法
	 */
	private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	/**
	 * 获取UUID
	 * @return UUID
	 */
	private static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 创建token
	 * @param subject token主要信息体
	 * @return 加密后的token
	 */
	public String createJwtToken(String subject) {
		return getJwtBuilder(subject, commonUtil.tokenExpireMillis(), getUUID())
				.compact();
	}

	/**
	 * 创建token
	 * @param subject token主要信息体
	 * @param ttlMillis 过期时间（毫秒）
	 * @return 加密后的token
	 */
	public String createJwtToken(String subject, Long ttlMillis) {
		return getJwtBuilder(subject, ttlMillis, getUUID())
				.compact();
	}

	/**
	 * 创建token
	 * @param subject token主要信息体
	 * @param ttlMillis 过期时间（毫秒）
	 * @param id token id
	 * @return 加密后的token
	 */
	public String createJwtToken(String subject, Long ttlMillis, String id) {
		return getJwtBuilder(subject, ttlMillis, id)
				.compact();
	}

	/**
	 * 生成JwtBuilder
	 * @param subject token主要信息体
	 * @param ttlMillis 过期时间（毫秒）
	 * @param id token id
	 * @return
	 */
	private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String id) {
		final long now = System.currentTimeMillis();

		return Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuer("arvin")
				.setIssuedAt(new Date(now))
				.setExpiration(new Date(now + ttlMillis))
				.signWith(KEY, SignatureAlgorithm.HS512);
	}

	/**
	 * 查看token是否已过期 (已预处理所有异常)
	 * @param token 加密后的token
	 * @return 是否过期
	 */
	public boolean validateToken(String token){
		try {
			Jwts.parserBuilder().setSigningKey(KEY).build().parse(token);
			return true;
		} catch (ExpiredJwtException e) {
			log.info("用户登陆已过期！");
			return false;
		} catch (MalformedJwtException | SignatureException | IllegalArgumentException e) {
			log.error("token解析发生异常 {}", e.getLocalizedMessage());
			return false;
		}
	}

	/**
	 * 解析token信息
	 * @param token 加密后的token
	 * @return 解析后的token内容
	 */
	public Claims parseJwtToken(String token){
		return Jwts.parserBuilder()
				.setSigningKey(KEY).build()
				.parseClaimsJws(token)
				.getBody();
	}

}
