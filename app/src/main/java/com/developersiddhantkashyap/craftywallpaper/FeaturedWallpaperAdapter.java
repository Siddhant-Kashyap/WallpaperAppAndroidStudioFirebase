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

public class FeaturedWallpaperAdapter extends RecyclerView.Adapter<FeaturedWallpaperAdapter.FeaturedWallpaperViewHolder> {


    private ArrayList<String> list;
    private Context mContext;

    public FeaturedWallpaperAdapter(ArrayList<String> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FeaturedWallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.featured_image_loader,parent,false);

        return new FeaturedWallpaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedWallpaperViewHolder holder, int position) {

        Glide.with(mContext).load(list.get(position)).into(holder.mImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,FeaturedFullImage.class);
                intent.putExtra("featured",list.get(position));
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FeaturedWallpaperViewHolder extends RecyclerView.ViewHolder {


        ImageView mImageView;

        public FeaturedWallpaperViewHolder(@NonNull View itemView) {

            super(itemView);

            mImageView=itemView.findViewById(R.id.featuredimgview);


        }
    }


}
