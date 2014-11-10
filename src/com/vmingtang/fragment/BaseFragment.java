package com.vmingtang.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.vmingtang.activity.ActivityApp_;

public abstract class BaseFragment extends Fragment {
	protected Context context;
	protected ActivityApp_ app;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = getActivity();
		if (app == null) {
			app = (ActivityApp_) context.getApplicationContext();
		}
	}
	public void showToastLong(String... values) {
		if (values == null || values.length == 0) {
			Toast.makeText(context, "网络不给力!", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(context, values[0], Toast.LENGTH_LONG).show();
		}
	}

	public void showToastShort(String... values) {
		if (values == null || values.length == 0) {
			Toast.makeText(context, "网络不给力!", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(context, values[0], Toast.LENGTH_SHORT).show();
		}
	}
	protected void finishAllActivity() {
		app.finishAll();
	}
}