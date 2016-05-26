package com.aller.wisdombj.utils.bitmap;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
/**
 * MemoryCache
 * @author Aller
 *
 */
public class MemoryCacheUtils {

	private LruCache<String, Bitmap> mMemoryCache;//最近最少使用算法
	public MemoryCacheUtils(){
		long maxMemory = Runtime.getRuntime().maxMemory() / 8 ;//模拟器默认是为每个APP分配16M内存
		mMemoryCache = new LruCache<String, Bitmap>((int)maxMemory){
			@Override
			protected int sizeOf(String key, Bitmap value) {
				int byteCount = value.getRowBytes() * value.getHeight() ;// 获取图片占用内存大小
				return byteCount;
			}
		};
	}
	
	//写入内存
	public void setBitmapToMemory(String url, Bitmap result) {
		mMemoryCache.get(url) ;
	}
	//从内存读
	public Bitmap getBitmapFromMemory(String url) {
		return mMemoryCache.get(url) ;
	}

}
