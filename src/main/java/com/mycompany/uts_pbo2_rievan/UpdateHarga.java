package com.mycompany.uts_pbo2_rievan;

public class UpdateHarga implements OperasiGudang {

    private double hargaBaru;

    public UpdateHarga(double hargaBaru) {
        this.hargaBaru = hargaBaru;
    }

    @Override
    public void proses(Barang barang) {
        double hargaLama = barang.getHargaSatuan();
        double selisih   = hargaBaru - hargaLama;
        double persen    = (selisih / hargaLama) * 100;

        barang.setHargaSatuan(hargaBaru);

        System.out.println("+-----------------------------------------+");
        System.out.println("|         PROSES : UPDATE HARGA           |");
        System.out.println("+-----------------------------------------+");
        System.out.println("  ID Barang   : " + barang.getKodeBarang());
        System.out.println("  Nama        : " + barang.getNamaBarang());
        System.out.printf ("  Harga Lama  : Rp%.0f%n", hargaLama);
        System.out.printf ("  Harga Baru  : Rp%.0f%n", hargaBaru);
        System.out.printf ("  Selisih     : %s Rp%.0f (%.1f%%)%n",
            selisih >= 0 ? "+" : "", selisih, persen);
        System.out.printf ("  Nilai Stok  : Rp%.0f%n", barang.getJumlah() * hargaBaru);
        System.out.println("  Status      : [OK] Harga berhasil diperbarui");
        System.out.println("+-----------------------------------------+");
    }

    @Override
    public String getNamaOperasi() { return "Update Harga"; }
}
