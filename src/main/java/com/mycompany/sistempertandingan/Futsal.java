package com.mycompany.sistempertandingan;

public class Futsal extends Olahraga implements JadwalMatch, PenilaianMatch {
    private int durasiMenit;

    public Futsal(String namaPertandingan, String tim1, String tim2, int durasiMenit) throws Exception {
        super(namaPertandingan, tim1, tim2);
        if (durasiMenit <= 0) {
            throw new Exception("Durasi menit harus lebih dari 0!");
        }
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

    @Override
    public void hitungBiayaSewa() {
        int totalBiaya = (durasiMenit / 60) * 150000;
        System.out.println("-> Biaya Sewa Lapangan Futsal: Rp " + totalBiaya);
    }

    @Override
    public void aturJadwal(String tanggal, String lapangan) {
        System.out.println("-> [JADWAL] Futsal dijadwalkan tanggal " + tanggal + " di Lapangan " + lapangan);
    }

    @Override
    public void beriRating(int bintang) {
        System.out.println("-> [RATING] Match Futsal mendapat rating " + bintang + "/5 Bintang.");
    }
}