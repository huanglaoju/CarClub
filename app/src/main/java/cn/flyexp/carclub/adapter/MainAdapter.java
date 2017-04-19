package cn.flyexp.carclub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.flyexp.carclub.R;

/**
 * Created by Won on 2017/4/19.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {


    public MainAdapter() {
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item, parent, false));
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        int i = new Random().nextInt(4);
        if (i == 3) {
            holder.title.setTextColor(context.getResources().getColor(R.color.color999));
        } else {
            holder.title.setTextColor(context.getResources().getColor(R.color.color21));
        }

        int j = new Random().nextInt(4);
        if (j == 3) {
            holder.llThumbnails.setVisibility(View.GONE);
            holder.thumbnail0.setVisibility(View.VISIBLE);
        } else {
            holder.llThumbnails.setVisibility(View.VISIBLE);
            holder.thumbnail0.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return 36;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.thumbnail1)
        ImageView thumbnail1;
        @BindView(R.id.thumbnail2)
        ImageView thumbnail2;
        @BindView(R.id.thumbnail3)
        ImageView thumbnail3;
        @BindView(R.id.ll_thumbnails)
        LinearLayout llThumbnails;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.thumbnail0)
        ImageView thumbnail0;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this , itemView);
        }
    }

    private IOnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(IOnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface IOnItemClickListener {
        void onItemClick(int position);
    }

}
