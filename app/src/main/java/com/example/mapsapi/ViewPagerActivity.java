package com.example.mapsapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ViewPagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    Adapter2 adapter2;
    List<Matche> models;
    List<User> model;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private DatabaseReference MatcheRef;
    private DatabaseReference UserRef;
    private StorageReference matchePhoto;
    private StorageReference UserPhoto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);


        MatcheRef = FirebaseDatabase.getInstance().getReference().child("Matches");
        UserRef = FirebaseDatabase.getInstance().getReference().child("Users");
        matchePhoto = FirebaseStorage.getInstance().getReference().child("matche image");
        UserPhoto = FirebaseStorage.getInstance().getReference().child("profile image");


        FirebaseRecyclerOptions<Matche> options = new FirebaseRecyclerOptions.Builder<Matche>()
                .setQuery(MatcheRef, Matche.class)
                .build();

        FirebaseRecyclerOptions<User> options2 = new FirebaseRecyclerOptions.Builder<User>()
                .setQuery(UserRef, User.class)
                .build();


        model = new ArrayList<>();
        adapter2 = new Adapter2(model, this);
        viewPager = findViewById(R.id.ViewPagerCard2);
        viewPager.setAdapter(adapter2);
        viewPager.setPadding(65, 0, 65, 50);

        models = new ArrayList<>();
        adapter = new Adapter(models, this);
        viewPager = findViewById(R.id.ViewPagerCard);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(65, 150, 65, 0);

        MatcheRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                models.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Matche matche = ds.getValue(Matche.class);
                    models.add(matche);
                    adapter.notifyDataSetChanged();


                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("FireBase", "Failed to read value.", error.toException());
            }
        });

        UserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                model.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    User user = ds.getValue(User.class);
                    model.add(user);
                    adapter2.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("FireBase", "Failed to read value.", databaseError.toException());
            }
        });



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }


            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
