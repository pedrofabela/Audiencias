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
public class textosMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
         if (rs.getString("ID_TEXTO") != null) {
            dat.setID_TEXTO(rs.getString("ID_TEXTO").trim());
        } else {
            dat.setID_TEXTO(rs.getString("ID_TEXTO"));
        }
        
      
            
         if (rs.getString("TEXTO") != null) {
            dat.setTEXTO(rs.getString("TEXTO").trim());
        } else {
            dat.setTEXTO(rs.getString("TEXTO"));
        }
         
         
         
        return dat;  
        
    }
    
}
