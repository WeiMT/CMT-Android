package com.vmingtang.fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import com.vmingtang.activity.R;

import android.widget.TextView;
@EFragment(R.layout.fragment_mine)
public class MineFragment  extends BaseFragment {
	@ViewById
	TextView tvTitle;

	@AfterViews
	void initView() {
		tvTitle.setText("我");
	}
}

