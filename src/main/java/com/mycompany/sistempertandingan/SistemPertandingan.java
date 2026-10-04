package com.mycompany.sistempertandingan;
import java.util.Scanner;

public class SistemPertandingan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daftarPertandingan = new String[10];

        int jumlahPertandingan = 0;
        boolean isRunning = true;

        System.out.println("==========================================");
        System.out.println("    Selamat Datang di Sistem Pertandingan   ");
        System.out.println("==========================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Pertandingan");
            System.out.println("2. Lihat Daftar Pertandingan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahPertandingan < daftarPertandingan.length) {
                        System.out.print("Masukkan nama pertandingan baru: ");
                        String pertandinganBaru = scanner.nextLine();

                        daftarPertandingan[jumlahPertandingan] = pertandinganBaru;

                        jumlahPertandingan++;
                        System.out.println("Sukses! Pertandingan berhasil ditambahkan.");
                    } else {
                        System.out.println("Maaf, kapasitas daftar pertandingan sudah penuh!");
                    }
                    break;
                case 2:
                    System.out.println("\n--- Daftar Pertandingan ---");
                    if (jumlahPertandingan == 0) {
                        System.out.println("Belum ada pertandingan yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahPertandingan; i++) {
                            System.out.printf("%d. Pertandingan: %s%n", (i + 1), daftarPertandingan[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan Sistem Pertandingan!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-3.");
                    break;
            }
        }
        scanner.close();
    }
}