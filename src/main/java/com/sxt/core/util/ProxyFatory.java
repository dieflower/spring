package com.sxt.core.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenrui
 * @date 2019/5/9 19:17
 */

public class ProxyFatory {


    public static Object creatProxy(final Class<?> clazz) {
        return  Proxy.newProxyInstance(ProxyFatory.class.getClassLoader(),
                new Class[]{clazz}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        if("toString".equals(name)){

                            return clazz.getSimpleName()+"@Proxy";
                        }
                        System.out.println(name);
                        System.out.println("执行sql");
                        System.out.println("hai");

                        return null;
                    }
                });

    }
}
