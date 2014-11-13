package com.vmingtang.fragment;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.vmingtang.activity.R;
import com.vmingtang.adapter.PageAdapter;

/**
 * 服务商界面
 * 
 * @author YaYa
 * 
 */
@EFragment(R.layout.fragment_service)
public class ServiceFragment extends BaseFragment {
	@ViewById
	TextView tvTitle,tv00,tv01,tv02,tv03,tv04,tv05,tv06,tv07,tv08,tv09,tv10,tv11;
	@ViewById
	ViewPager vpService;
	@ViewById
	LinearLayout llPoint;

	private ArrayList<View> pageViews;
	private ImageView ivPoint;
	private ImageView[] ivPoints;
	List<ImageView> list;
	int width;

	@AfterViews
	void initView() {
		tvTitle.setText("车名堂");
		pageViews = new ArrayList<View>();
		addTestImage();
		addServiceView();

	}

	void addServiceView() {
		width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
		tv00.setHeight(width/3);
		tv01.setHeight(width/3);
		tv02.setHeight(width/3);
		tv03.setHeight(width/3);
		tv04.setHeight(width/3);
		tv05.setHeight(width/3);
		tv06.setHeight(width/3);
		tv07.setHeight(width/3);
		tv08.setHeight(width/3);
		tv09.setHeight(width/3);
		tv10.setHeight(width/3);
		tv11.setHeight(width/3);
	}

	OnPageChangeListener pageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int arg0) {
			for (int i = 0; i < ivPoints.length; i++) {
				if (arg0 == i) {
					ivPoints[arg0].setBackgroundResource(R.drawable.small_green_round);
				} else {
					ivPoints[i].setBackgroundResource(R.drawable.small_white_round);
				}
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	void addTestImage() {
		list = new ArrayList<ImageView>();
		ImageView iv00 = new ImageView(context);
		iv00.setBackgroundResource(R.drawable.test1);
		ImageView iv01 = new ImageView(context);
		iv01.setBackgroundResource(R.drawable.test2);
		ImageView iv02 = new ImageView(context);
		iv02.setBackgroundResource(R.drawable.test3);
		list.add(iv00);
		list.add(iv01);
		list.add(iv02);
		pageViews.addAll(list);

		ivPoints = new ImageView[pageViews.size()];
		for (int i = 0; i < pageViews.size(); i++) {
			ivPoint = new ImageView(context);
			LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			params.leftMargin = 10;
			params.rightMargin = 10;
			ivPoint.setLayoutParams(params);
			ivPoints[i] = ivPoint;

			if (i == 0) {
				// 默认选中第一张图片
				ivPoints[i].setBackgroundResource(R.drawable.small_green_round);
			} else {
				ivPoints[i].setBackgroundResource(R.drawable.small_white_round);
			}

			llPoint.addView(ivPoints[i]);
			vpService.setAdapter(new PageAdapter(pageViews));
			vpService.setOnPageChangeListener(pageChangeListener);
		}
	}
}
