/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.repository;

import mj.gob.sisadmrh.model.Ubicacionfisica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jorge
 */
public interface UbicacionFisicaRepository  extends CrudRepository<Ubicacionfisica, Integer>{
    @Query(value = "SELECT u.* FROM UbicacionFisica u "
            + "WHERE u.nombreubicacion LIKE :nom ", nativeQuery = true)

    Iterable<Ubicacionfisica> findByUbicacion(@Param("nom") String dato);
    
}
