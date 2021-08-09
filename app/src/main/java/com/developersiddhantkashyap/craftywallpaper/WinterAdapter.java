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

public class WinterAdapter extends RecyclerView.Adapter<WinterAdapter.winterViewHolder> {
    private Context context;
    private ArrayList<String> mList;

    public WinterAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public WinterAdapter.winterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.winter_image_loader,parent,false);
        return new winterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WinterAdapter.winterViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.WinterImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,WinterFullImage.class);
                intent.putExtra("winter",mList.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class winterViewHolder extends RecyclerView.ViewHolder {

        private ImageView WinterImageView;
        public winterViewHolder(@NonNull View itemView) {
            super(itemView);
            WinterImageView= itemView.findViewById(R.id.WinterImageLoader);
        }
    }
}
