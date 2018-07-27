package mj.gob.sisadmrh.controller.otherreport;

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
import mj.gob.sisadmrh.model.Beneficio;
import mj.gob.sisadmrh.service.BeneficioService;
import mj.gob.sisadmrh.service.EmpleadoBeneficioService;
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
@RequestMapping(value = "otherreports")
public class OtherreportController extends UtilsController{
    
   
    private final String PREFIX = "fragments/otherreports/";

    @RequestMapping("abogados/")
    public String reporteabogados() {
        return PREFIX + "abogadosreport";
    }
    @RequestMapping("empleadoincapacidad/")
    public String reporteempleadoincapacidad() {
        return PREFIX + "empleadoincapacidadreport";
    }
    @RequestMapping("hijoscapesp/")
    public String reportehijoscapesp() {
        return PREFIX + "hijoscapespreport";
    }
    @RequestMapping("historial/")
    public String reportehistorial() {
        return PREFIX + "historialreport";
    }
    @RequestMapping("motoristas/")
    public String reportemotoristas() {
        return PREFIX + "motoristasreport";
    }
    @RequestMapping("notarios/")
    public String reportenotarios() {
        return PREFIX + "notariosreport";
    }
    @RequestMapping("renuncias/")
    public String reporterenuncias() {
        return PREFIX + "renunciasreport";
    }
    
    @RequestMapping(value = "abogados/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfabogados(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_abogados", params, download,response);
    }

    @RequestMapping(value = "empleadoincapacidad/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfempleadoincapacidad(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_empleadoincapacidad", params, download,response);
    }

    @RequestMapping(value = "hijoscapesp/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfhijoscapesp(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_hijoscapesp", params, download,response);
    }

    @RequestMapping(value = "historial/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfhistorial(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_historial", params, download,response);
    }

    @RequestMapping(value = "motoristas/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfmotoristas(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_motoristas", params, download,response);
    }

    @RequestMapping(value = "notarios/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfnotarios(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_notarios", params, download,response);
    }

    @RequestMapping(value = "renuncias/{indice}", method = { RequestMethod.POST, RequestMethod.GET })
    public void pdfrenuncias(@PathVariable("indice") Long indice, 
            @RequestParam(required = false) Boolean download, 
            @RequestParam(value="fechainicial",required = false) String fechainicio, 
            @RequestParam(value="fechafinal", required = false) String fechafin, 
                HttpServletResponse response) throws Exception {
                Map<String, Object> params = new HashMap<>();
		params.put("CODIGO", indice.toString());
		params.put("FECHAINICIO", fechainicio);
		params.put("FECHAFIN", fechafin);
        	generatePdf("otherreports", "rpt_renuncias", params, download,response);
    }

    
}
