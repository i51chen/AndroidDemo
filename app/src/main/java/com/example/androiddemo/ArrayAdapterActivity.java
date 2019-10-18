package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrayadapter);

    String[] strs = {"语文","数学","英语","体育"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
        ,android.R.layout.simple_expandable_list_item_1,strs);
        ListView listView = findViewById(R.id.lw1);
        listView.setAdapter(adapter);

    }
}
