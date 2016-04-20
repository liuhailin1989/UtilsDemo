package com.android.lqdemo.widget;

import com.android.lqdemo.R;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.RemoteViews;

public class LqWidgetProvider extends AppWidgetProvider{
    
    
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // TODO Auto-generated method stub
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_layout); 
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View widgetContainer = inflater.inflate(R.layout.widget_container, null, false);
//        rv.addView(widgetContainer, rv);
        appWidgetManager.updateAppWidget(appWidgetIds, rv);
    }
    
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // TODO Auto-generated method stub
        super.onDeleted(context, appWidgetIds);
    }
    
    @Override
    public void onEnabled(Context context) {
        // TODO Auto-generated method stub
        super.onEnabled(context);
    }
    
    @Override
    public void onDisabled(Context context) {
        // TODO Auto-generated method stub
        super.onDisabled(context);
    }
    
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        super.onReceive(context, intent);
    }
    
}
