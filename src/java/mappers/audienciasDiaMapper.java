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
public class audienciasDiaMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
        if (rs.getString("FECHA_AUDI") != null) {
            dat.setFECHA_AUDI(rs.getString("FECHA_AUDI").trim());
        } else {
            dat.setFECHA_AUDI(rs.getString("FECHA_AUDI"));
        }
        
         if (rs.getString("AUDIENCIAS_DIA") != null) {
            dat.setAUDIENCIAS_DIA(rs.getString("AUDIENCIAS_DIA").trim());
        } else {
            dat.setAUDIENCIAS_DIA(rs.getString("AUDIENCIAS_DIA"));
        }
        
         
        return dat;  
        
    }
    
}
