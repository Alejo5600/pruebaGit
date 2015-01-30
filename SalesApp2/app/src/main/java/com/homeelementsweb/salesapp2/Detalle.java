package com.homeelementsweb.salesapp2;

/**
 * Created by ingenierodesarrollo1 on 30/01/2015.
 */
public class Detalle {
    private int codigo;
    private String descripcion;
    private float saldo;
    private int cantidad;
    private float valor;
    private String observaciones;

    public Detalle(int codigo, String descripcion, float saldo, int cantidad, float valor, String observaciones) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.saldo = saldo;
        this.cantidad = cantidad;
        this.valor = valor;
        this.observaciones = observaciones;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


}
