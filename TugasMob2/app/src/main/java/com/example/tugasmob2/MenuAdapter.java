package com.example.tugasmob2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Menu> menus=new ArrayList<>();

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public MenuAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int i) {
        return menus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView= view;
        if (itemView==null){
            itemView= LayoutInflater.from(context).inflate(R.layout.item_menu,viewGroup, false);

        }

        Viewholder viewholder = new Viewholder(itemView);
        Menu menu= (Menu) getItem(i);
        viewholder.bind(menu);
        return itemView;
    }
    private class Viewholder{
        private TextView tvnama;
        private TextView tvdes;
        private ImageView image;
        Viewholder(View view){
            tvnama=view.findViewById(R.id.tv_menu);
            tvdes=view.findViewById(R.id.tv_desc);
            image=view.findViewById(R.id.img_menu);
        }
        void bind(Menu menu){
            tvnama.setText(menu.getNama());
            tvdes.setText(menu.getDeskripsi());
            image.setImageResource(menu.getGambar());
        }


    }
}
