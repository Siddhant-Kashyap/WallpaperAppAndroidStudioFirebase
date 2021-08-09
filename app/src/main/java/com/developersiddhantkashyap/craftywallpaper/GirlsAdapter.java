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

public class GirlsAdapter extends RecyclerView.Adapter<GirlsAdapter.girlsViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public GirlsAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public GirlsAdapter.girlsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.girls_image_loader,parent,false);

        return new girlsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GirlsAdapter.girlsViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.mImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,GirlsFullImage.class);
                intent.putExtra("girls",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class girlsViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        public girlsViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.GirlsimageView);
        }
    }
}
