package com.example.androiddemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint("ValidFragment")
public class MyFragment1 extends Fragment {

    private List<Map<String, Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;
    //    定义数据
    private String[] theme = {"妈", "表弟", "朱一旦"};
    private String[] chatContent = {"回家吃饭啊", "王者荣耀开黑啊", "赶紧订了张去非洲的机票"};
    private int[] imageViews = {R.mipmap.ic_launcher, R.mipmap.ball, R.mipmap.ball};



    private String content;
    public MyFragment1(){};
    public MyFragment1(String content) {
        this.content = content;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content1, container, false);
        listView = view.findViewById(R.id.listview);


        lists = new ArrayList<>();
        for (int i = 0; i < theme.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imageViews[i]);
            map.put("theme", theme[i]);
            map.put("chatContent", chatContent[i]);
            lists.add(map);

        }
        //SimpleAdapter 的构方法，第一个参数 是 个activity，在fragment中用getActivity()方法，在Activity中可以直接用this

        listView.setAdapter(new SimpleAdapter(this.getActivity(), lists, R.layout.list_item,
                new String[]{"image", "theme", "chatContent"},
                new int[]{R.id.personal_logo, R.id.text1, R.id.text2}));
//        getActivity().startActivity(new Intent(getActivity(), act2.class));
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }


}
