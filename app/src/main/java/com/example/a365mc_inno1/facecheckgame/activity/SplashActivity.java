package com.example.a365mc_inno1.facecheckgame.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.a365mc_inno1.facecheckgame.R;

public class SplashActivity extends AppCompatActivity {

    ImageView imgSplash;
    FrameLayout frameGetStart,layoutSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
        initSplash();
        initMove();
    }

    private void initView() {
        imgSplash = findViewById(R.id.img_splash);
        frameGetStart = findViewById(R.id.get_started);
        layoutSplash = findViewById(R.id.layout_spalsh);
    }

    private void initSplash() {
        Glide.with(this).load(R.raw.splash).apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE)).into(imgSplash);
    }

    private void initMove() {
        frameGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
