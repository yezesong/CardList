package widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.sunsmart.cardlist.BobyAdapter;
import com.sunsmart.cardlist.R;

import java.util.List;

import daogenerator.CardItem;

/**
 * Created by yzs on 2016/10/20.
 */

public class Card extends LinearLayout {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private LinearLayout mLinearLayout;
    private RelativeLayout mTitilelayout;
    private TextView mDateView, mTitleView;
    private ImageView mIconView;
    private BobyListView mBobylist;
    private BobyAdapter mBobyAdapter;

    public Card(Context context) {
        this(context, null);
    }

    public Card(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Card(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        if (mLayoutInflater == null) {
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        mLinearLayout = (LinearLayout) mLayoutInflater.inflate(R.layout.card_item, null);

        mTitilelayout = (RelativeLayout) mLinearLayout.findViewById(R.id.titile_layout);

        mDateView = (TextView) mLinearLayout.findViewById(R.id.tv_date);
        mIconView = (ImageView) mLinearLayout.findViewById(R.id.title_icon);
        mTitleView = (TextView) mLinearLayout.findViewById(R.id.title_title);
        mBobylist = (BobyListView) mLinearLayout.findViewById(R.id.boby_list);

        mTitilelayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("yzs001", " onClick title ");
                //openBrows(mContext, mTitleBaseCard, mTitleView.getText().toString());
            }
        });

        mBobyAdapter = new BobyAdapter(mContext);
        mBobylist.setAdapter(mBobyAdapter);
        mBobylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                //ViewHolder ViewHolder = (com.android.magcomm.netinfo.Card.ViewHolder) arg1.getTag();
                //openBrows(mContext, ViewHolder.baseCard, ViewHolder.baseCard.title);
            }
        });

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        addView(mLinearLayout, params);
    }

    public void setData(List<CardItem> list) {
        if (list.size() == 0) {
            return;
        }
        if (list.size() == 1) {
            mTitilelayout.setBackground(mContext.getDrawable(R.drawable.round_title_bg));
        } else {
            mTitilelayout.setBackground(mContext.getDrawable(R.drawable.title_bg));
        }
        CardItem baseCard = list.get(0);//第一条是做为title显示的
        mTitleView.setText(baseCard.getTitle());
        Glide.with(mContext.getApplicationContext()).load(baseCard.getIcon_add()).placeholder(mContext.getDrawable(R.mipmap.no_picture)).centerCrop().into(mIconView);
        mBobyAdapter.setData(list);
        postInvalidate();
    }
}
