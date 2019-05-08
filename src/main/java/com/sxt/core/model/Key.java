package com.sxt.core.model;


/**
 * @author chenrui
 * @date 2019/5/7 16:31
 */

public class Key implements Comparable<Key>{

    private String name;

    private Class<?> interfaces;

    public static Key of(String name) {

        return new Key(name,null);
    }
    public static Key of(Class<?> interfaces){
        return new Key(null,interfaces);
    }
    public Key(){}
    public Key(String name, Class<?> interfaces) {
        this.name = name;
        this.interfaces = interfaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class<?> interfaces) {
        this.interfaces = interfaces;
    }


    @Override
    public int compareTo(Key o) {
        if (this.equals(o)) {
            return 0;
        } else {
            if (this.getName() != null && o.getName() != null) {
                return this.getName().compareTo(o.getName());
            } else {
                return this.getInterfaces().getSimpleName().compareTo(o.getInterfaces().getSimpleName());

            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        Key key = (Key) obj;
        if (this.name!=null&&this.name.equals(key.getName()))
            return true;
        if (this.interfaces!=null&&this.interfaces.equals(key.getInterfaces()))
            return true;
        return false;
    }
}
