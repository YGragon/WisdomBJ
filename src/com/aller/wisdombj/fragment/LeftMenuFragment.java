package com.aller.wisdombj.fragment;

import java.util.ArrayList;

import com.aller.wisdombj.R;
import com.aller.wisdombj.activity.MainActivity;
import com.aller.wisdombj.base.impl.NewsConterPager;
import com.aller.wisdombj.domain.NewsData;
import com.aller.wisdombj.domain.NewsData.NewsMenuData;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
*	版权: Aller所有
*
*	作者 : Aller
*
*	E-mail : 1105894953@qq.com
*
*	版本 : 1.0
*
*	时间 : 2016年5月2日下午2:28:46
*
*	描述 : 侧边栏
*
*
*
*/

public class LeftMenuFragment extends BaseFragment {
	
	@ViewInject(R.id.lv_list)
	private ListView lvlist ;
	
	private ArrayList<NewsMenuData> mMenuList ;
	
	private int mCurrentpos ;//当前被点击的菜单项

	private MenuAdapte mAdapte;

	@Override
	public View initViews() {
		View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
		
		ViewUtils.inject(this,view);//使用注解
		
		return view;
	}
	
	public void initData(){
		lvlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mCurrentpos = position ;
				mAdapte.notifyDataSetChanged();
				
				setCurrentMenuDetailPager(position);
				
				toggleSlidingMenu();// 隐藏
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

	protected void setCurrentMenuDetailPager(int position) {
		MainActivity mainUI = (MainActivity) mActivity ;
		ContentFragment fragment = mainUI.getContentFragment() ;// 获取主页面fragment
		NewsConterPager pager = fragment.getNewsCenterPager();// 获取新闻中心页面
		pager.setCurrentMenuDetailPager(position);// 设置当前菜单详情页
	}

	/**
	 * 
	* @Title: setMenuData
	* @param: data 网络回传的数据对象
	* @Description: 设置网络数据
	*
	 */
	public void setMenuData(NewsData data){
		mMenuList = data.data ;
		mAdapte = new MenuAdapte();
		lvlist.setAdapter(mAdapte);
	}
	
	/**
	 * 
	* @ClassName: MenuAdapte
	* @Description: 侧边栏菜单数据适配器
	* @author Aller Aller_Dong@163.com
	* @date 2016年5月5日 下午3:45:28
	*
	 */
	class MenuAdapte extends BaseAdapter{

		@Override
		public int getCount() {
			return mMenuList.size();
		}
		@Override
		public Object getItem(int position) {
			return mMenuList.get(position);
		}
		@Override
		public long getItemId(int position) {
			return position;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(mActivity, R.layout.list_menu_item, null) ;
			TextView tv_title = (TextView) view.findViewById(R.id.tv_title) ;
			NewsMenuData newsMenuData = (NewsMenuData) getItem(position) ;
			tv_title.setText(newsMenuData.title);
			
			if (mCurrentpos == position) {
				//判断当前绘制的view是否被选中
				
				//设为红色
				tv_title.setEnabled(true);
			}else{
				//设为白色
				tv_title.setEnabled(false);
			}
			
			return view;
		}
		
	}

}
