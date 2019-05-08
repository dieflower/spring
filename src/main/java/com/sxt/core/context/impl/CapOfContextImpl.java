package com.sxt.core.context.impl;

import com.sxt.core.context.CapOfContext;
import com.sxt.core.model.Key;
import com.sxt.core.test.service.impl.UserServiceImpl;
import com.sxt.core.test.service.UserService;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenrui
 * @date 2019/5/7 17:31
 */

public class CapOfContextImpl implements CapOfContext {
    public static Map<Key,Object> iocs = new TreeMap<Key, Object>();


    public void putCap(Key key, Object value) {
        if(key==null||value==null)throw new RuntimeException("ioc容器不能有空值");
        if(key.getName()==null||key.getName().equals(""))throw new RuntimeException("名字不能为空值");
        if(key.getInterfaces()==null)throw new RuntimeException("接口不能为空");
        iocs.put(key, value);
    }

    public Object get(String name) {
        if (name == null)throw new RuntimeException("名字不能为空");
        Key key = Key.of(name);

        if(!iocs.containsKey(key))return null;
        return iocs.get(key);
    }

    public Object get(Class<?> clazz) {
        if(clazz == null)throw new RuntimeException("接口不能为空");
        Key key = Key.of(clazz);
        if (!iocs.containsKey(key))return null;
        return iocs.get(key);
    }

}
