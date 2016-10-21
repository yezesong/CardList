package com.sunsmart.cardlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import daogenerator.CardItem;
import widget.Card;

/**
 * Created by yzs on 2016/10/20.
 */

public class CardAdapter extends BaseAdapter {
    private Context mContext;
    private List<List<CardItem>> mCardsList = new ArrayList<>();
    private Card mCard;

    public CardAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDatas(List<List<CardItem>> cards) {
        mCardsList.clear();
        this.mCardsList = cards;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mCardsList != null)
            return mCardsList.size();
        return 0;
    }

    @Override
    public List<CardItem> getItem(int i) {
        if (mCardsList != null)
            return mCardsList.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        mCard = new Card(mContext);
        List<CardItem> mapCard = getItem(position);
        mCard.setData(mapCard);
        return mCard;
    }
}
