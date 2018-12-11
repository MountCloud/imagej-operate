package org.mountcloud.imagej.operate.annotation;

import java.lang.annotation.*;

/**
 * 操作注解
 * com.ugirls.imagej.annotation
 * 2018/6/13.
 *
 * @author zhanghaishan
 * @version V1.0
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IJOperationAnnotation {
}
