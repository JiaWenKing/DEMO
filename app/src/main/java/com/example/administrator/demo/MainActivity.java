package com.example.administrator.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.demo.JavaScript.JSActivity;
import com.example.administrator.demo.Scroll.Listview.ListviewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;

    private List<String> data;
    private DanLi danli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        danli = DanLi.getDanLi();
        data = getdata();
        Adapter adapter = new Adapter(this);
        listview.setAdapter(adapter);

        initView();


    }

    public void initView() {

    }

    @OnItemClick(R.id.listview)
    public void itemclickfun(int position) {
        switch (position) {
            case 0:
                danli.jump(MainActivity.this, JSActivity.class);
                break;
            case 1:
                danli.jump(MainActivity.this,ListviewActivity.class);
                break;
        }
    }


    private List<String> getdata() {
        List<String> list = new ArrayList<>();
        list.add("javascript通信");
        list.add("ScrollView-ListView");
        list.add("极光推送");

        return list;
    }


    static class ViewHolder {
        public TextView textView;
    }

    public class Adapter extends BaseAdapter {
        private Context context;
        LayoutInflater layout = null;

        public Adapter(Context context) {
            layout = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ViewHolder vh;
            if (view == null) {
                vh = new ViewHolder();
                view = layout.inflate(R.layout.listview_main, null);
                vh.textView = (TextView) view.findViewById(R.id.textview);
                view.setTag(vh);
            } else {
                vh = (ViewHolder) view.getTag();
            }
            vh.textView.setText(data.get(i));

            return view;
        }

    }
}

