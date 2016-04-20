package com.android.lqdemo.listview;

import com.android.lqdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MyTestListViewActivity extends Activity implements OnClickListener,OnItemClickListener{
    
    private ListView mListView;
    private Button mButton;
    String[] data = {"Test1","Test2","Test3","Test4","Test5","Test6","Test7","Test8","Test9","Test10"
            ,"Test11","Test12","Test13","Test14","Test1","Test2","Test3","Test4","Test5","Test6","Test7","Test8","Test9","Test10"
            ,"Test11","Test12","Test13","Test14","Test1","Test2","Test3","Test4","Test5","Test6","Test7","Test8","Test9","Test10"
            ,"Test11","Test12","Test13","Test14"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
        setupView();
        setListener();
        initData();
    }
    
    private void setupView(){
        mButton = (Button) findViewById(R.id.bt_select);
        mListView = (ListView) findViewById(R.id.lv_mylist);
    }
    
    private void setListener(){
        mButton.setOnClickListener(this);
        mListView.setOnItemClickListener(this);
    }
    
    private void initData(){
        mListView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1, data));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.bt_select:
//                mListView.setSmoothScrollbarEnabled(true);
//                mListView.smoothScrollToPosition(7,0);
//                mListView.setSelectionFromTop(7, 0);
                mListView.smoothScrollToPositionFromTop(7,0);
                break;

            default:
                break;
        }
    }
}
