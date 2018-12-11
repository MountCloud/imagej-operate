package org.mountcloud.imagej.operate.util;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 路径工具
 *
 * @author zhanghaishan
 * @version V1.0
 *
 * com.ugirls.util
 * 2017/12/19.
 */
public class FileUtil {

    /**
     * 创建文件的目录
     * @param filePath 文件路径
     */
    public static void createFloderByFile(String filePath){
        filePath = filePath.trim();
        File file = new File(filePath);
        File floder = file.getParentFile();
        if(!floder.exists()){
            floder.mkdirs();
        }
    }

}
