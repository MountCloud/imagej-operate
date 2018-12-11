package org.mountcloud.imagej;

import org.junit.Test;
import org.mountcloud.imagej.operate.IJOperationFactory;
import org.mountcloud.imagej.operate.operation.impl.blur.IJGaussianBlurOperation;
import org.mountcloud.imagej.operate.param.impl.IJGaussianBlurParam;

import java.lang.reflect.InvocationTargetException;

/**
 * Test
 * org.mountcloud.imagej
 * 2018/12/11.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class IJOperationFactoryTest {

    @Test
    public void testBlur() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        IJGaussianBlurParam param = new IJGaussianBlurParam();
        param.setRadius(25);
        param.setSourceImage("D:\\Pictures\\222.jpg");
        param.setTargetImage("D:\\Pictures\\222_25.png");


        IJGaussianBlurOperation operation = IJOperationFactory.getFactory().createOperation(param);
        System.out.println(operation.run());
    }

}
