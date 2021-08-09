package com.developersiddhantkashyap.craftywallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class PremiumFullImage extends AppCompatActivity {

    ImageView mImageView;
    private Button SetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_full_image);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mImageView =  findViewById(R.id.premiumFullimage);


        Glide.with(this).load(getIntent().getStringExtra("premium")).into(mImageView);
       /* SetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // SetBackground();

                Toast.makeText(getApplicationContext(),"Please Subscribe For This Section ",Toast.LENGTH_LONG).show();

            }
        });*/


    }
    /*private void SetBackground() {

        Bitmap bitmap =((BitmapDrawable)mImageView.getDrawable()).getBitmap();
        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
        try {
            manager.setBitmap(bitmap);
            Toast.makeText(this,"Wallpaper Set",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this,"Error : "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }*/
}