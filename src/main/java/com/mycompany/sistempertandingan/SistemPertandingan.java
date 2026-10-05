package com.mycompany.sistempertandingan;

import java.util.Scanner;

public class SistemPertandingan {

    public static void cariOlahraga(String namaPertandingan, Olahraga[] daftarOlahraga, int jumlahOlahraga) {
        System.out.println("Mencari pertandingan dengan nama: " + namaPertandingan);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahOlahraga; i++) {
            if (daftarOlahraga[i].getNamaPertandingan().equalsIgnoreCase(namaPertandingan)) {
                daftarOlahraga[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Pertandingan tidak ditemukan.");
    }

    public static void cariOlahraga(String tim, Olahraga[] daftarOlahraga, int jumlahOlahraga, boolean cariBerdasarkanTim) {
        System.out.println("Mencari pertandingan dengan tim: " + tim);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahOlahraga; i++) {
            if (daftarOlahraga[i].getTim1().equalsIgnoreCase(tim) || daftarOlahraga[i].getTim2().equalsIgnoreCase(tim)) {
                daftarOlahraga[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Pertandingan tidak ditemukan.");
    }

    public static void simulasiPertandingan(Olahraga item) {
        item.mulaiPertandingan();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Olahraga[] daftarOlahraga = new Olahraga[10];

        int jumlahOlahraga = 0;
        boolean isRunning = true;

        System.out.println("==========================================");
        System.out.println("    SELAMAT DATANG DI SISTEM PERTANDINGAN   ");
        System.out.println("==========================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Pertandingan");
            System.out.println("2. Lihat Daftar Pertandingan");
            System.out.println("3. Cari Pertandingan (Fitur Overloading)");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: 1-4: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahOlahraga < daftarOlahraga.length) {
                        System.out.println("\n-- Pilih Jenis Pertandingan --");
                        System.out.println("1. Futsal");
                        System.out.println("2. Basket");
                        System.out.println("3. Voli");
                        System.out.print("Pilihan (1/2/3): ");

                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Pertandingan: ");
                        String namaBaru = scanner.nextLine();

                        System.out.print("Masukkan Tim 1: ");
                        String tim1Baru = scanner.nextLine();

                        System.out.print("Masukkan Tim 2: ");
                        String tim2Baru = scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Durasi (Menit): ");
                            int durasi = scanner.nextInt();
                            scanner.nextLine();

                            daftarOlahraga[jumlahOlahraga] = new Futsal(namaBaru, tim1Baru, tim2Baru, durasi);
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Jumlah Quarter: ");
                            int quarter = scanner.nextInt();
                            scanner.nextLine();

                            daftarOlahraga[jumlahOlahraga] = new Basket(namaBaru, tim1Baru, tim2Baru, quarter);
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Jumlah Set: ");
                            int set = scanner.nextInt();
                            scanner.nextLine();

                            daftarOlahraga[jumlahOlahraga] = new Voli(namaBaru, tim1Baru, tim2Baru, set);
                        }

                        jumlahOlahraga++;
                        System.out.println("Sukses! Pertandingan berhasil ditambahkan.");
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    } else {
                        System.out.println("Maaf, kapasitas daftar pertandingan sudah penuh!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Daftar Pertandingan ---");
                    if (jumlahOlahraga == 0) {
                        System.out.println("Belum ada pertandingan yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahOlahraga; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarOlahraga[i].tampilkanInfo();
                            simulasiPertandingan(daftarOlahraga[i]);
                            System.out.println("");
                        }
                    }

                    System.out.println("\nTotal Pertandingan Terdaftar: " + Olahraga.totalOlahragaBerhasilDibuat);
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("\n-- Fitur Cari Pertandingan --");
                    System.out.println("1. Cari berdasarkan Nama Pertandingan (String)");
                    System.out.println("2. Cari berdasarkan Tim (String & Boolean)");
                    System.out.print("Pilih (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Nama Pertandingan: ");
                        String kataKunci = scanner.nextLine();
                        cariOlahraga(kataKunci, daftarOlahraga, jumlahOlahraga);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Nama Tim: ");
                        String kataKunci = scanner.nextLine();
                        cariOlahraga(kataKunci, daftarOlahraga, jumlahOlahraga, true);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }

                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
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