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

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>{

    private Context context;
    private ArrayList<String> mList;

    public AnimalAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }


    @NonNull
    @Override
    public AnimalAdapter.AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_image_loader,parent,false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.AnimalViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.AnimalImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AnimalFullImage.class);
                intent.putExtra("animal",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder {

        private ImageView AnimalImageView;
        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            AnimalImageView = itemView.findViewById(R.id.animalImageView);

        }
    }
}
