package com.aller.wisdombj.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class HorizontalViewPager extends ViewPager {

	public HorizontalViewPager(Context context) {
		super(context);
	}

	public HorizontalViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	/**
     * 事件分发，请求父控件及祖宗控件不要拦截事件
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
    	if (getCurrentItem() != 0) {
    		getParent().requestDisallowInterceptTouchEvent(true);// 用getParent去请求，拦截
		}else{
			//在新闻第一个页面，需要显示侧边栏，不拦截
			getParent().requestDisallowInterceptTouchEvent(false);// 用getParent去请求
		}
    	return super.dispatchTouchEvent(ev);
    }
	
}
