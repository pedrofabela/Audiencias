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
public class consultaFolioGirasMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
         if (rs.getString("ID_SERPUB") != null) {
            dat.setID_SERPUB(rs.getString("ID_SERPUB").trim());
        } else {
            dat.setNOMBRE_COMPLETO(rs.getString("ID_SERPUB"));
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
         
           if (rs.getString("ID_ATIENDE") != null) {
            dat.setID_ATIENDE(rs.getString("ID_ATIENDE").trim());
        } else {
            dat.setID_ATIENDE(rs.getString("ID_ATIENDE"));
        
        }
             if (rs.getString("FOLIO_REFERENCIA") != null) {
            dat.setFOLIO_REFERENCIA(rs.getString("FOLIO_REFERENCIA").trim());
        } else {
            dat.setFOLIO_REFERENCIA(rs.getString("FOLIO_REFERENCIA"));
        
        }
             
              if (rs.getString("FOLIO") != null) {
            dat.setFOLIO(rs.getString("FOLIO").trim());
        } else {
            dat.setFOLIO(rs.getString("FOLIO"));
        
        }
               if (rs.getString("OBSERVACIONES") != null) {
            dat.setOBSERVACIONES(rs.getString("OBSERVACIONES").trim());
        } else {
            dat.setOBSERVACIONES(rs.getString("OBSERVACIONES"));
        
        }
        if (rs.getString("FECHA_EVENTO") != null) {
            dat.setFECHA_EVENTO(rs.getString("FECHA_EVENTO").trim());
        } else {
            dat.setFECHA_EVENTO(rs.getString("FECHA_EVENTO"));
        
        }
          
           if (rs.getString("LUGAR_EVENTO") != null) {
            dat.setLUGAR_EVENTO(rs.getString("LUGAR_EVENTO").trim());
        } else {
            dat.setLUGAR_EVENTO(rs.getString("LUGAR_EVENTO"));
        
        }       
               
               
         
        return dat;  
        
    }
    
}
