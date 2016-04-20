package com.android.lqdemo.utils;

import android.util.Log;

public final class LqLog {
    // ===========================================================
    // Constants
    // ===========================================================

//    private static boolean ENABLE_DEBUG_MODE = true;
    
    public static int LEVEL = 5;
    
    private final static String TAG = "LQTHEME_LIB";
    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    private LqLog(){
            throw new UnsupportedOperationException("LqLog cannot instantiated!");
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    public static void v(String msg){
        if(LEVEL >= 5){
            Log.v(TAG, msg);
        }
    }
    
    public static void d(String msg){
        if(LEVEL >= 4){
            Log.d(TAG, msg);
        }
    }
    
    public static void i(String msg){
        if(LEVEL >= 3){
            Log.i(TAG, msg);
        }
    }
    
    public static void w(String msg){
        if(LEVEL >= 2){
            Log.w(TAG, msg);
        }
    }
    
    public static void e(String msg){
        if(LEVEL >= 1){
            Log.e(TAG, msg);
        }
    }
    
    public static void v(String tag,String msg){
        if(LEVEL >= 5){
            Log.v(tag, msg);
        }
    }
    
    public static void d(String tag,String msg){
        if(LEVEL >= 4){
            Log.d(tag, msg);
        }
    }
    
    public static void i(String tag,String msg){
        if(LEVEL >= 3){
            Log.i(tag, msg);
        }
    }
    
    public static void w(String tag,String msg){
        if(LEVEL >= 2){
            Log.w(tag, msg);
        }
    }
    
    public static void e(String tag,String msg){
        if(LEVEL >= 1){
            Log.e(tag, msg);
        }
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
