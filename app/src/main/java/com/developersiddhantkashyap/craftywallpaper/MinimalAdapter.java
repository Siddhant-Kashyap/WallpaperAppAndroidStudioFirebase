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

public class MinimalAdapter extends RecyclerView.Adapter<MinimalAdapter.minimalViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public MinimalAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MinimalAdapter.minimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.minimal_image_loader,parent,false);
        return new minimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MinimalAdapter.minimalViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.MinimalImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MinimalFullImage.class);
                intent.putExtra("minimal",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class minimalViewHolder extends RecyclerView.ViewHolder {

        ImageView MinimalImageView;
        public minimalViewHolder(@NonNull View itemView) {
            super(itemView);
            MinimalImageView=itemView.findViewById(R.id.MinimalimageView);
        }
    }
}
