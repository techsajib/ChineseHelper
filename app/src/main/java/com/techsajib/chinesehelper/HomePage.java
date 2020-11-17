package com.techsajib.chinesehelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.techsajib.chinesehelper.Firebase.FirebasePost;
import com.techsajib.chinesehelper.HSK1.HSK1ListView;
import com.techsajib.chinesehelper.HSK2.HSK2ListView;
import com.techsajib.chinesehelper.HSK3.HSK3ListView;
import com.techsajib.chinesehelper.HSK4.HSK4Listview;
import com.techsajib.chinesehelper.Practical.Accomodation.Accomodation;
import com.techsajib.chinesehelper.Practical.Animals.Animals;
import com.techsajib.chinesehelper.Practical.Colors.Colors;
import com.techsajib.chinesehelper.Practical.Common.Common;
import com.techsajib.chinesehelper.Practical.Countries.Countries;
import com.techsajib.chinesehelper.Practical.Direction.Direction;
import com.techsajib.chinesehelper.Practical.Emergency.Emergency;
import com.techsajib.chinesehelper.Practical.Family.Family;
import com.techsajib.chinesehelper.Practical.Food.Food;
import com.techsajib.chinesehelper.Practical.Fruits.Fruits;
import com.techsajib.chinesehelper.Practical.Greetings.Greetings;
import com.techsajib.chinesehelper.Practical.Health.Health;
import com.techsajib.chinesehelper.Practical.Nationality.Nationality;
import com.techsajib.chinesehelper.Practical.Numbers.Numbers;
import com.techsajib.chinesehelper.Practical.Profession.Profession;
import com.techsajib.chinesehelper.Practical.Sports.Sports;
import com.techsajib.chinesehelper.Practical.Studies.Studies;
import com.techsajib.chinesehelper.Practical.TimeDate.TimeDate;
import com.techsajib.chinesehelper.Practical.Transportation.Transportation;
import com.techsajib.chinesehelper.Practical.Weather.Weather;
import com.techsajib.chinesehelper.Settings.SettingsPage;

public class HomePage extends AppCompatActivity {

    //admob ad variable
    private AdView bannerAd;

    ListView listView;
    CardView greetings, common, numbers, timedate, nationality, countries, profession, emergency, transportation, direction,
            family, health, accommodation, food, fruits, studies, animals, sports, colors, weather;

    String mTitle[] = {"HSK 1 Vocabulary", "HSK 2 Vocabulary", "HSK 3 Vocabulary", "HSK 4 Vocabulary"};
    int mImage[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};
    int mIcon[] = {R.drawable.bracket, R.drawable.bracket, R.drawable.bracket, R.drawable.bracket};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        //for banner ad system
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        bannerAd = findViewById(R.id.bannerAd1);
        AdRequest adRequest = new AdRequest.Builder().build();
        bannerAd.loadAd(adRequest);


        // for Homepage Toolbar settings here
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        //CardView ID initialization
        greetings = findViewById(R.id.greetingsID);
        common = findViewById(R.id.commonID);
        numbers = findViewById(R.id.numbersID);
        timedate = findViewById(R.id.timedateID);
        nationality = findViewById(R.id.nationalityID);
        countries = findViewById(R.id.countriesID);
        profession = findViewById(R.id.professionID);
        emergency = findViewById(R.id.emergencyID);
        transportation = findViewById(R.id.transportationID);
        direction = findViewById(R.id.directionID);
        family = findViewById(R.id.familyID);
        health = findViewById(R.id.healthID);
        accommodation = findViewById(R.id.accommodationID);
        food = findViewById(R.id.foodID);
        fruits = findViewById(R.id.fruitsID);
        studies = findViewById(R.id.studiesID);
        animals = findViewById(R.id.animalsID);
        sports = findViewById(R.id.sportsID);
        colors = findViewById(R.id.colorsID);
        weather = findViewById(R.id.weatherID);


        //CardView OnClickListener
        greetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Greetings.class);
                startActivity(intent);
            }
        });

        common.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Common.class);
                startActivity(intent);
            }
        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Numbers.class);
                startActivity(intent);
            }
        });

        timedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimeDate.class);
                startActivity(intent);
            }
        });

        nationality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Nationality.class);
                startActivity(intent);
            }
        });

        countries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Countries.class);
                startActivity(intent);
            }
        });

        profession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Profession.class);
                startActivity(intent);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Emergency.class);
                startActivity(intent);
            }
        });

        transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Transportation.class);
                startActivity(intent);
            }
        });

        direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Direction.class); //pb
                startActivity(intent);
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Family.class);
                startActivity(intent);
            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Health.class);
                startActivity(intent);
            }
        });

        accommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Accomodation.class);
                startActivity(intent);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Food.class);
                startActivity(intent);
            }
        });

        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fruits.class);
                startActivity(intent);
            }
        });

        studies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Studies.class);
                startActivity(intent);
            }
        });

        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Animals.class);
                startActivity(intent);
            }
        });

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Sports.class);
                startActivity(intent);
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Colors.class);
                startActivity(intent);
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Weather.class);
                startActivity(intent);
            }
        });


        // for Homepage listView settings here
        listView = findViewById(R.id.mainListView);


        MyAdapter adapter = new MyAdapter(this, mTitle, mImage, mIcon);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent1 = new Intent(getApplicationContext(), HSK1ListView.class);
                    startActivity(intent1);
                }else if(position == 1){
                    Intent intent2 = new Intent(getApplicationContext(), HSK2ListView.class);
                    startActivity(intent2);
                }else if(position == 2){
                    Intent intent3 = new Intent(getApplicationContext(), HSK3ListView.class);
                    startActivity(intent3);
                }else if(position == 3){
                    Intent intent4 = new Intent(getApplicationContext(), HSK4Listview.class);
                    startActivity(intent4);
                }
            }
        });
    }

    // for main listview adapter
    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String sTitle[];
        int rImage[];
        int rIcon[];

        MyAdapter (Context c, String title[], int imge[], int icon[]){
            super(c, R.layout.home_listview_row, R.id.home_listview_Text, title);
            this.context = c;
            this.sTitle = title;
            this.rImage = imge;
            this.rIcon = icon;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View home_listview = layoutInflater.inflate(R.layout.home_listview_row, parent, false);
            ImageView images = home_listview.findViewById(R.id.home_listview_Logo);
            TextView myText = home_listview.findViewById(R.id.home_listview_Text);
            ImageView icons = home_listview.findViewById(R.id.home_listview_Icon);


            images.setImageResource(rImage[position]);
            myText.setText(sTitle[position]);
            icons.setImageResource(rIcon[position]);

            return home_listview;
        }
    }

    //for menu settings here
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.firebase_post:
                Toast.makeText(this, "Make Sure Internet Connection", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getApplicationContext(), FirebasePost.class);
                startActivity(intent1);
                return true;

            case R.id.settings:
                Intent intent = new Intent(getApplicationContext(), SettingsPage.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}