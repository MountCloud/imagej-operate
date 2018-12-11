package org.mountcloud.imagej.operate.util;

import ij.IJ;
import ij.ImagePlus;
import ij.io.FileSaver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ImageJ工具
 * org.mountcloud.imagej.operate.util
 * 2018/12/11.
 *
 * @author zhanghaishan
 * @version V1.0
 */
public class ImageJUtil {


    /**
     * 保存图片
     * @param path 保存地址
     * @param imp 图片
     * @return 保存结果
     */
    public static boolean saveAs(String path, ImagePlus imp) {
        if(imp==null||path==null){
            return false;
        }else{
            FileSaver fs = new FileSaver(imp);
            return fs.saveAsPng(path);
        }
    }

    /**
     * 加载图片
     * @param url 图片地址
     * @return 图片
     * @throws MalformedURLException 异常
     */
    public static ImagePlus loadImage(String url) throws MalformedURLException {

        if(url.startsWith("http")){
            if(url.indexOf(".png")>=0){
                return openPngUsingURL("",new URL(url));
            }else{
                return openJpegOrGifUsingURL("",new URL(url));
            }
        }else{
            if(url.indexOf(".png")>=0){
                return openPngUsingFile("",url);
            }else{
                return openJpegOrGifUsingFile("",url);
            }
        }

    }

    /**
     * 根据url加载jpeg图片
     * @param title 图片标题
     * @param url 图片地址
     * @return 图片
     */
    public static ImagePlus openJpegOrGifUsingURL(String title, URL url) {
        if (url == null) {
            return null;
        } else {
            Image img = Toolkit.getDefaultToolkit().createImage(url);
            if (img != null) {
                ImagePlus imp = new ImagePlus(title, img);
                return imp;
            } else {
                return null;
            }
        }
    }

    /**
     * 根据url加载png路径
     * @param title 图片标题
     * @param url 图片地址
     * @return 图片
     */
    public static ImagePlus openPngUsingURL(String title, URL url) {
        if (url == null) {
            return null;
        } else {
            BufferedImage img = null;

            try {
                img = ImageIO.read(url);
            } catch (IOException var5) {
                IJ.log("" + var5);
            }

            if (img != null) {
                ImagePlus imp = new ImagePlus(title, img);
                return imp;
            } else {
                return null;
            }
        }
    }

    /**
     * 根据文件加载jpeg图片
     * @param title 图片标题
     * @param file 图片地址
     * @return 图片
     */
    public static ImagePlus openJpegOrGifUsingFile(String title, String file) {
        if (file == null) {
            return null;
        } else {
            Image img = Toolkit.getDefaultToolkit().createImage(file);
            if (img != null) {
                ImagePlus imp = new ImagePlus(title, img);
                return imp;
            } else {
                return null;
            }
        }
    }

    /**
     * 根据文件加载png图片
     * @param title 图片标题
     * @param file 图片地址
     * @return 图片
     */
    public static ImagePlus openPngUsingFile(String title, String file) {
        if (file == null) {
            return null;
        } else {
            BufferedImage img = null;

            try {
                img = ImageIO.read(new File(file));
            } catch (IOException var5) {
                IJ.log("" + var5);
            }

            if (img != null) {
                ImagePlus imp = new ImagePlus(title, img);
                return imp;
            } else {
                return null;
            }
        }
    }
    
}
