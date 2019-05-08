package com.sxt.core.anno;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;

import java.lang.annotation.*;

/**
 * @author chenrui
 * @date 2019/5/8 9:09
 */
@Target(ElementType.TYPE)//放在类上
@Retention(RetentionPolicy.RUNTIME)//运行时可见
@Documented
public @interface Autobuild {

    String name() default "";
}
