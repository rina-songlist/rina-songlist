package com.rina.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 关系表工具类
 * @author : aftermath
 * @date : 2022-11-06 10:56:34
 */
public class RelationTableUtils {

    // TODO 将方法重载为单入有返、单入无返、双入无返的方法

    /**
     * 通过 id 更新 R 表单的 T 字段
     * @param index 索引id
     * @param newParams 更新后的参数集合
     * @param findOldListByIndex 通过索引查询旧参数的方法
     * @param tGetterFromR 从R拿到T的方法
     * @param rCreator R实例的构造方法
     * @param insertMapperByR 通过R插入表的方法
     * @param deleteMapperByIndexAndParam 通过索引和另一参数删除表的方法
     * @param <T> 需要更新的字段 (eg: RoleMenuId)
     * @param <R> 更新字段所处的实体类 (eg: RoleMenu)
     * @return 更新记录数
     */
    public static <T extends Comparable<T>, R> List<Integer> compareAndUpdateRelationTable(Long index,
                                                                                           List<T> newParams,
                                                                                           Function<Long, List<R>> findOldListByIndex,
                                                                                           Function<R, T> tGetterFromR,
                                                                                           Function<T, R> rCreator,
                                                                                           Function<R, Integer> insertMapperByR,
                                                                                           BiFunction<Long, T, Integer> deleteMapperByIndexAndParam) {
        final List<T> oldList = new ArrayList<>();
        findOldListByIndex.apply(index)
                .forEach(r -> oldList.add(tGetterFromR.apply(r)));

        //查找newList相比于oldList多出来的T, 将T插入新的R对象, 将新的R对象插入rList
        List<R> data4insert = new ArrayList<>();
        ListUtil.compareLists(newParams, oldList)
                .forEach(ids -> data4insert.add(rCreator.apply(ids)));

        //将rList中的元素插入表
        final List<Integer> updateResult = data4insert.stream().map(insertMapperByR)
                .distinct()
                .map(x -> x.equals(0) ? 1 : x)
                .collect(Collectors.toList());

        //查找oldList相比于newList多出来的T, 并删除
        final List<Integer> deleteResult = ListUtil.compareLists(oldList, newParams)
                .stream().map(changeParam -> deleteMapperByIndexAndParam.apply(index, changeParam))
                .distinct()
                .map(x -> x.equals(0) ? 1 : x)
                .collect(Collectors.toList());

        updateResult.addAll(deleteResult);
        return updateResult;
    }

}
