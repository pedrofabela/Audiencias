package daos;

import beans.DatosBean;
import java.util.ArrayList;
import java.util.List;
import mappers.audienciasAsignadasMapper;
import mappers.audienciasDiaMapper;
import mappers.audienciasPersonaMapper;

import mappers.busquedaMapper;
import mappers.consultaFolioGirasMapper;
import mappers.consultaFolioMapper;
import mappers.datosMapper;
import mappers.estatusAudienciaMapper;
import mappers.listaMunicipiosMapper;
import mappers.motivoMapper;
import mappers.serPubMapper;
import mappers.textosMapper;
import mappers.totalAudienciasMapper;
import mappers.totalMotivoMapper;
import mappers.validaCiudadanoMapper;
import mappers.visitasMapper;
import utilidades.Constantes;
import utilidades.ObjPrepareStatement;


public class ConsultaDAOImpl extends OracleDAOFactory implements ConsultaDAO {

    OracleDAOFactory oraDaoFac = new OracleDAOFactory();

   

    
      public List consultaCiudadanos(DatosBean datos) throws Exception {
        String query = "SELECT DAT.ID , DAT.NOMBRE_COMPLETO, DAT.TELEFONO, NOM_MUN AS MUNICIPIO, DAT.APSOLICITA AS APATERNO, DAT.AMSOLICITA AS AMATERNO, DAT.NOMSOLICITA AS NOMBRES, DAT.OCUPACION , DAT.CLAMUN, DAT.DIRECCION, DAT.CORREO FROM (SELECT DATOS.ID AS ID, DATOS.NOMBRE_COMPLETO,  DATOS.CLAMUN, DATOS.TELEFONO, DATOS.APSOLICITA, DATOS.AMSOLICITA, DATOS.NOMSOLICITA, DATOS.OCUPACION, DATOS.DIRECCION, DATOS.CORREO FROM DATOS) DAT JOIN (SELECT * FROM CAT_MUNICIPIOS) MUN ON DAT.CLAMUN=MUN.ID WHERE NOMBRE_COMPLETO LIKE '%"+datos.getBUSQUEDA_NOMBRE()+"%'  ORDER BY NOMBRE_COMPLETO ASC";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new busquedaMapper());
        return list;
    }
    public List totalAudiencias(DatosBean datos) throws Exception {
        String query = "SELECT  EN_PROCESO+CONCLUIDO AS TOTAL_AUDIENCIAS, EN_PROCESO, CONCLUIDO FROM (SELECT COUNT(FOLIO) AS EN_PROCESO FROM AUDIENCIAS WHERE TO_DATE(FECHA_AUDI) <='"+datos.getFECHA_TERMINO()+"' AND TO_DATE(FECHA_AUDI)>='"+datos.getFECHA_INICIO()+"' AND ESTATUS='EN PROCESO'),(SELECT COUNT(FOLIO) AS CONCLUIDO FROM AUDIENCIAS WHERE TO_DATE(FECHA_AUDI) <='"+datos.getFECHA_TERMINO()+"' AND TO_DATE(FECHA_AUDI)>='"+datos.getFECHA_INICIO()+"' AND ESTATUS='CONCLUIDO')";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new totalAudienciasMapper());
        return list;
    }
    
    public List listaConcluidas(DatosBean datos) throws Exception {
        String query = "SELECT RS.FOLIO, RS.FECHA_AUDI,  DAT.NOMBRE_COMPLETO, RS.NOMBRE_SERPUB, RS.ASUNTO, RS.ESTATUS, RS.MOTIVO FROM (SELECT AUDIEN.FOLIO, AUDIEN.ID, TO_CHAR(TO_DATE(AUDIEN.FECHA_AUDI,'dd/mm/yyyy')) AS FECHA_AUDI, SERPUB.NOMBRE_SERPUB, AUDIEN.ASUNTO, AUDIEN.ESTATUS, AUDIEN.MOTIVO FROM (SELECT AUD.FOLIO, AUD.FECHA_AUDI, AUD.ATENDIO AS ID_ATENDIO, AUD.ASUNTO, AUD.ESTATUS, MOT.MOTIVO, AUD.ID FROM (SELECT FOLIO, FECHA_AUDI, MOTIVO, ATENDIO, ASUNTO, ESTATUS, ID FROM AUDIENCIAS WHERE TO_DATE(FECHA_AUDI)<='"+datos.getFECHA_TERMINO()+"' AND TO_DATE(FECHA_AUDI)>='"+datos.getFECHA_INICIO()+"' ) AUD JOIN (SELECT ID_MOTIVO, MOTIVO FROM CAT_MOTIVO) MOT ON AUD.MOTIVO=MOT.ID_MOTIVO) AUDIEN JOIN(SELECT ID_SERPUB, NOMBRE_SERPUB FROM CAT_SERPUB)SERPUB ON AUDIEN.ID_ATENDIO=SERPUB.ID_SERPUB ORDER BY TO_DATE( AUDIEN.FECHA_AUDI) DESC) RS LEFT OUTER JOIN (SELECT ID, NOMBRE_COMPLETO FROM DATOS) DAT ON RS.ID=DAT.ID WHERE RS.ESTATUS='CONCLUIDO'";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new estatusAudienciaMapper());
        return list;
    }
    
    public List listaReportes(String consulta) throws Exception {
        String query = "SELECT FOLIO, TO_CHAR(FECHA_AUDI,'dd/mm/yy') AS FECHA_AUDI, MOTIVO, ASUNTO, NOMBRE_SERPUB, ESTATUS, NOMBRE_COMPLETO FROM (SELECT AUD.FOLIO, AUD.FECHA_AUDI, AUD.MOTIVO AS ID_MOTIVO, MOT.MOTIVO, AUD.ASUNTO, AUD.ATENDIO, SERPUB.ID_SERPUB, SERPUB.NOMBRE_SERPUB, AUD.ESTATUS, DAT.NOMBRE_COMPLETO FROM (SELECT FOLIO, FECHA_AUDI,  MOTIVO, ASUNTO, ATENDIO, ESTATUS,  ID FROM AUDIENCIAS)AUD LEFT JOIN (SELECT ID_MOTIVO, MOTIVO FROM CAT_MOTIVO)MOT ON AUD.MOTIVO=MOT.ID_MOTIVO LEFT JOIN (SELECT ID_SERPUB, NOMBRE_SERPUB FROM CAT_SERPUB) SERPUB ON AUD.ATENDIO=SERPUB.ID_SERPUB LEFT JOIN (SELECT ID, NOMBRE_COMPLETO FROM DATOS) DAT ON AUD.ID=DAT.ID) "+" "+consulta;
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new estatusAudienciaMapper());
        return list;
    }
    
     public List listaEnProceso(DatosBean datos) throws Exception {
        String query = "SELECT RS.FOLIO, RS.FECHA_AUDI,  DAT.NOMBRE_COMPLETO, RS.NOMBRE_SERPUB, RS.ASUNTO, RS.ESTATUS, RS.MOTIVO FROM (SELECT AUDIEN.FOLIO, AUDIEN.ID, TO_CHAR(TO_DATE(AUDIEN.FECHA_AUDI,'dd/mm/yyyy')) AS FECHA_AUDI, SERPUB.NOMBRE_SERPUB, AUDIEN.ASUNTO, AUDIEN.ESTATUS, AUDIEN.MOTIVO FROM (SELECT AUD.FOLIO, AUD.FECHA_AUDI, AUD.ATENDIO AS ID_ATENDIO, AUD.ASUNTO, AUD.ESTATUS, MOT.MOTIVO, AUD.ID FROM (SELECT FOLIO, FECHA_AUDI, MOTIVO, ATENDIO, ASUNTO, ESTATUS, ID FROM AUDIENCIAS WHERE TO_DATE(FECHA_AUDI)<='"+datos.getFECHA_TERMINO()+"' AND TO_DATE(FECHA_AUDI)>='"+datos.getFECHA_INICIO()+"' ) AUD JOIN (SELECT ID_MOTIVO, MOTIVO FROM CAT_MOTIVO) MOT ON AUD.MOTIVO=MOT.ID_MOTIVO) AUDIEN JOIN(SELECT ID_SERPUB, NOMBRE_SERPUB FROM CAT_SERPUB)SERPUB ON AUDIEN.ID_ATENDIO=SERPUB.ID_SERPUB ORDER BY TO_DATE( AUDIEN.FECHA_AUDI) DESC) RS LEFT OUTER JOIN (SELECT ID, NOMBRE_COMPLETO FROM DATOS) DAT ON RS.ID=DAT.ID WHERE RS.ESTATUS='EN PROCESO'";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new estatusAudienciaMapper());
        return list;
    }
    
    
     public List audienciasDia(DatosBean datos) throws Exception {
        String query = "SELECT DISTINCT(TO_CHAR(FECHA_AUDI,'dd/mm/yy')) AS FECHA_AUDI,  COUNT(FOLIO) AS AUDIENCIAS_DIA FROM AUDIENCIAS WHERE TO_DATE(FECHA_AUDI) <='"+datos.getFECHA_TERMINO()+"' AND TO_DATE(FECHA_AUDI)>='"+datos.getFECHA_INICIO()+"'  GROUP BY FECHA_AUDI ORDER BY TO_DATE(FECHA_AUDI) DESC";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new audienciasDiaMapper());
        return list;
    }
      public List audienciasAsignadas(DatosBean datos) throws Exception {
        String query = "SELECT AUDIENCIAS.FOLIO, TO_CHAR(AUDIENCIAS.FECHA_AUDI,'dd/mm/yy') AS FECHA_AUDI, AUDIENCIAS.NOMBRE_COMPLETO, MOT.DES_MOTIVO AS MOTIVO, AUDIENCIAS.ASUNTO, AUDIENCIAS.GIRAS, AUDIENCIAS.RUTA AS RUTA_DOC  FROM (SELECT AUD.FOLIO, AUD.FECHA_AUDI, AUD.MOTIVO, AUD.ASUNTO, DATOS.NOMBRE_COMPLETO, AUD.GIRAS, AUD.RUTA FROM (SELECT FOLIO, FECHA_AUDI, MOTIVO, ASUNTO, ID, GIRAS, RUTA FROM AUDIENCIAS WHERE  ATENDIO='"+datos.getFILTRO()+"' AND ESTATUS ='EN PROCESO') AUD JOIN (SELECT * FROM DATOS  ) DATOS ON AUD.ID=DATOS.ID) AUDIENCIAS JOIN (SELECT ID_MOTIVO, MOTIVO AS DES_MOTIVO FROM CAT_MOTIVO WHERE ESTATUS=1) MOT ON  AUDIENCIAS.MOTIVO=MOT.ID_MOTIVO";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new audienciasAsignadasMapper());
        return list;
    }
     
     public List audienciasPersona(DatosBean datos) throws Exception {
        String query = "SELECT CAT.ID_SERPUB, TRANSLATE(CAT.NOMBRE_SERPUB,'ñáéíóúàèìòùãõâêîôôäëïöüçÑÁÉÍÓÚÀÈÌÒÙÃÕÂÊÎÔÛÄËÏÖÜÇ','naeiouaeiouaoaeiooaeioucNAEIOUAEIOUAOAEIOOAEIOUC') AS NOMBRE_SERPUB, ATE.AUDIENCIAS_PERSONA FROM (SELECT DISTINCT(ATENDIO), COUNT(FOLIO) AS AUDIENCIAS_PERSONA FROM AUDIENCIAS WHERE ATENDIO IS NOT NULL AND TO_DATE(FECHA_AUDI) <='"+datos.getFECHA_TERMINO()+"' AND TO_DATE(FECHA_AUDI)>='"+datos.getFECHA_INICIO()+"' GROUP BY ATENDIO)ATE JOIN (SELECT * FROM CAT_SERPUB)CAT ON ATE.ATENDIO=CAT.ID_SERPUB";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new audienciasPersonaMapper());
        return list;
    }
     public List totalMotivos(DatosBean datos) throws Exception {
        String query = "SELECT CAT.ID_MOTIVO, CAT.MOTIVO, MOT.TOTAL_MOTIVOS FROM (SELECT DISTINCT(MOTIVO) AS MOTIVOS, COUNT(FOLIO) AS TOTAL_MOTIVOS  FROM AUDIENCIAS WHERE TO_DATE(FECHA_AUDI) <='"+datos.getFECHA_TERMINO()+"' AND TO_DATE(FECHA_AUDI)>='"+datos.getFECHA_INICIO()+"' AND MOTIVO IS NOT NULL GROUP BY MOTIVO)MOT JOIN (SELECT ID_MOTIVO, MOTIVO FROM CAT_MOTIVO )CAT ON MOT.MOTIVOS=CAT.ID_MOTIVO";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new totalMotivoMapper());
        return list;
    }

