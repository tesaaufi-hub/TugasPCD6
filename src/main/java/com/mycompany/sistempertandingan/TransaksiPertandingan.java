package com.mycompany.sistempertandingan;

public class TransaksiPertandingan {
    public static void prosesPertandingan(Tim tim, Olahraga olahraga) {
        System.out.println("\n===== STRUK TRANSAKSI PERTANDINGAN =====");
        System.out.println("Tim Peserta : " + tim.getNamaTim() + " (" + tim.getIdTim() + ")");
        System.out.println("Pertandingan: " + olahraga.getNamaPertandingan());
        System.out.println("Status      : Berhasil dicatat di sistem.");

        olahraga.mulaiPertandingan();

        if (olahraga instanceof JadwalMatch) {
            ((JadwalMatch) olahraga).aturJadwal("15 November 2026", "Utama");
        }
        System.out.println("----------------------------------------");
    }
}