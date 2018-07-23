package com.example.dell.myqqmessages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.example.dell.myqqmessages.adapter.MutiLayoutAdapter;
import com.example.dell.myqqmessages.datas.App;
import com.example.dell.myqqmessages.datas.Book;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;*/
    private ListView listView;
    private Button bt1,bt2;
    private ArrayList<Object> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);

        arrayList = new ArrayList<>();


       /* for(int i = 0;i < 20;i++){
            switch ((int)(Math.random() * 2)){
                case TYPE_BOOK:
                    arrayList.add(new Book("《第一行代码》",R.mipmap.ic_launcher));
                    break;
                case TYPE_APP:
                    arrayList.add(new App("百度",R.mipmap.duolaam));
                    break;
            }
        }*/

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);

    }
    private int a = 0,b=0;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt1:
                arrayList.add(new App("百度"+a,R.mipmap.duolaam));
                a++;
                break;
            case R.id.bt2:
                arrayList.add(new Book("《第一行代码》"+b,R.mipmap.ic_launcher));
                b++;
                Toast.makeText(MainActivity.this,"fsaf",Toast.LENGTH_SHORT).show();
                break;

        }
        MutiLayoutAdapter mutiLayoutAdapter = new MutiLayoutAdapter(MainActivity.this,arrayList,bt1,bt2);
        listView.setAdapter(mutiLayoutAdapter);

    }
}
