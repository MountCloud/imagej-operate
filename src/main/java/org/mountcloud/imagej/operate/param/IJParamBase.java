package org.mountcloud.imagej.operate.param;

/**
 * 父参数
 * com.ugirls.imagej.operation.parameter
 * 2018/6/13.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public abstract class IJParamBase {

    /**
     * 源图片
     */
    private String sourceImage;

    /**
     * 目标文件
     */
    private String targetImage;

    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        this.sourceImage = sourceImage;
    }

    public String getTargetImage() {
        return targetImage;
    }

    public void setTargetImage(String targetImage) {
        this.targetImage = targetImage;
    }
}
