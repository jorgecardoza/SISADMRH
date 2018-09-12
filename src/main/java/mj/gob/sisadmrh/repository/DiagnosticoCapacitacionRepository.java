/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Capacitador;
import mj.gob.sisadmrh.model.DiagnosticoCapacitacion;
import mj.gob.sisadmrh.model.Mision;
import mj.gob.sisadmrh.model.Ubicacionfisica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jorge
 */
public interface DiagnosticoCapacitacionRepository  extends CrudRepository<DiagnosticoCapacitacion, Integer>{
      @Query(value = "SELECT dc.* FROM DiagnosticoCapacitacion dc WHERE dc.nombreubicacion LIKE :nom ", nativeQuery = true)
    Iterable<DiagnosticoCapacitacion> findByUbicacion(@Param("nom") String dato);
}
