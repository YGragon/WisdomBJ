package com.aller.wisdombj.base.impl;

import com.aller.wisdombj.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class GovAffairsPager extends BasePager {

	public GovAffairsPager(Activity activity) {
		super(activity);
	}

	@Override
	public void initData() {
		tvTitle.setText("人口管理");
		setSlidingMenuEnable(true);// 有侧滑菜单

		TextView textView = new TextView(mActivity);
		textView.setText("政务");
		textView.setTextColor(Color.RED);
		textView.setTextSize(25);
		textView.setGravity(Gravity.CENTER);// 显示的布局居中

		// 向FrameLayout中动态添加布局
		flContent.addView(textView);
	}
}
