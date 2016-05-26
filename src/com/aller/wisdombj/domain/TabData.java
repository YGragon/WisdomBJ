package com.aller.wisdombj.domain;

import java.util.ArrayList;

/**
*	版权: Aller所有
*
*	作者 : Aller
*
*	E-mail : Aller_Dong@163.com
*
*	版本 : 1.0
*
*	时间 : 2016年5月11日下午9:34:33
*
*	描述 : 页签详情页数据
*/

public class TabData {
	
	public int retcode;

	public TabDetail data;
	
	public class TabDetail {
		public String title;
		public String more;
		public ArrayList<TabNewsData> news;
		public ArrayList<TopNewsData> topnews;

		@Override
		public String toString() {
			return "TabDetail [title=" + title + ", news=" + news
					+ ", topnews=" + topnews + "]";
		}
	}
	
	/**
	 * 
	* @ClassName: TabNewsData
	* @Description: 新闻呢列表的对象的数据
	* @author Aller Aller_Dong@163.com
	* @date 2016年5月11日 下午9:36:57
	*
	 */
	public class TabNewsData {
		public String id;
		public String listimage;
		public String pubdate;
		public String title;
		public String type;
		public String url;

		@Override
		public String toString() {
			return "TabNewsData [title=" + title + "]";
		}
	}
	
	/**
	 * 
	* @ClassName: TopNewsData
	* @Description: 头条新闻的数据
	* @author Aller Aller_Dong@163.com
	* @date 2016年5月11日 下午9:37:52
	*
	 */
	public class TopNewsData {
		public String id;
		public String topimage;
		public String pubdate;
		public String title;
		public String type;
		public String url;

		@Override
		public String toString() {
			return "TopNewsData [title=" + title + "]";
		}
	}

	@Override
	public String toString() {
		return "TabData [data=" + data + "]";
	}

}
