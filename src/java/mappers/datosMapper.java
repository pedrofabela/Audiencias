/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class datosMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
         if (rs.getString("NOMBRE_COMPLETO") != null) {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO").trim());
        } else {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO"));
        }
        
      
            
         if (rs.getString("TELEFONO") != null) {
            dat.setTELEFONO(rs.getString("TELEFONO").trim());
        } else {
            dat.setTELEFONO(rs.getString("TELEFONO"));
        }
         
           if (rs.getString("OCUPACION") != null) {
            dat.setOCUPACION(rs.getString("OCUPACION").trim());
        } else {
            dat.setOCUPACION(rs.getString("OCUPACION"));
        
        }
         
           if (rs.getString("MUNICIPIO") != null) {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO").trim());
        } else {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO"));
        
        }
         
         
        return dat;  
        
    }
    
}
