package com.example.lap3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IteamAdapter extends RecyclerView.Adapter<IteamAdapter.ViewHolder>{

    Context context;
    private List<Item> mItems;

    public IteamAdapter(Context context, List<Item> mItems) {
        this.context = context;
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        Item item = mItems.get(position);
        holder.hinhanh.setImageResource(item.getHinhAnh());
        holder.name.setText(item.getName());
        holder.caption.setText(item.getCaption()+"");

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name,caption;
        ImageView hinhanh;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            caption = itemView.findViewById(R.id.caption);
            hinhanh = itemView.findViewById(R.id.hinhanh);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            Item item=mItems.get(mPosition);
            Intent intent = new Intent(context,MainActivity3.class);
            intent.putExtra("item",item);
            ((Activity) context).overridePendingTransition(R.anim.translate_2, R.anim.translate_1);
            context.startActivity(intent);


        }
    }
}
