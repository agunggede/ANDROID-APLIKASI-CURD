package com.example.tugasmob2;

public class Menu {
    private String gambar;
    private String nama;
    private String deskripsi;
    private String spek;
    private String harga;
    private String toko;

    public Menu(String gambar, String nama, String deskripsi) {
        this.gambar = gambar;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.spek = spek;
        this.harga = harga;
        this.toko = toko;
    }

    public String getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getSpek() {
        return spek;
    }

    public String getHarga() {
        return harga;
    }

    public String getToko() {
        return toko;
    }
}

