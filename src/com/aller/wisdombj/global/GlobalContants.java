package com.aller.wisdombj.global;
/**
*	版权: Aller所有
*
*	作者 : Aller
*
*	E-mail : Aller_Dong@163.com
*
*	版本 : 1.0
*
*	时间 : 2016年5月5日下午12:39:47
*
*	描述 : 定义全局参数
*
*
*
*/

public class GlobalContants {
	//连接genymtion模拟器的地址为http://10.0.3.2:8080/zhbj
	//连接eclipse自带模拟器的地址为http://10.0.2.2:8080/zhbj
	//由于tomcat中的数据网址(为了简单就不去修改各个其中的网址了)是10.0.2.2:8080，所以用自带的模拟器测试
	//http://dongxi346.applinzi.com/zhbj 新浪云的服务器
	public static final String SERVER_URL = "http://10.0.2.2:8080/zhbj" ;
//	public static final String SERVER_URL = "http://dongxi346.applinzi.com/zhbj" ;
	// 获取分类信息的接口
	public static final String CATEGORIES_URL = SERVER_URL + "/categories.json";
	// 获取组图信息的接口
	public static final String PHOTOS_URL = SERVER_URL + "/photos/photos_1.json";
}
