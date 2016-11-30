package com.example.administrator.demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class JSActivity extends AppCompatActivity {

    private WebView webView;
    private Button button;
    private TextView textView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);

        webView = (WebView) findViewById(R.id.webview);
        button = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textview);

        //设置webview，允许JavaScript代码运行
        webView.getSettings().setJavaScriptEnabled(true);
        //2为webview添加一个javascrptInterface接口类对象，这个方法接受两个参数
        //（接口类对象，字符串用于js中调用Android方法）
        webView.addJavascriptInterface(new AAndroid(textView,this), "android");
        //加载写好的html文件
        webView.loadUrl("file:///android_asset/index.html");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //安卓调用网页上的js代码,使用loadurl方法，字符串，格式：JavaScript：方法名
                webView.loadUrl("javascript:useJs()");
            }
        });

    }
}
//js和Java通信
//网页和安卓原生app
//js调用安卓代码：
//    步骤：1在接口类中，声明方法（安卓的）
//         2.在js里使用指定字符串（用的是Android），接口类的方法名


//声明一个类，接口类
class AAndroid {
    private TextView tv;
    private Context context;
    public AAndroid(TextView tv,Context context){
        this.tv = tv;
        this.context = context;
    }
    //加声明
    @JavascriptInterface
    public void changeText(){
        tv.setText("收到网页消息");
    }
    @JavascriptInterface
    public void gotoLogin(){
        Intent intent = new Intent(context,Login_JS_Activity.class);
        context.startActivity(intent);
    }
}
