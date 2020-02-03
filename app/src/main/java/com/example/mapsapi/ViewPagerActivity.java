package com.example.mapsapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private String cuuentUserId;
    private FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        DatabaseReference myRef = database.getReference("Matches");
        cuuentUserId = mAuth.getCurrentUser().getUid();




        myRef.child(cuuentUserId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if (dataSnapshot.exists() && dataSnapshot.hasChild("image"))
                {
                    String date = dataSnapshot.child("date").getValue().toString();
                    String heure = dataSnapshot.child("heure").getValue().toString();
                    String duree=  dataSnapshot.child("duree").getValue().toString();
                    String type =  dataSnapshot.child("type").getValue().toString();
                    String prix =  dataSnapshot.child("prix").getValue().toString();
                    String ville =  dataSnapshot.child("ville").getValue().toString();
                    String description = dataSnapshot.child("description").getValue().toString();
                    String image= dataSnapshot.child("image").getValue().toString();

                    Log.i("tab", "resultat" + date);



                }

                else if (dataSnapshot.exists())
                {
                    String date = dataSnapshot.child("date").getValue().toString();
                    String heure = dataSnapshot.child("heure").getValue().toString();
                    String duree=  dataSnapshot.child("duree").getValue().toString();
                    String type =  dataSnapshot.child("type").getValue().toString();
                    String prix =  dataSnapshot.child("prix").getValue().toString();
                    String ville =  dataSnapshot.child("ville").getValue().toString().toLowerCase();
                    String description = dataSnapshot.child("description").getValue().toString();



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });




        models = new ArrayList<>();
        models.add(new Model(R.drawable.mbappe, "brochure", "Brochure est un document qui informe les utilisatuersdzdz zdzdzd zdzd zd ", "10 €" ));
        models.add(new Model(R.drawable.ronaldo, "Sticker", "le sticker c'est plutot sympa ca se colle un peu partout genre ou on vetut", "8 €" ));
        models.add(new Model(R.drawable.five, "Poster", "J'ai deja eu des poster dans ma chambre notemment quand j'eais petit", "5 €" ));
        models.add(new Model(R.drawable.easy, "NameCard", "une namecard corrspond a un nom que l'on peut donner à iune carte", "7 €" ));
        models.add(new Model(R.drawable.sticker, "test", "test2", "10 €" ));

        adapter = new Adapter(models, this);
        viewPager = findViewById(R.id.ViewPagerCard);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0, 130, 0);



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
