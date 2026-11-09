package com.mycompany.sistempertandingan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemPertandingan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stadion stadion = new Stadion("Stadion Utama");
        stadion.bukaStadion();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Pertandingan");
            System.out.println("2. Lihat Daftar Pertandingan");
            System.out.println("3. Cari Pertandingan");
            System.out.println("4. Kelola Tim");
            System.out.println("5. Transaksi Pertandingan (Demo Association)");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu: 1-6: ");

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
                        String nama = scanner.nextLine();

                        System.out.print("Masukkan Tim 1: ");
                        String tim1 = scanner.nextLine();

                        System.out.print("Masukkan Tim 2: ");
                        String tim2 = scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Durasi (Menit): ");
                            stadion.tambahOlahraga(new Futsal(nama, tim1, tim2, scanner.nextInt()));
                            scanner.nextLine();
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Jumlah Quarter: ");
                            stadion.tambahOlahraga(new Basket(nama, tim1, tim2, scanner.nextInt()));
                            scanner.nextLine();
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Jumlah Set: ");
                            stadion.tambahOlahraga(new Voli(nama, tim1, tim2, scanner.nextInt()));
                            scanner.nextLine();
                        }
                        break;

                    case 2:
                        System.out.println("\n--- Daftar Pertandingan di Stadion ---");
                        stadion.lihatSemuaOlahraga();
                        break;

                    case 3:
                        System.out.println("\n-- Fitur Cari Pertandingan --");
                        System.out.print("Masukkan Nama Pertandingan: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            stadion.cariOlahraga(kataKunci);
                        } catch (PertandinganTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.println("\n-- Kelola Tim --");
                        System.out.println("1. Tambah Tim");
                        System.out.println("2. Cari Tim");
                        System.out.println("3. Lihat Semua");
                        System.out.print("Pilih: ");
                        int menuA = scanner.nextInt();
                        scanner.nextLine();

                        if (menuA == 1) {
                            System.out.print("Masukkan ID Tim: ");
                            String idTim = scanner.nextLine();
                            System.out.print("Masukkan Nama Tim: ");
                            String namaTim = scanner.nextLine();

                            stadion.tambahTim(new Tim(idTim, namaTim));
                        } else if (menuA == 2) {
                            System.out.print("ID Tim yg dicari: ");
                            stadion.cariTim(scanner.nextLine());
                        } else if (menuA == 3) {
                            stadion.lihatSemuaTim();
                        }
                        break;

                    case 5:
                        System.out.println("\n-- Sistem Pertandingan (Asosiasi) --");
                        System.out.print("Masukkan ID Tim: ");
                        String inputIdTim = scanner.nextLine();

                        Tim peminjam = stadion.getTim(inputIdTim);

                        if (peminjam == null) {
                            System.out.println("Gagal: Tim belum terdaftar!");
                        } else if (stadion.getJumlahOlahraga() == 0) {
                            System.out.println("Gagal: Belum ada pertandingan yang bisa dipilih.");
                        } else {
                            stadion.lihatSemuaOlahraga();
                            System.out.print("Pilih Nomor Pertandingan yg ingin dimainkan: ");
                            int noKoleksi = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noKoleksi >= 0 && noKoleksi < stadion.getJumlahOlahraga()) {
                                Olahraga itemPinjam = stadion.getOlahragaInt(noKoleksi);
                                TransaksiPertandingan.prosesPertandingan(peminjam, itemPinjam);
                            } else {
                                System.out.println("Nomor pertandingan tidak valid!");
                            }
                        }
                        break;

                    case 6:
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