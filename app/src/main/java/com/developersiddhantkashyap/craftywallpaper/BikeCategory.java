package com.developersiddhantkashyap.craftywallpaper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BikeCategory extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private ArrayList<String> mlist;
    private BikeAdapter bikeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_category);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = findViewById(R.id.BikeCategoryView);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("bike");

        getData();

    }

    private void getData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mlist = new ArrayList<String>();

                for (DataSnapshot shot : snapshot.getChildren()) {

                    String data = shot.getValue().toString();
                    mlist.add(data);
                }
                recyclerView.setLayoutManager(new GridLayoutManager(BikeCategory.this, 2));

                bikeAdapter = new BikeAdapter(BikeCategory.this, mlist);

                recyclerView.setAdapter(bikeAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(BikeCategory.this, "Error in fragment" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}