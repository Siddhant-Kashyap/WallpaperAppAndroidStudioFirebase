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

public class VectorAdapter extends RecyclerView.Adapter<VectorAdapter.vectorViewHolder>{

    private Context context;
    private ArrayList<String> mList;

    public VectorAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public VectorAdapter.vectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vector_image_loader,parent,false);
        return new vectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VectorAdapter.vectorViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.VectorImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,VectorFullImage.class);
                intent.putExtra("vector",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class vectorViewHolder extends RecyclerView.ViewHolder {
        private ImageView VectorImageView;
        public vectorViewHolder(@NonNull View itemView) {
            super(itemView);
            VectorImageView = itemView.findViewById(R.id.VectorImageLoader);
        }
    }
}
