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

public class AbstractAdapter extends RecyclerView.Adapter<AbstractAdapter.abstractViewHolder> {


    private Context context;
    private ArrayList<String> mList;

    public AbstractAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AbstractAdapter.abstractViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.abstract_image_loader,parent,false);
        return new abstractViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AbstractAdapter.abstractViewHolder holder, int position) {
        Glide.with(context).load(mList.get(position)).into(holder.AbstractImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FullImageActivity.class);
                intent.putExtra("abstract",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class abstractViewHolder extends RecyclerView.ViewHolder {
        private ImageView AbstractImageView;

        public abstractViewHolder(@NonNull View itemView) {


            super(itemView);
            AbstractImageView = itemView.findViewById(R.id.abstractimageView);
        }
    }
}
