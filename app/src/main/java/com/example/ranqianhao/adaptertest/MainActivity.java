package com.example.ranqianhao.adaptertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] name = {"张三","李四","王麻子","李雷","韩梅梅"};
    private List<Map<String,Object>>list_map = new ArrayList<Map<String,Object>>();
    private ListView listView;
    private int[] images = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       listView = (ListView)findViewById(R.id.list_item);
        for(int i=0;i<5;i++){
            Map<String,Object> items = new HashMap<String, Object>(); //创建一个键值对的Map集合，用来存放名字和头像
            items.put("pic", images[i]);  //放入头像， 根据下标获取数组
            items.put("name", name[i]);      //放入名字， 根据下标获取数组
            list_map.add(items);   //把这个存放好数据的Map集合放入到list中，这就完成类数据源的准备工作
        }

        //2、创建适配器（可以使用外部类的方式、内部类方式等均可）
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                MainActivity.this,/*传入一个上下文作为参数*/
                list_map,         /*传入相对应的数据源，这个数据源不仅仅是数据而且还是和界面相耦合的混合体。*/
                R.layout.listview, /*设置具体某个items的布局，需要是新的布局，而不是ListView控件的布局*/
                new String[]{"pic","name"}, /*传入上面定义的键值对的键名称,会自动根据传入的键找到对应的值*/
                new int[]{R.id.items_imageView1,R.id.items_textView1});/*传入items布局文件中需要指定传入的控件，这里直接上id即可*/
//        //初始化适配器
//        adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,datas);
//        listView.setAdapter(adapter);
        //3、为listView加入适配器
        listView.setAdapter(simpleAdapter);

    }
}
