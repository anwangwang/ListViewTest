package com.awwhome.listviewtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ListView lv_listView;

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1.找到listview
        lv_listView = (ListView) findViewById(R.id.lv_listView);

        // 2.创建adapter对象
        MyAdapter myAdapter = new MyAdapter();

        // 3.把数据设置给listview
        lv_listView.setAdapter(myAdapter);
    }

    /**
     * listView 适配器
     */
    class MyAdapter extends BaseAdapter {

        // 告诉listview要显示的条目数
        @Override
        public int getCount() {
            return 10;
        }

        // 根据position获取listview上对应条目的bean数据，改方法不影响数据的显示，可以先不实现
        @Override
        public Object getItem(int position) {
            return null;
        }

        // 用来获取position行的id，改方法不影响数据的显示，可以先不实现
        @Override
        public long getItemId(int position) {
            return 0;
        }

        // 返回一个view对象，作为条目上的显示内容，该方法返回什么样子的view，listview的条目上就显示什么样子的view。必须实现
        // 屏幕上每显示一个条目，该方法就被调用一次
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView textView = new TextView(mContext);

            textView.setText("position:" + position);

            Log.d(TAG, "position:" + position);

            return textView;
        }
    }
}
