package com.android.lqdemo.animationdrawable;

import com.android.lqdemo.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationDrawableActivity extends Activity implements OnClickListener{
    
    private Button mButton;
    private TextView mTextView;
    AnimationDrawable animationDrawable;
    private ImageView ivImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable_layout);
        setupView();
        init();
    }
    
    private void setupView(){
        mButton = (Button) findViewById(R.id.btn_start);
        mTextView = (TextView) findViewById(R.id.icon);
        ivImageView = (ImageView) findViewById(R.id.iv_icon);
        mButton.setOnClickListener(this);
    }
    
    private void init(){
        animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.aaa_1), 200);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.aaa_2), 200);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.aaa_3), 200);
    }

    
    private void process(){
        mTextView.setCompoundDrawablesWithIntrinsicBounds(null, animationDrawable, null, null);
//        ivImageView.setBackground(animationDrawable);
        animationDrawable.start();
    }
    
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        int id = v.getId();
        
        switch (id) {
            case R.id.btn_start:
                process();
                break;

            default:
                break;
        }
    }
}
