package com.xylu.widgetdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class GridViewActivity extends Activity implements AdapterView.OnItemClickListener{

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);

        gridView = (GridView)findViewById(R.id.gridview);

        //写入数据
        ArrayList<HashMap<String, Object>> gridImageItem = new ArrayList<>();
        for(int i=0;i<10;i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("ItemImage", R.drawable.folder_img);
            map.put("ItemText", "NO." + String.valueOf(i));
            gridImageItem.add(map);
        }

        //生成适配器
        SimpleAdapter gridAdapter = new SimpleAdapter(this, gridImageItem, R.layout.gridview_item,
                new String[] {"ItemImage","ItemText"}, new int[] {R.id.gridview_item_img,R.id.gridview_item_txt});
        //添加并且显示
        gridView.setAdapter(gridAdapter);
        //添加消息处理
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent == gridView) {
            Intent intent = new Intent(this, ListViewActivity.class);
            this.startActivity(intent);
        }
    }
}
