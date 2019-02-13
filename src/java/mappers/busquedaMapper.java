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
public class busquedaMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
        if (rs.getString("ID") != null) {
            dat.setID(rs.getString("ID").trim());
        } else {
            dat.setID(rs.getString("ID"));
        }
        
         if (rs.getString("NOMBRE_COMPLETO") != null) {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO").trim());
        } else {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO"));
        }
        
        if (rs.getString("MUNICIPIO") != null) {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO").trim());
        } else {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO"));
        
        }
            
         if (rs.getString("TELEFONO") != null) {
            dat.setTELEFONO(rs.getString("TELEFONO").trim());
        } else {
            dat.setTELEFONO(rs.getString("TELEFONO"));
        }
         
         
         if (rs.getString("APATERNO") != null) {
            dat.setAPATERNO(rs.getString("APATERNO").trim());
        } else {
            dat.setAPATERNO(rs.getString("APATERNO"));
        }  
         
           if (rs.getString("AMATERNO") != null) {
            dat.setAMATERNO(rs.getString("AMATERNO").trim());
        } else {
            dat.setAMATERNO(rs.getString("AMATERNO"));
        }
         
           if (rs.getString("NOMBRES") != null) {
            dat.setNOMBRES(rs.getString("NOMBRES").trim());
        } else {
            dat.setNOMBRES(rs.getString("NOMBRES"));
        }
            if (rs.getString("OCUPACION") != null) {
            dat.setOCUPACION(rs.getString("OCUPACION").trim());
        } else {
            dat.setOCUPACION(rs.getString("OCUPACION"));
        }
         if (rs.getString("CLAMUN") != null) {
            dat.setCLAMUN(rs.getString("CLAMUN").trim());
        } else {
            dat.setCLAMUN(rs.getString("CLAMUN"));
        }
         
         if (rs.getString("DIRECCION") != null) {
            dat.setDIRECCION(rs.getString("DIRECCION").trim());
        } else {
            dat.setDIRECCION(rs.getString("DIRECCION"));
        }
         
         if (rs.getString("CORREO") != null) {
            dat.setCORREO(rs.getString("CORREO").trim());
        } else {
            dat.setCORREO(rs.getString("CORREO"));
        }
        return dat;  
        
    }
    
  
    
}

