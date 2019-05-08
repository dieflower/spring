package com.sxt.core.context;

import com.sxt.core.model.Bean;

import java.util.List;

/**
 * @author chenrui
 * @date 2019/5/7 16:19
 */

public interface BeanInit {


    List<Bean> readXml(String path);


    List<Bean> packageScan(String basePagkage);
}
