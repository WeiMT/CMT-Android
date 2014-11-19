package com.vmingtang.fragment;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import com.vmingtang.activity.R;
import com.vmingtang.adapter.InformationAdapter;
import com.vmingtang.data.entity.Information;

import android.widget.ListView;
import android.widget.TextView;

@EFragment(R.layout.fragment_information)
public class InformationFragment extends BaseFragment {
	@ViewById
	TextView tvTitle;
	@ViewById
	ListView lvInformation;
	
	InformationAdapter adapter;

	@AfterViews
	void initView() {
		tvTitle.setText("资讯");
		initTestDaTa();
	}
	void initTestDaTa(){
		List<Information> list = new ArrayList<Information>();
		Information im00 = new Information();
		im00.setTitle("好恰价洗车店");
		im00.setDate("2014-09-09 12:12:12");
		Information im01 = new Information();
		im01.setTitle("露露汽车维修");
		im01.setDate("2014-09-08 11:22:32");
		list.add(im00);
		list.add(im01);
		adapter = new InformationAdapter(context, list);
		lvInformation.setAdapter(adapter);
	}
}
