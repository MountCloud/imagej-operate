package org.mountcloud.imagej.operate.operation.impl.blur;

import ij.ImagePlus;
import ij.plugin.filter.GaussianBlur;
import org.mountcloud.imagej.operate.annotation.IJOperationAnnotation;
import org.mountcloud.imagej.operate.exception.OperationParamException;
import org.mountcloud.imagej.operate.operation.IJOperationBase;
import org.mountcloud.imagej.operate.param.impl.IJGaussianBlurParam;
import org.mountcloud.imagej.operate.util.FileUtil;
import org.mountcloud.imagej.operate.util.ImageJUtil;


/**
 * 模糊的操作类
 * com.ugirls.imagej.operation.impls
 * 2018/6/13.
 *
 * @author zhanghaishan
 * @version V1.0
 */
@IJOperationAnnotation
public class IJGaussianBlurOperation extends IJOperationBase<IJGaussianBlurParam> {

    public IJGaussianBlurOperation(IJGaussianBlurParam param) {
        super(param);
    }

    @Override
    public boolean run() {
        boolean state = true;
        ImagePlus imp = null;
        try{
            //获取模糊度
            Integer radius = param.getRadius();
            if(radius==null){
                throw new OperationParamException("radius is null");
            }

            imp = ImageJUtil.loadImage(param.getSourceImage());

            if(imp!=null){
                GaussianBlur blur = new GaussianBlur();
                blur.setup("",imp);

                state = blur.blur(imp.getProcessor(),radius);
                if(state){
                    blur.run(imp.getProcessor());
                    FileUtil.createFloderByFile(param.getTargetImage());
                }
            }else{
                state = false;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        if(!state){
            return state;
        }

        return ImageJUtil.saveAs(param.getTargetImage(),imp);
    }

}
