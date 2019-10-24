package com.example.androiddemo;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

@SuppressLint("ValidFragment")
public class MyFragment3 extends Fragment implements View.OnClickListener {

    private String content;

    public MyFragment3() {
    }

    ;

    public MyFragment3(String content) {
        this.content = content;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content3, container, false);
        //添加监听，注销登录
        view.findViewById(R.id.logout).setOnClickListener(this);
//        TextView ftv = (TextView) view.findViewById(R.id.ftv);
//        ftv.setText(content);
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logout) {
            Intent intent = new Intent(this.getActivity(), act5Login.class);
            startActivity(intent);

            Toast.makeText(this.getActivity(),"注销成功，重新登陆",Toast.LENGTH_LONG).show();
        }
    }
}
