package com.developersiddhantkashyap.craftywallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.IOException;

public class FoodFullImage extends AppCompatActivity {
    private ImageView mImageView;
    private Button SetButton;

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_full_image);
        mImageView =  findViewById(R.id.Foodfullimage);
        SetButton = findViewById(R.id.FoodSet);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        //BANNER AD START
        mAdView = findViewById(R.id.FoodadView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //BANNER AD END
        //Interstitial AD START
        InterstitialAd.load(this,"ca-app-pub-4864570840476809/6299483142", adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
                Log.i("kk", "onAdLoaded");
                ShowAd();

            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                Log.i("KK", loadAdError.getMessage());
                mInterstitialAd = null;

            }
        });





        Glide.with(this).load(getIntent().getStringExtra("food")).into(mImageView);
        SetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetBackground();


            }
        });
    }


    public void ShowAd()
    {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(FoodFullImage.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }

    private void SetBackground() {

        Bitmap bitmap =((BitmapDrawable)mImageView.getDrawable()).getBitmap();
        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
        try {
            manager.setBitmap(bitmap);
            Toast.makeText(this,"Wallpaper Set",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this,"Error : "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}