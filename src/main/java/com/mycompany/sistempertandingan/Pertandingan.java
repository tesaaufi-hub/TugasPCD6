package com.mycompany.sistempertandingan;

public class Pertandingan {
    private String namaPertandingan;
    private String tim1;
    private String tim2;

    public static int totalPertandinganBerhasilDibuat = 0;

    public Pertandingan(String nama, String timPertama, String timKedua) {
        namaPertandingan = nama;
        tim1 = timPertama;
        tim2 = timKedua;
    }

    public String getNamaPertandingan() {
        return this.namaPertandingan;
    }

    public void setNamaPertandingan(String namaPertandingan) {
        this.namaPertandingan = namaPertandingan;
    }

    public String getTim1() {
        return this.tim1;
    }

    public void setTim1(String tim1) {
        this.tim1 = tim1;
    }

    public String getTim2() {
        return this.tim2;
    }

    public void setTim2(String tim2) {
        this.tim2 = tim2;
    }

    public void tampilkanInfoPertandingan() {
        System.out.printf("Pertandingan: %-20s | Tim 1: %-15s | Tim 2: %s%n", this.namaPertandingan, this.tim1, this.tim2);
    }
}