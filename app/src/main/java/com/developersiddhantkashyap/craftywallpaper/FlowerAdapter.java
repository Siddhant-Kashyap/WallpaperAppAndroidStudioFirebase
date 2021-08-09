package com.developersiddhantkashyap.craftywallpaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.flowerViewHolder> {
    private Context context;
    private ArrayList<String> mList;

    public FlowerAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public FlowerAdapter.flowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.flower_image_loader,parent,false);
        return new flowerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerAdapter.flowerViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.FlowerImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FlowerFullImage.class);
                intent.putExtra("flower",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size() ;
    }

    public class flowerViewHolder extends RecyclerView.ViewHolder {
        ImageView FlowerImageView;
        public flowerViewHolder(@NonNull View itemView) {
            super(itemView);
            FlowerImageView=itemView.findViewById(R.id.FlowerimageView);
        }
    }
}
