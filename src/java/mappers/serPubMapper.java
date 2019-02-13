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
public class serPubMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
       
      
        
         if (rs.getString("ID_SERPUB") != null) {
            dat.setID_SERPUB(rs.getString("ID_SERPUB").trim());
        } else {
            dat.setID_SERPUB(rs.getString("ID_SERPUB"));
        }
        
      
            
         if (rs.getString("NOMBRE_SERPUB") != null) {
            dat.setNOMBRE_SERPUB(rs.getString("NOMBRE_SERPUB").trim());
        } else {
            dat.setNOMBRE_SERPUB(rs.getString("NOMBRE_SERPUB"));
        }
         
          
         
         
        return dat;  
        
    }
    
}
