package com.mycompany.sistempertandingan;

public abstract class Olahraga {
    protected String namaPertandingan;
    protected String tim1;
    protected String tim2;

    public static int totalOlahragaBerhasilDibuat = 0;

    public Olahraga(String namaPertandingan, String tim1, String tim2) throws Exception {
        if (namaPertandingan == null || namaPertandingan.trim().isEmpty()) {
            throw new Exception("Nama pertandingan tidak boleh kosong!");
        }
        if (tim1 == null || tim1.trim().isEmpty() || tim2 == null || tim2.trim().isEmpty()) {
            throw new Exception("Nama tim tidak boleh kosong!");
        }
        
        this.namaPertandingan = namaPertandingan;
        this.tim1 = tim1;
        this.tim2 = tim2;
        totalOlahragaBerhasilDibuat++;
    }

    public String getNamaPertandingan() { 
        return this.namaPertandingan; 
    }

    public String getTim1() { 
        return this.tim1; 
    }

    public String getTim2() { 
        return this.tim2; 
    }

    public void tampilkanInfo() {
        System.out.printf("Pertandingan: %-20s | Tim 1: %-15s | Tim 2: %s%n", this.namaPertandingan, this.tim1, this.tim2);
    }

    public void mulaiPertandingan() {
        System.out.println("Pertandingan dimulai secara umum.");
    }

    public abstract void hitungBiayaSewa();
}