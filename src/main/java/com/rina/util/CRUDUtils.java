package com.rina.util;

import kotlin.jvm.functions.Function2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : aftermath
 * @date : 2022-11-06 10:56:34
 */
@Component
public class CRUDUtils {
    /**
     * 通过 id 更新 R 表单的 T 字段
     *
     *
     * @param id 索引id
     * @param newList 新的 T 实例集合
     * @param findOldListById 通过 id 查询旧的 R(集合)
     * @param getT 从R拿到T
     * @param getR 获取一个R实例
     * @param insertR 向R中插入
     * @param deleteR 从R中删除
     * @param <T> 需要更新的资源 (eg: RolePermissionId)
     * @param <R> 需要更新的资源表 (eg: RolePermission)
     * @return 更新记录数
     */
    public <T extends Comparable<T>, R> List<Integer> updateById(Long id, List<T> newList,
                                                                 Function<Long, List<R>> findOldListById,
                                                                 Function<R, T> getT,
                                                                 Function<T, R> getR,
                                                                 Function<R, Integer> insertR,
                                                                 Function2<Long, T, Integer> deleteR) {
        final List<T> oldList = new ArrayList<>();
        findOldListById.apply(id)
                .forEach(r -> oldList.add(getT.apply(r)));

        //查找newList相比于oldList多出来的T, 将T插入新的R对象, 将新的R对象插入rList
        List<R> rList = new ArrayList<>();
        ListUtil.compareLists(newList, oldList)
                .forEach(t -> {
                    rList.add(getR.apply(t));
                });

        //将rList中的元素插入表
        final List<Integer> rInserted = rList.stream().map(insertR)
                .distinct()
                .map(x -> {
                    if (x.equals(0)) {
                        x = 1;
                    }
                    return x;
                })
                .collect(Collectors.toList());

        //查找oldList相比于newList多出来的T, 并删除
        final List<Integer> rDeleted = ListUtil.compareLists(oldList, newList)
                .stream().map(t -> deleteR.invoke(id, t))
                .distinct()
                .map(result -> {
                    if (result.equals(0)) {
                        result = 1;
                    }
                    return result;
                })
                .collect(Collectors.toList());

        List<Integer> updateResult;
        updateResult = rInserted;
        updateResult.addAll(rDeleted);
        return updateResult;
    }
}
