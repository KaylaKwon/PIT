package com.yckim.project_manager.Manager;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
  /*  private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
*/
    public static String Email;
    public static String Category;
    public static String ProjectName;

    private static Context mContext;

    public static Context getContext() {
        //  return instance.getApplicationContext();
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //  instance = this;
        mContext = getApplicationContext();
    }
}
