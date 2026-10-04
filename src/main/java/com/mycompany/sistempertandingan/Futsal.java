package com.mycompany.sistempertandingan;

public class Futsal extends Olahraga {
    private int durasiMenit;

    public Futsal(String namaPertandingan, String tim1, String tim2, int durasiMenit) {
        super(namaPertandingan, tim1, tim2);
        this.durasiMenit = durasiMenit;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Futsal]   Pertandingan: %-15s | Tim: %-10s VS %-10s | Durasi: %d Menit%n", 
                this.namaPertandingan, this.tim1, this.tim2, this.durasiMenit);
    }

    @Override
    public void mulaiPertandingan() {
        System.out.println("-> Info Pertandingan: Futsal dimulai dengan kick-off di tengah lapangan.");
    }
}