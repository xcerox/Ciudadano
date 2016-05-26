/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ciudadano.dto;

import java.util.Objects;

/**
 *
 * @author j.reyes
 */
public class TelefonoDto {
    private Integer id;
    private int linea;
    private String telefono;
    private CiudadanoDto ciudadano;

    public TelefonoDto() {
    }

    public TelefonoDto(Integer id, int linea, String telefono, CiudadanoDto ciudadano) {
        this.id = id;
        this.linea = linea;
        this.telefono = telefono;
        this.ciudadano = ciudadano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CiudadanoDto getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(CiudadanoDto ciudadano) {
        this.ciudadano = ciudadano;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TelefonoDto other = (TelefonoDto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TelefonoDto{" + "id=" + id + ", linea=" + linea + ", telefono=" + telefono + ", ciudadano=" + ciudadano + '}';
    }
    
    
}
