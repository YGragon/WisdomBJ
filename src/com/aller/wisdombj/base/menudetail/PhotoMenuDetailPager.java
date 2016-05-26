package com.aller.wisdombj.base.menudetail;

import java.util.ArrayList;

import com.aller.wisdombj.R;
import com.aller.wisdombj.base.BaseMenuDetailPager;
import com.aller.wisdombj.domain.PhotosData;
import com.aller.wisdombj.domain.PhotosData.PhotoInfo;
import com.aller.wisdombj.global.GlobalContants;
import com.aller.wisdombj.utils.CacheUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 菜单详情页-组图
 * 
 * @author Aller
 * 
 */
public class PhotoMenuDetailPager extends BaseMenuDetailPager {

	private ListView lvPhoto;
	private GridView gvPhoto;

	private ArrayList<PhotoInfo> mPhotoList;
	private PhotoAdapter mAdapter;
	
	private boolean isListDispaly = true ;//是否是ListView布局

	private ImageButton btnPhoto;

	public PhotoMenuDetailPager(Activity activity, ImageButton btnPhoto) {
		super(activity);

		this.btnPhoto = btnPhoto;

		btnPhoto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				changeDisplay();
			}
		});
	}

	/**
	 * 切换展现方式
	 */
	protected void changeDisplay() {
		if(isListDispaly){
			isListDispaly = false ;
			lvPhoto.setVisibility(View.GONE);
			gvPhoto.setVisibility(View.VISIBLE);
			
			btnPhoto.setImageResource(R.drawable.icon_pic_list_type);
		}else{
			isListDispaly = true ;
			lvPhoto.setVisibility(View.VISIBLE);
			gvPhoto.setVisibility(View.GONE);
			
			btnPhoto.setImageResource(R.drawable.icon_pic_grid_type);
		}
	}

	@Override
	public View initView() {
		View view = View.inflate(mActivity, R.layout.menu_photo_pager, null);
		lvPhoto = (ListView) view.findViewById(R.id.lv_photo);
		gvPhoto = (GridView) view.findViewById(R.id.gv_photo);
		return view;
	}

	@Override
	public void initData() {
		String cache = CacheUtils.getCache(GlobalContants.PHOTOS_URL, mActivity) ;
		if(!TextUtils.isEmpty(cache)){
		
		}
		
		getDataFromServer();
	}

	private void getDataFromServer() {
		HttpUtils utils = new HttpUtils();
		utils.send(HttpMethod.GET, GlobalContants.PHOTOS_URL, new RequestCallBack<String>() {

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				String result = responseInfo.result;
				parseData(result);
				
				//设置缓存
				CacheUtils.setCache(GlobalContants.PHOTOS_URL, result, mActivity);
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				Toast.makeText(mActivity, "服务器开小差了...", Toast.LENGTH_SHORT).show();
				error.printStackTrace();
			}

		});
	}

	protected void parseData(String result) {
		Gson gson = new Gson();
		PhotosData fromJsonData = gson.fromJson(result, PhotosData.class);

		mPhotoList = fromJsonData.data.news;// 获取组图列表集合

		if (mPhotoList != null) {
			mAdapter = new PhotoAdapter();
			lvPhoto.setAdapter(mAdapter);
			gvPhoto.setAdapter(mAdapter);
		}

	}

	class PhotoAdapter extends BaseAdapter {

		private BitmapUtils utils ;
		
		public PhotoAdapter() {
			utils = new BitmapUtils(mActivity) ;
			utils.configDefaultLoadingImage(R.drawable.news_pic_default) ;
		}
		
		@Override
		public int getCount() {
			return mPhotoList.size();
		}

		@Override
		public Object getItem(int position) {
			return mPhotoList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder;
			if (convertView == null) {
				convertView = View.inflate(mActivity, R.layout.list_photo_item, null);

				holder = new ViewHolder();
				holder.ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
				holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
				
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			
			PhotoInfo item = (PhotoInfo) getItem(position) ;
			
			holder.tvTitle.setText(item.title);
			utils.display(holder.ivPic, item.listimage);
			
			return convertView;

		}

	}

	static class ViewHolder {
		public TextView tvTitle;
		public ImageView ivPic;
	}

}
