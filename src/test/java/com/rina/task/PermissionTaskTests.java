package com.rina.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * permission相关的任务的测试类
 *
 * @author arvin
 * @date 2022/07/04
 */
@SpringBootTest
@WithUserDetails(value = "tester", userDetailsServiceBeanName = "userDetailsServiceImpl")
public class PermissionTaskTests {

	@Autowired
	private PermissionTask permissionTask;

	@Test
	void testUpdateViewPermissions() throws ExecutionException, InterruptedException {
		final Future<List<Integer>> future = permissionTask.updateViewPermissions("tester", 3L, Arrays.asList(3L, 4L, 5L));

		Thread.sleep(1000);

		System.out.println(future.isDone());
		System.out.println(future.get());
	}

}
