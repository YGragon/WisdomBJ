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
*	时间 : 2016年5月24日下午8:19:30
*
*	描述 : 图片数据的封装
*/

public class PhotosData {
	public int retcode ;
	public PhotosInfo data;
	
	public class PhotosInfo {
		public String title ;
		public ArrayList<PhotoInfo> news ;
	}
	
	public class PhotoInfo{
		public String id ;
		public String listimage ;
		public String pubdate ;
		public String title ;
		public String type ;
		public String url ;
	}
}
