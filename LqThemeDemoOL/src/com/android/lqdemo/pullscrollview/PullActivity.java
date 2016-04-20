package com.android.lqdemo.pullscrollview;

import com.android.lqdemo.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class PullActivity extends Activity implements OnClickListener{
    
    private PullScrollView mPullScrollView;
    private LinearLayout mContainerLayout;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_layout);
        mContext = this;
        setupView();
        initData();
    }
    
    private void setupView(){
        mPullScrollView = (PullScrollView) findViewById(R.id.pull_scroll_view);
        mContainerLayout = (LinearLayout) findViewById(R.id.ll_container);
//        mPullScrollView.setmHeaderView(findViewById(R.id.iv_headerview));
        
    }
    
    public void initData(){
        LayoutParams lParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        lParams.gravity = Gravity.CENTER;
        
        for (int i = 0; i < 20; i++) {
            TextView textView = new TextView(this);
            textView.setText("Scroll View Item " + i);
            textView.setLayoutParams(lParams);
            textView.setTextSize(20);
            textView.setPadding(0, 20, 0, 20);
            if(i %2 ==0){
                textView.setBackgroundColor(Color.GRAY);
            }
            else{
                textView.setBackgroundColor(Color.WHITE);
            }
            textView.setOnClickListener(this);
            mContainerLayout.addView(textView);
        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if(v instanceof TextView){
            Toast.makeText(mContext, ((TextView)v).getText(), Toast.LENGTH_SHORT).show();
        }
    }
    
}
