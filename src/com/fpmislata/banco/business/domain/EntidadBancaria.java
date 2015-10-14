
package com.fpmislata.banco.business.domain;

import java.util.Date;

/**
 *
 * @author alumno
 */
public class EntidadBancaria {
    private int idEntidadBancaria;
    private String nombre;
    private int codigoEntidad;
    private Date fechaCreacion;
    private String direccion;
    private String CIF;

    public EntidadBancaria() {
    }

    
    
    public EntidadBancaria(int idEntidadBancaria, String nombre, int codigoEntidad, Date fechaCreacion, String direccion, String CIF) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
        this.codigoEntidad = codigoEntidad;
        this.fechaCreacion = fechaCreacion;
        this.direccion = direccion;
        this.CIF = CIF;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(int codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
