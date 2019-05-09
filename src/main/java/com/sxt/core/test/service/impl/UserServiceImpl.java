package com.sxt.core.test.service.impl;

import com.sxt.core.anno.Autobuild;
import com.sxt.core.anno.Inject;
import com.sxt.core.test.Dao.UserDao;
import com.sxt.core.test.service.UserService;

/**
 * @author chenrui
 * @date 2019/5/7 19:28
 */
@Autobuild
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;



    public void hallo() {
        System.out.println("ha");
    }


    public void hai(){
        System.out.println("注入的userDauserDao");
        userDao.hai();
        System.out.println("aaa");
    }

}
