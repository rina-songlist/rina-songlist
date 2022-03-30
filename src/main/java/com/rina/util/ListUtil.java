package com.rina.util;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * List的工具类
 *
 * @author arvin
 * @date 2022/03/30
 */
public class ListUtil {

	/**
	 * 对比两个数组
	 * @param list1 数组1
	 * @param list2 数组2
	 * @param <T> 必须是基础数据类型
	 * @return 数组1有但数组2没有的元素
	 */
	public static<T extends Comparable<T>> List<T> compareLists(List<T> list1, List<T> list2) {
		Map<T, T> tempMap = list2.parallelStream()
				.collect(Collectors.toMap(Function.identity(), Function.identity(), (oldData, newData) -> newData));
		return list1.parallelStream().filter(str-> !tempMap.containsKey(str)).collect(Collectors.toList());
	}

}
