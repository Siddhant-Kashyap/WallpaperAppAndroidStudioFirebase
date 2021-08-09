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

public class SpaceAdapter extends RecyclerView.Adapter<SpaceAdapter.spaceViewHolder>{

    private Context context;
    private ArrayList<String> mList;

    public SpaceAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public SpaceAdapter.spaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.space_image_loader,parent,false);
        return new spaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpaceAdapter.spaceViewHolder holder, int position) {


        Glide.with(context).load(mList.get(position)).into(holder.SpaceImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SpaceFullImage.class);
                intent.putExtra("space",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class spaceViewHolder extends RecyclerView.ViewHolder {
        private ImageView SpaceImageView;
        public spaceViewHolder(@NonNull View itemView) {
            super(itemView);
            SpaceImageView = itemView.findViewById(R.id.SpaceImageLoader);

        }
    }
}
