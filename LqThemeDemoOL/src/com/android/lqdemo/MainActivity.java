
package com.android.lqdemo;


import com.android.lqdemo.R;
import com.android.lqdemo.animationdrawable.AnimationDrawableActivity;
import com.android.lqdemo.flurry.FlurryMainActivity;
import com.android.lqdemo.listview.MyTestListViewActivity;
import com.android.lqdemo.pageeffects.PageEffectsActivity;
import com.android.lqdemo.pullscrollview.PullActivity;
import com.android.lqdemo.pulltorefreshview.PullToRefreshActivity;
import com.android.lqdemo.statusbar.StatusBarActivity;
import com.android.lqdemo.utils.LqLog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity implements OnItemClickListener{

    private final static String TAG = "MainActivity";
    
    Context mContext;
    
    ListView mListView;
    
    String[] data = {"StatusBar","ListViewTest","Flurry","PullView","PageEffects","PullToRefresh","AnimationDrawable"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list_layout);
        mContext = this;
        
        setupViews();
        LqLog.i(TAG, "onCreate start");
    }

    private void setupViews() {
        mListView = (ListView) findViewById(R.id.main_list);
        mListView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, data));
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        Object object = parent.getAdapter().getItem(position);
        if(object instanceof String){
            if(object.equals("StatusBar")){
                enterActivity(StatusBarActivity.class);
            }
            else if(object.equals("ListViewTest")){
                enterActivity(MyTestListViewActivity.class);
            }
            else if(object.equals("Flurry")){
                enterActivity(FlurryMainActivity.class);
            }
            else if(object.equals("PullView")){
                enterActivity(PullActivity.class);
            }
            else if(object.equals("PageEffects")){
                enterActivity(PageEffectsActivity.class);
            }
            else if(object.equals("PullToRefresh")){
                enterActivity(PullToRefreshActivity.class);
            }
            else if(object.equals("AnimationDrawable")){
                enterActivity(AnimationDrawableActivity.class);
            }
            
        }
    }
   
    private void enterActivity(Class<?> clazz){
        LqLog.i(TAG, clazz.getName());
        String testString = null;
        try{
        testString.getBytes();
        }catch(Exception ex){
            LqLog.e(TAG, ex.getMessage());
        }
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        startActivity(intent);
    }
}
