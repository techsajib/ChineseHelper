package com.techsajib.chinesehelper.HSK3;

public class HSK3Model {
    String Chinese3;
    String Pinyin3;
    String Explain3;

    public HSK3Model(String chinese3, String pinyin3, String explain3) {
        Chinese3 = chinese3;
        Pinyin3 = pinyin3;
        Explain3 = explain3;
    }

    public String getChinese3() {
        return Chinese3;
    }

    public void setChinese3(String chinese3) {
        Chinese3 = chinese3;
    }

    public String getPinyin3() {
        return Pinyin3;
    }

    public void setPinyin3(String pinyin3) {
        Pinyin3 = pinyin3;
    }

    public String getExplain3() {
        return Explain3;
    }

    public void setExplain3(String explain3) {
        Explain3 = explain3;
    }
}
