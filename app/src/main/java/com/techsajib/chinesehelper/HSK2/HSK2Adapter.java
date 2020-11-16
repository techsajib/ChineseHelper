package com.techsajib.chinesehelper.HSK2;

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

public class HSK2Adapter extends ArrayAdapter<HSK2Model> {

    private Context mContext;
    private int mResource;

    public HSK2Adapter(@NonNull Context context, int resource, @NonNull ArrayList<HSK2Model> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);

        TextView txtChinese = convertView.findViewById(R.id.hsk2_chinese);
        TextView txtPinyin = convertView.findViewById(R.id.hsk2_pinyin);
        TextView txtExplain = convertView.findViewById(R.id.hsk2_explanation);

        txtChinese.setText(getItem(position).getChinese2());
        txtPinyin.setText(getItem(position).getPinyin2());
        txtExplain.setText(getItem(position).getExplain2());

        return convertView;
    }
}
