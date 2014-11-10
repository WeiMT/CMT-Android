package com.vmingtang.adapter;

import java.util.ArrayList;
import java.util.List;

import com.vmingtang.activity.BaseFragmentActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class FragmentTabAdapter implements android.widget.CompoundButton.OnCheckedChangeListener {

	private List<Fragment> fragments = new ArrayList<Fragment>();
	private BaseFragmentActivity baseFragmentActivity;
	private int currentIndex;
	private int fragmentContentId; // Activity中所要被替换的区域的id
	private List<RadioButton> rbList;

	public FragmentTabAdapter(BaseFragmentActivity baseFragmentActivity, List<Fragment> fragments, List<RadioButton> rbList, int fragmentContentId) {
		this(baseFragmentActivity, fragments, rbList, fragmentContentId, 0);
	}

	public FragmentTabAdapter(BaseFragmentActivity baseFragmentActivity, List<Fragment> fragments, List<RadioButton> rbList, int fragmentContentId, int currentIndex) {
		this.baseFragmentActivity = baseFragmentActivity;
		this.fragments = fragments;
		this.fragmentContentId = fragmentContentId;
		this.currentIndex = currentIndex;
		this.baseFragmentActivity = baseFragmentActivity;
		this.fragments = fragments;
		this.fragmentContentId = fragmentContentId;
		this.rbList = rbList;

		FragmentTransaction ft = baseFragmentActivity.getSupportFragmentManager().beginTransaction();
		ft.add(fragmentContentId, fragments.get(currentIndex));
		ft.commit();
		for (int i = 0; i < rbList.size(); i++) {
			rbList.get(i).setOnCheckedChangeListener(this);
		}
	}

	private void showTab(int index) {
		for (int i = 0; i < fragments.size(); i++) {
			FragmentTransaction ft = baseFragmentActivity.getSupportFragmentManager().beginTransaction();
			Fragment f = fragments.get(i);
			if (i == index) {
				ft.show(f);
			} else {
				ft.hide(f);
			}
			ft.commit();
		}
		currentIndex = index;
	}

	private Fragment getCurrentFragment() {
		return fragments.get(currentIndex);
	}


	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			for (int i = 0; i < rbList.size(); i++) {
				if(rbList.get(i).getId() == buttonView.getId()){
					Fragment f = fragments.get(i);
					// 暂停当前Fragment
					getCurrentFragment().onPause();
					FragmentTransaction ft = baseFragmentActivity.getSupportFragmentManager().beginTransaction();
					if (fragments.get(i).isAdded()) {
						f.onResume();
					} else {
						ft.add(fragmentContentId, f);
					}
					ft.commit();
					showTab(i);
				}else{
					rbList.get(i).setChecked(false);
				}
			}
		}

	}
}