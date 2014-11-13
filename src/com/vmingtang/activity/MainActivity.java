package com.vmingtang.activity;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.support.v4.app.Fragment;
import android.widget.RadioButton;

import com.vmingtang.adapter.FragmentTabAdapter;
import com.vmingtang.fragment.CarFragment_;
import com.vmingtang.fragment.InformationFragment_;
import com.vmingtang.fragment.MineFragment_;
import com.vmingtang.fragment.ServiceFragment_;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseFragmentActivity {
	@ViewById
	RadioButton rbMain00,rbMain01,rbMain02,rbMain03;
	
	List<Fragment> fragments;
	List<RadioButton> rbList;

	@AfterViews
	void initView() {
		rbList = new ArrayList<RadioButton>();
        rbList.add(rbMain00);
        rbList.add(rbMain01);
        rbList.add(rbMain02);
        rbList.add(rbMain03);
        
        fragments = new ArrayList<Fragment>();
        fragments.add(new ServiceFragment_());
        fragments.add(new CarFragment_());
        fragments.add(new InformationFragment_());
        fragments.add(new MineFragment_());
        new FragmentTabAdapter(this, fragments, rbList, R.id.flMain);
	}

}
