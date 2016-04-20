package com.android.lqdemo.app;

import android.app.Application;
import android.content.Intent;

public class DemoApplication extends Application {
    private int result;
    private Intent intent;

    public int getResult(){
        return result;
    }

    public Intent getIntent(){
        return intent;
    }


    public void setResult(int result1){
        this.result = result1;
    }

    public void setIntent(Intent intent1){
        this.intent = intent1;
    }
}