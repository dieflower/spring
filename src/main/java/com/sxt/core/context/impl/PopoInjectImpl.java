package com.sxt.core.context.impl;

import com.sxt.core.anno.Inject;
import com.sxt.core.context.CapOfContext;
import com.sxt.core.context.PopoInject;
import com.sxt.core.model.Key;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

/**
 * @author chenrui
 * @date 2019/5/8 10:29
 */

public class PopoInjectImpl implements PopoInject {
    private CapOfContextImpl capOfContext;

    public PopoInjectImpl(CapOfContextImpl capOfContext) {
        this.capOfContext = capOfContext;
    }

    @Override
    public void injectPropo() {
        Map<Key, Object> iocs = CapOfContextImpl.iocs;


        Set<Key> keys = iocs.keySet();
        for (Key key : keys) {
            Object o = iocs.get(key);
            Field[] declaredFields = o.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                Inject inject = declaredField.getAnnotation(Inject.class);
                if(inject==null)continue;

                Class<?> type = declaredField.getType();
                Object o1 = capOfContext.get(type);
                if (null==o1)throw new RuntimeException("值不能为空");
                declaredField.setAccessible(true);
                try {
                    declaredField.set(o,o1);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

        }

    }
}
