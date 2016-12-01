package com.example.administrator.demo.Scroll.Listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> datas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = (ListView) findViewById(R.id.listview);

        datas = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            datas.add(""+i);
        }
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(adapter);

        //动态设置listview高度    需要线性布局包裹listview
        setListViewHeight(listView);
    }



    //动态设置listview高度
    public void setListViewHeight(ListView lv){
        //获取listview对应的adapter
        ListAdapter listadapter = lv.getAdapter();
        if (listadapter ==null){
            return;
        }
        int titalHeight = 0;
        //遍历适配器条目
        for (int i = 0; i <listadapter.getCount() ; i++) {
            //listadapter . getcount
            View listItem = listadapter.getView(i,null,lv);
            //测量子项view宽高，执行之后，子项宽高就有了
            listItem.measure(0,0);
            //统计所有子项高度
            titalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = lv.getLayoutParams();
        //listview . getDiciderHeight()获取子项间分隔符占用的高度                最后一个item没有分隔符 -1
        int deviderHeight = (lv.getDividerHeight()) * (listadapter.getCount()) -1;
        params.height = titalHeight + deviderHeight;
        lv.setLayoutParams(params);

    }
}
