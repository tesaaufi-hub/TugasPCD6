package com.mycompany.sistempertandingan;

import java.io.Serializable;

public class Tim implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idTim;
    private String namaTim;

    public Tim(String idTim, String namaTim) {
        this.idTim = idTim;
        this.namaTim = namaTim;
    }

    public String getIdTim() { return idTim; }
    public String getNamaTim() { return namaTim; }
}