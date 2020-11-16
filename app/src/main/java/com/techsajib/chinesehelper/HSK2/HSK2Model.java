package com.techsajib.chinesehelper.HSK2;

public class HSK2Model {
    String Chinese2;
    String Pinyin2;
    String Explain2;

    public HSK2Model(String chinese2, String pinyin2, String explain2) {
        Chinese2 = chinese2;
        Pinyin2 = pinyin2;
        Explain2 = explain2;
    }

    public String getChinese2() {
        return Chinese2;
    }

    public void setChinese2(String chinese2) {
        Chinese2 = chinese2;
    }

    public String getPinyin2() {
        return Pinyin2;
    }

    public void setPinyin2(String pinyin2) {
        Pinyin2 = pinyin2;
    }

    public String getExplain2() {
        return Explain2;
    }

    public void setExplain2(String explain2) {
        Explain2 = explain2;
    }
}
