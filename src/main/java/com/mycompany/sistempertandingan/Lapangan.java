package com.mycompany.sistempertandingan;

public class Lapangan {
    private String namaLapangan;
    private int kapasitasPenonton;

    public Lapangan(String namaLapangan, int kapasitasPenonton) {
        this.namaLapangan = namaLapangan;
        this.kapasitasPenonton = kapasitasPenonton;
    }

    public void bukaLapangan() {
        System.out.println("-> [" + namaLapangan + "] dibuka. Kapasitas: " + kapasitasPenonton + " penonton.");
    }
}