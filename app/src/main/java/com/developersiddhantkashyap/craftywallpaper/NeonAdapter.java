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

public class NeonAdapter extends RecyclerView.Adapter<NeonAdapter.neonViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public NeonAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public NeonAdapter.neonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.neon_image_loader,parent,false);
        return new neonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NeonAdapter.neonViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position)).into(holder.NeonImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NeonFullImage.class);
                intent.putExtra("neon",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class neonViewHolder extends RecyclerView.ViewHolder {
        ImageView NeonImageView;
        public neonViewHolder(@NonNull View itemView) {
            super(itemView);
            NeonImageView=itemView.findViewById(R.id.NeonimageView);
        }
    }
}
