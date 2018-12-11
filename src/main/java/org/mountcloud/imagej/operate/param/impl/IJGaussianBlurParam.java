package org.mountcloud.imagej.operate.param.impl;

import org.mountcloud.imagej.operate.param.IJParamBase;

/**
 * 参数父类
 * com.ugirls.imagej.param.impls
 * 2018/6/13.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class IJGaussianBlurParam extends IJParamBase {

    /**
     * 模糊度
     */
    private Integer radius;

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
}
