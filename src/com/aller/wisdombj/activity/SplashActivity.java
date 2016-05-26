package com.aller.wisdombj.activity;

import com.aller.wisdombj.R;
import com.aller.wisdombj.R.id;
import com.aller.wisdombj.R.layout;
import com.aller.wisdombj.utils.PrefUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {

	 private RelativeLayout rl_root;

	    private RotateAnimation rotateAnimation;
	    private ScaleAnimation scaleAnimation ;
	    private AlphaAnimation alphaAnimation ;


	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE) ;
	        setContentView(R.layout.activity_splash);

	        rl_root = (RelativeLayout) findViewById(R.id.rl_root);

	        startAnim() ;
	    }

	    private void startAnim() {

	        //动画的集合
	        AnimationSet set = new AnimationSet(false);

	        //旋转动画
	        rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
	        //动画时间
	        rotateAnimation.setDuration(1000);
	        //保持动画状态
	        rotateAnimation.setFillAfter(true);

	        //缩放动画
	        scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
	        //动画时间
	        scaleAnimation.setDuration(1000);
	        //保持动画状态
	        scaleAnimation.setFillAfter(true);

	        //渐变动画
	        alphaAnimation = new AlphaAnimation(0, 1) ;
	        //动画时间
	        alphaAnimation.setDuration(1000);
	        //保持动画状态
	        alphaAnimation.setFillAfter(true);

	        //添加动画进入集合动画中
	        set.addAnimation(rotateAnimation);
	        set.addAnimation(scaleAnimation);
	        set.addAnimation(alphaAnimation);


	        set.setAnimationListener(new Animation.AnimationListener() {
	            @Override
	            public void onAnimationStart(Animation animation) {
	            }

	            @Override
	            public void onAnimationEnd(Animation animation) {
	                //动画结束，跳转到下一页
	                jumpNextPage() ;
	            }

	            @Override
	            public void onAnimationRepeat(Animation animation) {
	            }
	        });

	        //启动动画
	        rl_root.startAnimation(set);
	    }

	    /**
	     * 跳转下一页
	     */
	    private void jumpNextPage() {

	        boolean userguide = PrefUtils.getBoolean(this, "is_userguide_showed", false);
	        if (!userguide){
	            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
	        }else{
	            startActivity(new Intent(SplashActivity.this, MainActivity.class));
	        }
	        finish();
	    }
}
