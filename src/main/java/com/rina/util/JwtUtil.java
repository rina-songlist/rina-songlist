package com.rina.util;

import com.rina.config.AppProperties;
import com.rina.domain.vo.UserDetailsVo;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

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

	private final AppProperties appProperties;

	/**
	 * 使用的加密算法
	 */
	private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	/**
	 * 创建token
	 * @param userDetailsVo 简略化的user信息
	 * @return 加密后的token
	 */
	public String createJwtToken(UserDetailsVo userDetailsVo){
		final long now = System.currentTimeMillis();

		// 将自定义的过期时间解析并换算为long
		long expireTime = 1L;
		final String[] strings = appProperties.getJwt().getTokenExpireTime().split("\\*");
		for (String string : strings) {
			expireTime *= Long.parseLong(string);
		}

		return Jwts.builder()
				.setId("rina")
				.claim("authorities", userDetailsVo.getUserName())
				.setSubject(String.valueOf(userDetailsVo.getRoleId()))
				.setIssuedAt(new Date(now))
				.setExpiration(new Date(now + expireTime))
				.signWith(KEY, SignatureAlgorithm.HS512)
				.compact();
	}

	/**
	 * 查看token是否已过期
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
	public Optional<Claims> parseClaims(String token){
		try {
			final Claims claims = Jwts.parserBuilder().setSigningKey(KEY).build()
					.parseClaimsJws(token).getBody();
			return Optional.of(claims);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
			return Optional.empty();
		}
	}

}
