package com.android.lqdemo.pulltorefreshview;

import com.android.lqdemo.R;
import com.android.lqdemo.pulltorefreshview.PullToRefreshView.OnRefreshListener;

import android.app.Activity;
import android.os.Bundle;

public class PullToRefreshActivity extends Activity{
    
    private PullToRefreshView mPullToRefreshView;
    public static final int REFRESH_DELAY = 2000;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulltorefresh_layout);
        
        setupView();
    }
    
    private void setupView(){
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new OnRefreshListener() {
            
            @Override
            public void onRefresh() {
                // TODO Auto-generated method stub
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, REFRESH_DELAY);
            }
        });
    }
}
