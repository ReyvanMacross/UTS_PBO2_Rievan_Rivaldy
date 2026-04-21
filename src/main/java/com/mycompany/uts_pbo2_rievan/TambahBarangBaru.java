package com.mycompany.uts_pbo2_rievan;

import java.util.Map;

public class TambahBarangBaru implements OperasiGudang {

 private Map<String, Barang> dataGudang;
 private String kode;
 private String nama;
 private int jumlah;
 private String satuan;
 private double harga;

 public TambahBarangBaru(Map<String, Barang> dataGudang,
         String kode, String nama,
         int jumlah, String satuan, double harga) {
  this.dataGudang = dataGudang;
  this.kode = kode.toUpperCase();
  this.nama = nama;
  this.jumlah = jumlah;
  this.satuan = satuan;
  this.harga = harga;
 }

 @Override
 public void proses(Barang barang) {
  if (dataGudang.containsKey(kode)) {
   System.out.println("+-----------------------------------------+");
   System.out.println("|       PROSES : TAMBAH BARANG BARU       |");
   System.out.println("+-----------------------------------------+");
   System.out.println("  ID Barang  : " + kode);
   System.out.println("  Status     : [GAGAL] ID sudah terdaftar!");
   System.out.println("  Info       : Gunakan menu Barang Masuk");
   System.out.println("               untuk menambah stok.");
   System.out.println("+-----------------------------------------+");
   return;
  }

  Barang baru = new Barang(kode, nama, jumlah, satuan, harga);
  dataGudang.put(kode, baru);

  System.out.println("+-----------------------------------------+");
  System.out.println("|       PROSES : TAMBAH BARANG BARU       |");
  System.out.println("+-----------------------------------------+");
  System.out.println("  ID Barang    : " + kode);
  System.out.println("  Nama         : " + nama);
  System.out.println("  Stok Awal    : " + jumlah + " " + satuan);
  System.out.printf("  Harga/Satuan : Rp%.0f%n", harga);
  System.out.printf("  Nilai Awal   : Rp%.0f%n", jumlah * harga);
  System.out.println("  Status       : [OK] Barang baru berhasil didaftarkan");
  System.out.println("+-----------------------------------------+");
 }

 @Override
 public String getNamaOperasi() {
  return "Tambah Barang Baru";
 }
}
