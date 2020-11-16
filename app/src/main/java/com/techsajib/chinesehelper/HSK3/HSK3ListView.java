package com.techsajib.chinesehelper.HSK3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;

import com.techsajib.chinesehelper.R;

import java.util.ArrayList;

public class HSK3ListView extends AppCompatActivity {

    ListView listView;
    HSK3Adapter hsk3Adapter;
    ArrayList<HSK3Model> item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hsk3_listview);

        // for HSK1 Toolbar settings here
        Toolbar toolbar = findViewById(R.id.hsk3_toolbar);
        setSupportActionBar(toolbar);

        // for back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //for listview section
        listView = findViewById(R.id.hsk3ListView);

        //CREATING DATA FOR LISTVIEW
        //A category
        item.add(new HSK3Model("啊","a","modal particle ending sentence, showing affirmation, approval, or consent"));
        item.add(new HSK3Model("阿姨","āyí","aunt, step-mother, childcare worker, nursemaid"));
        item.add(new HSK3Model("矮","ǎi","short, low"));
        item.add(new HSK3Model("爱好","àihào","hobby, interest"));
        item.add(new HSK3Model("安静","ānjìng","quiet, peaceful, calm"));
        //b category
        item.add(new HSK3Model("把","bǎ","to hold, to put, to contain"));
        item.add(new HSK3Model("搬","bān","to move, to shift, to remove, to transport"));
        item.add(new HSK3Model("班","bān","team, class, squad"));
        item.add(new HSK3Model("办法","bànfǎ","method, way, means"));
        item.add(new HSK3Model("办公室","bàngōngshì","office, bureau"));
        item.add(new HSK3Model("半","bàn","half, semi-, incomplete"));
        item.add(new HSK3Model("帮忙","bāngmáng","help, give a hand, do a favor"));
        item.add(new HSK3Model("包","bāo","package, packet, pack, parcel"));
        item.add(new HSK3Model("饱","bǎo","full, satisfied, to eat till full"));
        item.add(new HSK3Model("北方","běifāng","north, northward, northern part a country"));
        item.add(new HSK3Model("被","bèi","by(indicates passive-voice sentences or clauses), quilt, to cover"));
        item.add(new HSK3Model("鼻子","bízi","nose"));
        item.add(new HSK3Model("比较","bǐjiào","compare, fairly, comparatively, contrast"));
        item.add(new HSK3Model("比赛","bǐsài","competition, contest, match"));
        item.add(new HSK3Model("笔记本","bǐjìběn","notebook, pocketbook"));
        item.add(new HSK3Model("必须","bìxū","must, compulsory, to have to"));
        item.add(new HSK3Model("变化","biànhuà","change, variation"));
        item.add(new HSK3Model("别人","biéren","others"));
        item.add(new HSK3Model("冰箱","bīngxiāng","refrigerator, fridge"));
        //C category
        item.add(new HSK3Model("菜单","càidān","menu, food menu"));
        item.add(new HSK3Model("参加","cānjiā","participate, join, take part"));
        item.add(new HSK3Model("草","cǎo","grass, manuscript, straw, draft"));
        item.add(new HSK3Model("层","céng","floor, layer, level"));
        item.add(new HSK3Model("差","chà","difference"));
        item.add(new HSK3Model("超市","chāoshì","supermarket"));
        item.add(new HSK3Model("衬衫","chènshān","shirt, blouse"));
        item.add(new HSK3Model("城市","chéngshì","city, town"));
        item.add(new HSK3Model("成绩","chéngjì","achievement, grades, performance record"));
        item.add(new HSK3Model("迟到","chídào","late, arrive late, come late"));
        item.add(new HSK3Model("除了","chúle","except, besides, apart from"));
        item.add(new HSK3Model("船","chuán","ship, boat, ferry"));
        item.add(new HSK3Model("春","chūn","spring"));
        item.add(new HSK3Model("词典","cí diǎn","dictionary"));
        item.add(new HSK3Model("聪明","cōngming","clever, intelligent, bright, smart"));
        //D category
        item.add(new HSK3Model("打扫","dǎsǎo","clean, sweep"));
        item.add(new HSK3Model("打算","dǎsuàn","to plan, to intend, to calculate"));
        item.add(new HSK3Model("带","dài","belt, band, ribbon, tire, area"));
        item.add(new HSK3Model("担心","dānxīn","worry, anxious, uneasy"));
        item.add(new HSK3Model("蛋糕","dàngāo","cake"));
        item.add(new HSK3Model("当然","dāngrán","of course, sure, certainly, without a doubt"));
        item.add(new HSK3Model("地","de","used before a verb or adjective, linking it to preceding modifying adverbial adjunct"));
        item.add(new HSK3Model("灯","dēng","lamp, light, valve"));
        item.add(new HSK3Model("地方","dìfāng","local, regional"));
        item.add(new HSK3Model("地铁","dìtiě","subway, metro"));
        item.add(new HSK3Model("地图","dìtú","map"));
        item.add(new HSK3Model("电梯","diàntī","elevator, lift"));
        item.add(new HSK3Model("电子邮","diànzǐ yóu","e-mail, electronic mail"));
        item.add(new HSK3Model("东","dōng","east, eastern, surname Dong"));
        item.add(new HSK3Model("冬","dōng","winter"));
        item.add(new HSK3Model("动物","dòngwù","animal"));
        item.add(new HSK3Model("短","duǎn","short or brief, to lack, weak point, fault"));
        item.add(new HSK3Model("段","duàn","paragraph, section, segment, stage"));
        item.add(new HSK3Model("锻炼","duànliàn","physical exercise, work out, do physical training"));
        item.add(new HSK3Model("多么","duōme","how (wonderful etc), what (a great idea etc), however"));
        //E category
        item.add(new HSK3Model("饿","è a","hungry"));
        item.add(new HSK3Model("耳朵","ěrduo","ear"));
        //F category
        item.add(new HSK3Model("发","fā","to send out, to issue, to show, "));
        item.add(new HSK3Model("发烧","fāshāo","fever, have a high temperature"));
        item.add(new HSK3Model("发现","fāxiàn","to find, to discover"));
        item.add(new HSK3Model("方便","fāngbiàn","convenient, suitable, to help out"));
        item.add(new HSK3Model("放","fàng","to release, to free, to let go"));
        item.add(new HSK3Model("放心","fàngxīn","don’t worry, take it easy"));
        item.add(new HSK3Model("分","fēn","branch, to divide, to separate"));
        item.add(new HSK3Model("复习","fùxí","review, to revise"));
        item.add(new HSK3Model("附近","fùjìn","nearby, neighboring, next to"));
        //G category
        item.add(new HSK3Model("干净","gānjìng","clean, neat and tidy"));
        item.add(new HSK3Model("感冒","gǎnmào","cold, to catch cold"));
        item.add(new HSK3Model("感兴趣","gǎn xìngqù","to be interested"));
        item.add(new HSK3Model("刚才","gāngcái","just now, a moment ago"));
        item.add(new HSK3Model("个子","gèzi","height, stature, build, size"));
        item.add(new HSK3Model("根据","gēnjù","according to, based on, foundation"));
        item.add(new HSK3Model("跟","gēn","with"));
        item.add(new HSK3Model("更","gèng","more, still more, even more"));
        item.add(new HSK3Model("公斤","gōngjīn","kilogram (kg)"));
        item.add(new HSK3Model("公园","gōngyuán","park, garden"));
        item.add(new HSK3Model("故事","gùshi","story, tale, narrative"));
        item.add(new HSK3Model("刮风","guāfēng","windy"));
        item.add(new HSK3Model("关","guān","to close, to shut, to turn off"));
        item.add(new HSK3Model("关系","guānxì","relationship"));
        item.add(new HSK3Model("关心","guānxīn","caring, concern, care"));
        item.add(new HSK3Model("关于","guānyú","about, pertaining to, with regards to"));
        item.add(new HSK3Model("国家","guójiā","country, state, nation"));
        item.add(new HSK3Model("过","guò","to cross, to go over, to pass"));
        item.add(new HSK3Model("过去","guòqù","past, former, previous"));
        //H category
        item.add(new HSK3Model("还是","háishì","still, nevertheless"));
        item.add(new HSK3Model("害怕","hàipà","to be afraid, to be scared"));
        item.add(new HSK3Model("黑板","hēibǎn","blackboard, chalkboard"));
        item.add(new HSK3Model("后来","hòulái","afterwards, later"));
        item.add(new HSK3Model("护照","hùzhào","passport, identification"));
        item.add(new HSK3Model("花","huā","flower, blossoms, pattern, design"));
        item.add(new HSK3Model("画","huà","painting, painting"));
        item.add(new HSK3Model("坏","huài","bad, spoiled, broken"));
        item.add(new HSK3Model("欢迎","huānyíng","welcome, greeting, reception"));
        item.add(new HSK3Model("环境","huánjìng","surroundings, environment, circumstances"));
        item.add(new HSK3Model("还","huán","to come back, to return"));
        item.add(new HSK3Model("换","huàn","change, exchange"));
        item.add(new HSK3Model("黄河","huánghé","yellow river"));
        item.add(new HSK3Model("回答","huídá","to reply, to answer"));
        item.add(new HSK3Model("会议","huìyì","meeting, conference, assembly"));
        item.add(new HSK3Model("或者","huòzhě","perhaps, possibly, maybe"));
        //J category
        item.add(new HSK3Model("几乎","jīhū","almost, nearly, practically"));
        item.add(new HSK3Model("机会","jīhuì","opportunity, chance"));
        item.add(new HSK3Model("极","jí","extremely, pole, mighty"));
        item.add(new HSK3Model("季节","jìjié","season, period"));
        item.add(new HSK3Model("记得","jìde","remember, keep in memory, bring to mind"));
        item.add(new HSK3Model("检查","jiǎnchá","inspection, examination"));
        item.add(new HSK3Model("简单","jiǎndān","simple, casual, common, uncomplicated"));
        item.add(new HSK3Model("健康","jiànkāng","health, healthy"));
        item.add(new HSK3Model("见面","jiànmiàn","meet, to see"));
        item.add(new HSK3Model("讲","jiǎng","to speak, to explain, to negotiate"));
        item.add(new HSK3Model("教","jiào","to teach"));
        item.add(new HSK3Model("脚","jiǎo","foot, leg, base, kick"));
        item.add(new HSK3Model("角","jiǎo","horn, angle, unit of money equal to 0.10 yuan"));
        item.add(new HSK3Model("接","jiē","to receive, to answer, to connect, to catch, to join"));
        item.add(new HSK3Model("街道","jiēdào","street"));
        item.add(new HSK3Model("结婚","jiéhūn","to marry, get married"));
        item.add(new HSK3Model("结束","jiéshù","to finish, to end, to conclude, to close"));
        item.add(new HSK3Model("节目","jiémù","program, show, programme"));
        item.add(new HSK3Model("节日","jiérì","festival, holiday"));
        item.add(new HSK3Model("解决","jiějué","solve, resolve, settle"));
        item.add(new HSK3Model("借","jiè","borrow, to lend, use as a pretext"));
        item.add(new HSK3Model("经常","jīngcháng","often, frequently, constantly, regularly"));
        item.add(new HSK3Model("经过","jīngguò","after, to pass, go through, "));
        item.add(new HSK3Model("经理","jīnglǐ","manager, director"));
        item.add(new HSK3Model("久","jiǔ","long"));
        item.add(new HSK3Model("旧","jiù","used, old, former, worn"));
        item.add(new HSK3Model("句子","jùzi","sentence"));
        item.add(new HSK3Model("决定","juédìng","decision"));
        //K category
        item.add(new HSK3Model("可爱","kě’ài","lovely, cute, gorgeous"));
        item.add(new HSK3Model("渴","kě","thirsty"));
        item.add(new HSK3Model("刻","kè","moment, to carve, classifier for short time intervals"));
        item.add(new HSK3Model("客人","kèrén","visitor, guest, passenger"));
        item.add(new HSK3Model("空调","kōngtiáo","air conditioner"));
        item.add(new HSK3Model("口","kǒu","mouth, classifier for things with mouths (people, domestic animals, cannons, wells etc)"));
        item.add(new HSK3Model("哭","kū","cry, weep"));
        item.add(new HSK3Model("裤子","kùzi","trousers, pants"));
        item.add(new HSK3Model("筷子","kuàizi","chopsticks"));
        //L category
        item.add(new HSK3Model("蓝","lán","blue"));
        item.add(new HSK3Model("老","lǎo","old, aged"));
        item.add(new HSK3Model("离开","líkāi","leave, depart"));
        item.add(new HSK3Model("礼物","lǐwù","gift"));
        item.add(new HSK3Model("历史","lìshǐ","history"));
        item.add(new HSK3Model("脸","liǎn","face"));
        item.add(new HSK3Model("练习","liànxí","exercise, practice"));
        item.add(new HSK3Model("辆","liàng","classifier for vehicles"));
        item.add(new HSK3Model("聊天","liáotiān","chat, gossip"));
        item.add(new HSK3Model("了解","liǎojiě","understand, realize, find out"));
        item.add(new HSK3Model("邻居","línjū","neighbor, next door"));
        item.add(new HSK3Model("留学","liúxué","study abroad"));
        item.add(new HSK3Model("楼","lóu","floor"));
        item.add(new HSK3Model("绿","lǜ","green"));
        //M category
        item.add(new HSK3Model("马","mǎ","horse"));
        item.add(new HSK3Model("马上","mǎshàng","right away, at once, straightway"));
        item.add(new HSK3Model("满意","mǎnyì","satisfied, pleased"));
        item.add(new HSK3Model("帽子","màozi","hat, cap"));
        item.add(new HSK3Model("米","mǐ","rice, meter (classifier)"));
        item.add(new HSK3Model("面包","miànbāo","bread"));
        item.add(new HSK3Model("明白","míngbai","to understand clearly"));
        //N category
        item.add(new HSK3Model("拿","ná","take, hold, seize, catch"));
        item.add(new HSK3Model("奶奶","nǎinai","grandma, father's mother"));
        item.add(new HSK3Model("南","nán","south"));
        item.add(new HSK3Model("难","nán","difficult, hard, disaster"));
        item.add(new HSK3Model("难过","nánguò","feel sorry"));
        item.add(new HSK3Model("年级","niánjí","grade"));
        item.add(new HSK3Model("年轻","niánqīng","young"));
        item.add(new HSK3Model("鸟","niǎo","bird"));
        item.add(new HSK3Model("努力","nǔlì","work hard, try hard, strive"));
        //P category
        item.add(new HSK3Model("爬山","páshān","to climb a mountain, hiking mountain"));
        item.add(new HSK3Model("盘子","pánzi","plate, tray, dish"));
        item.add(new HSK3Model("胖","pàng","fat"));
        item.add(new HSK3Model("啤酒","píjiǔ","beer"));
        item.add(new HSK3Model("皮鞋","píxié","leather shoes"));
        item.add(new HSK3Model("瓶子","píngzi","bottle"));
        //Q category
        item.add(new HSK3Model("其实","qíshí","actually, really, in fact"));
        item.add(new HSK3Model("其他","qítā","others"));
        item.add(new HSK3Model("奇怪","qíguài","strange, weird, odd"));
        item.add(new HSK3Model("骑","qí","to ride (an animal or bike)"));
        item.add(new HSK3Model("起飞","qǐ fēi","take off (in an airplane)"));
        item.add(new HSK3Model("起来","qǐ lái","beginning or continuing an action"));
        item.add(new HSK3Model("清楚","qīngchu","clear, clearly understood"));
        item.add(new HSK3Model("请假","qǐng jià","ask for time off"));
        item.add(new HSK3Model("秋","qiū","autumn, harvest time, surname Qiu"));
        item.add(new HSK3Model("裙子","qúnzi","skirt"));
        //R category
        item.add(new HSK3Model("然后","ránhòu","then, after"));
        item.add(new HSK3Model("热情","rèqíng","enthusiasm, cordial, passionate"));
        item.add(new HSK3Model("认为","rènwéi","to think, to believe, to consider, to feel"));
        item.add(new HSK3Model("认真","rènzhēn","earnest, conscientious, to take seriously"));
        item.add(new HSK3Model("容易","róngyì","easily, likely, liable"));
        item.add(new HSK3Model("如果","rúguǒ","if, in case"));
        //S category
        item.add(new HSK3Model("伞","sǎn","umbrella, parasol"));
        item.add(new HSK3Model("上网","shàngwǎng","surf the Internet, to be on the internet"));
        item.add(new HSK3Model("声音","shēngyīn","voice, sound"));
        item.add(new HSK3Model("生气","shēngqì","get angry, to take offense, offended"));
        item.add(new HSK3Model("世界","shìjiè","world"));
        item.add(new HSK3Model("试","shì","to test, to try, experiment"));
        item.add(new HSK3Model("瘦","shòu","thin, tight, lean"));
        item.add(new HSK3Model("叔叔","shūshu","uncle, father's younger brother"));
        item.add(new HSK3Model("舒服","shūfu","comfortable, feeling good"));
        item.add(new HSK3Model("数学","shùxué","mathematics"));
        item.add(new HSK3Model("树","shù","tree"));
        item.add(new HSK3Model("刷牙","shuāyá","to brush teeth"));
        item.add(new HSK3Model("双","shuāng","double, pair, two"));
        item.add(new HSK3Model("水平","shuǐpíng","level, standard"));
        item.add(new HSK3Model("司机","sījī","driver, chauffeur"));
        //T category
        item.add(new HSK3Model("太阳","tàiyáng","sunlight"));
        item.add(new HSK3Model("特别","tèbié","especially, special, particular"));
        item.add(new HSK3Model("疼","téng","hurts, pain, sore"));
        item.add(new HSK3Model("提高","tígāo","increase, raise"));
        item.add(new HSK3Model("体育","tǐyù","sports, physical education"));
        item.add(new HSK3Model("甜","tián","sweet"));
        item.add(new HSK3Model("条","tiáo","strip, item, article, clause"));
        item.add(new HSK3Model("同事","tóngshì","colleague, co-worker"));
        item.add(new HSK3Model("同意","tóngyì","to agree, to approve"));
        item.add(new HSK3Model("头发","tóufa","hair (on the head)"));
        item.add(new HSK3Model("突然","tūrán","suddenly, unexpected"));
        item.add(new HSK3Model("图书馆","túshūguǎn","library"));
        item.add(new HSK3Model("腿","tuǐ","leg"));
        //W category
        item.add(new HSK3Model("完成","wánchéng","complete, accomplish"));
        item.add(new HSK3Model("碗","wǎn","bowl"));
        item.add(new HSK3Model("万","wàn","ten thousand"));
        item.add(new HSK3Model("忘记","wàngjì","forget"));
        item.add(new HSK3Model("为","wèi","because of, for, by"));
        item.add(new HSK3Model("为了","wèile","in order to"));
        item.add(new HSK3Model("位","wèi","position, location, classifier for binary bits"));
        item.add(new HSK3Model("文化","wénhuà","culture, civilization"));
        //X category
        item.add(new HSK3Model("西","xī","west"));
        item.add(new HSK3Model("习惯","xíguàn","habit, usual practice, to be used to"));
        item.add(new HSK3Model("洗手间","xǐ shǒu jiān","restroom, toilet, washroom"));
        item.add(new HSK3Model("洗澡","xǐzǎo","to bathe, to take a shower"));
        item.add(new HSK3Model("夏","xià","summer"));
        item.add(new HSK3Model("先","xiān","before, early, former, prior"));
        item.add(new HSK3Model("相信","xiāngxìn","believe, to be convinced"));
        item.add(new HSK3Model("香蕉","xiāng jiāo","banana"));
        item.add(new HSK3Model("像","xiàng","appearance, to appear, to seem, image"));
        item.add(new HSK3Model("向","xiàng","direction, orientation, towards"));
        item.add(new HSK3Model("小心","xiǎoxīn","to be careful, to take care"));
        item.add(new HSK3Model("校长","xiàozhǎng","president(college, university), principal, headmaster"));
        item.add(new HSK3Model("新闻","xīnwén","news, journalism"));
        item.add(new HSK3Model("新鲜","xīnxiān","fresh"));
        item.add(new HSK3Model("信用卡","xìn yòng kǎ","credit card"));
        item.add(new HSK3Model("行李箱","xínglixiāng","suitcase, trunk"));
        item.add(new HSK3Model("熊猫","xióngmāo","panda"));
        item.add(new HSK3Model("需要","xūyào","to need, to want, to demand"));
        item.add(new HSK3Model("选择","xuǎnzé","to select, to pick, choice, option"));
        //Y category
        item.add(new HSK3Model("要求","yāoqiú","requirement"));
        item.add(new HSK3Model("爷爷","yéye","grandpa, father's father"));
        item.add(new HSK3Model("一直","yìzhí","straight, continuously, always"));
        item.add(new HSK3Model("一定","yídìng","surely, certainly, necessarily"));
        item.add(new HSK3Model("一共","yígòng","altogether"));
        item.add(new HSK3Model("一会儿","yíhuìr","a while"));
        item.add(new HSK3Model("一样","yíyàng","equal, same"));
        item.add(new HSK3Model("以前","yǐqián","before, formerly"));
        item.add(new HSK3Model("一般","yìbān","general, common, ordinary"));
        item.add(new HSK3Model("一边","yìbiān","one side"));
        item.add(new HSK3Model("音乐","yīnyuè","music"));
        item.add(new HSK3Model("银行","yínháng","bank"));
        item.add(new HSK3Model("饮料","yǐn liào","drink, beverage"));
        item.add(new HSK3Model("应该","yīnggāi","should, must"));
        item.add(new HSK3Model("影响","yǐngxiǎng","influence, effect"));
        item.add(new HSK3Model("用","yòng","to use, to employ"));
        item.add(new HSK3Model("游戏","yóuxì","game"));
        item.add(new HSK3Model("有名","yǒumíng","famous, celebrity, well-known"));
        item.add(new HSK3Model("又","yòu","also, again"));
        item.add(new HSK3Model("遇到","yùdào","to meet, to run into, to come across"));
        item.add(new HSK3Model("元","yuán","Yuan (RMB)"));
        item.add(new HSK3Model("愿意","yuànyì","to wish, to want, be willing"));
        item.add(new HSK3Model("月亮","yuèliang","moon"));
        item.add(new HSK3Model("越","yuè","to exceed, to climb over, the more"));
        //Z category
        item.add(new HSK3Model("站","zhàn","station, branch of a company or organisation"));
        item.add(new HSK3Model("张","zhāng","sheet, classifier for flat objects"));
        item.add(new HSK3Model("长","zhǎng","elder, senior, to grow"));
        item.add(new HSK3Model("着急","zháojí","to worry, to feel anxious"));
        item.add(new HSK3Model("照顾","zhàogù","to take care of, to look after, to show consideration"));
        item.add(new HSK3Model("照片","zhàopiàn","photo, image, photograph"));
        item.add(new HSK3Model("照相机","zhàoxiàngjī","camera"));
        item.add(new HSK3Model("只","zhǐ","only, just, one-only, single"));
        item.add(new HSK3Model("中间","zhōngjiān","middle, intermediate, between"));
        item.add(new HSK3Model("中文","zhōngwén","chinese language"));
        item.add(new HSK3Model("终于","zhōngyú","finally, at last, in the end"));
        item.add(new HSK3Model("种","zhǒng","kind, sort, type"));
        item.add(new HSK3Model("重要","zhòngyào","important, significant"));
        item.add(new HSK3Model("周末","zhōumò","weekend"));
        item.add(new HSK3Model("主要","zhǔyào","main, principal, major, primary"));
        item.add(new HSK3Model("注意","zhùyì","to take note of, to pay attention to"));
        item.add(new HSK3Model("自己","zìjǐ","self, own"));
        item.add(new HSK3Model("自行车","zìxíngchē","bicycle"));
        item.add(new HSK3Model("总是","zǒngshì","always"));
        item.add(new HSK3Model("嘴","zuǐ","mouth"));
        item.add(new HSK3Model("最后","zuìhòu","final, at last, ultimate"));
        item.add(new HSK3Model("最近","zuìjìn","recently, latest"));
        item.add(new HSK3Model("作业","zuòyè","task, assignment, homework"));


        hsk3Adapter = new HSK3Adapter(this, R.layout.hsk3_listview_row, item);
        listView.setAdapter(hsk3Adapter);
    }
}