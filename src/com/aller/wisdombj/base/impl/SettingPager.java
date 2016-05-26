package com.aller.wisdombj.base.impl;

import com.aller.wisdombj.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class SettingPager extends BasePager {

	public SettingPager(Activity activity) {
		super(activity);
	}

	@Override
	public void initData(){
		tvTitle.setText("设置");
		btnMenu.setVisibility(View.INVISIBLE);
		setSlidingMenuEnable(false);// 关闭侧边栏
		
		TextView textView = new TextView(mActivity) ;
		textView.setText("设置");
		textView.setTextColor(Color.RED);
		textView.setTextSize(25);
		textView.setGravity(Gravity.CENTER);//显示的布局居中
		
		//向FrameLayout中动态添加布局
		flContent.addView(textView);
	}

	
}
