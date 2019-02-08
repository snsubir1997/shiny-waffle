package com.subir.timestampedgridofimages.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;


import com.subir.timestampedgridofimages.Model.MyGrid;
import com.subir.timestampedgridofimages.R;

import java.util.ArrayList;


public class MyAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<MyGrid> mGrid;
    private Context mContext;

    public MyAdapter(Context ct, ArrayList<MyGrid> mGrid) {
        this.mGrid = mGrid;
        this.mContext = ct;
    }

    public int getCount() {
        return mGrid.size();
    }

    public Object getItem(int position) {
        return mGrid.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.my_grid_layout, parent, false);
        }


        TextView textViewAndroid = convertView.findViewById(R.id.gridTimestamp);
        ImageView imageViewAndroid = convertView.findViewById(R.id.gridImg);

        MyGrid myGrid= (MyGrid)getItem(position);

        textViewAndroid.setText(myGrid.getName());
        imageViewAndroid.setImageBitmap(myGrid.getImage());

        return convertView;
    }
}