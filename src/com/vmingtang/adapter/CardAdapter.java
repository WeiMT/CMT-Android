package com.vmingtang.adapter;

import java.util.List;

import com.vmingtang.activity.R;
import com.vmingtang.adapter.InformationAdapter.ViewHolder;
import com.vmingtang.data.entity.Card;
import com.vmingtang.data.entity.Information;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CardAdapter extends BaseAdapter {
	private List<Card> cards;
	private LayoutInflater inflater;

	public CardAdapter(Context context, List<Card> cards) {
		this.cards = cards;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return cards.size();
	}

	@Override
	public Card getItem(int position) {
		return cards.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_card, null);
			holder.ivCard = (ImageView)convertView.findViewById(R.id.ivCard);
			holder.tvShopName = (TextView)convertView.findViewById(R.id.tvShopName);
			holder.tvCardType = (TextView)convertView.findViewById(R.id.tvCardType);
			holder.tvCardDescription = (TextView)convertView.findViewById(R.id.tvCardDescription);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		Card card = getItem(position);
		holder.ivCard.setBackgroundResource(R.drawable.test2);
		holder.tvShopName.setText(card.getShopName());
		holder.tvCardType.setText(card.getType());
		holder.tvCardDescription.setText(card.getDescription());
		return convertView;
	}
	class ViewHolder{
		ImageView ivCard;
		TextView tvShopName,tvCardType,tvCardDescription;
	}

}
