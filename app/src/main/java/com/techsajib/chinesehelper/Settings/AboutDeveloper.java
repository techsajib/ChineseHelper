package com.techsajib.chinesehelper.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.techsajib.chinesehelper.R;

public class AboutDeveloper extends AppCompatActivity {

    ImageView youtube, facebook, instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_developer);

        //ID initialization
        youtube = findViewById(R.id.youtubeID);
        facebook = findViewById(R.id.facebookID);
        instagram = findViewById(R.id.instagramID);

        // for settings Toolbar settings here
        Toolbar toolbar = findViewById(R.id.about_developer_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String youtubeURL = "https://www.youtube.com/papelbd";
                Intent youtubeIntent=null;
                try {
                    youtubeIntent=new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setPackage("com.google.android.youtube");
                    youtubeIntent.setData(Uri.parse(youtubeURL ));
                    startActivity(youtubeIntent);
                } catch (ActivityNotFoundException e) {
                    youtubeIntent= new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setData(Uri.parse(youtubeURL ));
                    startActivity(youtubeIntent);
                }
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebookId = "fb://page/327031464582675";
                String urlPage = "http://www.facebook.com/MDSaziburRahmanBD";

                try {
                   startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId )));
                }catch (Exception e){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlPage )));
                }
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/techsajib"));
                startActivity(intent);
            }
        });

    }
}