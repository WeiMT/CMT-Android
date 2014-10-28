package com.vmingtang.activity;



import com.vmingtang.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	EditText etMobile;
	Button btnNext;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		etMobile = (EditText)findViewById(R.id.etMobile);
		btnNext = (Button)findViewById(R.id.btnNext);
		btnNext.setOnClickListener(clickListener);
	}
	OnClickListener clickListener = new OnClickListener() {
		
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnNext:
				String mobile = etMobile.getText().toString();
				if(mobile.length()<11){
					Toast.makeText(LoginActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
				}else{
					
				}
				break;

			}
			
		}
	};
}
