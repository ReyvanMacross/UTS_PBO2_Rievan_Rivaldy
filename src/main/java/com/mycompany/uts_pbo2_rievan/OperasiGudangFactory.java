package com.mycompany.uts_pbo2_rievan;

import java.util.Map;
import java.util.Scanner;

public class OperasiGudangFactory {

    public static OperasiGudang create(String nomorMenu, Scanner scanner,
                                       Map<String, Barang> dataGudang) {
        switch (nomorMenu) {
            case "1": {
                System.out.print("  Jumlah barang masuk  : ");
                int jumlah = scanner.nextInt();
                return new BarangMasuk(jumlah);
            }
            case "2": {
                System.out.print("  Jumlah barang keluar : ");
                int jumlah = scanner.nextInt();
                return new BarangKeluar(jumlah);
            }
            case "3": {
                return new CekStok();
            }
            case "4": {
                System.out.print("  Harga baru (Rp)      : ");
                double harga = scanner.nextDouble();
                return new UpdateHarga(harga);
            }
            case "5": {
                System.out.print("  ID Barang Baru       : ");
                String kode = scanner.next().trim();
                scanner.nextLine(); 
                System.out.print("  Nama Barang          : ");
                String nama = scanner.nextLine().trim();
                System.out.print("  Stok Awal            : ");
                int jumlah = scanner.nextInt();
                System.out.print("  Satuan (Kg/Liter/Pcs): ");
                String satuan = scanner.next().trim();
                System.out.print("  Harga/Satuan (Rp)    : ");
                double harga = scanner.nextDouble();
                return new TambahBarangBaru(dataGudang, kode, nama, jumlah, satuan, harga);
            }
            default:
                System.out.println("  ! Pilihan tidak valid: " + nomorMenu);
                return null;
        }
    }
}
