package com.example.recycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recycleviewdemo.R;
import com.example.recycleviewdemo.holder.MyViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * author：Admin
 * date：2017/11/2110:18
 * 编程使我快乐
 */

public class HomeAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<String> mDatas;

    public HomeAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }
    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Picasso.with(context).load(R.drawable.chip).into(holder.imageView);
        holder.textView.setText(mDatas.get(position));
        if(mOnItemClickLitener!=null){
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
            holder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    public void addData(int position) {
        mDatas.add(position, "Insert One");
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}
