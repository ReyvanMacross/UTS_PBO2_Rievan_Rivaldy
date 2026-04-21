package com.mycompany.uts_pbo2_rievan;

public class GudangManager {

    private OperasiGudang operasi;

    public void setOperasi(OperasiGudang operasi) {
        this.operasi = operasi;
    }

    public void jalankanOperasi(Barang barang) {
        if (operasi == null) {
            System.out.println("  ! Tidak ada operasi yang dipilih.");
            return;
        }
        operasi.proses(barang);
    }
}
