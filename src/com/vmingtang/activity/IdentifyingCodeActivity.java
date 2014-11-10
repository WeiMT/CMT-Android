package com.vmingtang.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import com.vmingtang.util.StringUtil;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@EActivity(R.layout.activity_identifying_code)
public class IdentifyingCodeActivity extends BaseActivity{
	@Extra
	String mobile;
	@ViewById
	TextView tvTitle,tvMobile;
	@ViewById
	Button btnCode,btnNext;
	@ViewById
	EditText etCode;
	@AfterViews
	void initView(){
		tvTitle.setText("验证码");
		tvMobile.setText(mobile);
		btnNext.setOnClickListener(clickListener);
	}
	OnClickListener clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnNext:
				String code = etCode.getText().toString();
				if(StringUtil.isTrimBlank(code)){
					showToastShort("请输入验证码");
				}else{
					MainActivity_.intent(context).start();
				}
				break;
			}
			
		}
	};
}
