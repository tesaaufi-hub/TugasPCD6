package com.mycompany.sistempertandingan;

public class Tim {
    private String idTim;
    private String namaTim;

    public Tim(String idTim, String namaTim) {
        this.idTim = idTim;
        this.namaTim = namaTim;
    }

    public String getIdTim() { return idTim; }
    public String getNamaTim() { return namaTim; }
}