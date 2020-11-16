package com.techsajib.chinesehelper.HSK3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.techsajib.chinesehelper.R;

import java.util.ArrayList;

public class HSK3Adapter extends ArrayAdapter<HSK3Model> {

    private Context mContext;
    private int mResource;

    public HSK3Adapter(@NonNull Context context, int resource, @NonNull ArrayList<HSK3Model> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView txtChinese = convertView.findViewById(R.id.hsk3_chinese);
        TextView txtPinyin = convertView.findViewById(R.id.hsk3_pinyin);
        TextView txtExplain = convertView.findViewById(R.id.hsk3_explanation);

        txtChinese.setText(getItem(position).getChinese3());
        txtPinyin.setText(getItem(position).getPinyin3());
        txtExplain.setText(getItem(position).getExplain3());

        return convertView;
    }


}
