package com.aller.wisdombj.utils.bitmap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.aller.wisdombj.utils.MD5Encoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;

/**
 *  LocalCache
 * @author Aller
 *
 */
public class LocalCacheUtils {
	
	public static final String CACHE_PATH = Environment.getExternalStorageDirectory()
			.getAbsolutePath() +"WisdomBJ" ;//保存的路径
	
	/**
	 * 从sdcard拿到数据
	 * @param url
	 * @return
	 */
	public Bitmap getBitmapFromLocal(String url) {
		try {
			String fileName = MD5Encoder.encode(url) ;
			File file = new File(CACHE_PATH,fileName) ;
			
			if(file.exists()){
				Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file)) ;
				return bitmap ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 向sdcard写入图片
	 * @param url
	 * @param result
	 */
	public void setBitmapToLocal(String url, Bitmap result) {
		String fileName;
		try {
			fileName = MD5Encoder.encode(url);
			File file = new File(CACHE_PATH,fileName) ;
			File parentFile = file.getParentFile() ;
			if(!parentFile.exists()){
				parentFile.mkdirs() ;
			}
			// 将图片保存在本地
			result.compress(CompressFormat.JPEG, 100, new FileOutputStream(file)) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
