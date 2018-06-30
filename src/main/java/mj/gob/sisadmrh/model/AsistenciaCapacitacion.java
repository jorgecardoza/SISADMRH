/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "ASISTENCIACAPACITACION")
//@NamedQueries({
//@NamedQuery(name = "Asistenciacapacitacion.findAll", query = "SELECT ac FROM Asistenciacapacitacion ac")})

public class AsistenciaCapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGOASISTENCIACAPACITACION")
    private Integer codigoasistenciacapacitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORASRECIBIDAS")
    private int horasrecibidas;
    @Size(max = 50)
    @Column(name = "UBICACIONASISTENCIACAPACITACION")
    private String ubicacionasistenciacapacitacion;
    @ManyToMany(mappedBy = "asistenciacapacitacionList")
    private List<Empleado> empleadoList;
    @JoinColumn(name = "CODIGOCAPACITACION", referencedColumnName = "CODIGOCAPACITACION")
    @ManyToOne(optional = false)
    private Capacitacion codigocapacitacion;

    public AsistenciaCapacitacion() {
    }

    public AsistenciaCapacitacion(Integer codigoasistenciacapacitacion) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
    }

    public AsistenciaCapacitacion(Integer codigoasistenciacapacitacion, int horasrecibidas) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
        this.horasrecibidas = horasrecibidas;
    }

    public Integer getCodigoasistenciacapacitacion() {
        return codigoasistenciacapacitacion;
    }

    public void setCodigoasistenciacapacitacion(Integer codigoasistenciacapacitacion) {
        this.codigoasistenciacapacitacion = codigoasistenciacapacitacion;
    }

    public int getHorasrecibidas() {
        return horasrecibidas;
    }

    public void setHorasrecibidas(int horasrecibidas) {
        this.horasrecibidas = horasrecibidas;
    }

    public String getUbicacionasistenciacapacitacion() {
        return ubicacionasistenciacapacitacion;
    }

    public void setUbicacionasistenciacapacitacion(String ubicacionasistenciacapacitacion) {
        this.ubicacionasistenciacapacitacion = ubicacionasistenciacapacitacion;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public Capacitacion getCodigocapacitacion() {
        return codigocapacitacion;
    }

    public void setCodigocapacitacion(Capacitacion codigocapacitacion) {
        this.codigocapacitacion = codigocapacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoasistenciacapacitacion != null ? codigoasistenciacapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaCapacitacion)) {
            return false;
        }
        AsistenciaCapacitacion other = (AsistenciaCapacitacion) object;
        if ((this.codigoasistenciacapacitacion == null && other.codigoasistenciacapacitacion != null) || (this.codigoasistenciacapacitacion != null && !this.codigoasistenciacapacitacion.equals(other.codigoasistenciacapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mj.gob.sisadmrh.model.Asistenciacapacitacion[ codigoasistenciacapacitacion=" + codigoasistenciacapacitacion + " ]";
    }
    
}
