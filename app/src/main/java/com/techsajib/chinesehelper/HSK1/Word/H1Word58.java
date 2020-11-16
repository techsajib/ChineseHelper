package com.techsajib.chinesehelper.HSK1.Word;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.techsajib.chinesehelper.Firebase.FirebasePost;
import com.techsajib.chinesehelper.HomePage;
import com.techsajib.chinesehelper.R;

public class H1Word58 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.h1_word58);

        //for button section
        Button back = findViewById(R.id.w58_button1);
        Button next = findViewById(R.id.w58_button2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), H1Word57.class);
                startActivity(intent);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), H1Word59.class);
                startActivity(intent);
            }
        });

        // for HSK1 Toolbar settings here
        Toolbar toolbar = findViewById(R.id.hsk1_word58);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    //for menu settings here
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.notificationDetails:
                Intent intent1 = new Intent(getApplicationContext(), FirebasePost.class);
                startActivity(intent1);
                return true;
            case R.id.homeDetails:
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}