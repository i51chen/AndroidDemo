package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public int[] idArray = {R.id.act0,R.id.act1, R.id.act2, R.id.act3, R.id.act4, R.id.act5, R.id.act6, R.id.act7, R.id.act8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < idArray.length; i++) {
            findViewById(idArray[i]).setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == idArray[0]) {
            Intent intent = new Intent(MainActivity.this, ArrayAdapterActivity.class);
            startActivity(intent);
        }
        if (v.getId() == idArray[1]) {
            Intent intent = new Intent(MainActivity.this, act1.class);
            startActivity(intent);
        }
        if (v.getId() == idArray[2]) {
            Intent intent = new Intent(MainActivity.this, act2.class);
            startActivity(intent);
        }
        if (v.getId() == idArray[3]) {
            Intent intent = new Intent(MainActivity.this, act3.class);
            startActivity(intent);
        }


    }
}
