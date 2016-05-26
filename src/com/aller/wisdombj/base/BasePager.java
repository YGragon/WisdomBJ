package com.aller.wisdombj.base;



import com.aller.wisdombj.R;
import com.aller.wisdombj.activity.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

/**
*	版权: Aller所有
*
*	作者 : Aller
*
*	E-mail : Aller_Dong@163.com
*
*	版本 : 1.0
*
*	时间 : 2016年5月4日下午3:23:20
*
*	描述 : 主页下5个子页面的基类
*
*
*
*/

public class BasePager {
	public Activity mActivity ;
	
	public View mRootView ;//布局对象
	public TextView tvTitle ;//标题
	public FrameLayout flContent ;//内容
	public ImageButton btnMenu ;//菜单按钮
	public ImageButton btnPhoto;// 组图切换按钮
	
	public BasePager(Activity activity) {
		this.mActivity = activity ;
		initViews() ;
	}
	
	/**
	 *
	* @Title: initViews
	* @Description:  初始化布局
	* @param 
	* @return 
	* @throws
	 */
	private void initViews() {
		
		mRootView = View.inflate(mActivity,R.layout.base_pager , null) ;
		
		tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
		flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);
		btnMenu = (ImageButton) mRootView.findViewById(R.id.btn_menu);
		btnPhoto = (ImageButton) mRootView.findViewById(R.id.btn_photo);
		
		btnMenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				toggleSlidingMenu();
			}
		});
	}

	/**
	 * 
	* @Title: toggleSlidingMenu
	* @param:
	* @Description: 切换SlidingMenu的状态
	*
	 */
	protected void toggleSlidingMenu() {
		MainActivity mainUi = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		slidingMenu.toggle();// 切换状态, 显示时隐藏, 隐藏时显示
	}
	
	/**
	 * 初始化数据
	 */
	public void initData() {
		
	}
	
	/**
	 * 
	* @Title: setSlidingMenuEnable
	* @param:
	* @Description: 设置侧边栏开启或关闭
	*
	 */
	public void setSlidingMenuEnable(boolean b) {
		MainActivity mainUI = (MainActivity) mActivity ;
		SlidingMenu slidingMenu = mainUI.getSlidingMenu() ;
		
		if (b) {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 设置全屏触摸
		}else{
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);//设置滑动无效
		}
	}
}
