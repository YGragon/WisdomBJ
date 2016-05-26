package com.aller.wisdombj.utils.bitmap;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.crypto.spec.IvParameterSpec;

import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.core.BitmapDecoder;
import com.lidroid.xutils.view.annotation.event.OnProgressChanged;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * NetCache
 * @author Aller
 *
 */
public class NetCacheUtils {

	private LocalCacheUtils mLocalCacheUtils;
	private MemoryCacheUtils mMemoryCacheUtils;

	public NetCacheUtils(LocalCacheUtils localCacheUtils, MemoryCacheUtils memoryCacheUtils) {
		mLocalCacheUtils = localCacheUtils;
		mMemoryCacheUtils = memoryCacheUtils;
	}

	public void getBitMapFromNet(ImageView ivPic, String url) {
		new BitmapTask().execute(ivPic, url) ;// 启动AsyncTask,
		// 参数会在doInbackground中获取
	}

	/**
	 *  Handler和线程池的封装
	 * @author Aller
	 *
	 */
	class BitmapTask extends AsyncTask<Object, Void, Bitmap> {

		private ImageView ivPic;
		private String url;

		/**
		 * 后台耗时方法在这里执行
		 */
		@Override
		protected Bitmap doInBackground(Object... params) {
			ivPic = (ImageView) params[0];
			url = (String) params[1];

			ivPic.setTag(url);// 将URL与ImageVIew相连接
			return downloadBitmap(url);
		}

		// 加载进度条，在主进程中执行
		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}

		/**
		 * 耗时方法执行结束后，执行此方法，在主线程中执行
		 */
		@Override
		protected void onPostExecute(Bitmap result) {
			super.onPostExecute(result);
			if (result != null) {
				String bindUrl = (String) ivPic.getTag();
				if (url.equals(bindUrl)) {
					ivPic.setImageBitmap(result);
					mLocalCacheUtils.setBitmapToLocal(url, result);// 将图片保存在本地
					mMemoryCacheUtils.setBitmapToMemory(url, result);// 将图片保存在内存
					System.out.println("从网络缓存读取图片啦.la..la..");
				}
			}
		}

	}

	/**
	 * 下载图片
	 * @param url
	 * @return
	 */
	public Bitmap downloadBitmap(String url) {

		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setReadTimeout(5000);
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			conn.connect();
			
			int responseCode = conn.getResponseCode() ;
			if(responseCode == 200){
				InputStream inputStream = conn.getInputStream() ;
				//图片压缩处理
				BitmapFactory.Options options =new BitmapFactory.Options() ;
				options.inSampleSize = 2 ;//宽高都压缩为原来的二分之一, 此参数需要根据图片要展示的大小来确定
				options.inPreferredConfig = Bitmap.Config.RGB_565 ;//设置图片格式
				
				Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options) ;
				return bitmap ;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			conn.disconnect();
		}
		return null;
	}
}
