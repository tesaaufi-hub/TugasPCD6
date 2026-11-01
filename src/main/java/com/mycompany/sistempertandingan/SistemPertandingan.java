package com.mycompany.sistempertandingan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemPertandingan {

    public static void cariOlahraga(String namaPertandingan, ArrayList<Olahraga> daftarOlahraga) throws PertandinganTidakDitemukanException {
        System.out.println("Mencari Pertandingan dengan Nama: " + namaPertandingan);
        boolean ditemukan = false;

        for (int i = 0; i < daftarOlahraga.size(); i++) {
            if (daftarOlahraga.get(i).getNamaPertandingan().equalsIgnoreCase(namaPertandingan)) {
                daftarOlahraga.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new PertandinganTidakDitemukanException("Gagal: Pertandingan dengan nama '" + namaPertandingan + "' tidak terdaftar di sistem.");
        }
    }

    public static void simulasiPertandingan(Olahraga item) {
        item.mulaiPertandingan();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Olahraga> daftarOlahraga = new ArrayList<>();
        HashMap<String, String> dataTim = new HashMap<>();

        boolean isRunning = true;

        System.out.println("==========================================");
        System.out.println("    SELAMAT DATANG DI SISTEM PERTANDINGAN   ");
        System.out.println("==========================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Pertandingan");
            System.out.println("2. Lihat Daftar Pertandingan");
            System.out.println("3. Cari Pertandingan (Demo Custom Exception)");
            System.out.println("4. Kelola Data Tim (HashMap)");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu: 1-5: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
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
                            daftarOlahraga.add(new Futsal(namaBaru, tim1Baru, tim2Baru, durasi));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Jumlah Quarter: ");
                            int quarter = scanner.nextInt();
                            scanner.nextLine();
                            daftarOlahraga.add(new Basket(namaBaru, tim1Baru, tim2Baru, quarter));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Jumlah Set: ");
                            int set = scanner.nextInt();
                            scanner.nextLine();
                            daftarOlahraga.add(new Voli(namaBaru, tim1Baru, tim2Baru, set));
                        }

                        System.out.println("Sukses! Pertandingan berhasil ditambahkan. (Total Pertandingan: " + daftarOlahraga.size() + ")");
                        break;

                    case 2:
                        System.out.println("\n--- Daftar Pertandingan ---");
                        if (daftarOlahraga.isEmpty()) {
                            System.out.println("Belum ada pertandingan yang tersimpan.");
                        } else {
                            for (int i = 0; i < daftarOlahraga.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarOlahraga.get(i).tampilkanInfo();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n-- Fitur Cari Pertandingan --");
                        System.out.print("Masukkan Nama Pertandingan: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            cariOlahraga(kataKunci, daftarOlahraga);
                        } catch (PertandinganTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }
                        break;

                    case 4:
                        System.out.println("\n-- Kelola Data Tim (HashMap) --");
                        System.out.println("1. Tambah Tim Baru");
                        System.out.println("2. Cari Tim via ID Tim");
                        System.out.println("3. Tampilkan Semua Tim");
                        System.out.print("Pilih: ");
                        int menuTim = scanner.nextInt();
                        scanner.nextLine();

                        if (menuTim == 1) {
                            System.out.print("Masukkan ID Tim (sebagai Key): ");
                            String idTim = scanner.nextLine();
                            System.out.print("Masukkan Nama Tim Lengkap (sebagai Value): ");
                            String namaTim = scanner.nextLine();

                            dataTim.put(idTim, namaTim);
                            System.out.println("Berhasil menambahkan tim!");

                        } else if (menuTim == 2) {
                            System.out.print("Masukkan ID Tim yang dicari: ");
                            String searchId = scanner.nextLine();

                            if (dataTim.containsKey(searchId)) {
                                System.out.println("Ditemukan! Nama Tim: " + dataTim.get(searchId));
                            } else {
                                System.out.println("Tim dengan ID tersebut tidak terdaftar.");
                            }

                        } else if (menuTim == 3) {
                            System.out.println("Total Tim Terdaftar: " + dataTim.size());
                            for (String keyId : dataTim.keySet()) {
                                System.out.println("- ID Tim: " + keyId + " | Nama Tim: " + dataTim.get(keyId));
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Terima kasih telah menggunakan Sistem Pertandingan!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan angka.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] Terjadi kegagalan: " + e.getMessage());
            }
        }
        scanner.close();
    }
}