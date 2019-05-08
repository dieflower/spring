package com.sxt.core.model;

import java.util.Map;

/**
 * @author chenrui
 * @date 2019/5/7 16:21
 */

public class Bean {
    private String name;

    private String classname;

    private Map<String,String> propos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Map<String, String> getPropos() {
        return propos;
    }

    public void setPropos(Map<String, String> propos) {
        this.propos = propos;
    }
    public Bean(){}
    public Bean(String name, String classname, Map<String, String> propos) {
        this.name = name;
        this.classname = classname;
        this.propos = propos;
    }
}
