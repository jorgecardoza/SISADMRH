/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mj.gob.sisadmrh.controller.otherreport;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author jorge
 */
@Component("fragments/capacitaciones.xlsx")
public class CapacitacionesView  extends AbstractXlsView{
     @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 
// response.setHeader("Content-Disposition", "<span id="IL_AD8" class="IL_AD">attachment</span>;filename=\"student.xls\"");    
 response.setHeader("Content-Disposition", "attachment; filename=\"Reporte_de_capacitaciones.xls\"");
        
  List<Object[]> capacitacionesList = (List<Object[]>) model.get("capacitacionesList");
 Sheet sheet = workbook.createSheet("Comites Data");
 sheet.createRow(1).createCell(3).setCellValue("REPORTE DE CAPACITACIONES");
 Row header = sheet.createRow(2);
 header.createCell(0).setCellValue("Nombre Empleado");
 header.createCell(1).setCellValue("Puesto");
 header.createCell(2).setCellValue("Horas");
  header.createCell(3).setCellValue("Capacitador");
 header.createCell(5).setCellValue("Capacitacion");
 header.createCell(6).setCellValue("Departamento Responsable");
  header.createCell(7).setCellValue("Desde");
  header.createCell(8).setCellValue("Hasta");
  
  
   
 int rowNum = 3;

  for(Object[] capacitaciones : capacitacionesList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(0).setCellValue((String) capacitaciones[0]);
 row.createCell(1).setCellValue((String) capacitaciones[1]);
 row.createCell(2).setCellValue((Integer) capacitaciones[2]);
 row.createCell(3).setCellValue((String) capacitaciones[3]);
 row.createCell(4).setCellValue((String) capacitaciones[4]);
 row.createCell(6).setCellValue((String) capacitaciones[5]);
 row.createCell(7).setCellValue((Timestamp) capacitaciones[6]);
 row.createCell(8).setCellValue((Timestamp) capacitaciones[7]);
 }

    
}
}