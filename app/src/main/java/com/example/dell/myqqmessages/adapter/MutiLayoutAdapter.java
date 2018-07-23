package com.example.dell.myqqmessages.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.myqqmessages.R;
import com.example.dell.myqqmessages.datas.App;
import com.example.dell.myqqmessages.datas.Book;

import java.util.ArrayList;

public class MutiLayoutAdapter extends BaseAdapter {
    //定义两个类别标志
    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;
    private Context mContext;
    private ArrayList<Object> mData = null;
    private Button bt1,bt2;

    public MutiLayoutAdapter(Context mContext, ArrayList<Object> mData, Button bt1,Button bt2) {
        this.mContext = mContext;
        this.mData = mData;
        this.bt1 = bt1;
        this.bt2 = bt2;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //多布局的核心，通过这个判断类别
    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof App) {
            return TYPE_APP;
        } else if (mData.get(position) instanceof Book) {
            return TYPE_BOOK;
        } else {
            return super.getItemViewType(position);
        }
    }

    //类别数目
    @Override
    public int getViewTypeCount() {
        return 2;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        if(convertView == null){
            switch (type){
                case TYPE_APP:
                    holder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_one, parent, false);
                    convertView.findViewById(R.id.img_icon).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(mContext,"sfas",Toast.LENGTH_SHORT).show();
                            //试试add
                        }
                    });
                    holder1.img_icon =  convertView.findViewById(R.id.img_icon);
                    holder1.txt_aname = convertView.findViewById(R.id.txt_aname);
                    convertView.setTag(R.id.Tag_APP,holder1);
                    break;
                case TYPE_BOOK:
                    holder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_two, parent, false);
                    holder2.txt_bname = convertView.findViewById(R.id.txt_bname);
                    holder2.txt_bauthor =  convertView.findViewById(R.id.txt_bauthor);
                    convertView.setTag(R.id.Tag_Book,holder2);
                    break;
            }
        }else{
            switch (type){
                case TYPE_APP:
                    holder1 = (ViewHolder1) convertView.getTag(R.id.Tag_APP);
                    break;
                case TYPE_BOOK:
                    holder2 = (ViewHolder2) convertView.getTag(R.id.Tag_Book);
                    break;
            }
        }

        Object obj = mData.get(position);
        //设置下控件的值
        switch (type){
            case TYPE_APP:
                App app = (App) obj;
                if(app != null){
                    holder1.img_icon.setImageResource(app.getImg());
                    holder1.txt_aname.setText(app.getName());
                }
                break;
            case TYPE_BOOK:
                Book book = (Book) obj;
                if(book != null){
                    holder2.txt_bname.setText(book.getName());
                    holder2.txt_bauthor.setImageResource(book.getImg());
                }
                break;
        }
        return convertView;
    }


    //两个不同的ViewHolder
    private static class ViewHolder1{
        ImageView img_icon;
        TextView txt_aname;
    }

    private static class ViewHolder2{
        TextView txt_bname;
        ImageView txt_bauthor;
    }
}
