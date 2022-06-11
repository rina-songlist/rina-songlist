package com.rina.util;

import com.rina.enums.ResultCode;
import com.rina.resp.Resp;
import com.rina.resp.UsualResp;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局前端数据的返回工具（基于mapper反馈处理）
 * @author arvin
 * @date 2022/03/23
 */
@Slf4j
public class RespUtil {

	/**
	 * 查询数据
	 * @param data 数据内容
	 * @param <T> 数据类型
	 * @return 全局返回体
	 */
	public static<T> Resp queryData(T data) {
		if (data == null) {
			log.error("数据库操作错误");
			return Resp.notFound();
		} else {
			return UsualResp.succeed(data);
		}
	}

	/**
	 * 添加（编辑）数据
	 * @param databaseResponses 数据库返回体
	 * @return 全局返回体
	 */
	public static Resp editData(Integer... databaseResponses){
		boolean isIntegrity = isIntegrity(databaseResponses);

		if (!isIntegrity) {
			log.error("数据库操作错误");
			return Resp.serverError();
		}
		return Resp.succeed(ResultCode.CREATED);
	}

	/**
	 * 删除数据
	 * @param databaseResponses 数据库返回体
	 * @return 全局返回体
	 */
	public static Resp deleteData(Integer... databaseResponses){
		boolean isIntegrity = isIntegrity(databaseResponses);

		if (!isIntegrity) {
			log.error("数据库操作错误");
			return Resp.serverError();
		}
		return Resp.succeed(ResultCode.DELETED);
	}

	/**
	 * 数据是否完整
	 * @param databaseResponses 数据库返回体
	 * @return 数据完整性状态
	 */
	private static boolean isIntegrity(Integer... databaseResponses) {
		boolean isIntegrity = true;

		for (Integer dataIntegrity : databaseResponses) {
			isIntegrity &= (dataIntegrity != 0);
		}
		return isIntegrity;
	}

}
