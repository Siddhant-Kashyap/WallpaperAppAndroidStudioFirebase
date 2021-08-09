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

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    private Context context;
    private ArrayList<String> mList;

    public AnimeAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AnimeAdapter.AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.anime_image_loader,parent,false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeAdapter.AnimeViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position)).into(holder.AnimeImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AnimeFullImage.class);
                intent.putExtra("anime",mList.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class AnimeViewHolder extends RecyclerView.ViewHolder {

        private ImageView AnimeImageView;
        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            AnimeImageView = itemView.findViewById(R.id.animeimageView);
        }
    }
}
