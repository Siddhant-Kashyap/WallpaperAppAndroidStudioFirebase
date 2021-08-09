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

public class LoveAdapter extends RecyclerView.Adapter<LoveAdapter.loveViewHolder>{


    private Context context;
    private ArrayList<String> mList;

    public LoveAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public LoveAdapter.loveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.love_image_loader,parent,false);
        return new loveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoveAdapter.loveViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.LoveImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,LoveFullImage.class);
                intent.putExtra("love",mList.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class loveViewHolder extends RecyclerView.ViewHolder {
        private ImageView LoveImageView;
        public loveViewHolder(@NonNull View itemView) {
            super(itemView);

            LoveImageView = itemView.findViewById(R.id.LoveimageView);
        }
    }
}
