/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jose
 */
public class GenerarReportes {
    
  
    public static Connection CONEXION;
    
    public void reporteFactura(int idventa){
        
                    
            try {
             Class.forName("org.gjt.mm.mysql.Driver");//.newInstance();
            CONEXION = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/libreria","root","");   
           
                
            JasperReport reporte=(JasperReport) JRLoader.loadObject("Factura2.jasper");
            Map parametro = new HashMap();
            
            parametro.put("codigofactura", idventa);
           
            JasperPrint j= JasperFillManager.fillReport(reporte, parametro,CONEXION);
            JasperViewer jv= new JasperViewer (j,false);
            
            jv.setTitle("Factura");
            jv.setVisible(true);
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al generar el reporte"+e);
            }
    
    
    }
    
   
}
