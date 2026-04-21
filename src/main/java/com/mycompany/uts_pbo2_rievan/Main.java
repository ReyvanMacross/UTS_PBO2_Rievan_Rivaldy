/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uts_pbo2_rievan;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<String, Barang> dataGudang = new LinkedHashMap<>();

    public static void main(String[] args) {
        inisialisasiData();

        Scanner scanner = new Scanner(System.in);
        GudangManager manager = new GudangManager();

        boolean lanjut = true;

        while (lanjut) {
            tampilkanHeader();
            tampilkanDaftarBarang();
            tampilkanMenu();

            System.out.print("  Pilih operasi (1-5 / 0 keluar): ");
            String pilihan = scanner.next().trim();

            if (pilihan.equals("0")) {
                System.out.println("\n  Terima kasih! Program selesai.");
                System.out.println("=========================================\n");
                lanjut = false;
                continue;
            }

            if (!pilihan.matches("[1-5]")) {
                System.out.println("\n  ! Pilihan tidak valid, masukkan angka 1-5.\n");
                continue;
            }

            Barang barang = null;
            if (!pilihan.equals("5")) {
                System.out.print("  Masukkan ID Barang    : ");
                String kode = scanner.next().trim().toUpperCase();
                barang = dataGudang.get(kode);
                if (barang == null) {
                    System.out.println("\n  ! ID barang tidak ditemukan.\n");
                    continue;
                }
            }

            System.out.println();

            OperasiGudang operasi = OperasiGudangFactory.create(pilihan, scanner, dataGudang);

            if (operasi == null) {
                System.out.println("\n  ! Operasi tidak valid.\n");
                continue;
            }

            System.out.println();

            manager.setOperasi(operasi);
            manager.jalankanOperasi(barang);

            System.out.println();
        }

        scanner.close();
    }

    
    private static void inisialisasiData() {
        dataGudang.put("KOP001", new Barang("KOP001", "Biji Kopi Arabika",50,"kg",120000));
        dataGudang.put("KOP002", new Barang("KOP002", "Biji Kopi Robusta",80,"kg",85000));
        dataGudang.put("KOP003", new Barang("KOP003", "Susu Full Cream",30,"liter",18000));
        dataGudang.put("KOP004", new Barang("KOP004", "Gula Pasir",25,"kg",14000));
        dataGudang.put("KOP005", new Barang("KOP005", "Sirup Vanilla",4,"botol",45000));
        dataGudang.put("KOP006", new Barang("KOP006", "Coklat Bubuk",15,"kg",95000));
        dataGudang.put("KOP007", new Barang("KOP007", "Creamer Sachet",200,"pcs",1500));
        dataGudang.put("KOP008", new Barang("KOP008", "Biji Kopi Luwak",100,"pack",8000));
    }

    private static void tampilkanDaftarBarang() {
        System.out.println("\n  === DAFTAR PERSEDIAAN GUDANG KOPI ===");

        String garis = "  +---------+------------------------+-------+---------+---------------+";
        System.out.println(garis);

        System.out.printf("  | %-7s | %-22s | %-5s | %-7s | %-13s |%n",
            "ID Brng", "Nama Barang", "Stok", "Satuan", "Harga/Satuan");
        System.out.println(garis);

        for (Barang b : dataGudang.values()) {
            System.out.printf("  | %-7s | %-22s | %5d | %-7s | Rp%,10.0f |%n",
                b.getKodeBarang(),
                b.getNamaBarang(),
                b.getJumlah(),
                b.getSatuan(),
                b.getHargaSatuan()
            );
        }

        System.out.println(garis);
        System.out.println();
    }

    private static void tampilkanHeader() {
        System.out.println("\n===========================================");
        System.out.println("   SISTEM PERSEDIAAN GUDANG PERKOPIAN   ");
        System.out.println("   Rievan Rivaldy Nur Triana | 24552011030");
        System.out.println("===========================================");
    }

    private static void tampilkanMenu() {
        System.out.println("  === MENU OPERASI ===");
        System.out.println("  1. Barang Masuk       (tambah kuantitas stok)");
        System.out.println("  2. Barang Keluar      (kurangi stok)");
        System.out.println("  3. Cek Stok           (lihat detail & kondisi)");
        System.out.println("  4. Update Harga       (ubah harga satuan)");
        System.out.println("  5. Tambah Barang Baru (daftarkan item baru)");
        System.out.println("  0. Keluar\n");
    }
}