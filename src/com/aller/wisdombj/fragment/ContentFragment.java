package com.aller.wisdombj.fragment;

import java.util.ArrayList;

import com.aller.wisdombj.R;
import com.aller.wisdombj.base.BasePager;
import com.aller.wisdombj.base.impl.GovAffairsPager;
import com.aller.wisdombj.base.impl.HomePager;
import com.aller.wisdombj.base.impl.NewsConterPager;
import com.aller.wisdombj.base.impl.SettingPager;
import com.aller.wisdombj.base.impl.SmartServicePager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * 版权: Aller所有
 *
 * 作者 : Aller
 *
 * E-mail : 1105894953@qq.com
 *
 * 版本 : 1.0
 *
 * 时间 : 2016年5月2日下午2:27:51
 *
 * 描述 : 主页内容
 *
 *
 *
 */

public class ContentFragment extends BaseFragment {

	@ViewInject(R.id.rg_group)
	private RadioGroup rgGroup;

	@ViewInject(R.id.vp_content)
	private ViewPager mViewPager;

	private ArrayList<BasePager> mPagerList;

	@Override
	public View initViews() {
		View view = View.inflate(mActivity, R.layout.fragment_content, null);
		ViewUtils.inject(this, view); // 注入view和事件
		return view;
	}

	@Override
	public void initData() {
		rgGroup.check(R.id.rb_home);// 默认home被选中

		mPagerList = new ArrayList<BasePager>();
		//初始化5个子页面
		mPagerList.add(new HomePager(mActivity));
		mPagerList.add(new NewsConterPager(mActivity));
		mPagerList.add(new SmartServicePager(mActivity));
		mPagerList.add(new GovAffairsPager(mActivity));
		mPagerList.add(new SettingPager(mActivity));

		mViewPager.setAdapter(new ContentAdapter());
		
		rgGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
					switch(checkedId){
					case R.id.rb_home:
						mViewPager.setCurrentItem(0, false);//参数二是去掉切换动画的效果
						break ;
					case R.id.rb_news:
						mViewPager.setCurrentItem(1, false);
						break ;
					case R.id.rb_smart:
						mViewPager.setCurrentItem(2, false);
						break ;
					case R.id.rb_gov:
						mViewPager.setCurrentItem(3, false);
						break ;
					case R.id.rb_setting:
						mViewPager.setCurrentItem(4, false);
						break ;
					}
			}
		});
		//页面改变的监听事件
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			//页面被选择
			@Override
			public void onPageSelected(int arg0) {
				mPagerList.get(arg0).initData();//页面被选择时初始化该页面数据
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		mPagerList.get(0).initData();//初始化第一个页面
	}

	class ContentAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mPagerList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}

		//初始化界面
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			container.addView(mPagerList.get(position).mRootView);
			return mPagerList.get(position).mRootView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

	}
	/**
	 * 获取新闻中心页面
	 * 
	 * @return
	 */
	public NewsConterPager getNewsCenterPager() {
		return (NewsConterPager) mPagerList.get(1);
	}

}
