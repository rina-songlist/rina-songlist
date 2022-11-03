package com.rina.service;

import com.rina.resp.Resp;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * 许可所对应的service
 * @author arvin
 * @date 2022/06/13
 */
@PreAuthorize("hasAuthority('sys:permission:view')")
public interface PermissionService extends PublicService{

	/**
	 * 列表查询许可
	 * @return
	 */
	Resp listPermissions();

	/**
	 * 树形查询许可
	 * @return
	 */
	Resp treePermissions();

}
