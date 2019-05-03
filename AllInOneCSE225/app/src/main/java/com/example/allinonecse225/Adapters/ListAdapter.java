package com.example.allinonecse225.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.allinonecse225.Modals.ItemList;
import com.example.allinonecse225.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<ItemList> arrayList;

    public ListAdapter(Context context, ArrayList<ItemList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
        }

        ItemList currentItem = (ItemList) getItem(position);

        TextView tv1 = convertView.findViewById(R.id.nameTextView);
        TextView tv2 = convertView.findViewById(R.id.rollTextView);

        tv1.setText(currentItem.getName());
        tv2.setText(currentItem.getRollNo());


        return convertView;
    }
}
