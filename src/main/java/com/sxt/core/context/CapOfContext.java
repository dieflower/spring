package com.sxt.core.context;

import com.sxt.core.model.Key;

/**
 * @author chenrui
 * @date 2019/5/7 16:30
 */

public interface CapOfContext {
    /**
     * 放到容器里面
     * @param key
     * 对象的标识
     * @param value
     * 对象
     */

    void putCap(Key key,Object value);

    /**
     * 获取对象
     *
     * @param name
     * 根据名字
     * @return
     */

    Object get(String name);

    /**
     * 获取对象根据接口获取
     *@param clazz
     * @return
     */
    Object get(Class<?> clazz);
}
