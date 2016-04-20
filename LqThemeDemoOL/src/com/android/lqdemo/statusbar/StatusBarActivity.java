package com.android.lqdemo.statusbar;

import com.android.lqdemo.R;

import android.app.Activity;
import android.annotation.SuppressLint;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.Button;  
import android.widget.RelativeLayout;  
  
@SuppressLint("NewApi")  
public class StatusBarActivity extends Activity implements OnClickListener  
{  
  
    private RelativeLayout mRLayout;  
    private Button mBtn1, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8;  
      
    @Override  
    protected void onCreate(Bundle savedInstanceState)   
    {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_statusbar);  
          
        mRLayout = (RelativeLayout)findViewById(R.id.content);  
        mBtn1 = (Button)findViewById(R.id.btn1);  
        mBtn2 = (Button)findViewById(R.id.btn2);  
        mBtn3 = (Button)findViewById(R.id.btn3);  
        mBtn4 = (Button)findViewById(R.id.btn4);  
        mBtn5 = (Button)findViewById(R.id.btn5);  
        mBtn6 = (Button)findViewById(R.id.btn6);  
        mBtn7 = (Button)findViewById(R.id.btn7);  
        mBtn8 = (Button)findViewById(R.id.btn8);  
          
        mBtn1.setOnClickListener(this);  
        mBtn2.setOnClickListener(this);  
        mBtn3.setOnClickListener(this);  
        mBtn4.setOnClickListener(this);  
        mBtn5.setOnClickListener(this);  
        mBtn6.setOnClickListener(this);  
        mBtn7.setOnClickListener(this);  
        mBtn8.setOnClickListener(this);       
    }  
      
    @Override  
    public void onClick(View v)  
    {  
        // TODO Auto-generated method stub  
        switch (v.getId())   
        {  
        case R.id.btn1:  
            //��ʾ״̬����Activity��ȫ����ʾ(�ָ�����״̬���������)  
            mRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);      
            break;  
        case R.id.btn2:  
            //����״̬����ͬʱActivity����չȫ����ʾ  
            mRLayout.setSystemUiVisibility(View.INVISIBLE);  
            break;  
        case R.id.btn3:  
            //Activityȫ����ʾ����״̬�������ظ��ǵ���  
            mRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);  
            break;        
        case R.id.btn4:  
            //Activityȫ����ʾ����״̬�����ᱻ���ظ��ǣ�״̬����Ȼ�ɼ���Activity���˲��ֲ��ֻᱻ״̬��ס  
            mRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);  
            break;  
              
        case R.id.btn5:  
            //ͬmRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);  
            mRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);  
            break;  
        case R.id.btn6:  
            //ͬmRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);  
            mRLayout.setSystemUiVisibility(View.SYSTEM_UI_LAYOUT_FLAGS);  
            break;  
        case R.id.btn7:  
            //�������ⰴ��(������)  
            mRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);  
            break;  
        case R.id.btn8:  
            //״̬����ʾ���ڵ�����ʾ״̬(low profileģʽ)��״̬����һЩͼ����ʾ�ᱻ���ء�  
            mRLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);  
            break;  
        }  
    }  
  
}  