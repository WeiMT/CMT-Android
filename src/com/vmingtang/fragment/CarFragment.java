package com.vmingtang.fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import com.vmingtang.activity.R;

import android.widget.TextView;
@EFragment(R.layout.fragment_car)
public class CarFragment extends BaseFragment {
	@ViewById
	TextView tvTitle;

	@AfterViews
	void initView() {
		tvTitle.setText("车");
	}
}

