package com.vmingtang.fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.widget.TextView;

import com.vmingtang.activity.R;

/**
 * 服务商界面
 * 
 * @author YaYa
 * 
 */
@EFragment(R.layout.fragment_shop)
public class ShopFragment extends BaseFragment {
	@ViewById
	TextView tvTitle;

	@AfterViews
	void initView() {
		tvTitle.setText("服务商");
	}
}
