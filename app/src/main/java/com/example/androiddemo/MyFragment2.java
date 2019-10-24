package com.example.androiddemo;

import android.annotation.SuppressLint;
import android.app.Fragment;
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
public class MyFragment2 extends Fragment {

    private String content;

    public MyFragment2() { }

    ;

    public MyFragment2(String content) {
        this.content = content;
    }

    //声明一个List，数据类型为Map<String,Object>
    private List<Map<String, Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;
    //定义数据

    private String[] theme = {"妈", "表弟", "朱一旦", "马化腾", "马云"};
    private int[] imageViews = {R.mipmap.ic_launcher, R.mipmap.ball, R.mipmap.ball, R.mipmap.ball,R.mipmap.ball};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_content2, container, false);
//        TextView ftv = (TextView) view.findViewById(R.id.ftv);
//        ftv.setText(content);
        listView = view.findViewById(R.id.listview);

        lists = new ArrayList<>();
        for (int i = 0; i < theme.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imageViews[i]);
            map.put("theme", theme[i]);
            lists.add(map);
        }

        listView.setAdapter(new SimpleAdapter(this.getActivity(), lists, R.layout.list_item1,
                new String[]{"image", "theme"},
                new int[]{R.id.personal_logo, R.id.text1}));
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }


}
