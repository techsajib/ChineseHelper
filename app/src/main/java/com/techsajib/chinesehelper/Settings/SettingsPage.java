package com.techsajib.chinesehelper.Settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.techsajib.chinesehelper.BuildConfig;
import com.techsajib.chinesehelper.R;

public class SettingsPage extends AppCompatActivity {

    //admob ad variable
    private AdView bannerAd;

    ListView listView;

    String mTitle[] = {"About Chinese helper", "Tips & Resource", "Rate This App", "Share This App", "About Developer"};
    int mImage[] = {R.drawable.ic_chinese_helper, R.drawable.ic_tips, R.drawable.ic_rating, R.drawable.ic_sharing, R.drawable.ic_appdev};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

        //for banner ad system
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        bannerAd = findViewById(R.id.bannerAd2);
        AdRequest adRequest = new AdRequest.Builder().build();
        bannerAd.loadAd(adRequest);

        // for settings Toolbar settings here
        Toolbar toolbar = findViewById(R.id.settings_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // for settings listView settings here
        listView = findViewById(R.id.settingsListView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mImage);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent(getApplicationContext(), AboutChineseHelper.class);
                    startActivity(intent);

                }else if (position==1){
                    Intent intent = new Intent(getApplicationContext(), TipsResource.class);
                    startActivity(intent);

                }else if (position==2){
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=" + getPackageName())));
                    }catch (ActivityNotFoundException e){
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                    }


                }else if (position==3){
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Download Chinese Helper App");

                    String appLink="http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    intent.putExtra(Intent.EXTRA_TEXT, appLink);
                    startActivity(Intent.createChooser(intent, "Share by"));


                }else if (position==4){
                    Intent intent = new Intent(getApplicationContext(), AboutDeveloper.class);
                    startActivity(intent);

                }
            }
        });

    }

    // for main listview adapter
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String sTitle[];
        int rImage[];

        MyAdapter (Context c, String title[], int imge[]){
            super(c, R.layout.settings_listview_row, R.id.settings_listview_Text, title);
            this.context = c;
            this.sTitle = title;
            this.rImage = imge;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View home_listview = layoutInflater.inflate(R.layout.settings_listview_row, parent, false);

            ImageView images = home_listview.findViewById(R.id.settings_listview_Logo);
            TextView myText = home_listview.findViewById(R.id.settings_listview_Text);

            images.setImageResource(rImage[position]);
            myText.setText(sTitle[position]);

            return home_listview;
        }
    }
}