package com.techsajib.chinesehelper.Practical.Studies;

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

public class Studies extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    ListView listView;
    MediaPlayer player;

    String mEnglish[] = {"Where do you study?", "What are you studying?", "I'm learning Chinese", "What's your major?", "What's your college grade?",
                        "English", "Mathematics", "Physics", "Chemistry", "Biology", "Astronomy", "Geography", "Political Science", "Agriculture",
                        "Architecture", "Business Administration", "Marketing", "Finance", "Accounting", "Economics", "Medicine", "Nursing",
                        "Engineering", "Computer Science & Technology", "Software Engineering", "Electrical Engineering", "Mechanical Engineering",
                        "Art", "Drama", "Music", "Law", "Journalism", "Fashion and Textile Design", "Physical education", "What's your native language?",
                        "I'm study in China", "I'm study in America"};

    String mChinese[] = {"你在哪里学习？", "你在学什么？", "我在学习中文", "你的专业是什么？", "你大学几年级了？", "英语", "数学", "物理", "化学", "生物学",
                        "天文学", "地理", "政治学", "农业", "建筑", "工商管理", "市场营销", "金融", "会计", "经济", "医学", "护理学", "工程",
                        "计算机科学与技术", "软件工程", "电机工程", "机械工程", "艺术", "戏剧", "音乐", "法律", "新闻", "时尚与纺织设计", "体育",
                        "你的母语是什么？", "我在中国学习", "我在美国学习"};

    String mPinyin[] = {"nǐ zài nǎ lǐ xué xí？", "nǐ zài xué shénme？", "wǒ zài xuéxí zhōngwén", "nǐ de zhuānyè shì shénme?", "nǐ dà xué jǐ nián jí le?",
                        "yīng yǔ", "shù xué", "wù lǐ", "huà xué", "shēng wù xué", "tiān wén xué", "dì lǐ", "zhèng zhì xué", "nóng yè", "jiàn zhù",
                        "gōng shāng guǎn lǐ", "shì chǎng yíng xiāo", "jīn róng", "kuài jì", "jīng jì", "yī xué", "hù lǐ xué", "gōng chéng",
                        "jìsuànjī kēxué yǔ jìshù", "ruǎn jiàn gōng chéng", "diàn jī gōng chéng", "jī xiè gōng chéng", "yì shù", "xì jù", "yīn yuè",
                        "fǎ lǜ", "xīn wén", "shí shàng yǔ fǎng zhī shè ji", "tǐ yù", "nǐ de mǔ yǔ shì shénme？", "wǒ zài zhōng guó xué xí",
                        "wǒ zài měi guó xué xí"};

    int mCopy[] = {R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file};


    int mMic[] = {R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studies);

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
        Toolbar toolbar = findViewById(R.id.studies_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // for settings listView settings here
        listView = findViewById(R.id.studiesListView);

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

                    }else if (position==33){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==34){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==35){
                        ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("text", china_text.getText().toString());
                        clipboardManager.setPrimaryClip(clipData);

                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show();

                    }else if (position==36){
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
                        player = MediaPlayer.create(getContext(), R.raw.s1);
                        player.start();

                    }else if (position==1){
                        player = MediaPlayer.create(getContext(), R.raw.s2);
                        player.start();

                    }else if (position==2){
                        player = MediaPlayer.create(getContext(), R.raw.s3);
                        player.start();

                    }else if (position==3){
                        player = MediaPlayer.create(getContext(), R.raw.s4);
                        player.start();

                    }else if (position==4){
                        player = MediaPlayer.create(getContext(), R.raw.s5);
                        player.start();

                    }else if (position==5){
                        player = MediaPlayer.create(getContext(), R.raw.s6);
                        player.start();

                    }else if (position==6){
                        player = MediaPlayer.create(getContext(), R.raw.s7);
                        player.start();

                    }else if (position==7){
                        player = MediaPlayer.create(getContext(), R.raw.s8);
                        player.start();

                    }else if (position==8){
                        player = MediaPlayer.create(getContext(), R.raw.s9);
                        player.start();

                    }else if (position==9){
                        player = MediaPlayer.create(getContext(), R.raw.s10);
                        player.start();

                    }else if (position==10){
                        player = MediaPlayer.create(getContext(), R.raw.s11);
                        player.start();

                    }else if (position==11){
                        player = MediaPlayer.create(getContext(), R.raw.s12);
                        player.start();

                    }else if (position==12){
                        player = MediaPlayer.create(getContext(), R.raw.s13);
                        player.start();

                    }else if (position==13){
                        player = MediaPlayer.create(getContext(), R.raw.s14);
                        player.start();

                    }else if (position==14){
                        player = MediaPlayer.create(getContext(), R.raw.s15);
                        player.start();

                    }else if (position==15){
                        player = MediaPlayer.create(getContext(), R.raw.s16);
                        player.start();

                    }else if (position==16){
                        player = MediaPlayer.create(getContext(), R.raw.s17);
                        player.start();

                    }else if (position==17){
                        player = MediaPlayer.create(getContext(), R.raw.s18);
                        player.start();

                    }else if (position==18){
                        player = MediaPlayer.create(getContext(), R.raw.s19);
                        player.start();

                    }else if (position==19){
                        player = MediaPlayer.create(getContext(), R.raw.s20);
                        player.start();

                    }else if (position==20){
                        player = MediaPlayer.create(getContext(), R.raw.s21);
                        player.start();

                    }else if (position==21){
                        player = MediaPlayer.create(getContext(), R.raw.s22);
                        player.start();

                    }else if (position==22){
                        player = MediaPlayer.create(getContext(), R.raw.s23);
                        player.start();

                    }else if (position==23){
                        player = MediaPlayer.create(getContext(), R.raw.s24);
                        player.start();

                    }else if (position==24){
                        player = MediaPlayer.create(getContext(), R.raw.s25);
                        player.start();

                    }else if (position==25){
                        player = MediaPlayer.create(getContext(), R.raw.s26);
                        player.start();

                    }else if (position==26){
                        player = MediaPlayer.create(getContext(), R.raw.s27);
                        player.start();

                    }else if (position==27){
                        player = MediaPlayer.create(getContext(), R.raw.s28);
                        player.start();

                    }else if (position==28){
                        player = MediaPlayer.create(getContext(), R.raw.s29);
                        player.start();

                    }else if (position==29){
                        player = MediaPlayer.create(getContext(), R.raw.s30);
                        player.start();

                    }else if (position==30){
                        player = MediaPlayer.create(getContext(), R.raw.s31);
                        player.start();

                    }else if (position==31){
                        player = MediaPlayer.create(getContext(), R.raw.s32);
                        player.start();

                    }else if (position==32){
                        player = MediaPlayer.create(getContext(), R.raw.s33);
                        player.start();

                    }else if (position==33){
                        player = MediaPlayer.create(getContext(), R.raw.s34);
                        player.start();

                    }else if (position==34){
                        player = MediaPlayer.create(getContext(), R.raw.s35);
                        player.start();

                    }else if (position==35){
                        player = MediaPlayer.create(getContext(), R.raw.s36);
                        player.start();

                    }else if (position==36){
                        player = MediaPlayer.create(getContext(), R.raw.s37);
                        player.start();

                    }
                }
            });



            return home_listview;
        }
    }
}