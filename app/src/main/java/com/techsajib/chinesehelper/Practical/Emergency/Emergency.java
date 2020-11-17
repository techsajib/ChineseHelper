package com.techsajib.chinesehelper.Practical.Emergency;

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

public class Emergency extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    ListView listView;
    MediaPlayer player;

    String mEnglish[] = {"It's an emergency", "I've lost my passport", "I've lost my location", "I've lost my wallet", "Where is the hospital?", "I need a doctor",
                        "Call the police", "Where is the police station?", "Where is the embassy?", "Can you help me please?", "Call an ambulance",
                        "Call a doctor", "I lost my bag", "I lost my mobile", "I lost my friend", "Can I use your mobile?", "I'm lost in Beijing",
                        "Where is the bathroom?", "Where do I find you?", "Could you repeat that please?", "Is there a pharmacy nearby?"};

    String mChinese[] = {"这是很紧急", "我的护照丢了", "我失去了我的位置", "我的钱包丢了", "医院在哪里？", "我需要医生", "打电话警察", "警察局在哪里？", "使馆在哪里？",
                        "请你能帮我吗？", "打电话叫救护车", "打电话叫医生", "我的包丢了", "我的手机丢了", "我失去了朋友", "我能用一下你的手机吗？", "我在北京迷路了",
                        "洗手间在哪里？", "我在哪里找到你？", "你能再说一遍吗？", "附近有药店吗？"};

    String mPinyin[] = {"zhè shì hěn jǐnjí", "wǒ de hùzhào diūle", "wǒ shī qùle wǒ de wèizhì", "wǒ de qiánbāo diūle", "yīyuàn zài nǎlǐ?", "wǒ xūyào yīshēng",
                        "dǎ diànhuà jǐngchá", "jǐngchá jú zài nǎlǐ?", "shǐguǎn zài nǎlǐ?", "qǐng nǐ néng bāng wǒ ma?", "dǎ diànhuà jiào jiùhù chē", "dǎ diànhuà jiào yīshēng",
                        "wǒ de bāo diūle", "wǒ de shǒujī diūle", "wǒ shī qùle péngyǒu", "wǒ néng yòng yí xià nǐ de shǒujī ma？", "wǒ zài běijīng mílùle",
                        "xǐ shǒujiān zài nǎlǐ?", "wǒ zài nǎlǐ zhǎodào nǐ?", "nǐ néng zài shuō yí biàn ma？", "fùjìn yǒu yàodiàn ma?"};

    int mCopy[] = {R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
             R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file};


    int mMic[] = {R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency);

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
        Toolbar toolbar = findViewById(R.id.emergency_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // for settings listView settings here
        listView = findViewById(R.id.emergencyListView);

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

                    }
                }
            });

            //for sudio in listview
            mic_icons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position==0){
                        player = MediaPlayer.create(getContext(), R.raw.e1);
                        player.start();

                    }else if (position==1){
                        player = MediaPlayer.create(getContext(), R.raw.e2);
                        player.start();

                    }else if (position==2){
                        player = MediaPlayer.create(getContext(), R.raw.e3);
                        player.start();

                    }else if (position==3){
                        player = MediaPlayer.create(getContext(), R.raw.e4);
                        player.start();

                    }else if (position==4){
                        player = MediaPlayer.create(getContext(), R.raw.e5);
                        player.start();

                    }else if (position==5){
                        player = MediaPlayer.create(getContext(), R.raw.e6);
                        player.start();

                    }else if (position==6){
                        player = MediaPlayer.create(getContext(), R.raw.e7);
                        player.start();

                    }else if (position==7){
                        player = MediaPlayer.create(getContext(), R.raw.e8);
                        player.start();

                    }else if (position==8){
                        player = MediaPlayer.create(getContext(), R.raw.e9);
                        player.start();

                    }else if (position==9){
                        player = MediaPlayer.create(getContext(), R.raw.e10);
                        player.start();

                    }else if (position==10){
                        player = MediaPlayer.create(getContext(), R.raw.e11);
                        player.start();

                    }else if (position==11){
                        player = MediaPlayer.create(getContext(), R.raw.e12);
                        player.start();

                    }else if (position==12){
                        player = MediaPlayer.create(getContext(), R.raw.e13);
                        player.start();

                    }else if (position==13){
                        player = MediaPlayer.create(getContext(), R.raw.e14);
                        player.start();

                    }else if (position==14){
                        player = MediaPlayer.create(getContext(), R.raw.e15);
                        player.start();

                    }else if (position==15){
                        player = MediaPlayer.create(getContext(), R.raw.e16);
                        player.start();

                    }else if (position==16){
                        player = MediaPlayer.create(getContext(), R.raw.e17);
                        player.start();

                    }else if (position==17){
                        player = MediaPlayer.create(getContext(), R.raw.e18);
                        player.start();

                    }else if (position==18){
                        player = MediaPlayer.create(getContext(), R.raw.e19);
                        player.start();

                    }else if (position==19){
                        player = MediaPlayer.create(getContext(), R.raw.e20);
                        player.start();

                    }else if (position==20){
                        player = MediaPlayer.create(getContext(), R.raw.e21);
                        player.start();

                    }
                }
            });



            return home_listview;
        }
    }
}