package com.techsajib.chinesehelper.HSK1;

public class HSK1Model {
    String Chinese;
    String Pinyin;
    String Explain;
    int Image;

    public HSK1Model(String chinese, String pinyin, String explain, int image) {
        Chinese = chinese;
        Pinyin = pinyin;
        Explain = explain;
        Image = image;
    }

    public String getChinese() {
        return Chinese;
    }

    public void setChinese(String chinese) {
        Chinese = chinese;
    }

    public String getPinyin() {
        return Pinyin;
    }

    public void setPinyin(String pinyin) {
        Pinyin = pinyin;
    }

    public String getExplain() {
        return Explain;
    }

    public void setExplain(String explain) {
        Explain = explain;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
