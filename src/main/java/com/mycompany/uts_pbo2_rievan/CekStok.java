package com.mycompany.uts_pbo2_rievan;

public class CekStok implements OperasiGudang {

    @Override
    public void proses(Barang barang) {
        double nilaiTotal = barang.getJumlah() * barang.getHargaSatuan();
        String kondisi;

        if (barang.getJumlah() == 0) {
            kondisi = "[HABIS]  Segera lakukan pembelian bahan!";
        } else if (barang.getJumlah() < 5) {
            kondisi = "[KRITIS] Stok sangat menipis";
        } else if (barang.getJumlah() < 20) {
            kondisi = "[RENDAH] Pertimbangkan restock";
        } else {
            kondisi = "[AMAN]   Stok mencukupi";
        }

        System.out.println("+-----------------------------------------+");
        System.out.println("|          LAPORAN CEK STOK               |");
        System.out.println("+-----------------------------------------+");
        System.out.println("  ID Barang   : " + barang.getKodeBarang());
        System.out.println("  Nama        : " + barang.getNamaBarang());
        System.out.println("  Stok        : " + barang.getJumlah() + " " + barang.getSatuan());
        System.out.printf ("  Harga/Satuan: Rp%.0f%n", barang.getHargaSatuan());
        System.out.printf ("  Nilai Total : Rp%.0f%n", nilaiTotal);
        System.out.println("  Kondisi     : " + kondisi);
        System.out.println("+-----------------------------------------+");
    }

    @Override
    public String getNamaOperasi() { return "Cek Stok"; }
}
