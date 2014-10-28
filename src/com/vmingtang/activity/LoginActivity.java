package com.vmingtang.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.widget.Button;
import android.widget.EditText;

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity {
	@ViewById
	EditText etMobile;
	@ViewById
	Button btnNext;

	@AfterViews
	void initView() {

	}
	@Click
	void btnNext(){
		String mobile = etMobile.getText().toString();
		if (mobile.length() < 11) {
			showToastShort("请输入正确的手机号码");
		} else {
			IdentifyingCodeActivity_.intent(context).mobile(mobile).start();
		}
	}
}
