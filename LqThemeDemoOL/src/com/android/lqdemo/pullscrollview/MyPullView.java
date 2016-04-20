package com.android.lqdemo.pullscrollview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

public class MyPullView extends RelativeLayout{

    private final static String TAG="MyPullView";
    private float mpreY=0;  
    private Rect mRect;
    
    public MyPullView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    
    public MyPullView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }
    
    public MyPullView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        float curY = event.getY();
        Log.i(TAG, "[MyPullView][onTouchEvent]curY =" +curY +" event.getAction()= "+event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mRect = new Rect(getLeft(),getTop(),getRight(),getBottom());
                break;
            case MotionEvent.ACTION_MOVE:
                int delta = (int)((curY - mpreY)*0.25);  
                Log.i(TAG, "[MyPullView][onTouchEvent]delta =" +delta);
//                if (delta>=0) 
                {  
                    layout(getLeft(),getTop()+delta, getRight(), getBottom()+delta); 
                }
                break;
            case MotionEvent.ACTION_UP:
                int curTop = getTop();  
                layout( mRect.left, mRect.top, mRect.right, mRect.bottom);  
                TranslateAnimation animation = new TranslateAnimation(0, 0, curTop - mRect.top, 0);  
                animation.setDuration(200);  
                startAnimation(animation);  
                break;
            default:
                break;
        }
        mpreY = curY;  
        return true;
    }
    
    
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // TODO Auto-generated method stub
        super.onLayout(changed, l, t, r, b);
    }
}
