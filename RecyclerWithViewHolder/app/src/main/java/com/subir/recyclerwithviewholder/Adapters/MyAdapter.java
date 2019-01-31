package com.subir.recyclerwithviewholder.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.subir.recyclerwithviewholder.Models.ItemList;
import com.subir.recyclerwithviewholder.R;

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
        myViewHolder.textViewRoll.setText(itemList.getRno());
        myViewHolder.textViewGpa.setText(itemList.getGpa());
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewRoll, textViewGpa;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.nameHolder);
            textViewRoll = itemView.findViewById(R.id.rollNoPlaceholder);
            textViewGpa = itemView.findViewById(R.id.gpaPlaceholder);
        }
    }

    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context)
        {
            this.context = context;
        }
        @Override
        public void onClick(View v) {
            removeItem(v);
        }

        private void removeItem(View v) {
            int pos = ;
        }
    }
}
