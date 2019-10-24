package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class act5Login extends AppCompatActivity implements View.OnClickListener {
    public String name, pwd;
    public EditText EditText1, EditText2;
    public Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act5_login);
        EditText1 = findViewById(R.id.login_edit_account);
        EditText2 = findViewById(R.id.login_edit_pwd);
        login = findViewById(R.id.login_btn_login);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_btn_login) {

//Toast.makeText(act5Login.this, name, Toast.LENGTH_LONG).show();
            //获取输入内容并转为字符串，然后去掉收尾空格
            name = EditText1.getText().toString().trim();
            pwd = EditText2.getText().toString().trim();
            if (name.equals("root") && pwd.equals("root") || name.equals("123") && pwd.equals("1")) {
                Intent intent = new Intent(act5Login.this, act4.class);

                //将name值存在一个bundle
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Toast.makeText(act5Login.this, "输入错误，请重新输入", Toast.LENGTH_SHORT).show();
                //clean密码输入行
                EditText2.setText("");
            }
        }
    }
}
