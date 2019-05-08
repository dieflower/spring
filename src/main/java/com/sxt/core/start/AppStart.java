package com.sxt.core.start;

import com.sxt.core.context.BeanFactory;
import com.sxt.core.context.BeanInit;
import com.sxt.core.context.CapOfContext;
import com.sxt.core.context.PopoInject;
import com.sxt.core.context.impl.BeanFactoryImpl;
import com.sxt.core.context.impl.BeanInitImpl;
import com.sxt.core.context.impl.CapOfContextImpl;
import com.sxt.core.context.impl.PopoInjectImpl;
import com.sxt.core.model.Bean;
import com.sxt.core.test.service.UserService;
import com.sxt.core.test.service.impl.UserServiceImpl;

import java.util.List;

/**
 * @author chenrui
 * @date 2019/5/8 10:43
 */

public class AppStart {

    public static void main(String[] args) {
        CapOfContextImpl capOfContext = new CapOfContextImpl();
        BeanInit beanInit = new BeanInitImpl();
        BeanFactory beanFactory = new BeanFactoryImpl(capOfContext);


        List<Bean> beans = beanInit.packageScan("com.sxt.core.test.service.impl");
        beanFactory.creatAndPut(beans);
        UserServiceImpl o = (UserServiceImpl)capOfContext.get(UserService.class);
        o.hallo();




    }
}
