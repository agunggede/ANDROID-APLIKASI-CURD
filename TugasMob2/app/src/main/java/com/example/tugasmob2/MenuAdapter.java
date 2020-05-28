package com.example.tugasmob2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.Viewholder> {
    private Context context;
    private ArrayList<Menu> menus;

    public MenuAdapter(Context context, ArrayList<Menu> lsgunpla) {
        this.context = context;
        menus=lsgunpla;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Menu menubaru = menus.get(position);
        String gambar = menubaru.getGambar();
        String nama = menubaru.getNama();
        String deskripsi = menubaru.getDeskripsi();
        String spek = menubaru.getSpek();
        String harga = menubaru.getHarga();
        String toko = menubaru.getToko();

        holder.tvnama.setText(nama);
        holder.tvdes.setText(deskripsi);
        Glide
                .with(context)
                .load(gambar)
                .centerCrop()
                .into(holder.image);


    }

    @Override
    public int getItemCount() {
        return menus.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView tvnama;
        public TextView tvdes;

        Viewholder(@NonNull View view){
            super(view);
            image=view.findViewById(R.id.img_menu);
            tvnama=view.findViewById(R.id.tv_menu);
            tvdes=view.findViewById(R.id.tv_desc);

        }

    }
}
