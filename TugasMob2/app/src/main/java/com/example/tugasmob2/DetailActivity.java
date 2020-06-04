package com.example.tugasmob2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.net.URISyntaxException;

import static com.example.tugasmob2.MainActivity.Extra_Deskripsi;
import static com.example.tugasmob2.MainActivity.Extra_Gambar;
import static com.example.tugasmob2.MainActivity.Extra_Harga;
import static com.example.tugasmob2.MainActivity.Extra_Nama;
import static com.example.tugasmob2.MainActivity.Extra_Spek;


public class DetailActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();
        String gambar = intent.getStringExtra(Extra_Gambar);
        String nama = intent.getStringExtra(Extra_Nama);
        String harga = intent.getStringExtra(Extra_Harga);
        String deskripsi = intent.getStringExtra(Extra_Deskripsi);
        String spek = intent.getStringExtra(Extra_Spek);


        TextView tvnama = findViewById(R.id.tv_nama);
        TextView tvharga = findViewById(R.id.tv_harga);
        TextView tvdeskripsi = findViewById(R.id.tv_deskripsi);
        ImageView ivgambar = findViewById(R.id.iv_gambar);
        TextView tvspek = findViewById(R.id.tv_spek);
        Button btnbeli = findViewById(R.id.btn_beli);

        Glide.with(this).load(gambar).fitCenter().into(ivgambar);
        tvharga.setText(harga);
        tvnama.setText(nama);
        tvdeskripsi.setText(deskripsi);
        tvspek.setText(spek);

        btnbeli.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        try{
            String nomerWa = "6282247831612";

            Intent beli = new Intent(Intent.ACTION_VIEW);
            beli.setData(Uri.parse("http://api.whatsapp.com/send?phone="+nomerWa));
            startActivity(beli);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
