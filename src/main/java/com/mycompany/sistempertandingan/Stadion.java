package com.mycompany.sistempertandingan;

import java.util.ArrayList;
import java.util.HashMap;

public class Stadion {
    private String namaStadion;
    private Lapangan lapanganUtama;
    private ArrayList<Olahraga> daftarOlahraga;
    private HashMap<String, Tim> dataTim;

    public Stadion(String namaStadion) {
        this.namaStadion = namaStadion;
        this.lapanganUtama = new Lapangan("Lapangan Utama", 500);
        this.daftarOlahraga = new ArrayList<>();
        this.dataTim = new HashMap<>();
    }

    public void bukaStadion() {
        System.out.println("\n*** Menginisialisasi sistem " + this.namaStadion + " ***");
        lapanganUtama.bukaLapangan();
    }

    public void tambahOlahraga(Olahraga o) {
        daftarOlahraga.add(o);
        System.out.println("Sukses! Pertandingan ditambahkan. (Total Pertandingan: " + daftarOlahraga.size() + ")");
    }

    public void tambahTim(Tim t) {
        dataTim.put(t.getIdTim(), t);
        System.out.println("Berhasil menambahkan tim!");
    }

    public void lihatSemuaOlahraga() {
        if (daftarOlahraga.isEmpty()) {
            System.out.println("Belum ada pertandingan yang tersimpan.");
            return;
        }
        for (int i = 0; i < daftarOlahraga.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarOlahraga.get(i).tampilkanInfo();
        }
    }

    public void cariOlahraga(String namaPertandingan) throws PertandinganTidakDitemukanException {
        System.out.println("Mencari Pertandingan dengan Nama: " + namaPertandingan);
        boolean ditemukan = false;

        for (Olahraga o : daftarOlahraga) {
            if (o.getNamaPertandingan().equalsIgnoreCase(namaPertandingan)) {
                o.tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new PertandinganTidakDitemukanException("Gagal: Pertandingan dengan nama '" + namaPertandingan + "' tidak terdaftar.");
        }
    }

    public void cariTim(String idTim) {
        if (dataTim.containsKey(idTim)) {
            System.out.println("Ditemukan! Nama Tim: " + dataTim.get(idTim).getNamaTim());
        } else {
            System.out.println("Tim dengan ID tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaTim() {
        System.out.println("Total Tim Terdaftar: " + dataTim.size());
        for (Tim t : dataTim.values()) {
            System.out.println("- ID Tim: " + t.getIdTim() + " | Nama: " + t.getNamaTim());
        }
    }

    public ArrayList<Olahraga> getDaftarOlahraga() {
        return daftarOlahraga;
    }

    public HashMap<String, Tim> getDataTim() {
        return dataTim;
    }
    public Tim getTim(String idTim) { 
        return dataTim.get(idTim); 
    }

    public Olahraga getOlahragaInt(int index) { 
        return daftarOlahraga.get(index); 
    }

    public int getJumlahOlahraga() { 
        return daftarOlahraga.size(); 
    }
}