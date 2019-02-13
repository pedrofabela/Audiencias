package business;

import beans.DatosBean;
import daos.ConsultaDAO;
import daos.ConsultaDAOImpl;
import java.util.List;


public class ConsultasBusiness {

    private ConsultaDAO con;

    public ConsultasBusiness() throws Exception {
        this.con = new ConsultaDAOImpl();
    }

      

      public List consultaCiudadanos(DatosBean datos) throws Exception {
        List lista = this.con.consultaCiudadanos(datos);
        return lista;
    }   
      
        public List totalAudiencias(DatosBean datos) throws Exception {
        List lista = this.con.totalAudiencias(datos);
        return lista;
    }   
        
         public List listaConcluidas(DatosBean datos) throws Exception {
        List lista = this.con.listaConcluidas(datos);
        return lista;
    }   
          
         public List listaReportes(String consulta) throws Exception {
        List lista = this.con.listaReportes(consulta);
        return lista;
    }   
      
          public List listaEnProceso(DatosBean datos) throws Exception {
        List lista = this.con.listaEnProceso(datos);
        return lista;
    }   
        
        
        
        public List audienciasDia(DatosBean datos) throws Exception {
        List lista = this.con.audienciasDia(datos);
        return lista;
    }   
        public List audienciasAsignadas(DatosBean datos) throws Exception {
        List lista = this.con.audienciasAsignadas(datos);
        return lista;
    }   
         public List audienciasPersona(DatosBean datos) throws Exception {
        List lista = this.con.audienciasPersona(datos);
        return lista;
    }   
        
         public List totalMotivos(DatosBean datos) throws Exception {
        List lista = this.con.totalMotivos(datos);
        return lista;
    }   
     public List consultaDatosCiudadanos(DatosBean datos) throws Exception {
        List lista = this.con.consultaDatosCiudadanos(datos);
        return lista;
    }    
      public List consultaFolioActualiza(DatosBean datos) throws Exception {
        List lista = this.con.consultaFolioActualiza(datos);
        return lista;
    } 
      public List consultaFolioActualizaGiras(DatosBean datos) throws Exception {
        List lista = this.con.consultaFolioActualizaGiras(datos);
        return lista;
    }    
    
       public List listaSerPub(DatosBean datos) throws Exception {
        List lista = this.con.listaSerPub(datos);
        return lista;
    }  
       public List listaSerPubGiras(DatosBean datos) throws Exception {
        List lista = this.con.listaSerPubGiras(datos);
        return lista;
    }    
         public List listaMotivo(DatosBean datos) throws Exception {
        List lista = this.con.listaMotivo(datos);
        return lista;
    }    
          public List listaVisitas(DatosBean datos) throws Exception {
        List lista = this.con.listaVisitas(datos);
        return lista;
    }   
           public List listaMunicipios() throws Exception {
        List lista = this.con.listaMunicipios();
        return lista;
    }     
        public List listaTextos() throws Exception {
        List lista = this.con.listaTextos();
        return lista;
    }        
             public List validaCiudadanos(DatosBean datos) throws Exception {
        List lista = this.con.validaCiudadanos(datos);
        return lista;
    } 
          
          
          
     // GUARDA AUDIECIA
          
              public boolean guardaSeguimiento(DatosBean datos) throws Exception {
        return con.guardaSeguimiento(datos);
     
    }    
              
               public boolean actualizarCiudadano(DatosBean datos) throws Exception {
        return con.actualizarCiudadano(datos);
     
    }    
                 public boolean actualizarCiudadanoGiras(DatosBean datos) throws Exception {
        return con.actualizarCiudadanoGiras(datos);
     
    }    
           public boolean actualizarAudiencia(DatosBean datos) throws Exception {
        return con.actualizarAudiencia(datos);
     
    }   
           public boolean actualizarAudienciaGiras(DatosBean datos) throws Exception {
        return con.actualizarAudienciaGiras(datos);
     
    }        
          
           public boolean guardaAudiencia(DatosBean datos) throws Exception {
        return con.guardaAudiencia(datos);
     
    }    
             public boolean guardaAudienciaGiras(DatosBean datos) throws Exception {
        return con.guardaAudienciaGiras(datos);
     
    }    
            public boolean guardaCiudadano(DatosBean datos) throws Exception {
        return con.guardaCiudadano(datos);
     
    }    
              public boolean guardaCiudadanoGiras(DatosBean datos) throws Exception {
        return con.guardaCiudadanoGiras(datos);
     
    }    
          
     public int folio() throws Exception {
        return con.folio();
     
    }     
     
       public int perfil_h(String perfilH) throws Exception {
        return con.perfil_h(perfilH);
     
    }  
    
       public int idCiudadano() throws Exception {
        return con.idCiudadano();
     
    }    
          
          
}
