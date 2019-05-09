package com.sxt.core.context.impl;

import com.sxt.core.context.BeanFactory;
import com.sxt.core.context.BeanInit;
import com.sxt.core.model.Bean;
import com.sxt.core.test.service.UserService;
import com.sxt.core.test.service.impl.UserServiceImpl;

import javax.naming.Name;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenrui
 * @date 2019/5/8 9:14
 */

public class BeanInitImpl implements BeanInit {
    @Override
    public List<Bean> readXml(String path) {
        return null;
    }

    @Override
    public List<Bean> packageScan(String basePagkage) {
        if(basePagkage==null||basePagkage.equals(""))throw new RuntimeException("包名不能为空");
        List<Bean> beans = new ArrayList<Bean>();
        String[] split = basePagkage.split("\\.");
        try {
                String base =basePagkage.replaceAll("\\.","\\\\");
            String path = BeanInitImpl.class.getResource("/").getFile()+base;
            System.out.println(path);

            //String path = "D:\\ideaworkspace\\CapOfTea\\src\\main\\java\\"+base;
                File f1 = new File(path);
                System.out.println(f1);
                if(f1.isDirectory()){
                    String[] list = f1.list();
                    for (String s : list) {
                        String file = s;
                        file = basePagkage+"."+file;
                        file = file.subSequence(0,file.lastIndexOf(".")).toString();
                        beans.add(new Bean(file,s,null));
                    }
                }
        }catch (Exception e){
            e.printStackTrace();
        }
        return beans;
    }

    public static void main(String[] args) {
        BeanInitImpl beanInit = new BeanInitImpl();
        CapOfContextImpl capOfContext = new CapOfContextImpl();
        BeanFactory beanFactory = new BeanFactoryImpl(capOfContext);
        List<Bean> beans = beanInit.packageScan("com.sxt.core.test.service.impl");
        beanFactory.creatAndPut(beans);
        UserService o =(UserService) capOfContext.get(UserService.class);
        o.hallo();
    }


}
