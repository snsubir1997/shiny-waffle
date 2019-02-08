package com.subir.roshansirtestapp1.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.subir.roshansirtestapp1.MainActivity;
import com.subir.roshansirtestapp1.Model.ItemList;
import com.subir.roshansirtestapp1.NextActivity;
import com.subir.roshansirtestapp1.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ItemList> itemLists;
    public MyAdapter(Context context, ArrayList<ItemList> itemLists) {
        this.context = context;
        this.itemLists = itemLists;
    }

    @Override
    public int getCount() {
        return itemLists.size();
    }

    @Override
    public Object getItem(int position) {
        return itemLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.nameTextView = convertView.findViewById(R.id.nameTextView);
            holder.regIdTextView = convertView.findViewById(R.id.regNoTextView);
            holder.personImageView = convertView.findViewById(R.id.profileImageView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        ItemList itemList = (ItemList) getItem(position);

        holder.nameTextView.setText(itemList.getName());
        holder.regIdTextView.setText(itemList.getRegId());
        holder.personImageView.setImageResource(itemList.getImageRes());

        return convertView;

    }

    static class ViewHolder {
        private TextView nameTextView;
        private TextView regIdTextView;
        private ImageView personImageView;
    }
}
