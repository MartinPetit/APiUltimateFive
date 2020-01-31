package com.example.mapsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.mbappe, "brochure", "Brochure est un document qui informe les utilisatuersdzdz zdzdzd zdzd zd "));
        models.add(new Model(R.drawable.ronaldo, "Sticker", "le sticker c'est plutot sympa ca se colle un peu partout genre ou on vetut"));
        models.add(new Model(R.drawable.five, "Poster", "J'ai deja eu des poster dans ma chambre notemment quand j'eais petit"));
        models.add(new Model(R.drawable.easy, "NameCard", "une namecard corrspond a un nom que l'on peut donner à iune carte"));
        models.add(new Model(R.drawable.sticker, "test", "test2"));

        adapter = new Adapter(models, this);
        viewPager = findViewById(R.id.ViewPagerCard);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0, 130, 0);

        Integer[] colors_temp = {getResources().getColor(R.color.color1),
        getResources().getColor(R.color.color2),
        getResources().getColor(R.color.color3),
        getResources().getColor(R.color.color4)};

        colors = colors_temp;


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position]));
                }else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
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
