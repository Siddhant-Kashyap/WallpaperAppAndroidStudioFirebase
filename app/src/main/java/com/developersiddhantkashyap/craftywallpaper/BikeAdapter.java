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

public class BikeAdapter extends RecyclerView.Adapter<BikeAdapter.BikeViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public BikeAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public BikeAdapter.BikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bike_image_loader,parent,false);
        return new BikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BikeAdapter.BikeViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.BikeImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BikeFullImage.class);
                intent.putExtra("bike",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class BikeViewHolder extends RecyclerView.ViewHolder {
        private ImageView BikeImageView;
        public BikeViewHolder(@NonNull View itemView) {
            super(itemView);
            BikeImageView = itemView.findViewById(R.id.BikeimageView);
        }
    }
}
