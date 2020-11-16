package com.techsajib.chinesehelper.HSK1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.techsajib.chinesehelper.R;

import java.util.ArrayList;

public class HSK1Adapter extends ArrayAdapter<HSK1Model> {
    private Context mContext;
    private int mResource;

    public HSK1Adapter(@NonNull Context context, int resource, @NonNull ArrayList<HSK1Model> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView txtChinese = convertView.findViewById(R.id.hsk1_chinese);
        TextView txtPinyin = convertView.findViewById(R.id.hsk1_pinyin);
        TextView txtExplain = convertView.findViewById(R.id.hsk1_explanation);
        ImageView imageView = convertView.findViewById(R.id.hsk1_listview_Icon);

        imageView.setImageResource(getItem(position).getImage());
        txtChinese.setText(getItem(position).getChinese());
        txtPinyin.setText(getItem(position).getPinyin());
        txtExplain.setText(getItem(position).getExplain());

        return convertView;
    }
}
