package com.coludev.phprestigea;

public class AptInquilino {

    private String aptId,nombreInquilino,tipoInquilino;
    private float  cuotaMantenimiento;

    public AptInquilino() {
    }

    public AptInquilino(String aptId, String nombreInquilino, String tipoInquilino, int cuotaMantenimiento) {
        this.aptId = aptId;
        this.nombreInquilino = nombreInquilino;
        this.tipoInquilino = tipoInquilino;
        this.cuotaMantenimiento = cuotaMantenimiento;
    }

    public String getAptId() {
        return aptId;
    }

    public void setAptId(String aptId) {
        this.aptId = aptId;
    }

    public String getNombreInquilino() {
        return nombreInquilino;
    }

    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }

    public String getTipoInquilino() {
        return tipoInquilino;
    }

    public void setTipoInquilino(String tipoInquilino) {
        this.tipoInquilino = tipoInquilino;
    }

    public float getCuotaMantenimiento() {
        return cuotaMantenimiento;
    }

    public void setCuotaMantenimiento(float cuotaMantenimiento) {
        this.cuotaMantenimiento = cuotaMantenimiento;
    }
}
