package com.xylu.widgetdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends Activity implements AdapterView.OnItemClickListener{

    private ListView listView;

    private  ArrayList<String> listViewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listView = (ListView)findViewById(R.id.listview);

        //写入数据
        listViewItem = new ArrayList<>();
        for(int i=0;i<10;i++) {
            listViewItem.add("file" + String.valueOf(i));
        }

        //生成适配器
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>(this, R.layout.listview_item, R.id.listview_item_txt, listViewItem);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (parent == listView) {
                Toast.makeText(this, listViewItem.get(position), Toast.LENGTH_SHORT).show();
            }
    }
}
