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
public class estatusAudienciaMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
         if (rs.getString("FOLIO") != null) {
            dat.setFOLIO(rs.getString("FOLIO").trim());
        } else {
            dat.setFOLIO(rs.getString("FOLIO"));
        }
        
      
            
         if (rs.getString("FECHA_AUDI") != null) {
            dat.setFECHA_AUDI(rs.getString("FECHA_AUDI").trim());
        } else {
            dat.setFECHA_AUDI(rs.getString("FECHA_AUDI"));
        }
         
           if (rs.getString("NOMBRE_COMPLETO") != null) {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO").trim());
        } else {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO"));
        }
         
           if (rs.getString("NOMBRE_SERPUB") != null) {
            dat.setNOMBRE_SERPUB(rs.getString("NOMBRE_SERPUB").trim());
        } else {
            dat.setNOMBRE_SERPUB(rs.getString("NOMBRE_SERPUB"));
        
        }
         
           if (rs.getString("ASUNTO") != null) {
            dat.setASUNTO(rs.getString("ASUNTO").trim());
        } else {
            dat.setASUNTO(rs.getString("ASUNTO"));
        
        }
         
           if (rs.getString("ESTATUS") != null) {
            dat.setESTATUS(rs.getString("ESTATUS").trim());
        } else {
            dat.setESTATUS(rs.getString("ESTATUS"));
        
        }
           
           if (rs.getString("MOTIVO") != null) {
            dat.setMOTIVO(rs.getString("MOTIVO").trim());
        } else {
            dat.setMOTIVO(rs.getString("MOTIVO"));
        
        }
         
        return dat;  
    
}
}