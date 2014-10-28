package com.vmingtang.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import android.widget.TextView;

@EActivity(R.layout.activity_identifying_code)
public class IdentifyingCodeActivity extends BaseActivity{
	@Extra
	String mobile;
	@ViewById
	TextView tvMobile;
	@AfterViews
	void initView(){
		tvMobile.setText(mobile);
	}
}
