package com.techsajib.chinesehelper.HSK4;

public class HSK4Model {
    String Chinese4;
    String Pinyin4;
    String Explain4;

    public HSK4Model(String chinese4, String pinyin4, String explain4) {
        Chinese4 = chinese4;
        Pinyin4 = pinyin4;
        Explain4 = explain4;
    }

    public String getChinese4() {
        return Chinese4;
    }

    public void setChinese4(String chinese4) {
        Chinese4 = chinese4;
    }

    public String getPinyin4() {
        return Pinyin4;
    }

    public void setPinyin4(String pinyin4) {
        Pinyin4 = pinyin4;
    }

    public String getExplain4() {
        return Explain4;
    }

    public void setExplain4(String explain4) {
        Explain4 = explain4;
    }
}
