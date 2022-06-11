package com.rina.handler;

import com.rina.domain.LoginUser;
import com.rina.resp.Resp;
import com.rina.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SpringSecurity
 * 授权失败后的处理器
 * @author arvin
 * @date 2022/06/08
 */
@Component
@Slf4j
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		final LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final String currentUser = loginUser.getUser().getUserName();
		log.info("当前用户：{}权限不足！", currentUser);

		WebUtil.myResponse(response, Resp.forbidden());
	}

}
