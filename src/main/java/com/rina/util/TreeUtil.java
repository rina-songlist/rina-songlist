package com.rina.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 树形结构的工具类
 *
 * @author arvin
 * @date 2022/03/17
 */
@Slf4j
public class TreeUtil {

	/**
	 * 将数组转化为树形结构
	 * @param source 源数据
	 * @param isRoot 是否为主节点的方法
	 * @param getIdFun 获取当前节点id的方法
	 * @param getPidFun 获取当前父节点id的方法
	 * @param getOrderFun 获取当前节点排序顺序的方法
	 * @param getChildFun 获取子节点的方法
	 * @param setChildFun 设定子节点的方法
	 * @param <T> 每一个节点的数据类型
	 * @return 树形结构的数组
	 */
	public static <T> List<T> list2tree(List<T> source,
	                                    Predicate<T> isRoot,
										Function<T, ?> getIdFun,
										Function<T, ?> getPidFun,
										Function<T,?> getOrderFun,
										Function<T, List<T>> getChildFun,
										BiConsumer<T, List<T>> setChildFun) {
		// 参数判空
		if (Objects.isNull(source)
				|| Objects.isNull(getIdFun)
				|| Objects.isNull(getPidFun)
				|| Objects.isNull(getChildFun)
				|| Objects.isNull(setChildFun)
				|| source.isEmpty()) {
			log.warn("参数不满足，直接返回空list");
			return new ArrayList<T>();
		}

		if (log.isDebugEnabled()) {
			log.debug("source为：{}",source);
		}

		// 开始解析数据结构
		final List<T> roots = new ArrayList<>();
		final Map<Object, T> map = new HashMap<>();

		source.forEach(t -> {
			Optional.ofNullable(isRoot).map(r -> {
				if (r.test(t)) {
					roots.add(t);
				}
				return r;
			}).orElseGet(() -> {
				Optional.ofNullable(getPidFun.apply(t)).orElseGet(() -> {
					roots.add(t);
					return null;
				});
				return null;
			});
			map.put(getIdFun.apply(t), t);
		});

		source.forEach(t -> {
			map.computeIfPresent(getPidFun.apply(t), (k, v) -> {
				Optional.ofNullable(getChildFun.apply(v)).orElseGet(() -> {
					final List<T> list = new ArrayList<>();
					setChildFun.accept(v, list);
					return list;
				}).add(t);
				return v;
			});
		});

		if (log.isDebugEnabled()) {
			log.debug("解析后的数据为：{}", JSON.toJSONString(roots));
		}

		// 开始排序
		final List<T> sortedList = new ArrayList<>(Optional.ofNullable(getOrderFun)
				.map(t -> sortResult(roots, t, getChildFun))
				.orElse(roots));

		if (log.isDebugEnabled()) {
			log.debug("排序后的数据为：{}", JSON.toJSONString(sortedList));
		}

		return sortedList;
	}

	/**
	 * 将数组转化为树形结构（简化了需求的是否为主节点和获取当前节点排序顺序的变量）
	 * @param source 源数据
	 * @param getIdFun 获取当前节点id的方法
	 * @param getPidFun 获取当前父节点id的方法
	 * @param getChildFun 获取子节点的方法
	 * @param setChildFun 设定子节点的方法
	 * @param <T> 每一个节点的数据类型
	 * @return 树形结构的数组
	 */
	public static <T> List<T> list2tree(List<T> source,
	                                    Function<T, ?> getIdFun,
	                                    Function<T, ?> getPidFun,
	                                    Function<T, List<T>> getChildFun,
	                                    BiConsumer<T, List<T>> setChildFun) {
		return list2tree(source,null,getIdFun,getPidFun,null,getChildFun,setChildFun);
	}

	/**
	 * 将数组转化为树形结构（简化了需求的获取当前节点排序顺序的变量）
	 * @param source 源数据
	 * @param getIdFun 获取当前节点id的方法
	 * @param getPidFun 获取当前父节点id的方法
	 * @param getOrderFun 获取当前节点排序顺序的方法
	 * @param getChildFun 获取子节点的方法
	 * @param setChildFun 设定子节点的方法
	 * @param <T> 每一个节点的数据类型
	 * @return 树形结构的数组
	 */
	public static <T> List<T> list2tree(List<T> source,
	                                    Function<T, ?> getIdFun,
	                                    Function<T, ?> getPidFun,
	                                    Function<T, ?> getOrderFun,
	                                    Function<T, List<T>> getChildFun,
	                                    BiConsumer<T, List<T>> setChildFun) {
		return list2tree(source, null, getIdFun, getPidFun, getOrderFun, getChildFun, setChildFun);
	}

	/**
	 * 将数组转化为树形结构（简化了需求的是否为主节点的变量）
	 * @param source 源数据
	 * @param isRoot 是否为主节点的方法
	 * @param getIdFun 获取当前节点id的方法
	 * @param getPidFun 获取当前父节点id的方法
	 * @param getChildFun 获取子节点的方法
	 * @param setChildFun 设定子节点的方法
	 * @param <T> 每一个节点的数据类型
	 * @return 树形结构的数组
	 */
	public static <T> List<T> list2tree(List<T> source,
	                                    Predicate<T> isRoot,
	                                    Function<T, ?> getIdFun,
	                                    Function<T, ?> getPidFun,
	                                    Function<T, List<T>> getChildFun,
	                                    BiConsumer<T, List<T>> setChildFun) {
		return  list2tree(source, isRoot, getIdFun, getPidFun, null, getChildFun, setChildFun);
	}

	/**
	 * 将树形结构排序的方法
	 * @param source 源数据
	 * @param getOrderFun 获取当前节点排序顺序的方法
	 * @param getChildFun 获取子节点的方法
	 * @param <T> 每一个节点的数据类型
	 * @return 树形结构的数组
	 */
	private static <T> List<T> sortResult(List<T> source, Function<T, ?> getOrderFun, Function<T, List<T>> getChildFun) {
		source.sort(Comparator.comparingLong(o -> Long.parseLong(getOrderFun.apply(o).toString())));

		source.forEach(x -> {
			Optional.ofNullable(getChildFun.apply(x)).ifPresent(t -> sortResult(t, getOrderFun, getChildFun));
		});
		return source;
	}
}
