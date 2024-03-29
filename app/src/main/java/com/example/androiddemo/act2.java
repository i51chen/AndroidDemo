package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class act2 extends AppCompatActivity {
    private List<Map<String, Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;
    //    定义数据
    private String[] theme = {"张三", "李四", "王五"};
    private String[] chatContent = {"我是张三，你好", "我是李四，你好", "我是王五，你好"};
    private int[] imageViews = {R.mipmap.ic_launcher, R.mipmap.ball, R.mipmap.ball};

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        lists = new ArrayList<>();
        for (int i = 0; i < theme.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imageViews[i]);
            map.put("theme", theme[i]);
            map.put("chatContent", chatContent[i]);
            lists.add(map);

        }
        //显示页面用一个ListView，新建样式页面（list_item.xml）设置样式
        adapter = new SimpleAdapter(this, lists, R.layout.list_item,
                new String[]{"image", "theme", "chatContent"},
                new int[]{R.id.personal_logo, R.id.text1, R.id.text2});
        listView = (ListView) findViewById(R.id.ll1);

        listView.setAdapter(adapter);
    }
}
