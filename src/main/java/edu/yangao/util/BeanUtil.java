package edu.yangao.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YangAo
 * @Description 用于复制bean的工具
 * @create 2022-05-28 20:07
 */
public class BeanUtil {

    /**
     * 复制bean
     * @param source 源bean
     * @param target 目标bean类型class
     * @return 复制后的bean
     * @param <T> 目标bean类型
     */
    public static <T> T copyBean(Object source, Class<T> target) {
        T temp = null;
        try {
            // 源不为空, 才进行复制属性操作
            if (source != null) {
                temp = target.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(source, temp);
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }

    /**
     * 复制列表
     * @param source 源列表
     * @param target 目标列表中元素的类型class
     * @return 复制后的列表
     * @param <T> 目标类型
     */
    public static <T> List<T> copyList(List<?> source, Class<T> target) {
        List<T> targetList = new ArrayList<>();
        // 如果列表为空, 则直接返回空的列表
        if (CollectionUtils.isEmpty(source)) {
            return targetList;
        }
        for (Object sourceItem : source) {
            targetList.add(copyBean(sourceItem, target));
        }
        return targetList;
    }
}
