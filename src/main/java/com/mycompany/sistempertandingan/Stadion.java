package com.mycompany.sistempertandingan;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

    public void simpanDataKeFile() {
        try {
            FileOutputStream fileKeluar = new FileOutputStream("data_stadion.dat");
            ObjectOutputStream mesinPembeku = new ObjectOutputStream(fileKeluar);

            mesinPembeku.writeObject(this.daftarOlahraga);
            mesinPembeku.writeObject(this.dataTim);

            mesinPembeku.close();
            System.out.println("-> [SYSTEM LOG] Seluruh data berhasil disimpan (Serialization) ke dalam Harddisk!");
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal menyimpan data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void muatDataDariFile() {
        try {
            File cekFile = new File("data_stadion.dat");
            if (!cekFile.exists()) return;

            FileInputStream fileMasuk = new FileInputStream(cekFile);
            ObjectInputStream mesinPembangkit = new ObjectInputStream(fileMasuk);

            this.daftarOlahraga = (ArrayList<Olahraga>) mesinPembangkit.readObject();
            this.dataTim = (HashMap<String, Tim>) mesinPembangkit.readObject();

            Olahraga.totalOlahragaBerhasilDibuat = this.daftarOlahraga.size();

            mesinPembangkit.close();
            System.out.println("-> [SYSTEM LOG] Data sistem berhasil dimuat ulang dari penyimpanan.");
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal memuat data: " + e.getMessage());
        }
    }

    public void bacaLogTransaksi() {
        System.out.println("\n--- Riwayat Log Transaksi ---");
        try {
            File fileLog = new File("log_transaksi.txt");
            if (!fileLog.exists()) {
                System.out.println("Belum ada log transaksi stadion.");
                return;
            }
            Scanner mesinBaca = new Scanner(fileLog);
            while (mesinBaca.hasNextLine()) {
                System.out.println(mesinBaca.nextLine());
            }
            mesinBaca.close();
        } catch (FileNotFoundException e) {
            System.out.println("Gagal membuka file log.");
        }
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

    public Tim getTim(String idTim) { 
        return dataTim.get(idTim); 
    }

    public Olahraga getOlahragaInt(int index) { 
        return daftarOlahraga.get(index); 
    }

    public int getJumlahOlahraga() { 
        return daftarOlahraga.size(); 
    }

    public ArrayList<Olahraga> getDaftarOlahraga() {
        return daftarOlahraga;
    }

    public HashMap<String, Tim> getDataTim() {
        return dataTim;
    }
}