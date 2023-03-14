/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reporteasistencia.modelo;

import java.util.Date;

/**
 *
 * @author joel
 */
public class Fichada {
   private int numero ;
   private String nombre; 
   private Date tiempo ;
   private String estado;
   private String dispositivo;
   private int  tipoRegistro;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public int getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(int tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public Fichada(int numero, String nombre, Date tiempo, String estado, String dispositivo, int tipoRegistro) {
        this.numero = numero;
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.estado = estado;
        this.dispositivo = dispositivo;
        this.tipoRegistro = tipoRegistro;
    }
    
   
}
