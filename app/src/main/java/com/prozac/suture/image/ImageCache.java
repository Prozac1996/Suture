package com.prozac.suture.image;

import android.graphics.Bitmap;

/**
 * 图片缓存接口
 */
public interface ImageCache {

    /**
     * 缓存一张图片
     * @param url   图片的url
     * @param bitmap    图片对象
     */
    void put(String url, Bitmap bitmap);

    /**
     * 从缓存获取一张图片
     * @param url
     * @return
     */
    Bitmap get(String url);
}
