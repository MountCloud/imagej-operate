package org.mountcloud.imagej.operate;

import org.mountcloud.imagej.operate.annotation.IJOperationAnnotation;
import org.mountcloud.imagej.operate.exception.OperationClassIsNullException;
import org.mountcloud.imagej.operate.operation.IJOperationBase;
import org.mountcloud.imagej.operate.param.IJParamBase;
import org.mountcloud.imagej.operate.util.IJClassUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作工厂类
 * com.ugirls.imagej
 * 2018/6/13.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class IJOperationFactory {

    /**
     * 包名
     */
    private String[] pkgNames;

    /**
     * 类搜索器
     */
    private IJClassUtil classUtil;

    /**
     * 工厂的所有操作类型
     */
    private Map<Class<? extends IJParamBase>,Class<? extends IJOperationBase>> classMaps;

    /**
     * 私有的工厂构造函数
     */
    private IJOperationFactory(String ... pkgNames){
        this.pkgNames = pkgNames;
        init();
        classMaps = findClass("com.ugirls.imagej.operation",IJOperationAnnotation.class);
    }

    /**
     * 初始化
     */
    private void init(){
        classUtil = new IJClassUtil();
    }

    /**
     * 返回工厂
     * @param pkgName 扫描operation的包名
     * @return 工厂
     */
    public static IJOperationFactory getFactory(String ... pkgName){
        IJOperationFactory factory = new IJOperationFactory(pkgName);
        return factory;
    }

    /**
     * 获取对应的操作
     * @param param 操作对应的参数
     * @param <T> 操作类型
     * @param <V> 参数类型
     * @return 参数对应的操作
     * @throws NoSuchMethodException 异常
     * @throws IllegalAccessException  异常
     * @throws InvocationTargetException 异常
     * @throws InstantiationException 异常
     */
    public <T extends IJOperationBase,V extends IJParamBase> T createOperation(V param) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls = classMaps.get(param.getClass());
        if(cls==null){
            throw new OperationClassIsNullException(param.getClass().getName()+" Operation Class is Null!");
        }
        Constructor con = cls.getDeclaredConstructor(new Class[]{param.getClass()});
        T result = (T) con.newInstance(new Object[]{param});
        return result;
    }

    /**
     * 获取类加载器
     * @param pkgName 包名
     * @param annotationClass 注解的类
     * @return 参数对应的操作map
     */
    private Map<Class<? extends IJParamBase>,Class<? extends IJOperationBase>> findClass(String pkgName, Class<? extends Annotation> annotationClass){
        List<Class<?>> lists = classUtil.getClasses("com.ugirls.imagej.operation",IJOperationAnnotation.class);

        Map<Class<? extends IJParamBase>,Class<? extends IJOperationBase>> result = new HashMap<Class<? extends IJParamBase>,Class<? extends IJOperationBase>>();
        for(int i=0;i<lists.size();i++){
            Class<?> tempClass = lists.get(i);
            Constructor[] cons=tempClass.getDeclaredConstructors();

            for(int y=0;y<cons.length;y++){
                Constructor tempCons = cons[i];
                Class<?>[] parameterTypes=tempCons.getParameterTypes();
                if(parameterTypes.length==1){
                    Class<?> conParam = parameterTypes[0];
                    if(IJParamBase.class.isAssignableFrom(conParam)&&IJOperationBase.class.isAssignableFrom(tempClass)){
                        Class<? extends IJOperationBase> putClass = (Class<? extends IJOperationBase>) tempClass;
                        Class<? extends IJParamBase> keyClass = (Class<? extends IJParamBase>) conParam;
                        result.put(keyClass,putClass);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 提供扫描的所有包
     * @return 所有扫描的包名
     */
    public String[] getPkgNames() {
        return pkgNames;
    }
}
