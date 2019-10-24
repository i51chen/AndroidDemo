package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

public class act4 extends AppCompatActivity implements View.OnClickListener {
    public TextView mtv;
    public TextView btn1, btn2, btn3;
    private FragmentManager fManager;
    private MyFragment1 fg1;
    private MyFragment2 fg2;
    private MyFragment3 fg3;
    private String name = "";
    final Intent intent = getIntent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act4);

        Bundle bundle = this.getIntent().getExtras();
        name = bundle.getString("name");
        TextView tv = findViewById(R.id.name);
        tv.setText(name);





        fManager = getFragmentManager();

        mtv = findViewById(R.id.mtv);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        //模拟点击，一进来就显示信息
        btn1.performClick();





    }

    private void setSelected() {
        btn1.setSelected(false);
        btn2.setSelected(false);
        btn3.setSelected(false);
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);
        if (fg3 != null) fragmentTransaction.hide(fg3);

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = fManager.beginTransaction();
        hideAllFragment(ft);
        switch (v.getId()) {
            case R.id.btn1:
                setSelected();
                btn1.setSelected(true);
                btn1.setBackgroundColor(getResources().getColor(R.color.lan));
                btn2.setBackgroundColor(0);
                btn3.setBackgroundColor(0);
                if (fg1 == null) {
                    fg1 = new MyFragment1();
                    ft.add(R.id.fragment_parent, fg1);
                } else {
                    ft.show(fg1);
                }
                break;
            case R.id.btn2:
                setSelected();
                btn2.setSelected(true);

                //设置颜色切不可直接用#xxxxxx
                //应该用getResources().getColor(R.color.lan);在colors。xml文件中声明过lan色
                //取消背景色可以用setBackground(0);
                btn2.setBackgroundColor(getResources().getColor(R.color.lan));
                btn1.setBackgroundColor(0);
                btn3.setBackgroundColor(0);
                if (fg2 == null) {
                    fg2 = new MyFragment2();
                    ft.add(R.id.fragment_parent, fg2);
                } else {
                    ft.show(fg2);
                }
                break;
            case R.id.btn3:
                setSelected();
                btn3.setSelected(true);
                btn3.setBackgroundColor(getResources().getColor(R.color.lan));
                btn2.setBackgroundColor(0);
                btn1.setBackgroundColor(0);
                if (fg3 == null) {
                    fg3 = new MyFragment3();
                    ft.add(R.id.fragment_parent, fg3);
                } else {
                    ft.show(fg3);
                }
                break;
        }
        ft.commit();
    }
}
