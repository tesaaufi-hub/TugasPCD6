package com.mycompany.sistempertandingan;
import java.util.Scanner;

public class SistemPertandingan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pertandingan[] daftarPertandingan = new Pertandingan[10];

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
        }
    }
}