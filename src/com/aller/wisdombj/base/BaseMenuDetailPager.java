package com.aller.wisdombj.base;

import android.app.Activity;
import android.view.View;

/**
*	版权: Aller所有
*
*	作者 : Aller
*
*	E-mail : Aller_Dong@163.com
*
*	版本 : 1.0
*
*	时间 : 2016年5月5日下午4:17:28
*
*	描述 : 菜单详情页基类
*/

public abstract class BaseMenuDetailPager {

	public Activity mActivity ; 
	public View mRootView ;//根布局对象
	public BaseMenuDetailPager(Activity mActivity) {
		this.mActivity = mActivity;
		mRootView = initView() ;
		
	}
	/**
	 * 
	* @Title: initView
	* @param:
	* @Description: 初始化界面
	*
	 */
	public abstract View initView() ;
	
	/**
	 * 
	* @Title: initData
	* @param:
	* @Description: 初始化数据
	*
	 */
	public void initData(){
		
	}
}
