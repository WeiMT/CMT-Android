package com.vmingtang.adapter;

import java.util.List;

import com.vmingtang.activity.R;
import com.vmingtang.data.entity.Information;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationAdapter extends BaseAdapter{
	private List<Information> informations;
	private LayoutInflater inflater;
	public InformationAdapter(Context context,List<Information> informations){
		this.informations = informations;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return informations.size();
	}

	@Override
	public Information getItem(int position) {
		return informations.get(position);
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
			convertView = inflater.inflate(R.layout.item_information, null);
			holder.ivInformation = (ImageView)convertView.findViewById(R.id.ivInformation);
			holder.tvInformationTitle = (TextView)convertView.findViewById(R.id.tvInformationTitle);
			holder.tvInformationDate = (TextView)convertView.findViewById(R.id.tvInformationDate);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder)convertView.getTag();
		}
		Information im = getItem(position);
		holder.ivInformation.setBackgroundResource(R.drawable.test1);
		holder.tvInformationTitle.setText(im.getTitle());
		holder.tvInformationDate.setText(im.getDate());
		return convertView;
	}
	class ViewHolder{
		ImageView ivInformation;
		TextView tvInformationTitle,tvInformationDate;
	}

}
