package com.bca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView itemsLv=findViewById(R.id.itemsLv);
            String names []={"sugam","Sangam","Saya","Prachanda","Nayan"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.list_view_items,R.id.namesTv,names);
        itemsLv.setAdapter(adapter);
    }
}