package com.techsajib.chinesehelper.Practical.Greetings;

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
import android.widget.AdapterView;
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

public class Greetings extends AppCompatActivity {

    //for InterstitialAd variable
    private InterstitialAd mInterstitialAd;

    ListView listView;
    MediaPlayer player;

    String mEnglish[] = {"Hello/Hi", "Good Morning", "Good Afternoon", "Good Evening", "Good Night", "How are you?", "I'm great, thanks",
                            "I'm not very fine", "Good/Bad", "Yes/No", "What's your name?", "My name is...", "Take care", "Good luck",
                            "Congratulations", "Can you speak English?", "I can speak English", "Can you speak Chinese?", "I can speak Chinese a little",
                            "Where are you from?", "I'm from America", "How old are you?", "I'm 23 years old", "Nice to meet you",
                            "See you later", "See you tomorrow", "Goodbye", "Thank you", "You're welcome"};

    String mChinese[] = {"你好", "早上好", "下午好", "晚上好", "晚安", "你好吗？", "我很好, 谢谢", "我不太好", "好 / 不好", "是 / 不是",
                        "你叫什么名字？", "我的名字是...", "保重", "祝好运", "恭喜你", "你会说英语吗?", "我会说英语", "你会说中文吗？",
                        "我会说一点中文", "你来自哪里?", "我来自美国", "你多大了?", "我二十三岁", "很高兴见到你", "回头见", "明天见",
                        "再见", "谢谢你", "不客气"};

    String mPinyin[] = {"nǐ hǎo", "zǎoshang hǎo", "xiàwǔ hǎo", "wǎnshàng hǎo", "wǎn'ān", "nǐ hǎo ma?", "wǒ hěn hǎo, xièxiè", "wǒ bù tài hǎo",
                        "hǎo / bù hǎo", "shì / bùshì", "nǐ jiào shénme míngzì?", "wǒ de míngzì shì...", "bǎozhòng", "zhù hǎo yùn",
                        "gōngxǐ nǐ", "nǐ huì shuō yīngyǔ ma?", "wǒ huì shuō yīngyǔ", "nǐ huì shuō zhōngwén ma?", "wǒ huì shuō yīdiǎn zhōngwén",
                        "nǐ láizì nǎlǐ?", "wǒ láizì měiguó", "nǐ duō dàle?", "wǒ èrshísān suì", "hěn gāoxìng jiàn dào nǐ", "huítóu jiàn",
                        "míngtiān jiàn", "zàijiàn", "xièxiè nǐ", "bù kèqì"};

    int mCopy[] = {R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file,
            R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file, R.drawable.copy_file};

    int mMic[] = {R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic, R.drawable.mic,
            R.drawable.mic, R.drawable.mic};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greetings);

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
        Toolbar toolbar = findViewById(R.id.greetings_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // for settings listView settings here
        listView = findViewById(R.id.greetingsListView);

        MyAdapter adapter = new MyAdapter(this, mEnglish, mChinese, mPinyin, mCopy, mMic);
        listView.setAdapter(adapter);

    }

    // for main listview adapter
    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String sEnglish[];
        String sChinese[];
        String sPinyin[];
        int cIcon[];
        int rIcon[];

        MyAdapter (Context c, String englishtitle[], String chinesetitle[], String pinyintitle[], int copy[], int icon[]){
            super(c, R.layout.practical_listview_row, R.id.english_text, englishtitle);
            this.context = c;
            this.sEnglish = englishtitle;
            this.sChinese = chinesetitle;
            this.sPinyin = pinyintitle;
            this.cIcon = copy;
            this.rIcon = icon;

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
            copy_file.setImageResource(cIcon[position]);
            icons.setImageResource(rIcon[position]);

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

                    }
                }
            });

            //for sudio in listview
            icons.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position==0){
                        player = MediaPlayer.create(getContext(), R.raw.g1);
                        player.start();

                    }else if (position==1){
                        player = MediaPlayer.create(getContext(), R.raw.g2);
                        player.start();

                    }else if (position==2){
                        player = MediaPlayer.create(getContext(), R.raw.g3);
                        player.start();

                    }else if (position==3){
                        player = MediaPlayer.create(getContext(), R.raw.g4);
                        player.start();

                    }else if (position==4){
                        player = MediaPlayer.create(getContext(), R.raw.g5);
                        player.start();

                    }else if (position==5){
                        player = MediaPlayer.create(getContext(), R.raw.g6);
                        player.start();

                    }else if (position==6){
                        player = MediaPlayer.create(getContext(), R.raw.g7);
                        player.start();

                    }else if (position==7){
                        player = MediaPlayer.create(getContext(), R.raw.g8);
                        player.start();

                    }else if (position==8){
                        player = MediaPlayer.create(getContext(), R.raw.g9);
                        player.start();

                    }else if (position==9){
                        player = MediaPlayer.create(getContext(), R.raw.g10);
                        player.start();

                    }else if (position==10){
                        player = MediaPlayer.create(getContext(), R.raw.g11);
                        player.start();

                    }else if (position==11){
                        player = MediaPlayer.create(getContext(), R.raw.g12);
                        player.start();

                    }else if (position==12){
                        player = MediaPlayer.create(getContext(), R.raw.g13);
                        player.start();

                    }else if (position==13){
                        player = MediaPlayer.create(getContext(), R.raw.g14);
                        player.start();

                    }else if (position==14){
                        player = MediaPlayer.create(getContext(), R.raw.g15);
                        player.start();

                    }else if (position==15){
                        player = MediaPlayer.create(getContext(), R.raw.g16);
                        player.start();

                    }else if (position==16){
                        player = MediaPlayer.create(getContext(), R.raw.g17);
                        player.start();

                    }else if (position==17){
                        player = MediaPlayer.create(getContext(), R.raw.g18);
                        player.start();

                    }else if (position==18){
                        player = MediaPlayer.create(getContext(), R.raw.g19);
                        player.start();

                    }else if (position==19){
                        player = MediaPlayer.create(getContext(), R.raw.g20);
                        player.start();

                    }else if (position==20){
                        player = MediaPlayer.create(getContext(), R.raw.g21);
                        player.start();

                    }else if (position==21){
                        player = MediaPlayer.create(getContext(), R.raw.g22);
                        player.start();

                    }else if (position==22){
                        player = MediaPlayer.create(getContext(), R.raw.g23);
                        player.start();

                    }else if (position==23){
                        player = MediaPlayer.create(getContext(), R.raw.g24);
                        player.start();

                    }else if (position==24){
                        player = MediaPlayer.create(getContext(), R.raw.g25);
                        player.start();

                    }else if (position==25){
                        player = MediaPlayer.create(getContext(), R.raw.g26);
                        player.start();

                    }else if (position==26){
                        player = MediaPlayer.create(getContext(), R.raw.g27);
                        player.start();

                    }else if (position==27){
                        player = MediaPlayer.create(getContext(), R.raw.g28);
                        player.start();

                    }else if (position==28){
                        player = MediaPlayer.create(getContext(), R.raw.g29);
                        player.start();

                    }
                }
            });



            return home_listview;
        }
    }
}