package com.sxt.core.context.impl;

import com.sxt.core.context.CapOfContext;
import com.sxt.core.context.MapperScan;
import com.sxt.core.model.Bean;
import com.sxt.core.model.Key;
import com.sxt.core.test.Dao.UserDao;
import com.sxt.core.util.ProxyFatory;

import java.util.List;

/**
 * @author chenrui
 * @date 2019/5/9 10:13
 */

public class MapperScanImpl  implements MapperScan {
    private CapOfContext capOfContext;


    public MapperScanImpl(CapOfContext capOfContext) {
        this.capOfContext = capOfContext;
    }

    @Override
    public void mapperScan(String backage) {
        BeanInitImpl beanInit = new BeanInitImpl();
        List<Bean> beans = beanInit.packageScan(backage);
        try {
            for (Bean bean : beans) {
                String name = bean.getName();
                System.out.println(name);
                Class<?> aClass = Class.forName(name);
                Object o = ProxyFatory.creatProxy(aClass);//创建动态代理
                Key key = new Key(bean.getName(),aClass);

                capOfContext.putCap(key,o);

            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        CapOfContextImpl capOfContext = new CapOfContextImpl();
        MapperScan mapperScan = new MapperScanImpl(capOfContext);
        mapperScan.mapperScan("com.sxt.core.test.Dao");
        UserDao o =(UserDao) capOfContext.get(UserDao.class);
        o.hai();



    }
}
