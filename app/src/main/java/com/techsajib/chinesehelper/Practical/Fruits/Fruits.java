package com.techsajib.chinesehelper.Practical.Fruits;

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

public class Fruits extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    ListView listView;
    MediaPlayer player;

    String mEnglish[] = {"Fruit", "Do you like fruit?", "Apple", "Banana", "Blackberry", "Cherry", "Coconut", "Date", "Dragonfruit",
                        "Grape", "Guava", "Jackfruit", "Lemon", "Lychee", "Watermelon", "Pineapple", "Peach", "Pear", "Papaya", "Raspberry",
                        "Mango", "Orange", "Strawberry", "Do you like Chinese fruit?"};

    String mChinese[] = {"水果", "你喜欢水果吗？", "苹果", "香蕉", "黑莓", "樱桃", "椰子", "枣", "火龙果", "葡萄", "番石榴", "菠萝蜜", "柠檬",
                        "荔枝", "西瓜", "菠萝", "桃子", "梨", "番木瓜", "树莓", "芒果", "橙子", "草莓", "你喜欢中国水果吗？"};

    String mPinyin[] = {"shuǐ guǒ", "nǐ xǐ huan shuǐ guǒ ma？", "píng guǒ", "xiāng jiāo", "hēi méi", "yīng táo", "yē zi", "zǎo", "huǒ lóng guǒ",
                        "pú táo", "fān shí liu", "bō luó mì", "níng méng", "lì zhī", "xī guā", "bō luó", "táo zǐ", "lí", "gān mù guā",
                        "shù méi", "máng guǒ", "chéng zǐ", "cǎo méi", "nǐ xǐ huan zhōng guó shuǐ guǒ ma？"};

    int mCopy[] = {R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file};

    int mMic[] = {R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruits);

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
        Toolbar toolbar = findViewById(R.id.fruits_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // for settings listView settings here
        listView = findViewById(R.id.fruitsListView);

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
            ImageView icons = home_listview.findViewById(R.id.mic_icon);


            eng_text.setText(sEnglish[position]);
            china_text.setText(sChinese[position]);
            pinyin_text.setText(sPinyin[position]);
            copy_file.setImageResource(cCopy[position]);
            icons.setImageResource(rMic[position]);


            // for text copy from listview
            copy_file.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position==0){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==1){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==2){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==3){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==4){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==5){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==6){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==7){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==8){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==9){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==10){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==11){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==12){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==13){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==14){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==15){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==16){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==17){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==18){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==19){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==20){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
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

                    }
                }
            });


            //for sudio in listview
            icons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position==0){
                        player = MediaPlayer.create(getContext(), R.raw.ft1);
                        player.start();

                    }else if (position==1){
                        player = MediaPlayer.create(getContext(), R.raw.ft2);
                        player.start();

                    }else if (position==2){
                        player = MediaPlayer.create(getContext(), R.raw.ft3);
                        player.start();

                    }else if (position==3){
                        player = MediaPlayer.create(getContext(), R.raw.ft4);
                        player.start();

                    }else if (position==4){
                        player = MediaPlayer.create(getContext(), R.raw.ft5);
                        player.start();

                    }else if (position==5){
                        player = MediaPlayer.create(getContext(), R.raw.ft6);
                        player.start();

                    }else if (position==6){
                        player = MediaPlayer.create(getContext(), R.raw.ft7);
                        player.start();

                    }else if (position==7){
                        player = MediaPlayer.create(getContext(), R.raw.ft8);
                        player.start();

                    }else if (position==8){
                        player = MediaPlayer.create(getContext(), R.raw.ft9);
                        player.start();

                    }else if (position==9){
                        player = MediaPlayer.create(getContext(), R.raw.ft10);
                        player.start();

                    }else if (position==10){
                        player = MediaPlayer.create(getContext(), R.raw.ft11);
                        player.start();

                    }else if (position==11){
                        player = MediaPlayer.create(getContext(), R.raw.ft12);
                        player.start();

                    }else if (position==12){
                        player = MediaPlayer.create(getContext(), R.raw.ft13);
                        player.start();

                    }else if (position==13){
                        player = MediaPlayer.create(getContext(), R.raw.ft14);
                        player.start();

                    }else if (position==14){
                        player = MediaPlayer.create(getContext(), R.raw.ft15);
                        player.start();

                    }else if (position==15){
                        player = MediaPlayer.create(getContext(), R.raw.ft16);
                        player.start();

                    }else if (position==16){
                        player = MediaPlayer.create(getContext(), R.raw.ft17);
                        player.start();

                    }else if (position==17){
                        player = MediaPlayer.create(getContext(), R.raw.ft18);
                        player.start();

                    }else if (position==18){
                        player = MediaPlayer.create(getContext(), R.raw.ft19);
                        player.start();

                    }else if (position==19){
                        player = MediaPlayer.create(getContext(), R.raw.ft20);
                        player.start();

                    }else if (position==20){
                        player = MediaPlayer.create(getContext(), R.raw.ft21);
                        player.start();

                    }else if (position==21){
                        player = MediaPlayer.create(getContext(), R.raw.ft22);
                        player.start();

                    }else if (position==22){
                        player = MediaPlayer.create(getContext(), R.raw.ft23);
                        player.start();

                    }else if (position==23){
                        player = MediaPlayer.create(getContext(), R.raw.ft24);
                        player.start();

                    }
                }
            });

            return home_listview;
        }
    }
}