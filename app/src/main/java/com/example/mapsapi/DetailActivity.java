package com.example.mapsapi;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView = findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("param"));

        ImageView imageView = findViewById(R.id.ImageMatch);
        imageView.setImageResource(getIntent().getIntExtra("image", 0));

        TextView testView = findViewById(R.id.DescriptionMatch);
        testView.setText(getIntent().getStringExtra("description"));



    }
}
