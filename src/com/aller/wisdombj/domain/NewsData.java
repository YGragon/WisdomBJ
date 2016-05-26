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
*	时间 : 2016年5月5日下午3:00:47
*
*	描述 : 网络分类信息的封装
*		   
*		   字段名字必须和服务器返回的字段名一致，方便Gson解析
*
*/

public class NewsData {
	
	public int retcode ;
	public ArrayList<NewsMenuData> data ;
	//侧边栏数据对象
	public class NewsMenuData{
		public String id ;
		public String title ;
		public int type ;
		public String url ;
		
		public ArrayList<NewsTabData> children;

		@Override
		public String toString() {
			return "NewsMenuData [title=" + title + ", children=" + children + "]";
		}
	}
	
	//新闻页下面的11个子页的数据对象
	public class NewsTabData{
		
		public String id ;
		public String title ;
		public int type ;
		public String url ;
		@Override
		public String toString() {
			return "NewsTabData [title=" + title + "]";
		}
	}

	@Override
	public String toString() {
		return "NewsData [data=" + data + "]";//方便输出结果
	}
}
