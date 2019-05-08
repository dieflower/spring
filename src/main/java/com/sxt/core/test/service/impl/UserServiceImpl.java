package com.sxt.core.test.service.impl;

import com.sxt.core.anno.Autobuild;
import com.sxt.core.test.service.UserService;

/**
 * @author chenrui
 * @date 2019/5/7 19:28
 */
@Autobuild
public class UserServiceImpl implements UserService {
    public void hallo() {
        System.out.println("ha");
    }
}
