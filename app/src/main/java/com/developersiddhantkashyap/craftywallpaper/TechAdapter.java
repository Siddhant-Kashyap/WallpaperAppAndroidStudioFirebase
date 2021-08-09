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

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.techViewHolder>{
    private Context context;
    private ArrayList<String> mList;

    public TechAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public TechAdapter.techViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tech_image_loader,parent,false);
        return new techViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TechAdapter.techViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.TechImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TechFullImage.class);
                intent.putExtra("tech",mList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class techViewHolder extends RecyclerView.ViewHolder {
        private ImageView TechImageView;
        public techViewHolder(@NonNull View itemView) {
            super(itemView);
            TechImageView= itemView.findViewById(R.id.TechImageLoader);
        }
    }
}
