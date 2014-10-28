package com.vmingtang.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.vmingtang.activity.R;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {
	@ViewById
	Button btnLogin;

	@AfterViews
	void initView() {
		btnLogin.setOnClickListener(clickListener);
	}

	OnClickListener clickListener = new OnClickListener() {

		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnLogin:
				startActivity(new Intent(context, LoginActivity.class));
				break;
			}

		}
	};

}
