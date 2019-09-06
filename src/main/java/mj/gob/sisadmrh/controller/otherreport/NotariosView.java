/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mj.gob.sisadmrh.model.Empleado;
import mj.gob.sisadmrh.pojos.AbogadosPojo;
 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


/**
 *
 * @author root
 */
public class NotariosView extends AbstractXlsView{
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_notarios.xls\"");
        
  List<Object[]>  notarioList = ( List<Object[]>)  model.get("notariosList");
Sheet sheet = workbook.createSheet("Lista de Notarios");
 sheet.createRow(1).createCell(5).setCellValue("Reporte de Notarios");
 Row header = sheet.createRow(2);
 
 header.createCell(3).setCellValue("Codigo de empleado");
 header.createCell(4).setCellValue("Empleado");
 header.createCell(5).setCellValue("Universidad");
  header.createCell(6).setCellValue("DUI");
   header.createCell(7).setCellValue("Fecha de aprobación");
  
 int rowNum = 3;
 for(Object[] notarios:notarioList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(3).setCellValue(((Integer) notarios[0]));
 row.createCell(4).setCellValue(((String) notarios[1]));
 row.createCell(5).setCellValue(((String) notarios[3]));
  row.createCell(6).setCellValue(((String) notarios[4]));
   row.createCell(7).setCellValue(((String) notarios[2]));
 }
 }
}
