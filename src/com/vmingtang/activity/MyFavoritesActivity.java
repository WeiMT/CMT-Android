package com.vmingtang.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.widget.TextView;

@EActivity(R.layout.activity_my_favorites)
public class MyFavoritesActivity extends BaseActivity{
	@ViewById
	TextView tvTitle;

	@AfterViews
	void initView(){
		tvTitle.setText("我的收藏");
	}
}
