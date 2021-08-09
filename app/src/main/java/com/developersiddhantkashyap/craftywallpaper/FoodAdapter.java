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

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.foodViewHolder>{

    private Context context;
    private ArrayList<String> mList;

    public FoodAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public FoodAdapter.foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_image_loader,parent,false);
        return new foodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.foodViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position)).into(holder.FoodImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FoodFullImage.class);
                intent.putExtra("food",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class foodViewHolder extends RecyclerView.ViewHolder {
        private ImageView FoodImageView;
        public foodViewHolder(@NonNull View itemView) {
            super(itemView);
            FoodImageView=itemView.findViewById(R.id.FoodimageView);
        }
    }
}
