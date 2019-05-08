package com.sxt.core.context.impl;

import com.sxt.core.anno.Autobuild;
import com.sxt.core.context.BeanFactory;
import com.sxt.core.context.CapOfContext;
import com.sxt.core.model.Bean;
import com.sxt.core.model.Key;

import java.util.List;

/**
 * @author chenrui
 * @date 2019/5/8 10:10
 */

public class BeanFactoryImpl  implements BeanFactory {
    private CapOfContext capOfContext;

    public BeanFactoryImpl(CapOfContext capOfContext) {
        this.capOfContext = capOfContext;
    }

    @Override
    public void creatAndPut(List<Bean> beans) {
        if (beans.isEmpty()) return;
        for (Bean bean : beans) {

            String clazzName = bean.getName();
            System.out.println(clazzName);
            try {
                Class<?> aClass = Class.forName(clazzName);
                Autobuild autobuild = aClass.getAnnotation(Autobuild.class);
                if(autobuild==null) continue;//没有注解就不创建对象

                Object o = aClass.newInstance();
                String objname = null;
                if(autobuild.name().equals("")) {
                    objname = bean.getName();
                }else {

                    objname = autobuild.name();
                }

                Class<?> interfaceself = null;
                Class<?>[] interfaces = aClass.getInterfaces();
                if(null==interfaces||interfaces.length==0){
                    interfaceself = aClass;
                }else {

                    interfaceself=interfaces[0];
                }
                capOfContext.putCap(new Key(objname,interfaceself),o);

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
