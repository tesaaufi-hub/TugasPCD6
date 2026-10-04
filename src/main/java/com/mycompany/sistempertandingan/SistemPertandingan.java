package com.mycompany.sistempertandingan;

import java.util.Scanner;

public class SistemPertandingan {

    public static void cariPertandingan(String namaPertandingan, Pertandingan[] daftarPertandingan, int jumlahPertandingan) {
        System.out.println("Mencari pertandingan dengan nama: " + namaPertandingan);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahPertandingan; i++) {
            if (daftarPertandingan[i].getNamaPertandingan().equalsIgnoreCase(namaPertandingan)) {
                System.out.print("- Ditemukan: ");
                daftarPertandingan[i].tampilkanInfoPertandingan();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Pertandingan tidak ditemukan.");
    }

    public static void cariPertandingan(String tim, Pertandingan[] daftarPertandingan, int jumlahPertandingan, boolean cariBerdasarkanTim) {
        System.out.println("Mencari pertandingan dengan tim: " + tim);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahPertandingan; i++) {
            if (daftarPertandingan[i].getTim1().equalsIgnoreCase(tim) || daftarPertandingan[i].getTim2().equalsIgnoreCase(tim)) {
                System.out.print("- Ditemukan: ");
                daftarPertandingan[i].tampilkanInfoPertandingan();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Pertandingan tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pertandingan[] daftarPertandingan = new Pertandingan[10];

        int jumlahPertandingan = 0;
        boolean isRunning = true;

        System.out.println("==========================================");
        System.out.println("    SELAMAT DATANG DI SISTEM PERTANDINGAN   ");
        System.out.println("==========================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Pertandingan");
            System.out.println("2. Lihat Daftar Pertandingan");
            System.out.println("3. Cari Pertandingan");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: 1-4: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahPertandingan < daftarPertandingan.length) {
                        System.out.println("\n-- Form Tambah Pertandingan --");

                        System.out.print("Masukkan Nama Pertandingan: ");
                        String namaBaru = scanner.nextLine();

                        System.out.print("Masukkan Tim 1: ");
                        String tim1Baru = scanner.nextLine();

                        System.out.print("Masukkan Tim 2: ");
                        String tim2Baru = scanner.nextLine();

                        Pertandingan pertandinganBaru = new Pertandingan(namaBaru, tim1Baru, tim2Baru);

                        daftarPertandingan[jumlahPertandingan] = pertandinganBaru;

                        jumlahPertandingan++;
                        System.out.println("Sukses! Objek Pertandingan berhasil diciptakan dan ditambahkan.");
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
                            System.out.print((i + 1) + ". ");
                            daftarPertandingan[i].tampilkanInfoPertandingan();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Cari Pertandingan ---");
                    System.out.println("1. Cari Berdasarkan Nama Pertandingan");
                    System.out.println("2. Cari Berdasarkan Nama Tim");
                    System.out.print("Pilih Opsi Cari (1-2): ");
                    int opsiCari = scanner.nextInt();
                    scanner.nextLine();

                    if (opsiCari == 1) {
                        System.out.print("Masukkan Nama Pertandingan: ");
                        String namaCari = scanner.nextLine();
                        cariPertandingan(namaCari, daftarPertandingan, jumlahPertandingan);
                    } else if (opsiCari == 2) {
                        System.out.print("Masukkan Nama Tim: ");
                        String timCari = scanner.nextLine();
                        cariPertandingan(timCari, daftarPertandingan, jumlahPertandingan, true);
                    } else {
                        System.out.println("Opsi pencarian tidak valid.");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan Sistem Pertandingan!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silahkan masukkan angka 1-4.");
                    break;
            }
        }
        scanner.close();
    }
}