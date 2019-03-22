package com.prozac.suture.image;

import android.graphics.Bitmap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 图片加载器
 */
public class ImageLoader {

    /**
     * 单例
     */
    private static volatile ImageLoader instance;
    /**
     * 应有缺省实现
     */
    ImageCache mImageCache = null;
    /**
     * 根据内存核数来规定线程数
     */
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private ImageLoader(){ }

    /**
     * 获取单例对象
     * @return 单例图片加载器
     */
    public static ImageLoader getInstance(){
        if(instance == null){
            synchronized (ImageLoader.class){
                if(instance == null){
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    /**
     * 显示一张图片
     * @param url
     */
    public Bitmap loadBitmap(String url){
        Bitmap bitmap = null;
        if(url != null && !url.equals("")){
            bitmap = mImageCache.get(url);
        }
        if(bitmap == null){
            bitmap = downloadImage(url);
        }
        return bitmap;
    }

    /**
     * 从网络下载一张图
     * @param url
     * @return
     */
    public Bitmap downloadImage(String url){
        return null;
    }

}
