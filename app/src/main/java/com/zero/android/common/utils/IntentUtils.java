package com.zero.android.common.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by zf on 2016/2/4.
 */
public class IntentUtils {
    public static void goListActivity(Context context,Class clazz){
        Intent intent= new Intent(context,clazz);
        context.startActivity(intent);
    }
}
