package com.techsajib.chinesehelper.HSK2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;

import com.techsajib.chinesehelper.HSK1.HSK1Adapter;
import com.techsajib.chinesehelper.HSK1.HSK1Model;
import com.techsajib.chinesehelper.R;

import java.util.ArrayList;

public class HSK2ListView extends AppCompatActivity {

    ListView listView;
    HSK2Adapter hsk2Adapter;
    ArrayList<HSK2Model> item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hsk2_listview);

        // for HSK1 Toolbar settings here
        Toolbar toolbar = findViewById(R.id.hsk2_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for listview section
        listView = findViewById(R.id.hsk2ListView);

        //CREATING DATA FOR LISTVIEW
        //Personal Pronoun
        item.add(new HSK2Model("我","wǒ","I, me"));   //WORD-1
        item.add(new HSK2Model("我们","wǒmen","we, us"));  //WORD-2
        item.add(new HSK2Model("你","nǐ","you (singular)"));  //WORD-3
        item.add(new HSK2Model("你们","nǐmen","you (plural)"));    //WORD-4
        item.add(new HSK2Model("您","nín","you (politely)"));  //WORD-3
        item.add(new HSK2Model("他","tā","he, him")); //WORD-5
        item.add(new HSK2Model("她","tā","she, her"));    //WORD-6
        item.add(new HSK2Model("他们","tāmen","they (male, plural)")); //WORD-7
        item.add(new HSK2Model("她们","tāmen","they (female, plural)"));   //WORD-8
        //Demonstrative Pronoun
        item.add(new HSK2Model("这/这儿","zhè/zhèr","this/here"));   //WORD-9
        item.add(new HSK2Model("那/那儿","nà/nàr","that/there"));   //WORD-10
        //Interrogative Pronoun
        item.add(new HSK2Model("哪/哪儿","nǎ/nǎr","which/where"));  //WORD-11
        item.add(new HSK2Model("谁","shéi","who, whose"));   //WORD-12
        item.add(new HSK2Model("什么","shénme","what"));   //WORD-13
        item.add(new HSK2Model("多少","duōshǎo","how many, how much")); //WORD-14
        item.add(new HSK2Model("几","jǐ","a few, how many")); //WORD-14
        item.add(new HSK2Model("怎么","zěnme","how")); //WORD-15
        item.add(new HSK2Model("怎么样","zěnme yàng","how about")); //WORD-16
        item.add(new HSK2Model("它","tā","it"));
        item.add(new HSK2Model("大家","dàjiā","everyone"));
        item.add(new HSK2Model("每","měi","every, each, per"));
        item.add(new HSK2Model("为什么","wèishénme","why"));
        //Adjective
        item.add(new HSK2Model("好","hǎo","good, fine, ok")); //WORD-41
        item.add(new HSK2Model("大","dà","big, large"));  //WORD-42
        item.add(new HSK2Model("小","xiǎo","small, few"));    //WORD-43
        item.add(new HSK2Model("多少","duōshǎo","how many, how much"));     //WORD-44
        item.add(new HSK2Model("冷","lěng","cold"));  //WORD-45
        item.add(new HSK2Model("热","rè","hot")); //WORD-46
        item.add(new HSK2Model("高兴","gāoxìng","happy, glad"));  //WORD-47
        item.add(new HSK2Model("漂亮","piàoliàng","beautiful, pretty"));   //WORD-48
        item.add(new HSK2Model("高","gāo","tall"));
        item.add(new HSK2Model("红","hóng","red"));
        item.add(new HSK2Model("白","bái","white"));
        item.add(new HSK2Model("黑","hēi","black"));
        item.add(new HSK2Model("忙","máng","busy"));
        item.add(new HSK2Model("快","kuài","fast"));
        item.add(new HSK2Model("慢","màn","slow"));
        item.add(new HSK2Model("远","yuǎn","far"));
        item.add(new HSK2Model("近","jìn","close"));
        item.add(new HSK2Model("好吃","hǎochī","delicioous"));
        item.add(new HSK2Model("累","lèi","tired"));
        item.add(new HSK2Model("长","cháng","long"));
        item.add(new HSK2Model("新","xīn","new"));
        item.add(new HSK2Model("贵","guì","expensive"));
        item.add(new HSK2Model("便宜","piányi","cheap"));
        item.add(new HSK2Model("晴","qíng","fine"));
        item.add(new HSK2Model("阴","yīn","cloudy"));
        item.add(new HSK2Model("错","cuò","wrong"));
        item.add(new HSK2Model("快乐","kuàilè","happy"));
        //Numberal
        item.add(new HSK2Model("数词","shù cí","NUMERALS"));   //WORD-17   no-page
        item.add(new HSK2Model("零","líng","0 (zero)"));  //WORD-28   no-page
        item.add(new HSK2Model("一","yī","1 (one)")); //WORD-18
        item.add(new HSK2Model("二/两","èr/liǎng","2 (two)")); //WORD-19
        item.add(new HSK2Model("三","sān","3 (three)"));  //WORD-20
        item.add(new HSK2Model("四","sì","4 (four)"));    //WORD-21
        item.add(new HSK2Model("五","wǔ","5 (five)"));    //WORD-22
        item.add(new HSK2Model("六","liù","6 (six)"));    //WORD-23
        item.add(new HSK2Model("七","qī","7 (seven)"));   //WORD-24
        item.add(new HSK2Model("八","bā","8 (eight)"));   //WORD-25
        item.add(new HSK2Model("九","jiǔ","9 (nine)"));   //WORD-26
        item.add(new HSK2Model("十","shí","10 (ten)"));   //WORD-27
        item.add(new HSK2Model("两","liǎng","2, (two, both)"));
        item.add(new HSK2Model("百","bǎi","100, hundred"));
        item.add(new HSK2Model("千","qiān","1000, thousand"));
        item.add(new HSK2Model("第一","dì yī","1st, first"));
        item.add(new HSK2Model("第二","dì èr","2nd, second"));
        item.add(new HSK2Model("第三","dì sān","3rd, third"));
        //Quantifier
        item.add(new HSK2Model("个","gè","one, a, an (general measure word)"));   //WORD-29
        item.add(new HSK2Model("岁","suì","year (of age)"));  //WORD-30
        item.add(new HSK2Model("本","běn","A measure word for books | origin, roots "));  //WORD-31
        item.add(new HSK2Model("些","xiē","some, few, several")); //WORD-32
        item.add(new HSK2Model("块","kuài","piece, A unit of Chinese money"));    //WORD-33
        item.add(new HSK2Model("次","cì","number"));
        item.add(new HSK2Model("公斤","gōngjīn","1kg, kilogram"));
        item.add(new HSK2Model("元","yuán","yuan, A unit of Chinese money"));
        item.add(new HSK2Model("件","jiàn","piece, item, measure word for a piece"));
        item.add(new HSK2Model("张","zhāng","sheet"));
        //Adverb
        item.add(new HSK2Model("不","bù","no, not")); //WORD-34
        item.add(new HSK2Model("没","méi","no, not"));    //WORD-35
        item.add(new HSK2Model("很","hěn","very"));   //WORD-36
        item.add(new HSK2Model("太","tài","too, extremely")); //WORD-37
        item.add(new HSK2Model("都","dōu","all, both"));  //WORD-38
        item.add(new HSK2Model("别","bié","do not, other, another"));
        item.add(new HSK2Model("非常","fēicháng","very much, extremely, most"));
        item.add(new HSK2Model("也","yě","also, likewise"));
        item.add(new HSK2Model("还","hái","still, yet"));
        item.add(new HSK2Model("最","zuì","most"));
        item.add(new HSK2Model("真","zhēn","real, true"));
        item.add(new HSK2Model("正在","zhèngzài","be being"));
        item.add(new HSK2Model("已经","yǐjīng","already"));
        item.add(new HSK2Model("一起","yìqǐ","together"));
        item.add(new HSK2Model("再","zài","again"));
        item.add(new HSK2Model("就","jiǜ","at once"));
        //Conjunction
        item.add(new HSK2Model("和","hé","and")); //WORD-39
        item.add(new HSK2Model("因为","yīnwèi","because"));
        item.add(new HSK2Model("所以","suǒyǐ","so"));
        item.add(new HSK2Model("但是","dànshì","but"));
        //Preposition
        item.add(new HSK2Model("在","zài","in, at, on")); //WORD-40
        item.add(new HSK2Model("从","cóng","from"));
        item.add(new HSK2Model("对","duì","yes, right, correct"));
        item.add(new HSK2Model("此","cǐ","this"));
        item.add(new HSK2Model("向","xiàng","to, towards"));
        item.add(new HSK2Model("离","lí","leave"));
        //Auxilary
        item.add(new HSK2Model("的","de","used after an attribute, possessive particle"));    //WORD-49
        item.add(new HSK2Model("了","le","particle for new situation or completed action"));  //WORD-50
        item.add(new HSK2Model("吗","ma","question particle"));   //WORD-51
        item.add(new HSK2Model("呢","ne","modal particle ending a question"));    //WORD-52
        item.add(new HSK2Model("得","dé","particle showing degree, particle showing possibility"));
        item.add(new HSK2Model("着","zhe","with"));
        item.add(new HSK2Model("过","guò","cross, pass, spend, after"));
        item.add(new HSK2Model("吧","ba","a particle that goes on the end of a sentence"));
        item.add(new HSK2Model("喂","wèi","hey, hello")); //WORD-53
        //noun
        item.add(new HSK2Model("家","jiā","home, family, household"));    //WORD-54
        item.add(new HSK2Model("学校","xuéxiào","school"));   //WORD-55
        item.add(new HSK2Model("饭店","fàndiàn","restaurant"));   //WORD-56
        item.add(new HSK2Model("商店","shāngdiàn","store, shop"));    //WORD-57
        item.add(new HSK2Model("医院","yīyuàn","hospital"));  //WORD-58
        item.add(new HSK2Model("火车站","huǒchēzhàn","train station, railway station"));  //WORD-59
        item.add(new HSK2Model("机场","jīchǎng","airport"));
        item.add(new HSK2Model("中国","zhōngguó","China, Middle kingdom"));   //WORD-60
        item.add(new HSK2Model("北京","běijīng","Beijing (capital of China)"));    //WORD-61
        item.add(new HSK2Model("教室","jiàoshì","classroom"));
        item.add(new HSK2Model("房间","fángjiān","room"));
        item.add(new HSK2Model("路","lù","road"));
        item.add(new HSK2Model("上","shàng","up, on, above"));  //WORD-62
        item.add(new HSK2Model("下","xià","down, under, below, next"));   //WORD-63
        item.add(new HSK2Model("前面","qiánmiàn","front"));   //WORD-64
        item.add(new HSK2Model("后面","hòumiàn","behind, back, rear"));   //WORD-65
        item.add(new HSK2Model("里面","lǐmiàn","inside, internal"));  //WORD-66
        item.add(new HSK2Model("左边","zuǒbiān","left"));
        item.add(new HSK2Model("右边","yòubiān","right"));
        item.add(new HSK2Model("旁边","pángbiān","side"));
        item.add(new HSK2Model("外","wài","out"));
        item.add(new HSK2Model("今天","jīntiān","today"));    //WORD-67
        item.add(new HSK2Model("明天","míngtiān","tomorrow"));    //WORD-68
        item.add(new HSK2Model("昨天","zuótiān","yesterday"));   //WORD-69
        item.add(new HSK2Model("上午","shàngwǔ","morning, AM")); //WORD-70
        item.add(new HSK2Model("中午","zhōngwǔ","noon, midday"));    //WORD-71
        item.add(new HSK2Model("下午","xiàwǔ","afternoon"));     //WORD-72
        item.add(new HSK2Model("年","nián","year")); //WORD-73
        item.add(new HSK2Model("月","yuè","month, moon")); //WORD-74
        item.add(new HSK2Model("日","rì","day, sun"));    //WORD-75
        item.add(new HSK2Model("星期","xīngqī","week")); //WORD-76
        item.add(new HSK2Model("点","diǎn","point, spot"));  //WORD-77
        item.add(new HSK2Model("分钟","fēnzhōng","minute")); //WORD-78
        item.add(new HSK2Model("现在","xiànzài","now, right now"));  //WORD-79
        item.add(new HSK2Model("时候","shíhou","time, moment"));   //WORD-80
        item.add(new HSK2Model("早上","zǎoshàng","morning"));
        item.add(new HSK2Model("晚上","wǎnshàng","night"));
        item.add(new HSK2Model("小时","xiǎoshí","hour"));
        item.add(new HSK2Model("时间","shíjiān","time"));
        item.add(new HSK2Model("去年","qùnián","last year"));
        item.add(new HSK2Model("号","hào","number"));
        item.add(new HSK2Model("生日","shēngrì","birthday"));
        item.add(new HSK2Model("爸爸","bàba","father, dad, papa"));   //WORD-81
        item.add(new HSK2Model("妈妈","māma","mother, mom, mommy"));   //WORD-82
        item.add(new HSK2Model("儿子","érzi","son")); //WORD-83
        item.add(new HSK2Model("女儿","nǚér","daughter"));    //WORD-84
        item.add(new HSK2Model("老师","lǎoshī","teacher"));   //WORD-85
        item.add(new HSK2Model("学生","xuéshēng","student")); //WORD-86
        item.add(new HSK2Model("同学","tóngxué","schoolmate, classmate"));    //WORD-87
        item.add(new HSK2Model("朋友","péngyǒu","friend"));   //WORD-88
        item.add(new HSK2Model("医生","yīshēng","doctor"));   //WORD-89
        item.add(new HSK2Model("先生","xiānsheng","sir, Mr."));   //WORD-90
        item.add(new HSK2Model("小姐","xiǎojiě","Miss, Mrs."));   //WORD-91
        item.add(new HSK2Model("哥哥","gēge","older brother"));
        item.add(new HSK2Model("姐姐","jiějie","older sister"));
        item.add(new HSK2Model("弟弟","dìdi","younger brother"));
        item.add(new HSK2Model("妹妹","mèimei","younger sister"));
        item.add(new HSK2Model("丈夫","zhàngfu","husband"));
        item.add(new HSK2Model("妻子","qīzi","wife"));
        item.add(new HSK2Model("孩子","háizi","child"));
        item.add(new HSK2Model("男人","nánrén","man"));
        item.add(new HSK2Model("女人","nǚrén","woman"));
        item.add(new HSK2Model("服务员","fúwùyuán","waiter"));
        item.add(new HSK2Model("衣服","yīfu","clothes")); //WORD-92
        item.add(new HSK2Model("水","shuǐ","water"));    //WORD-93
        item.add(new HSK2Model("菜","cài","food, dish"));    //WORD-94
        item.add(new HSK2Model("米饭","mǐfàn","cooked rice"));    //WORD-95
        item.add(new HSK2Model("水果","shuǐguǒ","fruits"));   //WORD-96
        item.add(new HSK2Model("苹果","píngguǒ","apple"));    //WORD-97
        item.add(new HSK2Model("茶","chá","tea"));   //WORD-98
        item.add(new HSK2Model("杯子","bēizi","cup, glass")); //WORD-99
        item.add(new HSK2Model("钱","qián","money"));
        item.add(new HSK2Model("飞机","fēijī","airplane"));
        item.add(new HSK2Model("出租车","chūzūchē","taxi, cab"));
        item.add(new HSK2Model("电视","diànshì","television, TV"));
        item.add(new HSK2Model("电脑","diànnǎo","computer"));
        item.add(new HSK2Model("电影","diànyǐng","movie"));
        item.add(new HSK2Model("天气","tiānqì","weather"));
        item.add(new HSK2Model("猫","māo","cat"));
        item.add(new HSK2Model("狗","gǒu","dog"));
        item.add(new HSK2Model("东西","dōngxi","thing"));
        item.add(new HSK2Model("鱼","yú","fish"));
        item.add(new HSK2Model("羊肉","yángròu","mutton"));
        item.add(new HSK2Model("牛奶","niúnǎi","milk"));
        item.add(new HSK2Model("鸡蛋","jīdàn","egg"));
        item.add(new HSK2Model("西瓜","xīguā","watermelon"));
        item.add(new HSK2Model("咖啡","kāfēi","coffee"));
        item.add(new HSK2Model("自行车","zìxíngchē","bike"));
        item.add(new HSK2Model("船","chuán","boat"));
        item.add(new HSK2Model("雪","xué","snow"));
        item.add(new HSK2Model("药","yào","medicine"));
        item.add(new HSK2Model("手机","shǒujī","phone"));
        item.add(new HSK2Model("手表","shǒubiǎo","hand watch"));
        item.add(new HSK2Model("眼睛","yǎnjīng","eye"));
        item.add(new HSK2Model("身体","shēntǐ","body"));
        item.add(new HSK2Model("公共汽车","gōnggòngqìchē","bus"));
        item.add(new HSK2Model("报纸","bàozhǐ","newspaper"));
        item.add(new HSK2Model("人","rén","person"));
        item.add(new HSK2Model("名字","míngzi","name"));
        item.add(new HSK2Model("书","shū","book"));
        item.add(new HSK2Model("汉语","hànyǔ","Mandarin, Chinese language"));
        item.add(new HSK2Model("字","zì","character, word, symbol"));
        item.add(new HSK2Model("桌子","zhuōzi","desk, table"));
        item.add(new HSK2Model("椅子","yǐzi","chair"));
        item.add(new HSK2Model("门","mén","door"));
        item.add(new HSK2Model("题","tí","topic"));
        item.add(new HSK2Model("课","kè","lesson"));
        item.add(new HSK2Model("姓","xìng","surname"));
        item.add(new HSK2Model("问题","wèntí","question"));
        item.add(new HSK2Model("事情","shìqing","matter"));
        item.add(new HSK2Model("考试","kǎoshì","exam"));
        item.add(new HSK2Model("票","piào","ticket"));
        item.add(new HSK2Model("意思","yìsi","meaning"));
        item.add(new HSK2Model("颜色","yánsè","color"));
        item.add(new HSK2Model("谢谢","xièxie","thanks, appreciate"));    //WORD-117
        item.add(new HSK2Model("不客气","búkèqì","you're welcome, don't mention it"));   //WORD-118
        item.add(new HSK2Model("再见","zàijiàn","goodbye"));  //WORD-119
        item.add(new HSK2Model("请","qǐng","please, politely request"));    //WORD-120
        item.add(new HSK2Model("对不起","duìbùqǐ","sorry"));   //WORD-121
        item.add(new HSK2Model("没关系","méiguānxì","It doesn’t matter, It's ok, That's nothing"));  //WORD-122
        item.add(new HSK2Model("是","shì","to be (am, is, are)"));   //WORD-123
        item.add(new HSK2Model("有","yǒu","have"));  //WORD-124
        item.add(new HSK2Model("看","kàn","to look, to watch")); //WORD-125
        item.add(new HSK2Model("听","tīng","to listen"));    //WORD-126
        item.add(new HSK2Model("说话","shuōhuà","speak, say"));   //WORD-127
        item.add(new HSK2Model("读","dú","read"));   //WORD-128
        item.add(new HSK2Model("写","xiě","write")); //WORD-129
        item.add(new HSK2Model("看见","kànjiàn","to see"));   //WORD-130
        item.add(new HSK2Model("叫","jiào","to call"));  //WORD-131
        item.add(new HSK2Model("来","lái","come"));  //WORD-132
        item.add(new HSK2Model("回","huí","back, return"));  //WORD-133
        item.add(new HSK2Model("去","qù","to go,  just passed")); //WORD-134
        item.add(new HSK2Model("吃","chī","to eat"));   //WORD-135
        item.add(new HSK2Model("喝","hē","to drink"));   //WORD-136
        item.add(new HSK2Model("睡觉","shuìjiào","go to sleep")); //WORD-137
        item.add(new HSK2Model("打电话","dǎ diànhuà","call up, make a telephone call")); //WORD-138
        item.add(new HSK2Model("做","zuò","to do, to make"));    //WORD-139
        item.add(new HSK2Model("买","mǎi","buy, purchase"));  //WORD-140
        item.add(new HSK2Model("开","kāi","to open, to drive, to start, to turn on, to boil"));    //WORD-141
        item.add(new HSK2Model("坐","zuò","to sit, to take a seat"));   //WORD-142
        item.add(new HSK2Model("住","zhù","live, stay"));    //WORD-143
        item.add(new HSK2Model("学习","xuéxí","study, learn, gain knowledge"));    //WORD-144
        item.add(new HSK2Model("工作","gōngzuò","job, work, task"));    //WORD-145
        item.add(new HSK2Model("下雨","xiàyǔ","rain"));   //WORD-146
        item.add(new HSK2Model("问","wèn","to ask"));
        item.add(new HSK2Model("走","zǒu","to walk, to go, to run, to leave"));
        item.add(new HSK2Model("进","jìn","enter, come in, get in, take in"));
        item.add(new HSK2Model("出","chū","come out, go out, turn out,  to occur"));
        item.add(new HSK2Model("跑步","pǎobù","run, jogging, march"));
        item.add(new HSK2Model("到","dào","to arrive"));
        item.add(new HSK2Model("穿","chuān","wear, put on"));
        item.add(new HSK2Model("洗","xǐ","wash, to bathe"));
        item.add(new HSK2Model("给","gěi","give"));
        item.add(new HSK2Model("找","zhǎo","find, seek, looking for, want to see"));
        item.add(new HSK2Model("懂","dǒng","understand"));
        item.add(new HSK2Model("笑","xiào","smile, laugh"));
        item.add(new HSK2Model("回答","huídá","answer, reply"));
        item.add(new HSK2Model("告诉","gàosù","tell, inform"));
        item.add(new HSK2Model("准备","zhǔnbèi","prepare, ready"));
        item.add(new HSK2Model("开始","kāishǐ","begin, start"));
        item.add(new HSK2Model("介绍","jièshào","introduce"));
        item.add(new HSK2Model("帮助","bāngzhù","help"));
        item.add(new HSK2Model("玩","wán","play"));
        item.add(new HSK2Model("送","sòng","to present, to deliver, to carry"));
        item.add(new HSK2Model("等","děng","wait"));
        item.add(new HSK2Model("让","ràng","let"));
        item.add(new HSK2Model("起床","qǐchuáng","get up"));
        item.add(new HSK2Model("唱歌","chànggē","sing"));
        item.add(new HSK2Model("跳舞","tiàowǔ","dance"));
        item.add(new HSK2Model("旅游","lǚyóu","travel"));
        item.add(new HSK2Model("上班","shàngbān","be on duty"));
        item.add(new HSK2Model("生病","shēngbìng","fall ill"));
        item.add(new HSK2Model("休息","xiūxi","rest, break"));
        item.add(new HSK2Model("运动","yùndòng","exercise"));
        item.add(new HSK2Model("游泳","yóuyǒng","swim"));
        item.add(new HSK2Model("踢足球","tīzúqiú","play footbal"));
        item.add(new HSK2Model("打篮球","dǎlánqiú","play basketball"));
        item.add(new HSK2Model("完","wán","finish"));
        item.add(new HSK2Model("爱","ài","love, affection, be fond of"));    //WORD-147
        item.add(new HSK2Model("喜欢","xǐhuān","like, love"));    //WORD-148
        item.add(new HSK2Model("想","xiǎng","to want, to wish, would like"));    //WORD-149
        item.add(new HSK2Model("认识","rènshi","to know"));   //WORD-150
        item.add(new HSK2Model("觉得","juédé","to think, to feel"));
        item.add(new HSK2Model("知道","zhīdào","know"));
        item.add(new HSK2Model("希望","xīwàng","hope"));
        item.add(new HSK2Model("可以","kěyǐ","can, be able to"));
        item.add(new HSK2Model("要","yào","ask to do, want"));
        item.add(new HSK2Model("可能","kěnéng","may, possible"));
        item.add(new HSK2Model("会","huì","can, be able to, to be possible"));    //WORD-151
        item.add(new HSK2Model("能","néng","can, may, capable")); //WORD-152


        // custom adapter declaration
        hsk2Adapter = new HSK2Adapter(this, R.layout.hsk2_listview_row, item);
        listView.setAdapter(hsk2Adapter);
    }
}