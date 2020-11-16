package com.techsajib.chinesehelper.HSK1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.techsajib.chinesehelper.Firebase.FirebasePost;
import com.techsajib.chinesehelper.HSK1.Word.*;
import com.techsajib.chinesehelper.R;

import java.util.ArrayList;

public class HSK1ListView extends AppCompatActivity {

    ListView listView;
    HSK1Adapter hsk1Adapter;
    EditText filterSearch;

    ArrayList<HSK1Model> item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hsk1_listview);

        // for HSK1 Toolbar settings here
        Toolbar toolbar = findViewById(R.id.hsk1_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for listview section
        listView = findViewById(R.id.hsk1ListView);

        //CREATING DATA FOR LISTVIEW
        //Personal Pronoun
        item.add(new HSK1Model("我","wǒ","I, me", R.drawable.bracket));   //WORD-1
        item.add(new HSK1Model("我们","wǒmen","we, us", R.drawable.bracket));  //WORD-2
        item.add(new HSK1Model("你","nǐ","you (singular)", R.drawable.bracket));  //WORD-3
        item.add(new HSK1Model("你们","nǐmen","you (plural)", R.drawable.bracket));    //WORD-4
        item.add(new HSK1Model("他","tā","he, him", R.drawable.bracket)); //WORD-5
        item.add(new HSK1Model("她","tā","she, her", R.drawable.bracket));    //WORD-6
        item.add(new HSK1Model("他们","tāmen","they (male, plural)", R.drawable.bracket)); //WORD-7
        item.add(new HSK1Model("她们","tāmen","they (female, plural)", R.drawable.bracket));   //WORD-8
        //Demonstrative Pronoun
        item.add(new HSK1Model("这/这儿","zhè/zhèr","this/here", R.drawable.bracket));   //WORD-9
        item.add(new HSK1Model("那/那儿","nà/nàr","that/there", R.drawable.bracket));   //WORD-10
        //Interrogative Pronoun
        item.add(new HSK1Model("哪/哪儿","nǎ/nǎr","which/where", R.drawable.bracket));  //WORD-11
        item.add(new HSK1Model("谁","shéi","who, whose", R.drawable.bracket));   //WORD-12
        item.add(new HSK1Model("什么","shénme","what", R.drawable.bracket));   //WORD-13
        item.add(new HSK1Model("多少/几","duōshǎo/jǐ","how many, how much, a few", R.drawable.bracket)); //WORD-14
        item.add(new HSK1Model("怎么","zěnme","how", R.drawable.bracket)); //WORD-15
        item.add(new HSK1Model("怎么样","zěnme yàng","how about", R.drawable.bracket)); //WORD-16
        //Numberal
        item.add(new HSK1Model("数词","shù cí","NUMERALS", R.drawable.bracket));   //WORD-17   no-page
        item.add(new HSK1Model("一","yī","1 (one)", R.drawable.bracket)); //WORD-18
        item.add(new HSK1Model("二/两","èr/liǎng","2 (two)", R.drawable.bracket)); //WORD-19
        item.add(new HSK1Model("三","sān","3 (three)", R.drawable.bracket));  //WORD-20
        item.add(new HSK1Model("四","sì","4 (four)", R.drawable.bracket));    //WORD-21
        item.add(new HSK1Model("五","wǔ","5 (five)", R.drawable.bracket));    //WORD-22
        item.add(new HSK1Model("六","liù","6 (six)", R.drawable.bracket));    //WORD-23
        item.add(new HSK1Model("七","qī","7 (seven)", R.drawable.bracket));   //WORD-24
        item.add(new HSK1Model("八","bā","8 (eight)", R.drawable.bracket));   //WORD-25
        item.add(new HSK1Model("九","jiǔ","9 (nine)", R.drawable.bracket));   //WORD-26
        item.add(new HSK1Model("十","shí","10 (ten)", R.drawable.bracket));   //WORD-27
        item.add(new HSK1Model("零","líng","0 (zero)", R.drawable.bracket));  //WORD-28   no-page
        //Quantifier
        item.add(new HSK1Model("个","gè","one, a, an (general measure word)", R.drawable.bracket));   //WORD-29
        item.add(new HSK1Model("岁","suì","year (of age)", R.drawable.bracket));  //WORD-30
        item.add(new HSK1Model("本","běn","A measure word for books | origin, roots ", R.drawable.bracket));  //WORD-31
        item.add(new HSK1Model("些","xiē","some, few, several", R.drawable.bracket)); //WORD-32
        item.add(new HSK1Model("块","kuài","piece, A unit of Chinese money", R.drawable.bracket));    //WORD-33
        //Adverb
        item.add(new HSK1Model("不","bù","no, not", R.drawable.bracket)); //WORD-34
        item.add(new HSK1Model("没","méi","no, not", R.drawable.bracket));    //WORD-35
        item.add(new HSK1Model("很","hěn","very", R.drawable.bracket));   //WORD-36
        item.add(new HSK1Model("太","tài","too, extremely", R.drawable.bracket)); //WORD-37
        item.add(new HSK1Model("都","dōu","all, both", R.drawable.bracket));  //WORD-38
        item.add(new HSK1Model("和","hé","and", R.drawable.bracket)); //WORD-39
        item.add(new HSK1Model("在","zài","in, at, on", R.drawable.bracket)); //WORD-40
        //Adjective
        item.add(new HSK1Model("好","hǎo","good, fine, ok", R.drawable.bracket)); //WORD-41
        item.add(new HSK1Model("大","dà","big, large", R.drawable.bracket));  //WORD-42
        item.add(new HSK1Model("小","xiǎo","small, few", R.drawable.bracket));    //WORD-43
        item.add(new HSK1Model("多少","duōshǎo","how many, how much", R.drawable.bracket));     //WORD-44
        item.add(new HSK1Model("冷","lěng","cold", R.drawable.bracket));  //WORD-45
        item.add(new HSK1Model("热","rè","hot", R.drawable.bracket)); //WORD-46
        item.add(new HSK1Model("高兴","gāoxìng","happy, glad", R.drawable.bracket));  //WORD-47
        item.add(new HSK1Model("漂亮","piàoliàng","beautiful, pretty", R.drawable.bracket));   //WORD-48
        //Auxilary
        item.add(new HSK1Model("的","de","used after an attribute, possessive particle", R.drawable.bracket));    //WORD-49
        item.add(new HSK1Model("了","le","particle for new situation or completed action", R.drawable.bracket));  //WORD-50
        item.add(new HSK1Model("吗","ma","question particle", R.drawable.bracket));   //WORD-51
        item.add(new HSK1Model("呢","ne","modal particle ending a question", R.drawable.bracket));    //WORD-52
        item.add(new HSK1Model("喂","wèi","hey, hello", R.drawable.bracket)); //WORD-53
        //Noun
        item.add(new HSK1Model("家","jiā","home, family, household", R.drawable.bracket));    //WORD-54
        item.add(new HSK1Model("学校","xuéxiào","school", R.drawable.bracket));   //WORD-55
        item.add(new HSK1Model("饭店","fàndiàn","restaurant", R.drawable.bracket));   //WORD-56
        item.add(new HSK1Model("商店","shāngdiàn","store, shop", R.drawable.bracket));    //WORD-57
        item.add(new HSK1Model("医院","yīyuàn","hospital", R.drawable.bracket));  //WORD-58
        item.add(new HSK1Model("火车站","huǒchēzhàn","train station, railway station", R.drawable.bracket));  //WORD-59
        item.add(new HSK1Model("中国","zhōngguó","China, Middle kingdom", R.drawable.bracket));   //WORD-60
        item.add(new HSK1Model("北京","běijīng","Beijing (capital of China)", R.drawable.bracket));    //WORD-61
        item.add(new HSK1Model("上","shàng","up, on, above", R.drawable.bracket));  //WORD-62
        item.add(new HSK1Model("下","xià","down, under, below, next", R.drawable.bracket));   //WORD-63
        item.add(new HSK1Model("前面","qiánmiàn","front", R.drawable.bracket));   //WORD-64
        item.add(new HSK1Model("后面","hòumiàn","behind, back, rear", R.drawable.bracket));   //WORD-65
        item.add(new HSK1Model("里面","lǐmiàn","inside, internal", R.drawable.bracket));  //WORD-66
        item.add(new HSK1Model("今天","jīntiān","today", R.drawable.bracket));    //WORD-67
        item.add(new HSK1Model("明天","míngtiān","tomorrow", R.drawable.bracket));    //WORD-68
        item.add(new HSK1Model("昨天","zuótiān","yesterday", R.drawable.bracket));   //WORD-69
        item.add(new HSK1Model("上午","shàngwǔ","morning, AM", R.drawable.bracket)); //WORD-70
        item.add(new HSK1Model("中午","zhōngwǔ","noon, midday", R.drawable.bracket));    //WORD-71
        item.add(new HSK1Model("下午","xiàwǔ","afternoon", R.drawable.bracket));     //WORD-72
        item.add(new HSK1Model("年","nián","year", R.drawable.bracket)); //WORD-73
        item.add(new HSK1Model("月","yuè","month, moon", R.drawable.bracket)); //WORD-74
        item.add(new HSK1Model("日","rì","day, sun", R.drawable.bracket));    //WORD-75
        item.add(new HSK1Model("星期","xīngqī","week", R.drawable.bracket)); //WORD-76
        item.add(new HSK1Model("点","diǎn","point, spot", R.drawable.bracket));  //WORD-77
        item.add(new HSK1Model("分钟","fēnzhōng","minute", R.drawable.bracket)); //WORD-78
        item.add(new HSK1Model("现在","xiànzài","now, right now", R.drawable.bracket));  //WORD-79
        item.add(new HSK1Model("时候","shíhou","time, moment", R.drawable.bracket));   //WORD-80
        item.add(new HSK1Model("爸爸","bàba","father, dad, papa", R.drawable.bracket));   //WORD-81
        item.add(new HSK1Model("妈妈","māma","mother, mom, mommy", R.drawable.bracket));   //WORD-82
        item.add(new HSK1Model("儿子","érzi","son", R.drawable.bracket)); //WORD-83
        item.add(new HSK1Model("女儿","nǚér","daughter", R.drawable.bracket));    //WORD-84
        item.add(new HSK1Model("老师","lǎoshī","teacher", R.drawable.bracket));   //WORD-85
        item.add(new HSK1Model("学生","xuéshēng","student", R.drawable.bracket)); //WORD-86
        item.add(new HSK1Model("同学","tóngxué","schoolmate, classmate", R.drawable.bracket));    //WORD-87
        item.add(new HSK1Model("朋友","péngyǒu","friend", R.drawable.bracket));   //WORD-88
        item.add(new HSK1Model("医生","yīshēng","doctor", R.drawable.bracket));   //WORD-89
        item.add(new HSK1Model("先生","xiānsheng","sir, Mr.", R.drawable.bracket));   //WORD-90 - no page
        item.add(new HSK1Model("小姐","xiǎojiě","Miss, Mrs.", R.drawable.bracket));   //WORD-91   - no page
        item.add(new HSK1Model("衣服","yīfu","clothes", R.drawable.bracket)); //WORD-92
        item.add(new HSK1Model("水","shuǐ","water", R.drawable.bracket));    //WORD-93
        item.add(new HSK1Model("菜","cài","food, dish", R.drawable.bracket));    //WORD-94
        item.add(new HSK1Model("米饭","mǐfàn","cooked rice", R.drawable.bracket));    //WORD-95
        item.add(new HSK1Model("水果","shuǐguǒ","fruits", R.drawable.bracket));   //WORD-96
        item.add(new HSK1Model("苹果","píngguǒ","apple", R.drawable.bracket));    //WORD-97
        item.add(new HSK1Model("茶","chá","tea", R.drawable.bracket));   //WORD-98
        item.add(new HSK1Model("杯子","bēizi","cup, glass", R.drawable.bracket)); //WORD-99

        item.add(new HSK1Model("钱","qián","money", R.drawable.bracket));    //WORD-100
        item.add(new HSK1Model("飞机","fēijī","plane, airplane, aircraft", R.drawable.bracket));  //WORD-101
        item.add(new HSK1Model("出租车","chūzū chē","taxi, cab", R.drawable.bracket)); //WORD-102
        item.add(new HSK1Model("电视","diànshì","television, TV", R.drawable.bracket));   //WORD-103
        item.add(new HSK1Model("电脑","diànnǎo","computer", R.drawable.bracket)); //WORD-104
        item.add(new HSK1Model("电影","diànyǐng","movie", R.drawable.bracket));   //WORD-105
        item.add(new HSK1Model("天气","tiānqì","weather", R.drawable.bracket));   //WORD-106
        item.add(new HSK1Model("猫","māo","cat", R.drawable.bracket));   //WORD-107
        item.add(new HSK1Model("狗","gǒu","dog", R.drawable.bracket));   //WORD-108
        item.add(new HSK1Model("东西","dōngxi","things, stuff", R.drawable.bracket)); //WORD-109
        item.add(new HSK1Model("人","rén","person, people", R.drawable.bracket));    //WORD-110
        item.add(new HSK1Model("名字","míngzi","name, first name", R.drawable.bracket));  //WORD-111
        item.add(new HSK1Model("书","shū","book", R.drawable.bracket));  //WORD-112
        item.add(new HSK1Model("汉语","hànyǔ","Mandarin, Chinese language", R.drawable.bracket)); //WORD-113
        item.add(new HSK1Model("字","zì","character, word, symbol", R.drawable.bracket));    //WORD-114
        item.add(new HSK1Model("桌子","zhuōzi","desk, table", R.drawable.bracket));    //WORD-115
        item.add(new HSK1Model("椅子","yǐzi","chair", R.drawable.bracket));   //WORD-116
        item.add(new HSK1Model("谢谢","xièxie","thanks, appreciate", R.drawable.bracket));    //WORD-117
        item.add(new HSK1Model("不客气","búkèqì","you're welcome, don't mention it", R.drawable.bracket));   //WORD-118
        item.add(new HSK1Model("再见","zàijiàn","goodbye", R.drawable.bracket));  //WORD-119
        item.add(new HSK1Model("请","qǐng","please, politely request", R.drawable.bracket));    //WORD-120
        item.add(new HSK1Model("对不起","duìbùqǐ","sorry", R.drawable.bracket));   //WORD-121
        item.add(new HSK1Model("没关系","méiguānxì","It doesn’t matter, It's ok, That's nothing", R.drawable.bracket));  //WORD-122
        item.add(new HSK1Model("是","shì","to be (am, is, are)", R.drawable.bracket));   //WORD-123
        item.add(new HSK1Model("有","yǒu","have", R.drawable.bracket));  //WORD-124
        item.add(new HSK1Model("看","kàn","to look, to watch", R.drawable.bracket)); //WORD-125
        item.add(new HSK1Model("听","tīng","to listen", R.drawable.bracket));    //WORD-126
        item.add(new HSK1Model("说话","shuōhuà","speak, say", R.drawable.bracket));   //WORD-127
        item.add(new HSK1Model("读","dú","read", R.drawable.bracket));   //WORD-128
        item.add(new HSK1Model("写","xiě","write", R.drawable.bracket)); //WORD-129
        item.add(new HSK1Model("看见","kànjiàn","to see", R.drawable.bracket));   //WORD-130
        item.add(new HSK1Model("叫","jiào","to call", R.drawable.bracket));  //WORD-131
        item.add(new HSK1Model("来","lái","come", R.drawable.bracket));  //WORD-132
        item.add(new HSK1Model("回","huí","back, return", R.drawable.bracket));  //WORD-133
        item.add(new HSK1Model("去","qù","go", R.drawable.bracket)); //WORD-134
        item.add(new HSK1Model("吃","chī","eat", R.drawable.bracket));   //WORD-135
        item.add(new HSK1Model("喝","hē","drink", R.drawable.bracket));   //WORD-136
        item.add(new HSK1Model("睡觉","shuìjiào","go to sleep", R.drawable.bracket)); //WORD-137
        item.add(new HSK1Model("打电话","dǎ diànhuà","call up, make a telephone call", R.drawable.bracket)); //WORD-138
        item.add(new HSK1Model("做","zuò","to do, to make", R.drawable.bracket));    //WORD-139
        item.add(new HSK1Model("买","mǎi","buy, purchase", R.drawable.bracket));  //WORD-140
        item.add(new HSK1Model("开","kāi","to open, to drive, to start, to turn on, to boil", R.drawable.bracket));    //WORD-141
        item.add(new HSK1Model("坐","zuò","to sit, to take a seat", R.drawable.bracket));   //WORD-142
        item.add(new HSK1Model("住","zhù","live, stay", R.drawable.bracket));    //WORD-143
        item.add(new HSK1Model("学习","xuéxí","study, learn, gain knowledge", R.drawable.bracket));    //WORD-144
        item.add(new HSK1Model("工作","gōngzuò","job, work, task", R.drawable.bracket));    //WORD-145
        item.add(new HSK1Model("雨","yǔ","rain", R.drawable.bracket));   //WORD-146
        item.add(new HSK1Model("爱","ài","love, affection, be fond of", R.drawable.bracket));    //WORD-147
        item.add(new HSK1Model("喜欢","xǐhuān","like, love", R.drawable.bracket));    //WORD-148
        item.add(new HSK1Model("想","xiǎng","to want, to wish, would like", R.drawable.bracket));    //WORD-149
        item.add(new HSK1Model("认识","rènshi","to know", R.drawable.bracket));   //WORD-150
        item.add(new HSK1Model("会","huì","can, be able to, to be possible", R.drawable.bracket));    //WORD-151
        item.add(new HSK1Model("能","néng","can, may, capable", R.drawable.bracket)); //WORD-152


        // custom adapter declaration
        hsk1Adapter = new HSK1Adapter(this, R.layout.hsk1_listview_row, item);
        listView.setAdapter(hsk1Adapter);


        //for listview clicking settings
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    Intent intent = new Intent(getApplicationContext(), H1Word1.class);
                    startActivity(intent);

                }else if (position==1){
                    Intent intent1 = new Intent(getApplicationContext(), H1Word2.class);
                    startActivity(intent1);

                }else if (position==2){
                    Intent intent2 = new Intent(getApplicationContext(), H1Word3.class);
                    startActivity(intent2);

                }else if (position==3){
                    Intent intent3 = new Intent(getApplicationContext(), H1Word4.class);
                    startActivity(intent3);

                }else if (position==4){
                    Intent intent4 = new Intent(getApplicationContext(), H1Word5.class);
                    startActivity(intent4);
                    
                }else if (position==5){
                    Intent intent4 = new Intent(getApplicationContext(), H1Word6.class);
                    startActivity(intent4);

                }else if (position==6){
                    Intent intent4 = new Intent(getApplicationContext(), H1Word7.class);
                    startActivity(intent4);

                }else if (position==7){
                    Intent intent = new Intent(getApplicationContext(), H1Word8.class);
                    startActivity(intent);

                }else if (position==8){
                    Intent intent = new Intent(getApplicationContext(), H1Word9.class);
                    startActivity(intent);

                }else if (position==9){
                    Intent intent = new Intent(getApplicationContext(), H1Word10.class);
                    startActivity(intent);

                }else if (position==10){
                    Intent intent = new Intent(getApplicationContext(), H1Word11.class);
                    startActivity(intent);

                }else if (position==11){
                    Intent intent = new Intent(getApplicationContext(), H1Word12.class);
                    startActivity(intent);

                }else if (position==12){
                    Intent intent = new Intent(getApplicationContext(), H1Word13.class);
                    startActivity(intent);

                }else if (position==13){
                    Intent intent = new Intent(getApplicationContext(), H1Word14.class);
                    startActivity(intent);

                }else if (position==14){
                    Intent intent = new Intent(getApplicationContext(), H1Word15.class);
                    startActivity(intent);

                }else if (position==15){
                    Intent intent = new Intent(getApplicationContext(), H1Word16.class);
                    startActivity(intent);

                }else if (position==17){
                    Intent intent = new Intent(getApplicationContext(), H1Word18.class);
                    startActivity(intent);

                }else if (position==18){
                    Intent intent = new Intent(getApplicationContext(), H1Word19.class);
                    startActivity(intent);

                }else if (position==19){
                    Intent intent = new Intent(getApplicationContext(), H1Word20.class);
                    startActivity(intent);

                }else if (position==20){
                    Intent intent = new Intent(getApplicationContext(), H1Word21.class);
                    startActivity(intent);

                }else if (position==21){
                    Intent intent = new Intent(getApplicationContext(), H1Word22.class);
                    startActivity(intent);

                }else if (position==22){
                    Intent intent = new Intent(getApplicationContext(), H1Word23.class);
                    startActivity(intent);

                }else if (position==23){
                    Intent intent = new Intent(getApplicationContext(), H1Word24.class);
                    startActivity(intent);

                }else if (position==24){
                    Intent intent = new Intent(getApplicationContext(), H1Word25.class);
                    startActivity(intent);

                }else if (position==25){
                    Intent intent = new Intent(getApplicationContext(), H1Word26.class);
                    startActivity(intent);

                }else if (position==26){
                    Intent intent = new Intent(getApplicationContext(), H1Word27.class);
                    startActivity(intent);

                }else if (position==28){
                    Intent intent = new Intent(getApplicationContext(), H1Word29.class);
                    startActivity(intent);

                }else if (position==29){
                    Intent intent = new Intent(getApplicationContext(), H1Word30.class);
                    startActivity(intent);

                }else if (position==30){
                    Intent intent = new Intent(getApplicationContext(), H1Word31.class);
                    startActivity(intent);

                }else if (position==31){
                    Intent intent = new Intent(getApplicationContext(), H1Word32.class);
                    startActivity(intent);

                }else if (position==32){
                    Intent intent = new Intent(getApplicationContext(), H1Word33.class);
                    startActivity(intent);

                }else if (position==33){
                    Intent intent = new Intent(getApplicationContext(), H1Word34.class);
                    startActivity(intent);

                }else if (position==34){
                    Intent intent = new Intent(getApplicationContext(), H1Word35.class);
                    startActivity(intent);

                }else if (position==35){
                    Intent intent = new Intent(getApplicationContext(), H1Word36.class);
                    startActivity(intent);

                }else if (position==36){
                    Intent intent = new Intent(getApplicationContext(), H1Word37.class);
                    startActivity(intent);

                }else if (position==37){
                    Intent intent = new Intent(getApplicationContext(), H1Word38.class);
                    startActivity(intent);

                }else if (position==38){
                    Intent intent = new Intent(getApplicationContext(), H1Word39.class);
                    startActivity(intent);

                }else if (position==39){
                    Intent intent = new Intent(getApplicationContext(), H1Word40.class);
                    startActivity(intent);

                }else if (position==40){
                    Intent intent = new Intent(getApplicationContext(), H1Word41.class);
                    startActivity(intent);

                }else if (position==41){
                    Intent intent = new Intent(getApplicationContext(), H1Word42.class);
                    startActivity(intent);

                }else if (position==42){
                    Intent intent = new Intent(getApplicationContext(), H1Word43.class);
                    startActivity(intent);

                }else if (position==43){
                    Intent intent = new Intent(getApplicationContext(), H1Word44.class);
                    startActivity(intent);

                }else if (position==44){
                    Intent intent = new Intent(getApplicationContext(), H1Word45.class);
                    startActivity(intent);

                }else if (position==45){
                    Intent intent = new Intent(getApplicationContext(), H1Word46.class);
                    startActivity(intent);

                }else if (position==46){
                    Intent intent = new Intent(getApplicationContext(), H1Word47.class);
                    startActivity(intent);

                }else if (position==47){
                    Intent intent = new Intent(getApplicationContext(), H1Word48.class);
                    startActivity(intent);

                }else if (position==48){
                    Intent intent = new Intent(getApplicationContext(), H1Word49.class);
                    startActivity(intent);

                }else if (position==49){
                    Intent intent = new Intent(getApplicationContext(), H1Word50.class);
                    startActivity(intent);

                }else if (position==50){
                    Intent intent = new Intent(getApplicationContext(), H1Word51.class);
                    startActivity(intent);

                }else if (position==51){
                    Intent intent = new Intent(getApplicationContext(), H1Word52.class);
                    startActivity(intent);

                }else if (position==52){
                    Intent intent = new Intent(getApplicationContext(), H1Word53.class);
                    startActivity(intent);

                }else if (position==53){
                    Intent intent = new Intent(getApplicationContext(), H1Word54.class);
                    startActivity(intent);

                }else if (position==54){
                    Intent intent = new Intent(getApplicationContext(), H1Word55.class);
                    startActivity(intent);

                }else if (position==55){
                    Intent intent = new Intent(getApplicationContext(), H1Word56.class);
                    startActivity(intent);

                }else if (position==56){
                    Intent intent = new Intent(getApplicationContext(), H1Word57.class);
                    startActivity(intent);

                }else if (position==57){
                    Intent intent = new Intent(getApplicationContext(), H1Word58.class);
                    startActivity(intent);

                }else if (position==58){
                    Intent intent = new Intent(getApplicationContext(), H1Word59.class);
                    startActivity(intent);

                }else if (position==59){
                    Intent intent = new Intent(getApplicationContext(), H1Word60.class);
                    startActivity(intent);

                }else if (position==60){
                    Intent intent = new Intent(getApplicationContext(), H1Word61.class);
                    startActivity(intent);

                }else if (position==61){
                    Intent intent = new Intent(getApplicationContext(), H1Word62.class);
                    startActivity(intent);

                }else if (position==62){
                    Intent intent = new Intent(getApplicationContext(), H1Word63.class);
                    startActivity(intent);

                }else if (position==63){
                    Intent intent = new Intent(getApplicationContext(), H1Word64.class);
                    startActivity(intent);

                }else if (position==64){
                    Intent intent = new Intent(getApplicationContext(), H1Word65.class);
                    startActivity(intent);

                }else if (position==65){
                    Intent intent = new Intent(getApplicationContext(), H1Word66.class);
                    startActivity(intent);

                }else if (position==66){
                    Intent intent = new Intent(getApplicationContext(), H1Word67.class);
                    startActivity(intent);

                }else if (position==67){
                    Intent intent = new Intent(getApplicationContext(), H1Word68.class);
                    startActivity(intent);

                }else if (position==68){
                    Intent intent = new Intent(getApplicationContext(), H1Word69.class);
                    startActivity(intent);

                }else if (position==69){
                    Intent intent = new Intent(getApplicationContext(), H1Word70.class);
                    startActivity(intent);

                }else if (position==70){
                    Intent intent = new Intent(getApplicationContext(), H1Word71.class);
                    startActivity(intent);

                }else if (position==71){
                    Intent intent = new Intent(getApplicationContext(), H1Word72.class);
                    startActivity(intent);

                }else if (position==72){
                    Intent intent = new Intent(getApplicationContext(), H1Word73.class);
                    startActivity(intent);

                }else if (position==73){
                    Intent intent = new Intent(getApplicationContext(), H1Word74.class);
                    startActivity(intent);

                }else if (position==74){
                    Intent intent = new Intent(getApplicationContext(), H1Word75.class);
                    startActivity(intent);

                }else if (position==75){
                    Intent intent = new Intent(getApplicationContext(), H1Word76.class);
                    startActivity(intent);

                }else if (position==76){
                    Intent intent = new Intent(getApplicationContext(), H1Word77.class);
                    startActivity(intent);

                }else if (position==77){
                    Intent intent = new Intent(getApplicationContext(), H1Word78.class);
                    startActivity(intent);

                }else if (position==78){
                    Intent intent = new Intent(getApplicationContext(), H1Word79.class);
                    startActivity(intent);

                }else if (position==79){
                    Intent intent = new Intent(getApplicationContext(), H1Word80.class);
                    startActivity(intent);

                }else if (position==80){
                    Intent intent = new Intent(getApplicationContext(), H1Word81.class);
                    startActivity(intent);

                }else if (position==81){
                    Intent intent = new Intent(getApplicationContext(), H1Word82.class);
                    startActivity(intent);

                }else if (position==82){
                    Intent intent = new Intent(getApplicationContext(), H1Word83.class);
                    startActivity(intent);

                }else if (position==83){
                    Intent intent = new Intent(getApplicationContext(), H1Word84.class);
                    startActivity(intent);

                }else if (position==84){
                    Intent intent = new Intent(getApplicationContext(), H1Word85.class);
                    startActivity(intent);

                }else if (position==85){
                    Intent intent = new Intent(getApplicationContext(), H1Word86.class);
                    startActivity(intent);

                }else if (position==86){
                    Intent intent = new Intent(getApplicationContext(), H1Word87.class);
                    startActivity(intent);

                }else if (position==87){
                    Intent intent = new Intent(getApplicationContext(), H1Word88.class);
                    startActivity(intent);

                }else if (position==88){
                    Intent intent = new Intent(getApplicationContext(), H1Word89.class);
                    startActivity(intent);

                }else if (position==91){
                    Intent intent = new Intent(getApplicationContext(), H1Word92.class);
                    startActivity(intent);

                }else if (position==92){
                    Intent intent = new Intent(getApplicationContext(), H1Word93.class);
                    startActivity(intent);

                }else if (position==93){
                    Intent intent = new Intent(getApplicationContext(), H1Word94.class);
                    startActivity(intent);

                }else if (position==94){
                    Intent intent = new Intent(getApplicationContext(), H1Word95.class);
                    startActivity(intent);

                }else if (position==95){
                    Intent intent = new Intent(getApplicationContext(), H1Word96.class);
                    startActivity(intent);

                }else if (position==96){
                    Intent intent = new Intent(getApplicationContext(), H1Word97.class);
                    startActivity(intent);

                }else if (position==97){
                    Intent intent = new Intent(getApplicationContext(), H1Word98.class);
                    startActivity(intent);

                }else if (position==98){
                    Intent intent = new Intent(getApplicationContext(), H1Word99.class);
                    startActivity(intent);

                }else if (position==99){
                    Intent intent = new Intent(getApplicationContext(), H1Word100.class);
                    startActivity(intent);

                }else if (position==100){
                    Intent intent = new Intent(getApplicationContext(), H1Word101.class);
                    startActivity(intent);

                }else if (position==101){
                    Intent intent = new Intent(getApplicationContext(), H1Word102.class);
                    startActivity(intent);

                }else if (position==102){
                    Intent intent = new Intent(getApplicationContext(), H1Word103.class);
                    startActivity(intent);

                }else if (position==103){
                    Intent intent = new Intent(getApplicationContext(), H1Word104.class);
                    startActivity(intent);

                }else if (position==104){
                    Intent intent = new Intent(getApplicationContext(), H1Word105.class);
                    startActivity(intent);

                }else if (position==105){
                    Intent intent = new Intent(getApplicationContext(), H1Word106.class);
                    startActivity(intent);

                }else if (position==106){
                    Intent intent = new Intent(getApplicationContext(), H1Word107.class);
                    startActivity(intent);

                }else if (position==107){
                    Intent intent = new Intent(getApplicationContext(), H1Word108.class);
                    startActivity(intent);

                }else if (position==108){
                    Intent intent = new Intent(getApplicationContext(), H1Word109.class);
                    startActivity(intent);

                }else if (position==109){
                    Intent intent = new Intent(getApplicationContext(), H1Word110.class);
                    startActivity(intent);

                }else if (position==110){
                    Intent intent = new Intent(getApplicationContext(), H1Word111.class);
                    startActivity(intent);

                }else if (position==111){
                    Intent intent = new Intent(getApplicationContext(), H1Word112.class);
                    startActivity(intent);

                }else if (position==1112){
                    Intent intent = new Intent(getApplicationContext(), H1Word113.class);
                    startActivity(intent);

                }else if (position==113){
                    Intent intent = new Intent(getApplicationContext(), H1Word114.class);
                    startActivity(intent);

                }else if (position==114){
                    Intent intent = new Intent(getApplicationContext(), H1Word115.class);
                    startActivity(intent);

                }else if (position==115){
                    Intent intent = new Intent(getApplicationContext(), H1Word116.class);
                    startActivity(intent);

                }else if (position==116){
                    Intent intent = new Intent(getApplicationContext(), H1Word117.class);
                    startActivity(intent);

                }else if (position==117){
                    Intent intent = new Intent(getApplicationContext(), H1Word118.class);
                    startActivity(intent);

                }else if (position==118){
                    Intent intent = new Intent(getApplicationContext(), H1Word119.class);
                    startActivity(intent);

                }else if (position==119){
                    Intent intent = new Intent(getApplicationContext(), H1Word120.class);
                    startActivity(intent);

                }else if (position==120){
                    Intent intent = new Intent(getApplicationContext(), H1Word121.class);
                    startActivity(intent);

                }else if (position==121){
                    Intent intent = new Intent(getApplicationContext(), H1Word122.class);
                    startActivity(intent);

                }else if (position==122){
                    Intent intent = new Intent(getApplicationContext(), H1Word123.class);
                    startActivity(intent);

                }else if (position==123){
                    Intent intent = new Intent(getApplicationContext(), H1Word124.class);
                    startActivity(intent);

                }else if (position==124){
                    Intent intent = new Intent(getApplicationContext(), H1Word125.class);
                    startActivity(intent);

                }else if (position==125){
                    Intent intent = new Intent(getApplicationContext(), H1Word126.class);
                    startActivity(intent);

                }else if (position==126){
                    Intent intent = new Intent(getApplicationContext(), H1Word127.class);
                    startActivity(intent);

                }else if (position==127){
                    Intent intent = new Intent(getApplicationContext(), H1Word128.class);
                    startActivity(intent);

                }else if (position==128){
                    Intent intent = new Intent(getApplicationContext(), H1Word129.class);
                    startActivity(intent);

                }else if (position==129){
                    Intent intent = new Intent(getApplicationContext(), H1Word130.class);
                    startActivity(intent);

                }else if (position==130){
                    Intent intent = new Intent(getApplicationContext(), H1Word131.class);
                    startActivity(intent);

                }else if (position==131){
                    Intent intent = new Intent(getApplicationContext(), H1Word132.class);
                    startActivity(intent);

                }else if (position==132){
                    Intent intent = new Intent(getApplicationContext(), H1Word133.class);
                    startActivity(intent);

                }else if (position==133){
                    Intent intent = new Intent(getApplicationContext(), H1Word134.class);
                    startActivity(intent);

                }else if (position==134){
                    Intent intent = new Intent(getApplicationContext(), H1Word135.class);
                    startActivity(intent);

                }else if (position==135){
                    Intent intent = new Intent(getApplicationContext(), H1Word136.class);
                    startActivity(intent);

                }else if (position==136){
                    Intent intent = new Intent(getApplicationContext(), H1Word137.class);
                    startActivity(intent);

                }else if (position==137){
                    Intent intent = new Intent(getApplicationContext(), H1Word138.class);
                    startActivity(intent);

                }else if (position==138){
                    Intent intent = new Intent(getApplicationContext(), H1Word139.class);
                    startActivity(intent);

                }else if (position==139){
                    Intent intent = new Intent(getApplicationContext(), H1Word140.class);
                    startActivity(intent);

                }else if (position==140){
                    Intent intent = new Intent(getApplicationContext(), H1Word141.class);
                    startActivity(intent);

                }else if (position==141){
                    Intent intent = new Intent(getApplicationContext(), H1Word142.class);
                    startActivity(intent);

                }else if (position==142){
                    Intent intent = new Intent(getApplicationContext(), H1Word143.class);
                    startActivity(intent);

                }else if (position==143){
                    Intent intent = new Intent(getApplicationContext(), H1Word144.class);
                    startActivity(intent);

                }else if (position==144){
                    Intent intent = new Intent(getApplicationContext(), H1Word145.class);
                    startActivity(intent);

                }else if (position==145){
                    Intent intent = new Intent(getApplicationContext(), H1Word146.class);
                    startActivity(intent);

                }else if (position==146){
                    Intent intent = new Intent(getApplicationContext(), H1Word147.class);
                    startActivity(intent);

                }else if (position==147){
                    Intent intent = new Intent(getApplicationContext(), H1Word148.class);
                    startActivity(intent);

                }else if (position==148){
                    Intent intent = new Intent(getApplicationContext(), H1Word149.class);
                    startActivity(intent);

                }else if (position==149){
                    Intent intent = new Intent(getApplicationContext(), H1Word150.class);
                    startActivity(intent);

                }else if (position==150){
                    Intent intent = new Intent(getApplicationContext(), H1Word151.class);
                    startActivity(intent);

                }else if (position==151){
                    Intent intent = new Intent(getApplicationContext(), H1Word152.class);
                    startActivity(intent);

                }

            }
        });

    }

}