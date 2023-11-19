package com.coludev.phprestigea;

import com.google.firebase.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Recibo {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    private int id;
    private String inquilinoID;
    private String estado;
    private String cuotaPagada;
    private Timestamp fechadepago;
    private float monto;

    public Recibo() {}
    public Recibo(int id,String inquilinoID, String estado, String cuotaPagada, Timestamp fechadepago, float monto) {
        this.id = id;
        this.inquilinoID = inquilinoID;
        this.estado = estado;
        this.cuotaPagada = cuotaPagada;
        this.fechadepago = fechadepago;
        this.monto = monto;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public String getInquilinoID() {
        return inquilinoID;
    }

    public String getEstado() {
        return estado;
    }

    public String getCuotaPagada() {
        return cuotaPagada;
    }

    public String getFechadepago() {
        return (fechadepago != null ? dateFormat.format(fechadepago.toDate()) : "");
    }
    public String getMonto() {
        return String.valueOf(monto);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInquilinoID(String inquilinoID) {
        this.inquilinoID = inquilinoID;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCuotaPagada(String cuotaPagada) {
        this.cuotaPagada = cuotaPagada;
    }

    public void setFechadepago(Timestamp fechadepago) {
        this.fechadepago = fechadepago;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
