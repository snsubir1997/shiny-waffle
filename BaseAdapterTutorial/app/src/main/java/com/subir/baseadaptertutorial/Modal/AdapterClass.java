package com.subir.baseadaptertutorial.Modal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.subir.baseadaptertutorial.R;

import java.util.ArrayList;

public class AdapterClass extends BaseAdapter {

    private Context context;
    private ArrayList<ItemList> item;

    public AdapterClass(Context context, ArrayList<ItemList> itemList)
    {
        this.context = context;
        this.item = itemList;
    }

    @Override
    public int getCount() {
        return item.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return item.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        }

        // get current item to be displayed
        ItemList currentItem = (ItemList) getItem(position);

        // get the TextView for item name and item description
        TextView textViewName = convertView.findViewById(R.id.nameHolder);
        TextView textViewRoll = convertView.findViewById(R.id.rollNoPlaceholder);
        TextView textViewGpa = convertView.findViewById(R.id.gpaPlaceholder);

        //sets the text for item name and item description from the current item object
        textViewName.setText(currentItem.getName());
        textViewRoll.setText(currentItem.getRno());
        textViewGpa.setText(currentItem.getGpa());


        // returns the view for the current row
        return convertView;
    }
}
