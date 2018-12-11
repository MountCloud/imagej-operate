package org.mountcloud.imagej.operate.exception;

/**
 * 操作参数异常
 * org.mountcloud.imagej.operate.exception
 * 2018/12/11.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class OperationParamException extends RuntimeException {

    /**
     * 异常描述
     * @param ex
     */
    public OperationParamException(String ex){
        super(ex);
    }

}
