package com.example.recycleviewdemo.holder;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recycleviewdemo.R;

/**
 * author：Admin
 * date：2017/11/2110:14
 * 编程使我快乐
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textView;
    public LinearLayout linearLayout;

    public MyViewHolder(View itemView) {
        super(itemView);
        linearLayout=itemView.findViewById(R.id.ll_layout);
        imageView = itemView.findViewById(R.id.image);
        textView = itemView.findViewById(R.id.textView);

    }
}
