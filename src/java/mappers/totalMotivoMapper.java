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
public class totalMotivoMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
        if (rs.getString("ID_MOTIVO") != null) {
            dat.setID_MOTIVO(rs.getString("ID_MOTIVO").trim());
        } else {
            dat.setID_MOTIVO(rs.getString("ID_MOTIVO"));
        }
        
         if (rs.getString("MOTIVO") != null) {
            dat.setMOTIVO(rs.getString("MOTIVO").trim());
        } else {
            dat.setMOTIVO(rs.getString("MOTIVO"));
        }
        
         if (rs.getString("TOTAL_MOTIVOS") != null) {
            dat.setTOTAL_MOTIVOS(rs.getString("TOTAL_MOTIVOS").trim());
        } else {
            dat.setTOTAL_MOTIVOS(rs.getString("TOTAL_MOTIVOS"));
        }
        return dat;  
        
    }
    
}
