package com.developersiddhantkashyap.craftywallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class  MainActivity2 extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    FragmentManager fragmentManager;

    TabLayout tabLayout;
    TabItem newArrival,featured,premium;
    ViewPager viewPager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
        tabLayout= (TabLayout)findViewById(R.id.tabCustom);
        newArrival =(TabItem)findViewById(R.id.NewArrival);
        featured=(TabItem)findViewById(R.id.Featured);
        premium =(TabItem)findViewById(R.id.Premium);


        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        viewPager =(ViewPager)findViewById(R.id.viewPagerHolder);


        drawerLayout =(DrawerLayout)findViewById(R.id.MyDrawer);
        navigationView =(NavigationView)findViewById(R.id.cNav);


       ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
       drawerLayout.addDrawerListener(toggle);
       toggle.syncState();


       fragmentManager = new FragmentManager(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
       viewPager.setAdapter(fragmentManager);

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

       viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.subscribe)
                {
                    Toast.makeText(getApplicationContext(),"Subscription coming soon!!",Toast.LENGTH_LONG).show();
                }
                if(item.getItemId()==R.id.Follow)
                {
                    Toast.makeText(getApplicationContext(),"Follow us on Social Media",Toast.LENGTH_SHORT).show();
                }
                if(item.getItemId()==R.id.Support)
                {
                    String[] TO_MAILS = {"7gamespro7@gmail.com"};

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("*/*");
                    intent.putExtra(Intent.EXTRA_EMAIL, TO_MAILS);

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent.createChooser(intent,"Choose APP  To Mail Us"));
                    }
                }
                if(item.getItemId()==R.id.AbstractCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,AbstractCategory.class);
                    startActivity(intent);

                }
                if(item.getItemId()==R.id.AloneCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,AloneCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.AnimalCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,AnimalCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.AnimeCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,AnimeCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.BoysCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,BoysCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.BikeCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,BikeCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.CarCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,CarsCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.CityscapeCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,CityCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.DarkCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,DarkCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.FantasyCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,FantasyCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.FlowerCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,FlowerCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.FoodCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,FoodCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.GirlsCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,GirlsCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.LoveCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,LoveCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.MinimalismCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,MinimalCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.MotivationCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,MotivationCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.NatureCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,NatureCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.NeonCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,NeonCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.SpaceCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,SpaceCategory.class);
                    startActivity(intent);

                }

                if(item.getItemId()==R.id.TechCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,TechCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.VectorCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,VectorCategory.class);
                    startActivity(intent);
                }
                if(item.getItemId()==R.id.WinterCategory)
                {
                    Intent intent= new Intent(MainActivity2.this,WinterCategory.class);
                    startActivity(intent);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return  true;


            }
        });



















    }




}




