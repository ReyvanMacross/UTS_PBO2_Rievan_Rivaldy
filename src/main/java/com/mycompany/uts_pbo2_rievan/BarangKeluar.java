package com.mycompany.uts_pbo2_rievan;

public class BarangKeluar implements OperasiGudang {

    private int jumlahKeluar;

    public BarangKeluar(int jumlahKeluar) {
        this.jumlahKeluar = jumlahKeluar;
    }

    @Override
    public void proses(Barang barang) {
        int stokLama = barang.getJumlah();

        System.out.println("+-----------------------------------------+");
        System.out.println("|         PROSES : BARANG KELUAR          |");
        System.out.println("+-----------------------------------------+");
        System.out.println("  ID Barang  : " + barang.getKodeBarang());
        System.out.println("  Nama       : " + barang.getNamaBarang());
        System.out.println("  Stok Saat Ini: " + stokLama + " " + barang.getSatuan());
        System.out.println("  Keluar     : " + jumlahKeluar + " " + barang.getSatuan());

        if (jumlahKeluar > stokLama) {
            System.out.println("  Status     : [GAGAL] Stok tidak mencukupi!");
            System.out.println("+-----------------------------------------+");
            return;
        }

        barang.setJumlah(stokLama - jumlahKeluar);
        System.out.println("  Stok Baru  : " + barang.getJumlah() + " " + barang.getSatuan());
        System.out.printf ("  Nilai Keluar: Rp%.0f%n", jumlahKeluar * barang.getHargaSatuan());

        String kondisi = barang.getJumlah() < 5
            ? "  Status     : [!] Stok kritis, segera restock!"
            : "  Status     : [OK] Pengeluaran berhasil";
        System.out.println(kondisi);
        System.out.println("+-----------------------------------------+");
    }

    @Override
    public String getNamaOperasi() { return "Barang Keluar"; }
}
