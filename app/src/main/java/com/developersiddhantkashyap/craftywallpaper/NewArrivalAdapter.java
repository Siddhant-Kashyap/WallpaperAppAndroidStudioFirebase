package com.developersiddhantkashyap.craftywallpaper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NewArrivalAdapter  extends RecyclerView.Adapter<NewArrivalAdapter.newArrivalViewHolder> {

    private Context context;
   private ArrayList<String> mList;

    public NewArrivalAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public NewArrivalAdapter.newArrivalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.image_loader,parent,false);

        return new newArrivalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewArrivalAdapter.newArrivalViewHolder holder, int position) {

        Glide.with(context).load(mList.get(position)).into(holder.imgView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NewArrivalFullImage.class);
                intent.putExtra("newarrival",mList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public class newArrivalViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgView;

        public newArrivalViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView =itemView.findViewById(R.id.imgView);

        }
    }
}
