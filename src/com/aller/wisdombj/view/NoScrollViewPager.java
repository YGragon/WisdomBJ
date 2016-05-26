package com.aller.wisdombj.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
*	版权: Aller所有
*
*	作者 : Aller
*
*	E-mail : Aller_Dong@163.com
*
*	版本 : 1.0
*
*	时间 : 2016年5月4日下午2:26:12
*
*	描述 : 不能左右滑动的ViewPager
*
*
*
*/

public class NoScrollViewPager extends ViewPager {

	public NoScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	public NoScrollViewPager(Context context) {
		super(context);
		
	}
	//表示事件是否拦截，返回false表示不拦截，事件可以往下传递
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		return false;
	}
	//表示事件的点击事件，返回false表示什么都不用做
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		return false;
	}

}
