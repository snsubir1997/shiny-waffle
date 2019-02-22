package com.example.cse226ca1.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cse226ca1.Model.ItemList;
import com.example.cse226ca1.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<ItemList> itemLists;
    public MyAdapter(List<ItemList> itemLists) {
        this.itemLists = itemLists;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        ItemList itemList = itemLists.get(i);
        myViewHolder.textViewName.setText(itemList.getName());
        myViewHolder.imageViewPic.setImageResource(itemList.getImg());
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewPic;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.nameHolder);
            imageViewPic = itemView.findViewById(R.id.profile_image);
        }
    }
}