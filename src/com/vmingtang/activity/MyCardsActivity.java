package com.vmingtang.activity;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.vmingtang.adapter.CardAdapter;
import com.vmingtang.data.entity.Card;

import android.widget.ListView;
import android.widget.TextView;
@EActivity(R.layout.activity_my_cards)
public class MyCardsActivity extends BaseActivity {
	@ViewById
	TextView tvTitle;
	@ViewById
	ListView lvCard;
	
	CardAdapter adapter;

	@AfterViews
	void initView(){
		tvTitle.setText("我的卡包");
		initTestData();
	}
	void initTestData(){
		List<Card> cards = new ArrayList<Card>();
		Card c0 = new Card();
		c0.setShopName("回头客洗车店");
		c0.setType("打折卡");
		c0.setDescription("新老客户打折优惠中");
		Card c1 = new Card();
		c1.setShopName("青山路加油站");
		c1.setType("储值卡");
		c1.setDescription("￥ 1230元");
		cards.add(c0);
		cards.add(c1);
		adapter = new CardAdapter(context, cards);
		lvCard.setAdapter(adapter);
	}

}
