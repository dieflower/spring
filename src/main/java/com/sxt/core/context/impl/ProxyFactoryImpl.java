package com.sxt.core.context.impl;

import com.sxt.core.context.ProxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author chenrui
 * @date 2019/5/9 15:36
 */

public class ProxyFactoryImpl implements ProxyFactory {

    @Override
    public Object creatProxy(final Object obj) {
       return  Proxy.newProxyInstance(ProxyFactoryImpl.class.getClassLoader(),
                new Class[]{obj.getClass().getInterfaces()[0]}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object reslut = null;
                        try {
                            System.out.println("前置通知");
                            reslut = method.invoke(obj,args);

                            System.out.println("提交事务");


                        }catch (Exception e){

                            e.printStackTrace();

                            System.out.println("回滚事务");
                        }
                        return reslut;
                    }
                });

    }
}
