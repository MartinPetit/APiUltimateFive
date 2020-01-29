package com.example.mapsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class HomeActivity extends AppCompatActivity {
    private int[] mImages = new int[] {
        R.drawable.mbappe, R.drawable.chaussures, R.drawable.easy, R.drawable.five, R.drawable.ronaldo
    };

    private String[] mImagesTitle = new String[] {
        "mbappe", "chaussures", "easy", "five", "ronaldo"
    };

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CarouselView carouselView = findViewById(R.id.caroussel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(HomeActivity.this, mImagesTitle[position], Toast.LENGTH_SHORT).show();
            }
        });

        int images[] = {R.drawable.ronaldo, R.drawable.mbappe, R.drawable.five};

        viewFlipper = findViewById(R.id.v_flipper);

        for (int image:images) {
            flipperImages(image);
        }


    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setInAnimation(this, android.R.anim.slide_out_right);
    };
}
