package mj.gob.sisadmrh.controller.contrato;

import mj.gob.sisadmrh.controller.contrato.*;
import mj.gob.sisadmrh.controller.contrato.*;
import mj.gob.sisadmrh.controller.contrato.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import mj.gob.sisadmrh.controller.UtilsController;
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.model.Contrato;
import mj.gob.sisadmrh.service.ContratoService;
import mj.gob.sisadmrh.service.ContratoService;
//import mj.gob.sisadmrh.service.ContratoContratoService;
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
@RequestMapping(value = "contratos")
public class ContratoController extends UtilsController{
    
    private ContratoService contratoService;
//    private ContratoContratoService contratoContratoService;
    


    
    @Autowired
    public void setContratoService(ContratoService contratoService) {
        this.contratoService = contratoService;
    }
    
    private final String PREFIX = "fragments/contrato/";
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("contratos", contratoService.listAllContrato());
        return PREFIX + "contratos";
    }
    
    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("contrato", contratoService.getContratoById(id));
        return PREFIX + "contratoform";
    }

    @RequestMapping("new/{id}")
    public String newContrato(Model model) {
        model.addAttribute("contrato", new Contrato());
        return PREFIX + "contratoform";
    }

    @RequestMapping(value = "contrato")
    public String saveContrato(Contrato contrato,Model model) {
        try{
            contratoService.saveContrato(contrato);
            model.addAttribute("msg", 0);
        }
        catch(Exception e){
            model.addAttribute("msg", 1);
        }
        
        return "redirect:./show/" + contrato.getCodigocontrato();
    }
    
    @RequestMapping("show/{id}")    
    public String showContrato(@PathVariable Integer id, Model model) {
        model.addAttribute("contrato", contratoService.getContratoById(id).get());
        return PREFIX +"contratoshow";
    }

    @RequestMapping("delete/{id}")
<<<<<<< HEAD
    public String delete(@PathVariable Integer id,Model model) {
         try{
            contratoService.deleteContrato(id);
            model.addAttribute("msg", 3);
        }
        catch(Exception e){
            model.addAttribute("msg", 4);
        }
        
=======
    public String delete(@PathVariable Integer id) {
        contratoService.deleteContrato(id);
>>>>>>> eceb235497f17a196ae6f76834129201b8cae4ad
        return "redirect:/contratos/";
    }
    
    
    
}
