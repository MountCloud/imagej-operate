package org.mountcloud.imagej.operate.operation;

import org.mountcloud.imagej.operate.param.IJParamBase;

/**
 * 操作类父类
 * com.ugirls.imagej.operation
 * 2018/6/13.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public abstract class IJOperationBase<T extends IJParamBase> {

    /***
     * 参数
     */
    protected T param;

    /**
     * 进行执行
     * @return 执行结果
     */
    public abstract boolean run();


    public IJOperationBase(T param){
        this.param = param;
    }

}
