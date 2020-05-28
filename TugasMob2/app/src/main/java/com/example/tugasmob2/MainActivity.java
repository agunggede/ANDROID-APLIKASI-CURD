package com.example.tugasmob2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


private MenuAdapter adapter;
private String [] dataNama;
private String [] dataDeskripsi;
private String [] dataHarga;
private String [] dataSpek;
private String [] dataToko;
private TypedArray dataGambar;
private ArrayList<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvlist = findViewById(R.id.lv_list);
        adapter=new MenuAdapter(this);
        lvlist.setAdapter(adapter);


        prepare();
        tambahItem();
        lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent pindah = new Intent(MainActivity.this,DetailActivity.class);
                pindah.putExtra(DetailActivity.datanama,menus.get(i).getNama());
                pindah.putExtra(DetailActivity.datadeskripsi,menus.get(i).getDeskripsi());
                pindah.putExtra(DetailActivity.dataspek,menus.get(i).getSpek());
                pindah.putExtra(DetailActivity.dataharga,menus.get(i).getHarga());
                pindah.putExtra(DetailActivity.datatoko,menus.get(i).getToko());
                pindah.putExtra(DetailActivity.datagambar,menus.get(i).getGambar());

                startActivity(pindah);
            }
        });

    }

    private void prepare(){
        dataNama=getResources().getStringArray(R.array.data_nama);
        dataDeskripsi=getResources().getStringArray(R.array.data_deskripsi);
        dataSpek=getResources().getStringArray(R.array.data_spek);
        dataHarga=getResources().getStringArray(R.array.data_harga);
        dataToko=getResources().getStringArray(R.array.data_toko);
        dataGambar=getResources().obtainTypedArray(R.array.data_image);
    }

    private void tambahItem(){
        menus = new ArrayList<>();

        for (int i=0;i<dataNama.length; i++){
            Menu menu = new Menu();
            menu.setGambar(dataGambar.getResourceId(i,-1));
            menu.setNama(dataNama[i]);
            menu.setDeskripsi(dataDeskripsi[i]);
            menu.setSpek(dataSpek[i]);
            menu.setHarga(dataHarga[i]);
            menu.setToko(dataToko[i]);
            menus.add(menu);
        }
        adapter.setMenus(menus);
    }

}
