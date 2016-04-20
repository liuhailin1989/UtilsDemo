
package com.android.lqdemo.flurry;

import java.util.HashMap;
import java.util.Map;

import com.android.lqdemo.R;
import com.android.lqdemo.utils.LqLog;
import com.flurry.android.FlurryAgent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FlurryMainActivity extends Activity implements OnClickListener{

    private final static String TAG = "FlurryMainActivity";
    private Context mContext;
    private Button mBtnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flurry_layout);
        mContext = this;
        setupView();
        initData();
    }

    private void setupView() {
        mBtnApply = (Button) findViewById(R.id.btn_apply);
        mBtnApply.setOnClickListener(this);
    }

    private void initData(){
        LqLog.i(TAG, "[FlurryMainActivity][initData] + key =" + FlurryConfig.APP_KEY);
        FlurryAgent.init(mContext, FlurryConfig.APP_KEY);
        
    }
    
    private void applyClick(){
        LqLog.i(TAG, "[FlurryMainActivity][applyClick]");
        Map map = new HashMap<String,String>();
        map.put(FlurryConfig.THEME_ID, "001");
        map.put(FlurryConfig.THEME_NAME, "deepJungle");
        FlurryAgent.onEvent(FlurryConfig.THEME_APPLY,map);
    }
    
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        LqLog.i(TAG, "[FlurryMainActivity][onStart]");
        FlurryAgent.onStartSession(mContext,FlurryConfig.APP_KEY);
        FlurryAgent.setLogEvents(true);
    }
    
    
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        LqLog.i(TAG, "[FlurryMainActivity][onStop]");
        FlurryAgent.onEndSession(mContext);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        int id = v.getId();
        switch (id) {
            case R.id.btn_apply:
                applyClick();
                break;

            default:
                break;
        }
    }
    
}
