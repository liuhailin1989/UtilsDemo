
package com.android.lqdemo.pullscrollview;


import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

public class PullScrollView extends ScrollView {

    private final static String TAG = "PullScrollView";

    private final static float DAMP_RATIO = 0.3f;

    private PointF touchFirstPoint = new PointF();// first down event point
    
    private PointF lastPoint = new PointF();// last move event point

    private View childView;

    /**
     * child view's position at down action
     */
    private Rect childViewInitRect = new Rect();

    int contentTop;

    int contentBottom;

    float deltaY;
    
    float deltaMoveY;
    
    int tempScrollValue;

    private boolean isPulling;
    
    float childViewMoveDistance = 0;
    
    private Interpolator mScrollAnimationInterpolator;
    
    private SmoothScrollRunnable mCurrentSmoothScrollRunnable;

    public PullScrollView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init();
    }

    public PullScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init();
    }

    public PullScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        init();
    }

    private void init(){
        setOverScrollMode(OVER_SCROLL_NEVER);
    }
    @Override
    protected void onFinishInflate() {
        // TODO Auto-generated method stub
        if (getChildCount() > 0) {
            childView = getChildAt(0);
        }
        super.onFinishInflate();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        Log.i(TAG, "[PullScrollView][onInterceptTouchEvent] ev.getAction()" +ev.getAction());
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchFirstPoint.set(ev.getRawX(), ev.getRawY());
                lastPoint.set(ev.getRawX(), ev.getRawY());
                childViewInitRect.set(childView.getLeft(), childView.getTop(),
                        childView.getRight(), childView.getBottom());
                tempScrollValue = getScrollY();
                isPulling = false;
                childViewMoveDistance = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "[PullScrollView][onInterceptTouchEvent]deltaY =" + deltaY + "  getScrollY()" + getScrollY());
                if ((getScrollY() == 0 )||(getScrollY() == (childViewInitRect.bottom - getHeight()))) {
                    onTouchEvent(ev);
                    return true;
                }
                break;
            default:

                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        Log.i(TAG, "[PullScrollView][onTouchEvent] ev.getAction()" +ev.getAction());
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "[PullScrollView][onTouchEvent] ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "[PullScrollView][onTouchEvent]ACTION_MOVE deltaY= " +deltaY +"  getScrollY()" +getScrollY());
                deltaY = ev.getRawY() - lastPoint.y;
                deltaMoveY = ev.getRawY() - touchFirstPoint.y;
                
                if(deltaMoveY < 0 && getScrollY() == 0){
                    childView.scrollTo(0, childViewInitRect.top);
                    isPulling = false;
                    break;
                }else if(deltaMoveY > 0 && (getScrollY() == (childViewInitRect.bottom - getHeight()))){
                    childView.scrollTo(0, childViewInitRect.top);
                    isPulling = false;
                    break;
                }
                
                if ((getScrollY() == 0)||(getScrollY() == (childViewInitRect.bottom - getHeight()))) {
                    childViewMoveDistance += deltaY * DAMP_RATIO;
                    Log.i(TAG, "[PullScrollView][onTouchEvent]layout childViewMoveDistance= "+childViewMoveDistance );
                    contentTop = (int) (childViewInitRect.top + childViewMoveDistance);
                    contentBottom = (int) (childViewInitRect.bottom + childViewMoveDistance);
                    childView.scrollTo(0, -contentTop);
                    isPulling = true;
                }
                
                lastPoint.set(ev.getRawX(), ev.getRawY());
                break;

            case MotionEvent.ACTION_UP:
                if (isPulling) {
//                    childView.scrollTo(0,childViewInitRect.top);
                    smoothScrollTo(childViewInitRect.top,500,0,new OnSmoothScrollFinishedListener() {
                        
                        @Override
                        public void onSmoothScrollFinished() {
                            // TODO Auto-generated method stub
                            Log.i(TAG, "onSmoothScrollFinished");
                            childView.scrollTo(0,childViewInitRect.top);
                        }
                    });
                    isPulling = false;
                    contentTop = 0;
                    childViewMoveDistance = 0;
                }
                break;
            default:

                break;
        }
        Log.i(TAG, "onTouchEvent isPulling =" + isPulling);
        return isPulling || super.onTouchEvent(ev);
    }
    
    private void smoothScrollTo(int newScrollValue, long duration,long delayMillis,
            OnSmoothScrollFinishedListener listener) {
        if (null != mCurrentSmoothScrollRunnable) {
            mCurrentSmoothScrollRunnable.stop();
        }

        final int oldScrollValue;
        oldScrollValue = -contentTop;
        Log.i(TAG, "run oldScrollValue=" + oldScrollValue);
        if (null == mScrollAnimationInterpolator) {
            // Default interpolator is a Decelerate Interpolator
            mScrollAnimationInterpolator = new DecelerateInterpolator();
        }
        mCurrentSmoothScrollRunnable = new SmoothScrollRunnable(oldScrollValue, newScrollValue,
                duration, listener);
        if (delayMillis > 0) {
            postDelayed(mCurrentSmoothScrollRunnable, delayMillis);
        } else {
            post(mCurrentSmoothScrollRunnable);
        }
    }
    //
    final class SmoothScrollRunnable implements Runnable {
        private final Interpolator mInterpolator;
        private final int mScrollToY;
        private final int mScrollFromY;
        private final long mDuration;
        private OnSmoothScrollFinishedListener mListener;

        private boolean mContinueRunning = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public SmoothScrollRunnable(int fromY, int toY, long duration, OnSmoothScrollFinishedListener listener) {
            mScrollFromY = fromY;
            mScrollToY = toY;
            mInterpolator = mScrollAnimationInterpolator;
            mDuration = duration;
            mListener = listener;
        }

        @Override
        public void run() {

            /**
             * Only set mStartTime if this is the first time we're starting,
             * else actually calculate the Y delta
             */
            if (mStartTime == -1) {
                mStartTime = System.currentTimeMillis();
            } else {

                /**
                 * We do do all calculations in long to reduce software float
                 * calculations. We use 1000 as it gives us good accuracy and
                 * small rounding errors
                 */
                long normalizedTime = (1000 * (System.currentTimeMillis() - mStartTime)) / mDuration;
                normalizedTime = Math.max(Math.min(normalizedTime, 1000), 0);
                Log.i(TAG, "run normalizedTime=" +normalizedTime);
                final int deltaY = Math.round((mScrollFromY - mScrollToY)
                        * mInterpolator.getInterpolation(normalizedTime / 1000f));
                mCurrentY = mScrollFromY - deltaY;
                Log.i(TAG, "run mCurrentY=" +mCurrentY);
                childView.scrollTo(0,mCurrentY);
            }

            // If we're not at the target Y, keep going...
            if (mContinueRunning && mScrollToY != mCurrentY) {
                ViewCompat.postOnAnimation(childView, this);
            } else {
                if (null != mListener) {
                    mListener.onSmoothScrollFinished();
                }
            }
        }

        public void stop() {
            mContinueRunning = false;
            removeCallbacks(this);
        }
    }
    
    static interface OnSmoothScrollFinishedListener {
        void onSmoothScrollFinished();
    }
}
