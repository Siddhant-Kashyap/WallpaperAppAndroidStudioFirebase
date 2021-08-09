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

public class MotivationAdapter extends RecyclerView.Adapter<MotivationAdapter.motivationViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public MotivationAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MotivationAdapter.motivationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.motivation_image_loader,parent,false);
        return new motivationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MotivationAdapter.motivationViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.MotivationImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MotivationFullImage.class);
                intent.putExtra("motivation",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class motivationViewHolder extends RecyclerView.ViewHolder {
        ImageView MotivationImageView;
        public motivationViewHolder(@NonNull View itemView) {
            super(itemView);
            MotivationImageView=itemView.findViewById(R.id.MotivationimageView);
        }
    }
}
