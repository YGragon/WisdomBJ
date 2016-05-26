package com.aller.wisdombj.utils;

import android.content.Context;

public class DensityUtils {
	/**
	 * dp转换为px
	 * @param ctx 上下文
	 * @param dp 
	 * @return px 
	 */
	public static int dp2px(Context ctx, float dp){
		float density = ctx.getResources().getDisplayMetrics().density ;
		int px = (int) (dp * density + 0.5f) ;//四舍五入
		return px;
		
	}
	/**
	 * px转换为dp
	 * @param ctx
	 * @param px
	 * @return dp
	 */
	public static float px2dp(Context ctx, float px){
		float density = ctx.getResources().getDisplayMetrics().density ;
		float dp = px / density ;
		return dp;
		
	}
}
