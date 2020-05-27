package com.example.tugasmob2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URISyntaxException;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String datanama="datanama";
    public static final String datadeskripsi="datadeskripsi";
    public static final String dataharga="dataharga";
    public static final String datatoko="datatoko";
    public static final String dataspek="dataspek";
    public static final String datagambar="datagambar";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvnama = findViewById(R.id.tv_nama);
        TextView tvharga = findViewById(R.id.tv_harga);
        TextView tvspek = findViewById(R.id.tv_spek);
        TextView tvtoko = findViewById(R.id.tv_toko);
        TextView tvdeskripsi = findViewById(R.id.tv_deskripsi);
        ImageView ivgambar = findViewById(R.id.iv_gambar);
        Button btnbeli = findViewById(R.id.btn_beli);


        tvnama.setText(getIntent().getStringExtra(datanama));
        tvdeskripsi.setText(getIntent().getStringExtra(datadeskripsi));
        tvharga.setText(getIntent().getStringExtra(dataharga));
        tvspek.setText(getIntent().getStringExtra(dataspek));
        tvtoko.setText(getIntent().getStringExtra(datatoko));
        ivgambar.setImageResource(getIntent().getIntExtra(datagambar,0));

        btnbeli.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try {
            String nomerWa = "6282247831612";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+nomerWa));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
