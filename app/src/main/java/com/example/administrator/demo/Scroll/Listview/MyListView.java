package com.example.administrator.demo.Scroll.Listview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/12/1.
 * 使listview 正确嵌套在scrollview中
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //重写绘制测量方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                                                        //最大 、、精确 、 参数值
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
