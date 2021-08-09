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

public class VectorCategory extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private ArrayList<String> mlist;
    private VectorAdapter mVectorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_category);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = findViewById(R.id.VectorCategoryView);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("vector");

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
                recyclerView.setLayoutManager(new GridLayoutManager(VectorCategory.this, 2));

                mVectorAdapter= new VectorAdapter(VectorCategory.this, mlist);

                recyclerView.setAdapter(mVectorAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(VectorCategory.this, "Error in fragment" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}