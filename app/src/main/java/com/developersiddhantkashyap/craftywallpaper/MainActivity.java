package com.developersiddhantkashyap.craftywallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        ImageView imageView = findViewById(R.id.loadone);
        ImageView imageView1=findViewById(R.id.loadtwo);
        ImageView imageView2 = findViewById(R.id.loadthree);
        ImageView Logo =findViewById(R.id.Logo);

        imageView.animate().rotation(90).setDuration(2000);
        imageView1.animate().translationY(100).setDuration(3000);
        imageView2.animate().translationY(30).setDuration(2500);

        Logo.animate().alpha(1).setDuration(1500);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

                finish();
            }
        },3000);




    }


}