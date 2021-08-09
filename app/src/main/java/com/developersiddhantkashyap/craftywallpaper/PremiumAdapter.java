package com.developersiddhantkashyap.craftywallpaper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class PremiumAdapter extends RecyclerView.Adapter<PremiumAdapter.premiumViewHolder> {

    private Context context;
    private ArrayList<String> mList;

    public PremiumAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public PremiumAdapter.premiumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.premium_image_loader,parent,false);
        return new premiumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PremiumAdapter.premiumViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.pImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*   Intent intent = new Intent(context,PremiumFullImage.class);
                intent.putExtra("premium",mList.get(position));
                context.startActivity(intent);*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class premiumViewHolder extends RecyclerView.ViewHolder {


        private ImageView pImageView;

        public premiumViewHolder(@NonNull View itemView) {


            super(itemView);

            pImageView = itemView.findViewById(R.id.premiumImageLoader);

        }
    }
}
