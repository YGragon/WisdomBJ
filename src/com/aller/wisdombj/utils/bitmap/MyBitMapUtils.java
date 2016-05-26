package com.aller.wisdombj.utils.bitmap;

public class MyBitMapUtils {
	private NetCacheUtils mNetCacheUtils;
	private LocalCacheUtils mLocalCacheUtils;
	private MemoryCacheUtils mMemoryCacheUtils;

	public MyBitMapUtils(){
		mNetCacheUtils = new NetCacheUtils(mLocalCacheUtils, mMemoryCacheUtils);
		mLocalCacheUtils = new LocalCacheUtils();
		mMemoryCacheUtils = new MemoryCacheUtils();
	}
}
