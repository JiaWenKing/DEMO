package com.example.administrator.demo;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/11/16.
 */

public class DanLi {
    static DanLi danLi=null;
    private Intent it;

    public DanLi() {
        super();
        it = new Intent();
    }

    public static DanLi getDanLi(){
        if (danLi == null){
            synchronized (DanLi.class) {
                if (danLi == null) {
                    danLi = new DanLi();
                }
            }
        }
        return danLi;
    }

    /**
     * 跳转方法
     */
    public void jump(Context context,Class c){
        it.setClass(context,c);
        context.startActivity(it);
    }
}
