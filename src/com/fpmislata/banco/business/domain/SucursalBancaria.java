/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

/**
 *
 * @author alumno
 */
public class SucursalBancaria {
    int idSucursalBancaria;
    String localizacion;
    String direccion;
    String telefono;
    String nombreDirector;

    public SucursalBancaria() {
    }

    public SucursalBancaria(int idSucursalBancaria, String localizacion, String direccion, String nombreDirector) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.localizacion = localizacion;
        this.direccion = direccion;
        this.nombreDirector = nombreDirector;
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }
    
    
}
