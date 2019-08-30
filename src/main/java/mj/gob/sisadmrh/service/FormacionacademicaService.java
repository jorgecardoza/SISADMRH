package mj.gob.sisadmrh.service;

import java.util.Optional;
import mj.gob.sisadmrh.model.Formacionacademica;

/**
 *
 * @author Mmachuca
 */

public interface FormacionacademicaService {
    Iterable <Formacionacademica> listAllFormacionacademica();
    
    Iterable <Formacionacademica> listAllActivos();
    
    void findIntegrity(Formacionacademica formacionacademica);
    
    Optional<Formacionacademica> getFormacionacademicaById(Integer id);

    Formacionacademica saveFormacionacademica(Formacionacademica empleado);

    void deleteFormacionacademica(Integer id);
    
    Iterable<Formacionacademica> findByDato(int id) ;
}
