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

public class BoysAdapter extends RecyclerView.Adapter<BoysAdapter.BoysViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public BoysAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public BoysAdapter.BoysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.boys_image_loader,parent,false);
       return new BoysViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoysAdapter.BoysViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.mImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BoysFullImge.class);
                intent.putExtra("boys",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class BoysViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        public BoysViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.boysimgview);
        }
    }
}
