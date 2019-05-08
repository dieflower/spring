package com.sxt.core.context;

import com.sxt.core.model.Bean;

import java.util.List;

/**
 * @author chenrui
 * @date 2019/5/7 16:22
 */

public interface BeanFactory {

    void creatAndPut(List<Bean> beans);
}