public List validaCiudadanos(DatosBean datos) throws Exception {
     String query = "SELECT ID, NOMBRE_COMPLETO FROM DATOS WHERE NOMBRE_COMPLETO='"+datos.getNOMBRE_COMPLETO()+"' AND ROWNUM =1";  
     Constantes.enviaMensajeConsola("Consulta cct----->"+query);  
     List list = null;  
     list = queryForList(query, new validaCiudadanoMapper());   
     return list;
     
}  
      
      
      public List consultaDatosCiudadanos(DatosBean datos) throws Exception {
        String query = "SELECT DATOS.NOMBRE_COMPLETO, DATOS.TELEFONO, DATOS.OCUPACION, CAT_MUN.NOM_MUN AS MUNICIPIO FROM (SELECT NOMBRE_COMPLETO, TELEFONO, OCUPACION, CLAMUN FROM DATOS WHERE ID='"+datos.getID()+"') DATOS JOIN (SELECT ID, NOM_MUN FROM CAT_MUNICIPIOS )CAT_MUN ON DATOS.CLAMUN=CAT_MUN.ID";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new datosMapper());
        return list;
    }
      
       public List consultaFolioActualiza(DatosBean datos) throws Exception {
        String query = "SELECT FOLIO,  TITULAR AS ID_SERPUB,  MOTIVO,  ASUNTO,  TURNADO AS FOLIO_REFERENCIA,  ATENDIO AS ID_ATIENDE, PRODEP AS PROCEDENCIA FROM AUDIENCIAS WHERE FOLIO='"+datos.getFOLIO()+"'";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new consultaFolioMapper());
        return list;
    }
        public List consultaFolioActualizaGiras(DatosBean datos) throws Exception {
        String query = "SELECT FOLIO,  TITULAR AS ID_SERPUB,  MOTIVO,  ASUNTO,  TURNADO AS FOLIO_REFERENCIA,  ATENDIO AS ID_ATIENDE, NOTA AS OBSERVACIONES,  TO_CHAR(FECHA_EVENTO, 'dd/mm/yyyy') AS FECHA_EVENTO, LUGAR_EVENTO FROM AUDIENCIAS WHERE FOLIO='"+datos.getFOLIO()+"'";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new consultaFolioGirasMapper());
        return list;
    }
       
       
     public List listaSerPub(DatosBean datos) throws Exception {
        String query = "SELECT ID_SERPUB, NOMBRE_SERPUB FROM CAT_SERPUB WHERE ESTATUS=1 ORDER BY NOMBRE_SERPUB ASC";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new serPubMapper());
        return list;
    }
      public List listaSerPubGiras(DatosBean datos) throws Exception {
        String query = "SELECT ID_SERPUB, NOMBRE_SERPUB FROM CAT_SERPUB WHERE ESTATUS=1 AND GIRAS='1' ORDER BY NOMBRE_SERPUB ASC";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new serPubMapper());
        return list;
    }
      public List listaMotivo(DatosBean datos) throws Exception {
        String query = "SELECT ID_MOTIVO, MOTIVO FROM CAT_MOTIVO WHERE ESTATUS=1 ORDER BY MOTIVO ASC";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new motivoMapper());
        return list;
    }
        public List listaVisitas(DatosBean datos) throws Exception {
        String query = "SELECT AUDIEN.FOLIO, TO_CHAR(TO_DATE(AUDIEN.FECHA_AUDI,'dd/mm/yyyy')) AS FECHA_AUDI, SERPUB.NOMBRE_SERPUB, AUDIEN.ASUNTO, AUDIEN.ESTATUS, AUDIEN.MOTIVO, AUDIEN.GIRAS, AUDIEN.RUTA AS RUTA_DOC, AUDIEN.FECHA_EVENTO, AUDIEN.LUGAR_EVENTO, AUDIEN.SEGUIMIENTO FROM (SELECT AUD.FOLIO, AUD.FECHA_AUDI, AUD.ATENDIO AS ID_ATENDIO, AUD.ASUNTO, AUD.ESTATUS, MOT.MOTIVO, AUD.GIRAS, AUD.RUTA, AUD.FECHA_EVENTO, AUD.LUGAR_EVENTO, AUD.SEGUIMIENTO FROM (SELECT FOLIO, FECHA_AUDI, MOTIVO, ATENDIO, ASUNTO, ESTATUS, GIRAS, RUTA, FECHA_EVENTO, LUGAR_EVENTO, SEGUIMIENTO FROM AUDIENCIAS WHERE ID ='"+datos.getID()+"') AUD JOIN (SELECT ID_MOTIVO, MOTIVO FROM CAT_MOTIVO) MOT ON AUD.MOTIVO=MOT.ID_MOTIVO) AUDIEN JOIN(SELECT ID_SERPUB, NOMBRE_SERPUB FROM CAT_SERPUB)SERPUB ON AUDIEN.ID_ATENDIO=SERPUB.ID_SERPUB ORDER BY TO_DATE( AUDIEN.FECHA_AUDI) DESC";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new visitasMapper());
        return list;
    }
     public List listaMunicipios() throws Exception {
        String query = "SELECT ID, NOM_MUN AS MUNICIPIO FROM CAT_MUNICIPIOS";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new listaMunicipiosMapper());
        return list;
    }  
      public List listaTextos() throws Exception {
        String query = "SELECT ID_TEXTO, TEXTO FROM TEXTOS WHERE ESTATUS=1";
        Constantes.enviaMensajeConsola("Consulta cct----->"+query);
        List list = null;
        list = queryForList(query, new textosMapper());
        return list;
    }   
         
        // GUARDADO DE INFORMACION
        
        
        public boolean guardaAudiencia(DatosBean datos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        
       
        
        
        
        
       temporal = new ObjPrepareStatement("ID", "STRING", datos.getID());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("TITULAR", "STRING", datos.getID_SERPUB());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ATENDIO", "STRING", datos.getID_ATIENDE());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("MOTIVO", "STRING", datos.getID_MOTIVO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FOLIO", "STRING", datos.getFOLIO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("FECHA_AUDI", "STRING", datos.getFECHA_AUDI());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ESTATUS", "STRING", datos.getESTATUS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ASUNTO", "STRING", datos.getASUNTO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("TURNADO", "STRING", datos.getFOLIO_REFERENCIA());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("PRODEP", "STRING", datos.getPROCEDENCIA());
        arregloCampos.add(temporal);
        
        return oraDaoFac.queryInsert("AUDIENCIAS", arregloCampos);
    }
        
       
        public boolean guardaAudienciaGiras(DatosBean datos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        
       
        
        
        
        
       temporal = new ObjPrepareStatement("ID", "STRING", datos.getID());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("TITULAR", "STRING", datos.getID_SERPUB());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ATENDIO", "STRING", datos.getID_ATIENDE());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("MOTIVO", "STRING", datos.getID_MOTIVO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FOLIO", "STRING", datos.getFOLIO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("FECHA_AUDI", "STRING", datos.getFECHA_AUDI());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ESTATUS", "STRING", datos.getESTATUS());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("ASUNTO", "STRING", datos.getASUNTO());
        arregloCampos.add(temporal);
       temporal = new ObjPrepareStatement("GIRAS", "STRING", "1");
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("NOTA", "STRING", datos.getOBSERVACIONES());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("RUTA", "STRING", datos.getRUTA_DOC());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("FECHA_EVENTO", "STRING", datos.getFECHA_EVENTO());
         arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("LUGAR_EVENTO", "STRING", datos.getLUGAR_EVENTO());
        arregloCampos.add(temporal);
        
        return oraDaoFac.queryInsert("AUDIENCIAS", arregloCampos);
    }
           
        
        
        public boolean guardaCiudadano(DatosBean datos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        
       
        
        
        
        
       temporal = new ObjPrepareStatement("ID", "STRING", datos.getID());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("APSOLICITA", "STRING", datos.getAPATERNO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AMSOLICITA", "STRING", datos.getAMATERNO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("NOMSOLICITA", "STRING", datos.getNOMBRES());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE_COMPLETO", "STRING", datos.getNOMBRE_COMPLETO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("TELEFONO", "STRING", datos.getTELEFONO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("OCUPACION", "STRING", datos.getOCUPACION());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CLAMUN", "STRING", datos.getMUNICIPIO());
        arregloCampos.add(temporal);
       
       
        
        return oraDaoFac.queryInsert("DATOS", arregloCampos);
    }

         public boolean guardaCiudadanoGiras(DatosBean datos) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        
       
        
        
        
        
       temporal = new ObjPrepareStatement("ID", "STRING", datos.getID());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("APSOLICITA", "STRING", datos.getAPATERNO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AMSOLICITA", "STRING", datos.getAMATERNO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("NOMSOLICITA", "STRING", datos.getNOMBRES());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("NOMBRE_COMPLETO", "STRING", datos.getNOMBRE_COMPLETO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("TELEFONO", "STRING", datos.getTELEFONO());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("OCUPACION", "STRING", datos.getOCUPACION());
        arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("CLAMUN", "STRING", datos.getMUNICIPIO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("DIRECCION", "STRING", datos.getDIRECCION());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("CORREO", "STRING", datos.getCORREO());
        arregloCampos.add(temporal);
       
       
        
        return oraDaoFac.queryInsert("DATOS", arregloCampos);
    }
        
         public int folio() throws Exception {
        String query = "SELECT MAX(FOLIO) AS FOLIO FROM AUDIENCIAS";
       
        int folio=0;
        folio = queryInteger(query);
        return folio;
    }
         
          public int perfil_h(String perfilH) throws Exception {
        String query = "SELECT PERFIL_H FROM CAT_SERPUB WHERE ID_SERPUB='"+perfilH+"'";
       
        int perfil=0;
        perfil = queryInteger(query);
        return perfil;
    }
         
         
         
         
         
         public int idCiudadano() throws Exception {
        String query = "SELECT MAX(ID) AS ID FROM DATOS";
       
        int folio=0;
        folio = queryInteger(query);
        return folio;
    }
         
         
          public boolean guardaSeguimiento(DatosBean datos ) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("ESTATUS", "STRING", "CONCLUIDO");
            arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("SEGUIMIENTO", "STRING", datos.getSEGUIMIENTO());
        arregloCampos.add(temporal);
          temporal = new ObjPrepareStatement("FECASI", "STRING", datos.getFECASI());
        arregloCampos.add(temporal);
        
        String Condicion;
        Condicion = "WHERE FOLIO=" + "'" + "" + datos.getFOLIO()+ "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("AUDIENCIAS", arregloCampos, Condicion);
    }
        
       public boolean actualizarCiudadano(DatosBean datos ) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("APSOLICITA", "STRING", datos.getAPATERNO());
            arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AMSOLICITA", "STRING", datos.getAMATERNO());
        arregloCampos.add(temporal);
          temporal = new ObjPrepareStatement("NOMSOLICITA", "STRING", datos.getNOMBRES());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("NOMBRE_COMPLETO", "STRING", datos.getNOMBRE_COMPLETO());
        arregloCampos.add(temporal);
        
         temporal = new ObjPrepareStatement("TELEFONO", "STRING", datos.getTELEFONO());
        arregloCampos.add(temporal);
        
         temporal = new ObjPrepareStatement("OCUPACION", "STRING", datos.getOCUPACION());
        arregloCampos.add(temporal);
        
         temporal = new ObjPrepareStatement("CLAMUN", "STRING", datos.getMUNICIPIO());
        arregloCampos.add(temporal);
        
        
        String Condicion;
        Condicion = "WHERE ID=" + "'" + "" + datos.getID()+ "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("DATOS", arregloCampos, Condicion);
    }  
       public boolean actualizarCiudadanoGiras(DatosBean datos ) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("APSOLICITA", "STRING", datos.getAPATERNO());
            arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("AMSOLICITA", "STRING", datos.getAMATERNO());
        arregloCampos.add(temporal);
          temporal = new ObjPrepareStatement("NOMSOLICITA", "STRING", datos.getNOMBRES());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("NOMBRE_COMPLETO", "STRING", datos.getNOMBRE_COMPLETO());
        arregloCampos.add(temporal);
        
         temporal = new ObjPrepareStatement("TELEFONO", "STRING", datos.getTELEFONO());
        arregloCampos.add(temporal);
        
         temporal = new ObjPrepareStatement("OCUPACION", "STRING", datos.getOCUPACION());
        arregloCampos.add(temporal);
        
         temporal = new ObjPrepareStatement("CLAMUN", "STRING", datos.getMUNICIPIO());
        arregloCampos.add(temporal);
        
          temporal = new ObjPrepareStatement("DIRECCION", "STRING", datos.getDIRECCION());
        arregloCampos.add(temporal);
          temporal = new ObjPrepareStatement("CORREO", "STRING", datos.getCORREO());
        arregloCampos.add(temporal);
        
        String Condicion;
        Condicion = "WHERE ID=" + "'" + "" + datos.getID()+ "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("DATOS", arregloCampos, Condicion);
    }
        
     public boolean actualizarAudiencia(DatosBean datos ) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("TITULAR", "STRING", datos.getID_SERPUB());
            arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MOTIVO", "STRING", datos.getID_MOTIVO());
        arregloCampos.add(temporal);
          temporal = new ObjPrepareStatement("ASUNTO", "STRING", datos.getASUNTO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("ATENDIO", "STRING", datos.getID_ATIENDE());
        arregloCampos.add(temporal);
        
        
        
         temporal = new ObjPrepareStatement("TURNADO", "STRING", datos.getFOLIO_REFERENCIA());
        arregloCampos.add(temporal);
          temporal = new ObjPrepareStatement("PRODEP", "STRING", datos.getPROCEDENCIA());
        arregloCampos.add(temporal);
        
        
        
        String Condicion;
        Condicion = "WHERE FOLIO=" + "'" + "" + datos.getFOLIO()+ "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("AUDIENCIAS", arregloCampos, Condicion);
    }  
      public boolean actualizarAudienciaGiras(DatosBean datos ) throws Exception {
        //Crear un ArrayList para agregar los campos a insertar
        ArrayList<ObjPrepareStatement> arregloCampos = new ArrayList<ObjPrepareStatement>();
        ObjPrepareStatement temporal;
        //Constantes.enviaMensajeConsola("Entre al DAO del INSERT DATOS...................................");
        //En el objeto temporal settear el campo de la tabla, el tipo de dato y el valor a insertar
        // Integer a=Integer.parseInt(correspondencia1.getCANTI1());
        temporal = new ObjPrepareStatement("TITULAR", "STRING", datos.getID_SERPUB());
            arregloCampos.add(temporal);
        temporal = new ObjPrepareStatement("MOTIVO", "STRING", datos.getID_MOTIVO());
        arregloCampos.add(temporal);
          temporal = new ObjPrepareStatement("ASUNTO", "STRING", datos.getASUNTO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("ATENDIO", "STRING", datos.getID_ATIENDE());
        arregloCampos.add(temporal);
          temporal = new ObjPrepareStatement("NOTA", "STRING", datos.getOBSERVACIONES());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("FECHA_EVENTO", "STRING", datos.getFECHA_EVENTO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("LUGAR_EVENTO", "STRING", datos.getLUGAR_EVENTO());
        arregloCampos.add(temporal);
         temporal = new ObjPrepareStatement("RUTA", "STRING", datos.getRUTA_DOC());
        arregloCampos.add(temporal);
        
        
        
       
        
        
        
        String Condicion;
        Condicion = "WHERE FOLIO=" + "'" + "" + datos.getFOLIO()+ "" + "'" + "";

        //Se terminan de adicionar a nuesto ArrayLis lbjos oetos
        //Ejecutar la funcion del OracleDAOFactory queryInsert
        return oraDaoFac.queryUpdate("AUDIENCIAS", arregloCampos, Condicion);
    }  
        
}
