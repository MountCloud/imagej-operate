package org.mountcloud.imagej.operate.exception;

/**
 * 操作类为空的异常
 * org.mountcloud.imagej.operate.exception
 * 2018/12/11.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class OperationClassIsNullException extends RuntimeException {

    /**
     * 构造
     * @param ex 异常描述
     */
    public OperationClassIsNullException(String ex){
        super(ex);
    }

}
