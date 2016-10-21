package com.sunsmart.cardlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import daogenerator.CardItem;
import transform.GlideRoundTransform;

/**
 * Created by yzs on 2016/10/20.
 */

public class BobyAdapter extends BaseAdapter {
    private List<CardItem> mList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater = null;

    public BobyAdapter(Context context) {
        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<CardItem> cards) {
        mList.clear();
        this.mList = cards;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mList != null) return mList.size() -1;
        return 0;
    }

    @Override
    public CardItem getItem(int i) {
        if (mList != null) return mList.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (contentView == null) {
            holder = new ViewHolder();
            contentView = mInflater.inflate(R.layout.card_item_list, null);
            holder.mTitle = (TextView) contentView.findViewById(R.id.title);
            holder.mIcon = (ImageView) contentView.findViewById(R.id.icon);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        Log.d("yzs002", "position is " + position + " and size is " + mList.size());
        //注意是加1，因为第一条是title
        final CardItem baseCard = mList.get(position + 1);
        //holder.mIcon.setTag(baseCard.getIcon_add());
        Glide.with(mContext)
                .load(baseCard.getIcon_add())
                .centerCrop()
                .placeholder(mContext.getDrawable(R.mipmap.no_picture))
                //.transform(new GlideRoundTransform(mContext))
                .into(holder.mIcon);

        holder.mTitle.setText(baseCard.getTitle());
        holder.address = baseCard.getNews_add();
        holder.baseCard = baseCard;
        if(position == mList.size() -2){
            contentView.setBackground(mContext.getDrawable(R.drawable.round_listview_listitem_selector));
        }else{
            contentView.setBackground(mContext.getDrawable(R.drawable.listview_listitem_selector));
        }
        return contentView;
    }

    static class ViewHolder {
        public ImageView mIcon;
        public TextView mTitle;
        public String address;
        public CardItem baseCard;
    }
}
