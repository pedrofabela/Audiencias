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
public class totalAudienciasMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
         if (rs.getString("EN_PROCESO") != null) {
            dat.setEN_PROCESO(rs.getString("EN_PROCESO").trim());
        } else {
            dat.setEN_PROCESO(rs.getString("EN_PROCESO"));
        }
        
      
            
         if (rs.getString("CONCLUIDO") != null) {
            dat.setCONCLUIDO(rs.getString("CONCLUIDO").trim());
        } else {
            dat.setCONCLUIDO(rs.getString("CONCLUIDO"));
        }
         
           if (rs.getString("TOTAL_AUDIENCIAS") != null) {
            dat.setTOTAL_AUDIENCIAS(rs.getString("TOTAL_AUDIENCIAS").trim());
        } else {
            dat.setTOTAL_AUDIENCIAS(rs.getString("TOTAL_AUDIENCIAS"));
        
        }
         
         
         
         
        return dat;  
        
    }
}
