package com.mycompany.sistempertandingan;

public class Voli extends Olahraga {
    private int jumlahSet;

    public Voli(String namaPertandingan, String tim1, String tim2, int jumlahSet) {
        super(namaPertandingan, tim1, tim2);
        this.jumlahSet = jumlahSet;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Voli]     Pertandingan: %-15s | Tim: %-10s VS %-10s | Total Set: %d%n", 
                this.namaPertandingan, this.tim1, this.tim2, this.jumlahSet);
    }

    @Override
    public void mulaiPertandingan() {
        System.out.println("-> Info Pertandingan: Voli dimulai dengan Servis dari belakang garis lapangan.");
    }
}