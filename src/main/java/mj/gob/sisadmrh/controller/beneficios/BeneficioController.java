package mj.gob.sisadmrh.controller.beneficios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;
=======
>>>>>>> eceb235497f17a196ae6f76834129201b8cae4ad
import javax.persistence.TemporalType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.model.Empleadobeneficio;
import mj.gob.sisadmrh.model.EmpleadobeneficioPK;
import mj.gob.sisadmrh.service.BeneficioService;
import mj.gob.sisadmrh.service.EmpleadoBeneficioService;
import mj.gob.sisadmrh.service.EmpleadoService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author dialv
 * 
 */
@Controller
@RequestMapping(value = "beneficios")
public class BeneficioController extends UtilsController{
    
    private BeneficioService beneficioService;
    @Autowired
    private EmpleadoBeneficioService empleadoBeneficioService;
    @Autowired
    private EmpleadoService empleadoService;
    


    
    @Autowired
    public void setBeneficioService(BeneficioService beneficioService) {
        this.beneficioService = beneficioService;
    }
    
    private final String PREFIX = "fragments/beneficio/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("beneficios", beneficioService.listAllBeneficios());
        return PREFIX + "beneficios";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("beneficio", beneficioService.getBeneficioById(id));
        return PREFIX + "beneficioform";
    }

    @RequestMapping("new/{id}")
    public String newBeneficio(Model model) {
        model.addAttribute("beneficio", new Beneficio());
        return PREFIX + "beneficioform";
    }

    @RequestMapping(value = "beneficio")
    public String saveBeneficio(Beneficio beneficio,Model model) {
        try{
         beneficioService.saveBeneficio(beneficio);
         model.addAttribute("msg", 0);
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
        }
       return PREFIX+"beneficioform";
        
       // return "redirect:./show/" + beneficio.getCodigobeneficio();
    }
    
    @RequestMapping("show/{id}")
    public String showBeneficio(@PathVariable Integer id, Model model) {
        model.addAttribute("beneficio", beneficioService.getBeneficioById(id).get());
        return PREFIX +"beneficioshow";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id,Model model) {
        try{
         beneficioService.deleteBeneficio(id);
          model.addAttribute("msg", 3);
        }
        catch(Exception e){
         model.addAttribute("msg", 4);
        }
       return PREFIX + "beneficios";
       // return "redirect:/beneficios/";
    }
    
    @RequestMapping("asignar/{id}")
    public String newEmpleadoBeneficio(Model model) {
        model.addAttribute("beneficio", new Beneficio());
        
        Iterable<Beneficio> beneficio = beneficioService.listAllBeneficios();
//         
      model.addAttribute("beneficios", beneficio);
        return PREFIX + "beneficioempleadoform";
    }
<<<<<<< HEAD
    
=======
>>>>>>> eceb235497f17a196ae6f76834129201b8cae4ad
    @RequestMapping(value = "beneficio/asignar/{id}")
    public String saveEmpleadoBeneficio(Beneficio beneficio,Model model,@PathVariable Integer id) {
        try{
         Empleadobeneficio emben = new  Empleadobeneficio();  
         emben.setBeneficio(beneficio);
         Empleado em = empleadoService.getEmpleadoById(id).get();
         emben.setEmpleado(empleadoService.getEmpleadoById(id).get());
         EmpleadobeneficioPK embenpk = new EmpleadobeneficioPK();
         embenpk.setCodigobeneficio(beneficio.getCodigobeneficio());
         embenpk.setCodigoempleado(em.getCodigoempleado());
         emben.setEmpleadobeneficioPK(embenpk);
         emben.setFechabeneficio(new Date());
         empleadoBeneficioService.saveEmpleadobeneficio(emben);
         model.addAttribute("msg", 0);
        }
        catch(Exception e){
         model.addAttribute("msg", 1);
<<<<<<< HEAD
          Logger.getLogger(BeneficioController.class.getName()).log(Level.SEVERE, null, e);
=======
>>>>>>> eceb235497f17a196ae6f76834129201b8cae4ad
        }
       return PREFIX+"beneficioform";
        
       // return "redirect:./show/" + beneficio.getCodigobeneficio();
    }
    
    @RequestMapping("report/")
    public String reporte() {
        return PREFIX + "beneficiosreport";
    }
    
    @RequestMapping(value = "pdf/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdf(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("beneficios", "rpt_beneficios", params, download,response);
    }

    
}
