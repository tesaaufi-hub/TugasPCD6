package com.mycompany.sistempertandingan;

public class Basket extends Olahraga implements PenilaianMatch {
    private int jumlahQuarter;

    public Basket(String namaPertandingan, String tim1, String tim2, int jumlahQuarter) {
        super(namaPertandingan, tim1, tim2);
        this.jumlahQuarter = jumlahQuarter;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Basket]   Pertandingan: %-15s | Tim: %-10s VS %-10s | Quarter: %d%n", 
                this.namaPertandingan, this.tim1, this.tim2, this.jumlahQuarter);
    }

    @Override
    public void mulaiPertandingan() {
        System.out.println("-> Info Pertandingan: Basket dimulai dengan Jump Ball oleh wasit.");
    }

    @Override
    public void hitungBiayaSewa() {
        int totalBiaya = jumlahQuarter * 50000;
        System.out.println("-> Biaya Sewa Lapangan Basket: Rp " + totalBiaya);
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("-> [RATING] Match Basket mendapat rating " + bintang + "/5 Bintang.");
    }
}