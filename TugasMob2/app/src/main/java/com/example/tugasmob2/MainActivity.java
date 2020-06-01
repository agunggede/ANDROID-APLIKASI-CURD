package com.example.tugasmob2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MenuAdapter.OnItemClickListener {

    public static final String Extra_Nama = "nama";
    public static final String Extra_Deskripsi = "deskripsi";
    public static final String Extra_Gambar = "image";

    private MenuAdapter menuAdapter;
    private RecyclerView recyclerView;
    private int jumdata;
    private RequestQueue requestQueue;
    private ArrayList<Menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.lv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        menus = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);
        parseJSON();





    }

    private void parseJSON() {
        String url = "http://gunplastoreagung.000webhostapp.com/koneksi.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jumdata = response.length();
                        try {
                            for (int i = 0; i < jumdata; i++) {
                                JSONObject data = response.getJSONObject(i);
                                String deskripsi = data.getString("deskripsi");
                                String image = data.getString("image");
                                String nama = data.getString("nama");
                                menus.add(new Menu(image, nama, deskripsi));
                            }
                            menuAdapter = new MenuAdapter(MainActivity.this, menus);
                            recyclerView.setAdapter(menuAdapter);
                            menuAdapter.setOnItemClickListener(MainActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent pindah = new Intent(MainActivity.this,DetailActivity.class);
        Menu clickedItem = menus.get(position);

        pindah.putExtra(Extra_Gambar, clickedItem.getGambar());
        pindah.putExtra(Extra_Nama, clickedItem.getNama());
        pindah.putExtra(Extra_Deskripsi, clickedItem.getDeskripsi());

        startActivity(pindah);
    }
}



