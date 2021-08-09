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

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public CarsAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cars_image_loader,parent,false);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {


        Glide.with(context).load(mList.get(position)).into(holder.mImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CarsFullImage.class);
                intent.putExtra("cars",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CarsViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.carsimgview);
        }
    }
}
