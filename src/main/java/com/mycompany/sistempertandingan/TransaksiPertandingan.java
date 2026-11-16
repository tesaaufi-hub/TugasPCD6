package com.mycompany.sistempertandingan;

import java.io.FileWriter;
import java.io.IOException;

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

        try (FileWriter pipaTulis = new FileWriter("log_transaksi.txt", true)) {
            String log = "Tim Peserta: " + tim.getNamaTim() + " | Pertandingan: " + olahraga.getNamaPertandingan() + "\n";
            pipaTulis.write(log);
        } catch (IOException e) {
            System.out.println("Peringatan: Gagal menulis log transaksi ke file. " + e.getMessage());
        }
    }
}