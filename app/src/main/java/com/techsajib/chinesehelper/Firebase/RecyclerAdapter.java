package com.techsajib.chinesehelper.Firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.techsajib.chinesehelper.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<FirebaseData> messageList;

    public RecyclerAdapter(Context mContext, ArrayList<FirebaseData> messageList) {
        this.mContext = mContext;
        this.messageList = messageList;
    }




    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.firebase_post_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //for title section
        holder.titleView.setText(messageList.get(position).getTitle());
        //for description title
        holder.descriptionView.setText(messageList.get(position).getDescription());
        //for image section
        Glide.with(mContext)
                .load(messageList.get(position).getImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //for widgets
        ImageView imageView;
        TextView titleView, descriptionView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.firebase_image);
            titleView = itemView.findViewById(R.id.firebase_title);
            descriptionView = itemView.findViewById(R.id.firebase_description);

        }
    }
}
