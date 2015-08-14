package com.yckim.project_manager.Timeline;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chan on 15. 8. 13..
 */
public class TLEvent {
    public String title;
    public long dtstart;
    public long dtend;
    private String strdtstart;
    private String strdtend;

    public TLEvent(){}
    public TLEvent(String t, String s, String e){
        title = t; strdtstart = s; strdtend = e;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = null;
        try {
            date = sdf.parse(strdtstart);
        }catch(Exception ex){
            Log.e("TLEvent", "ParseException");
        }
        dtstart = date.getTime();

        date = null;
        try {
            date = sdf.parse(strdtend);
        }catch(Exception ex){
            Log.e("TLEvent", "ParseException");
        }
        dtend = date.getTime();
    }
}