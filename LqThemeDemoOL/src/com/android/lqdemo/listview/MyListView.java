package com.android.lqdemo.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ListView;

public class MyListView extends ListView{

    private static final String TAG = "MyListView";
    
    private Context mContext;
 
    public MyListView(Context context)
    {
        super(context);
        mContext = context;
    }
 
    public MyListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mContext = context;
    }
 
    public MyListView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mContext = context;
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
