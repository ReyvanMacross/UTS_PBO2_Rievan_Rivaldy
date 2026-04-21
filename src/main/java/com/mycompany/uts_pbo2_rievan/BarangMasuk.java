package com.mycompany.uts_pbo2_rievan;

public class BarangMasuk implements OperasiGudang {

    private int jumlahMasuk;

    public BarangMasuk(int jumlahMasuk) {
        this.jumlahMasuk = jumlahMasuk;
    }

    @Override
    public void proses(Barang barang) {
        int stokLama = barang.getJumlah();
        barang.setJumlah(stokLama + jumlahMasuk);

        System.out.println("+-----------------------------------------+");
        System.out.println("|         PROSES : BARANG MASUK           |");
        System.out.println("+-----------------------------------------+");
        System.out.println("  ID Barang  : " + barang.getKodeBarang());
        System.out.println("  Nama       : " + barang.getNamaBarang());
        System.out.println("  Stok Lama  : " + stokLama + " " + barang.getSatuan());
        System.out.println("  Masuk      : " + jumlahMasuk + " " + barang.getSatuan());
        System.out.println("  Stok Baru  : " + barang.getJumlah() + " " + barang.getSatuan());
        System.out.printf ("  Total Nilai: Rp%.0f%n", barang.getJumlah() * barang.getHargaSatuan());
        System.out.println("  Status     : [OK] Stok berhasil ditambahkan");
        System.out.println("+-----------------------------------------+");
    }

    @Override
    public String getNamaOperasi() { return "Barang Masuk"; }
}
