package com.techsajib.chinesehelper.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.techsajib.chinesehelper.HomePage;
import com.techsajib.chinesehelper.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN =  2000;

    //Variables
    ImageView splashScreenImage;
    TextView splashScreenTitle;
    Animation topAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //ID initialization
        splashScreenImage = findViewById(R.id.splashScreenImage);
        splashScreenTitle = findViewById(R.id.splashScreenTitle);

        //for Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        splashScreenImage.setAnimation(topAnim);
        splashScreenTitle.setAnimation(bottomAnim);

        //for Splash screen Timing
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}