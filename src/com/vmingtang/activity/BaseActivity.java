package com.vmingtang.activity;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class BaseActivity extends Activity {
	protected String TAG = getClass().getName();
	protected ActivityApp_ app;
	protected Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (app == null) {
			app = (ActivityApp_) getApplication();
		}
		app.addActivity(this);
		context = this;
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		app.removeActivity(this);
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
	}
	protected void finishAllActivity() {
		app.finishAll();
	}
	public void showToastLong(String... values) {
		if (values == null || values.length == 0) {
			Toast.makeText(context, "网络不给力啊", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(context, values[0], Toast.LENGTH_LONG).show();
		}
	}

	public void showToastShort(String... values) {
		if (values == null || values.length == 0) {
			Toast.makeText(context, "网络不给力啊", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(context, values[0], Toast.LENGTH_SHORT).show();
		}
	}
}
