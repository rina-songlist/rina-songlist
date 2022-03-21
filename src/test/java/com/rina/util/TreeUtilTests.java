package com.rina.util;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 树形结构的测试类的测试类
 *
 * @author arvin
 * @date 2022/03/18
 */
public class TreeUtilTests {

	// 定义一个基础的节点类
	@Data
	@Accessors(chain = true)
	public static class Node {
		Integer id;
		Integer pid;
		List<Node> children;
	}

	/**
	 * 创建一个随机能够形成树形结构的数组
	 * @param tierN 树的深度
	 * @param rootN 主节点的个数
	 * @param childN 每个节点中的子节点的个数
	 * @return 能够形成树形结构的数组
	 */
	private static List<Node> createRandomTestTreeInfoList(int tierN, int rootN, int childN) {
		final Random random = new Random();
		final int tier = tierN == 0 ? 5 + random.nextInt(5) : tierN;
		final List<Node> testTrees = new ArrayList<>();

		Queue<Node> pre = new LinkedList<>();
		final int rootNum = rootN == 0 ? 1 + random.nextInt(5) : rootN;
		for (int i = 0; i < rootNum; i++) {
			final Node testTree = new Node().setId(testTrees.size());
			testTrees.add(testTree);
			pre.add(testTree);
		}
		for (int i = 0; i < tier; i++) {
			final int childNum = childN == 0 ? 3 + random.nextInt(3) : childN;
			final int size = pre.size();
			for (int j = 0; j < size; j++) {
				final Integer pid = Objects.requireNonNull(pre.poll()).getId();
				for (int k = 0; k < childNum; k++) {
					final Node child = new Node().setId(testTrees.size()).setPid(pid);
					testTrees.add(child);
					pre.offer(child);
				}
			}
		}
		return testTrees;
	}

	@Test
	public void testSortNormally() {
		// 创建数组
		final List<Node> nodeList = createRandomTestTreeInfoList(2, 2, 2);
		System.out.println(JSON.toJSONString(nodeList));

		// 普通的序列化方式
		final List<Node> roots = new ArrayList<>();
		final Map<Integer, Node> map = new HashMap<>();
		for (Node node : nodeList) {
			if (node.getPid() == null) {
				roots.add(node);
			}
			map.put(node.getId(), node);
		}

		for (Node node : nodeList) {
			final Node parent = map.get(node.getPid());
			if (parent != null) {
				final List<Node> children = parent.getChildren();
				if (children == null) {
					parent.setChildren(new ArrayList<>());
				}
				parent.getChildren().add(node);
			}
		}
		System.out.println(JSON.toJSONString(roots));
	}

	@Test
	public void testSortWithTreeUtil() {
		// 创建数组
		final List<Node> nodeList = createRandomTestTreeInfoList(2, 2, 2);
		System.out.println(JSON.toJSONString(nodeList));

		// 使用TreeUtil的序列化方式
		final List<Node> roots2 = TreeUtil.list2tree(nodeList, Node::getId, Node::getPid, Node::getChildren, Node::setChildren);
		System.out.println(JSON.toJSONString(roots2));
	}

}
