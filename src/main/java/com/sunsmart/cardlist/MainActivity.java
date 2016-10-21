package com.sunsmart.cardlist;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import daogenerator.CardItem;
import widget.SimpleArcDialog;

public class MainActivity extends AppCompatActivity {

    private TextView mEmptyView;
    private ListView mCardListView;
    private CardAdapter mCardAdapter;
    private List<List<CardItem>> mCardsList = new ArrayList<List<CardItem>>();

    private SimpleArcDialog mDialogLoading;

    //模拟获取网络数据的延时动作
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            testForLoadDatas();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCardListView = (ListView) findViewById(R.id.cardlist);
        mEmptyView = (TextView) findViewById(R.id.emptyview);
        mCardListView.setEmptyView(mEmptyView);

        mCardAdapter = new CardAdapter(this);
        mCardListView.setAdapter(mCardAdapter);
        mDialogLoading = new SimpleArcDialog(MainActivity.this);
        mDialogLoading.show();
        mCardsList.add(FinalTest.getTestItem(5));
       mCardsList.add(FinalTest.getTestItem(1));
        mCardsList.add(FinalTest.getTestItem(3));
        /*mCardsList.add(FinalTest.getTestItem(4));
        mCardsList.add(FinalTest.getTestItem(6));*/

        mHandler.sendEmptyMessageDelayed(1, 1500);
    }

    private void testForLoadDatas() {
        mDialogLoading.dismiss();
        mCardAdapter.setDatas(mCardsList);
    }
}
