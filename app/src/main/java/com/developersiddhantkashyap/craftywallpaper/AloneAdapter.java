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

public class AloneAdapter extends RecyclerView.Adapter<AloneAdapter.aloneViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public AloneAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public aloneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.alone_image_loader,parent,false);
        return new AloneAdapter.aloneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull aloneViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.AloneImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AloneFullImage.class);
                intent.putExtra("alone",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class aloneViewHolder extends RecyclerView.ViewHolder {

        ImageView AloneImageView;
        public aloneViewHolder(@NonNull View itemView) {
            super(itemView);
            AloneImageView=itemView.findViewById(R.id.aloneimageView);

        }
    }
}
