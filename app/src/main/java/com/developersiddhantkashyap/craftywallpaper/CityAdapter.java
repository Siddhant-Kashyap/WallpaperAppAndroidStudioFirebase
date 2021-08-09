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

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.cityViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public CityAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public cityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.city_image_loader,parent,false);
        return new cityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cityViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position)).into(holder.cityimageview);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CityFullImage.class);
                intent.putExtra("city",mList.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class cityViewHolder extends RecyclerView.ViewHolder {

        private ImageView cityimageview;
        public cityViewHolder(@NonNull View itemView) {
            super(itemView);
           cityimageview = itemView.findViewById(R.id.CityimageView);
        }
    }
}
