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

public class FantasyAdapter extends RecyclerView.Adapter<FantasyAdapter.fantasyViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public FantasyAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public FantasyAdapter.fantasyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fantasy_image_loader,parent,false);

        return new fantasyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FantasyAdapter.fantasyViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position)).into(holder.FantasyImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FantasyFullImage.class);
                intent.putExtra("fantasy",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class fantasyViewHolder extends RecyclerView.ViewHolder {
        ImageView FantasyImageView;

        public fantasyViewHolder(@NonNull View itemView) {
            super(itemView);
            FantasyImageView=itemView.findViewById(R.id.Fantasyimgview);
        }
    }
}
