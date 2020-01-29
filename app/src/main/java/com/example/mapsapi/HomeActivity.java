package com.example.mapsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

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

    CarouselPicker carouselPicker;

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

        carouselPicker = (CarouselPicker) findViewById(R.id.carouselPicker);


        List<CarouselPicker.PickerItem> mixItems = new ArrayList<>();
        mixItems.add(new CarouselPicker.TextItem("One", 20));
        mixItems.add(new CarouselPicker.DrawableItem(R.drawable.ronaldo));
        mixItems.add(new CarouselPicker.TextItem("two", 20));
        mixItems.add(new CarouselPicker.DrawableItem(R.drawable.mbappe));
        CarouselPicker.CarouselViewAdapter mixAdapter = new CarouselPicker.CarouselViewAdapter(this, mixItems,0);
        carouselPicker.setAdapter(mixAdapter);



    }
}
