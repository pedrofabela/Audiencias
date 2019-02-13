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
public class audienciasAsignadasMapper implements Mapper{
    
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
        
          if (rs.getString("MOTIVO") != null) {
            dat.setMOTIVO(rs.getString("MOTIVO").trim());
        } else {
            dat.setMOTIVO(rs.getString("MOTIVO"));
        }
         
           if (rs.getString("ASUNTO") != null) {
            dat.setASUNTO(rs.getString("ASUNTO").trim());
        } else {
            dat.setASUNTO(rs.getString("ASUNTO"));
        }
            if (rs.getString("GIRAS") != null) {
            dat.setGIRAS(rs.getString("GIRAS").trim());
        } else {
            dat.setGIRAS(rs.getString("GIRAS"));
        }
             if (rs.getString("RUTA_DOC") != null) {
            dat.setRUTA_DOC(rs.getString("RUTA_DOC").trim());
        } else {
            dat.setRUTA_DOC(rs.getString("RUTA_DOC"));
        }
        return dat;  
        
    }
    
}
