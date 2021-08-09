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

public class NatureAdapter extends RecyclerView.Adapter<NatureAdapter.natureViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public NatureAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public NatureAdapter.natureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nature_image_loader,parent,false);
        return new natureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NatureAdapter.natureViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.NatureImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NatureFullImage.class);
                intent.putExtra("nature",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class natureViewHolder extends RecyclerView.ViewHolder {
        private ImageView NatureImageView;

        public natureViewHolder(@NonNull View itemView) {
            super(itemView);
            NatureImageView = itemView.findViewById(R.id.NatureimageView);
        }
    }
}
