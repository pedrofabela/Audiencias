/**
 *
 * @author Esteban
 */
package daos;

import beans.DatosBean;
import java.util.List;

public interface ConsultaDAO {

   
    public List consultaCiudadanos(DatosBean datos) throws Exception;
     public List totalAudiencias(DatosBean datos) throws Exception;
     public List listaConcluidas(DatosBean datos) throws Exception;
     public List listaReportes(String consulta) throws Exception;
      public List listaEnProceso(DatosBean datos) throws Exception;
     public List audienciasDia(DatosBean datos) throws Exception;
      public List audienciasAsignadas(DatosBean datos) throws Exception;
      public List audienciasPersona(DatosBean datos) throws Exception;
     public List totalMotivos(DatosBean datos) throws Exception;
     public List validaCiudadanos(DatosBean datos) throws Exception;
     public List consultaDatosCiudadanos(DatosBean datos) throws Exception;
       public List consultaFolioActualiza(DatosBean datos) throws Exception;
         public List consultaFolioActualizaGiras(DatosBean datos) throws Exception;
      public List listaSerPub(DatosBean datos) throws Exception;
       public List listaSerPubGiras(DatosBean datos) throws Exception;
         public List listaMotivo(DatosBean datos) throws Exception;
            public List listaVisitas(DatosBean datos) throws Exception;
             public List listaMunicipios() throws Exception;
              public List listaTextos() throws Exception;
             public boolean guardaAudiencia(DatosBean datos) throws Exception;
                 public boolean guardaAudienciaGiras(DatosBean datos) throws Exception;
              public boolean guardaSeguimiento(DatosBean datos) throws Exception;
                public boolean actualizarCiudadano(DatosBean datos) throws Exception;
                  public boolean actualizarCiudadanoGiras(DatosBean datos) throws Exception;
                 public boolean actualizarAudiencia(DatosBean datos) throws Exception;
                 public boolean actualizarAudienciaGiras(DatosBean datos) throws Exception;
            public boolean guardaCiudadano(DatosBean datos) throws Exception;
            public boolean guardaCiudadanoGiras(DatosBean datos) throws Exception;
               public int folio() throws Exception;
                public int perfil_h(String perfilH) throws Exception;
                public int idCiudadano() throws Exception;
    

   

    

}
