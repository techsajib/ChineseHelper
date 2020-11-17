package com.techsajib.chinesehelper.Practical.Transportation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.techsajib.chinesehelper.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Transportation extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    ListView listView;
    MediaPlayer player;

    String mEnglish[] = {"I want to go airport", "Where is the airport?", "I want to go bus station", "Where is bus station?", "I want to go train station",
                        "Where is train station?", "I need a taxi", "Where is the ticket office?", "Get in the car", "Get off the car", "Car",
                        "Ambulance", "Bus", "Boat", "Plane", "Taxi", "Motorbike", "Train", "Truck", "Helicopter", "Metro", "Van", "Ticket", "Passport",
                        "Do you have a map?", "Take me to this address", "Please stop here", "Is it a direct train?", "Petrol station", "May I sit there?",
                        "May I open the window?", "What is the next station?", "Do you like traveling by plane?"};

    String mChinese[] = {"我想去机场", "机场在哪里？", "我想去公车站", "公车站在哪里?", "我想去火车站", "火车站在哪里？", "我需要出租车", "售票处在哪里?",
                        "上车", "下车", "汽车", "救护车", "公车", "船", "飞机", "出租车", "摩托车", "火车", "卡车", "直升机", "地铁", "箱型车", "票",
                        "护照", "你有地图吗？", "带我去这个地址", "请停在这里", "它是直达火车吗？", "加油站", "我可以坐在那里吗？", "我可以打开窗户吗？",
                        "下一站是什么？", "你喜欢坐飞机吗？"};

    String mPinyin[] = {"wǒ xiǎng qù jī chǎng", "jīchǎng zài nǎlǐ?", "wǒ xiǎng qù gōngchē zhàn", "gōngchē zhàn zài nǎlǐ?", "wǒ xiǎng qù huǒchē zhàn",
                        "huǒchē zhàn zài nǎlǐ?", "wǒ xūyào chūzū chē", "shòu piào chù zài nǎlǐ?", "shàng chē", "xià chē", "qìchē", "jiùhù chē",
                        "gōng chē", "chuán", "fēi jī", "chūzū chē", "mótuō chē", "huǒ chē", "kǎ chē", "zhí shēng jī", "dì tiě", "xiāng xíng chē",
                        "piào", "hù zhào", "nǐ yǒu dìtú ma?", "dài wǒ qù zhège dìzhǐ", "qǐng tíng zài zhèlǐ", "tā shì zhídá huǒchē ma?", "jiāyóu zhàn",
                        "wǒ kěyǐ zuò zài nàlǐ ma?", "wǒ kě yǐ dǎ kāi chuāng hu ma？", "xià yí zhàn shì shénme？", "nǐ xǐhuān zuò fēijī ma?"};

    int mCopy[] = {R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file};


    int mMic[] = {R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transportation);

        //for Interstitial ad system
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "Ad wasn't loaded yet.");
                        }
                    }
                });
            }
        }, 5, 5, TimeUnit.SECONDS);


        // for settings Toolbar settings here
        Toolbar toolbar = findViewById(R.id.transportation_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // for settings listView settings here
        listView = findViewById(R.id.transportationListView);

        MyAdapter adapter = new MyAdapter(this, mEnglish, mChinese, mPinyin, mCopy, mMic);
        listView.setAdapter(adapter);

    }

    // for main listview adapter
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String sEnglish[];
        String sChinese[];
        String sPinyin[];
        int cCopy[];
        int rMic[];

        MyAdapter (Context c, String englishtitle[], String chinesetitle[], String pinyintitle[], int copy[], int mic[]){
            super(c, R.layout.practical_listview_row, R.id.english_text, englishtitle);
            this.context = c;
            this.sEnglish = englishtitle;
            this.sChinese = chinesetitle;
            this.sPinyin = pinyintitle;
            this.cCopy = copy;
            this.rMic = mic;

        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View home_listview = layoutInflater.inflate(R.layout.practical_listview_row, parent, false);

            TextView eng_text = home_listview.findViewById(R.id.english_text);
            final TextView china_text = home_listview.findViewById(R.id.chinese_text);
            TextView pinyin_text = home_listview.findViewById(R.id.pinyin_text);
            ImageView copy_file = home_listview.findViewById(R.id.copy_icon);
            ImageView mic_icons = home_listview.findViewById(R.id.mic_icon);


            eng_text.setText(sEnglish[position]);
            china_text.setText(sChinese[position]);
            pinyin_text.setText(sPinyin[position]);
            copy_file.setImageResource(cCopy[position]);
            mic_icons.setImageResource(rMic[position]);

            // for text copy from listview
            copy_file.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position == 0) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 1) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 2) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 3) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 4) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 5) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 6) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 7) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 8) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 9) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 10) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 11) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 12) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 13) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 14) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 15) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 16) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 17) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 18) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 19) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    } else if (position == 20) {
                        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==21){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==22){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==23){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==24){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==25){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==26){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==27){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==28){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==29){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==30){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==31){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==32){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }
                }
            });

            //for sudio in listview
            mic_icons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position==0){
                        player = MediaPlayer.create(getContext(), R.raw.v1);
                        player.start();

                    }else if (position==1){
                        player = MediaPlayer.create(getContext(), R.raw.v2);
                        player.start();

                    }else if (position==2){
                        player = MediaPlayer.create(getContext(), R.raw.v3);
                        player.start();

                    }else if (position==3){
                        player = MediaPlayer.create(getContext(), R.raw.v4);
                        player.start();

                    }else if (position==4){
                        player = MediaPlayer.create(getContext(), R.raw.v5);
                        player.start();

                    }else if (position==5){
                        player = MediaPlayer.create(getContext(), R.raw.v6);
                        player.start();

                    }else if (position==6){
                        player = MediaPlayer.create(getContext(), R.raw.v7);
                        player.start();

                    }else if (position==7){
                        player = MediaPlayer.create(getContext(), R.raw.v8);
                        player.start();

                    }else if (position==8){
                        player = MediaPlayer.create(getContext(), R.raw.v9);
                        player.start();

                    }else if (position==9){
                        player = MediaPlayer.create(getContext(), R.raw.v10);
                        player.start();

                    }else if (position==10){
                        player = MediaPlayer.create(getContext(), R.raw.v11);
                        player.start();

                    }else if (position==11){
                        player = MediaPlayer.create(getContext(), R.raw.v12);
                        player.start();

                    }else if (position==12){
                        player = MediaPlayer.create(getContext(), R.raw.v13);
                        player.start();

                    }else if (position==13){
                        player = MediaPlayer.create(getContext(), R.raw.v14);
                        player.start();

                    }else if (position==14){
                        player = MediaPlayer.create(getContext(), R.raw.v15);
                        player.start();

                    }else if (position==15){
                        player = MediaPlayer.create(getContext(), R.raw.v16);
                        player.start();

                    }else if (position==16){
                        player = MediaPlayer.create(getContext(), R.raw.v17);
                        player.start();

                    }else if (position==17){
                        player = MediaPlayer.create(getContext(), R.raw.v18);
                        player.start();

                    }else if (position==18){
                        player = MediaPlayer.create(getContext(), R.raw.v19);
                        player.start();

                    }else if (position==19){
                        player = MediaPlayer.create(getContext(), R.raw.v20);
                        player.start();

                    }else if (position==20){
                        player = MediaPlayer.create(getContext(), R.raw.v21);
                        player.start();

                    }else if (position==21){
                        player = MediaPlayer.create(getContext(), R.raw.v22);
                        player.start();

                    }else if (position==22){
                        player = MediaPlayer.create(getContext(), R.raw.v23);
                        player.start();

                    }else if (position==23){
                        player = MediaPlayer.create(getContext(), R.raw.v24);
                        player.start();

                    }else if (position==24){
                        player = MediaPlayer.create(getContext(), R.raw.v25);
                        player.start();

                    }else if (position==25){
                        player = MediaPlayer.create(getContext(), R.raw.v26);
                        player.start();

                    }else if (position==26){
                        player = MediaPlayer.create(getContext(), R.raw.v27);
                        player.start();

                    }else if (position==27){
                        player = MediaPlayer.create(getContext(), R.raw.v28);
                        player.start();

                    }else if (position==28){
                        player = MediaPlayer.create(getContext(), R.raw.v29);
                        player.start();

                    }else if (position==29){
                        player = MediaPlayer.create(getContext(), R.raw.v30);
                        player.start();

                    }else if (position==30){
                        player = MediaPlayer.create(getContext(), R.raw.v31);
                        player.start();

                    }else if (position==31){
                        player = MediaPlayer.create(getContext(), R.raw.v32);
                        player.start();

                    }else if (position==32){
                        player = MediaPlayer.create(getContext(), R.raw.v33);
                        player.start();

                    }
                }
            });



            return home_listview;
        }
    }
}