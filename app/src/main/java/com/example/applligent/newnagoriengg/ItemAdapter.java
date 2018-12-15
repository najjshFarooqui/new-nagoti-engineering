package com.example.applligent.newnagoriengg;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    List<Item> items;

    public ItemAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.activity_part_list, viewGroup, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        itemHolder.bindTo(items.get(i));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected class ItemHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView companyName;

        public ItemHolder(@NonNull final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            companyName = itemView.findViewById(R.id.companyName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Item item = items.get(getAdapterPosition());
                    Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        protected void bindTo(Item items) {
            companyName.setText(items.companyName);
        }
    }
}

