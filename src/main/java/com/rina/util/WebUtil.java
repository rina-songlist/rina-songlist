package com.rina.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义Web工具类
 * @author arvin
 * @date 2022/05/26
 */
@Slf4j
public class WebUtil {

	/**
	 * 自定义的http返回信息
	 * @param response 当前会话的servlet返回体
	 * @param data 将在返回体中写入的内容
	 * @param <T> 返回体类型
	 */
	public static <T> void myResponse(HttpServletResponse response, T data) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().println(objectMapper.writeValueAsString(data));
		} catch (IOException e) {
			log.error("数据写入返回体错误：{}", e.getLocalizedMessage());
		}
	}

}
