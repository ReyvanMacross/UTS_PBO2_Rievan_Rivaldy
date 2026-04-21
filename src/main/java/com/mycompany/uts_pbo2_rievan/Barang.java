package com.mycompany.uts_pbo2_rievan;

public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private int jumlah;
    private String satuan;
    private double hargaSatuan;

    public Barang(String kodeBarang, String namaBarang, int jumlah, String satuan, double hargaSatuan) {
        this.kodeBarang  = kodeBarang;
        this.namaBarang  = namaBarang;
        this.jumlah      = jumlah;
        this.satuan      = satuan;
        this.hargaSatuan = hargaSatuan;
    }

    public String getKodeBarang()  { return kodeBarang; }
    public String getNamaBarang()  { return namaBarang; }
    public int    getJumlah()      { return jumlah; }
    public String getSatuan()      { return satuan; }
    public double getHargaSatuan() { return hargaSatuan; }

    public void setJumlah(int jumlah)        { this.jumlah      = jumlah; }
    public void setHargaSatuan(double harga) { this.hargaSatuan = harga; }

    public String toDisplayString() {
        return String.format(
            "  ID Barang  : %s%n" +
            "  Nama       : %s%n" +
            "  Stok       : %d %s%n" +
            "  Harga/Satuan: Rp%.0f",
            kodeBarang, namaBarang, jumlah, satuan, hargaSatuan
        );
    }
}
