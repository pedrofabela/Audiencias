package action;

//BEANS
import beans.DatosBean;
import beans.moduloBean;
import beans.moduloAuxBean;
import beans.usuarioBean;
import business.ConsultasBusiness;
import com.lowagie.text.Rectangle;


//BUSINESS




//SESION
import java.util.*;

import com.opensymphony.xwork2.ActionSupport;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;

import org.apache.struts2.interceptor.SessionAware;
import utilidades.Constantes;


public class PrincipalAction extends ActionSupport implements SessionAware {

    //Uusario
    private usuarioBean usuariocons;
    private String cveusuario;
    private String pasusuario;
    private String nomModulo;
    private String modulo;
    private String nombreUsuario;

    //LISTAS PERSISTENTES DEL MENU
    public List<moduloBean> modulosAUX = new ArrayList<moduloBean>();
    public List<moduloAuxBean> modulosAUXP = new ArrayList<moduloAuxBean>();
    public List<DatosBean> ListaCiudadanos = new ArrayList<DatosBean>();
    public List<DatosBean> ListaConsultaCiudadano = new ArrayList<DatosBean>();
    public List<DatosBean> ListaSerPub = new ArrayList<DatosBean>();
    public List<DatosBean> ListaMotivo = new ArrayList<DatosBean>();
    public List<DatosBean> ListaVisitas = new ArrayList<DatosBean>();
    public List<DatosBean> ListaMunicipios = new ArrayList<DatosBean>();
    public List<DatosBean> ListaTotalAudiencias = new ArrayList<DatosBean>();
    public List<DatosBean> ListaTotalMotivos = new ArrayList<DatosBean>();
    public List<DatosBean> ListaAudienicasDia = new ArrayList<DatosBean>();
    public List<DatosBean> ListaAudienicasPersona = new ArrayList<DatosBean>();
    public List<DatosBean> ListaAudienciasAsignadas = new ArrayList<DatosBean>();
    public List<DatosBean> ListaConcluidas = new ArrayList<DatosBean>();
    public List<DatosBean> ListaEnProceso = new ArrayList<DatosBean>();
    public List<DatosBean> ListaTextos = new ArrayList<DatosBean>();
      public List<DatosBean> ListaFolioActualiza = new ArrayList<DatosBean>();
 
   

    private ArrayList<DatosBean> ListaDatos = new ArrayList<>();
     
    DatosBean datos= new DatosBean();
    
    private boolean banInd = false;
    private boolean banForm=false;
    
    
    boolean valida1 = true;
    boolean valida2 = true;
    boolean valida3 = true;
    boolean valida4 = true;
    boolean valida5 = true;
    boolean valida6 = true;
    boolean banderafechas=false;
                boolean mensajeActualiza=false;

    
        

    //SESSIN USUARIO	
    // private Map session  = ActionContext.getContext().getSession();
    private String nivelUsuario;

    //Exception
    private String TipoError;
    private String TipoException;
    
    
    
    private boolean banT = false;
    private String archiFileName;
    private File archi;
    
    String ruta=null;

    //******************** PARA OBJETO DE NAVEGACIoN ***********************************************
    private Map session;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    
    
    
    public boolean isBanT() {
        return banT;
    }

    public void setBanT(boolean banT) {
        this.banT = banT;
    }

    public String getArchiFileName() {
        return archiFileName;
    }

    public void setArchiFileName(String archiFileName) {
        this.archiFileName = archiFileName;
    }

    public File getArchi() {
        return archi;
    }

    public void setArchi(File archi) {
        this.archi = archi;
    }
    
    
    
    
    

    public List<DatosBean> getListaTextos() {
        return ListaTextos;
    }

    public void setListaTextos(List<DatosBean> ListaTextos) {
        this.ListaTextos = ListaTextos;
    }

    public boolean isMensajeActualiza() {
        return mensajeActualiza;
    }

    public void setMensajeActualiza(boolean mensajeActualiza) {
        this.mensajeActualiza = mensajeActualiza;
    }
    
    
    

    public List<DatosBean> getListaConcluidas() {
        return ListaConcluidas;
    }

    public void setListaConcluidas(List<DatosBean> ListaConcluidas) {
        this.ListaConcluidas = ListaConcluidas;
    }

    public List<DatosBean> getListaEnProceso() {
        return ListaEnProceso;
    }

    public void setListaEnProceso(List<DatosBean> ListaEnProceso) {
        this.ListaEnProceso = ListaEnProceso;
    }

    public List<DatosBean> getListaFolioActualiza() {
        return ListaFolioActualiza;
    }

    public void setListaFolioActualiza(List<DatosBean> ListaFolioActualiza) {
        this.ListaFolioActualiza = ListaFolioActualiza;
    }
    
    
    
    

    public boolean isBanderafechas() {
        return banderafechas;
    }

    public void setBanderafechas(boolean banderafechas) {
        this.banderafechas = banderafechas;
    }

    public List<DatosBean> getListaAudienciasAsignadas() {
        return ListaAudienciasAsignadas;
    }

    public void setListaAudienciasAsignadas(List<DatosBean> ListaAudienciasAsignadas) {
        this.ListaAudienciasAsignadas = ListaAudienciasAsignadas;
    }
    
    
    

    public List<DatosBean> getListaAudienicasDia() {
        return ListaAudienicasDia;
    }

    public void setListaAudienicasDia(List<DatosBean> ListaAudienicasDia) {
        this.ListaAudienicasDia = ListaAudienicasDia;
    }

    public List<DatosBean> getListaAudienicasPersona() {
        return ListaAudienicasPersona;
    }

    public void setListaAudienicasPersona(List<DatosBean> ListaAudienicasPersona) {
        this.ListaAudienicasPersona = ListaAudienicasPersona;
    }
    
    

    public List<DatosBean> getListaTotalMotivos() {
        return ListaTotalMotivos;
    }

    public void setListaTotalMotivos(List<DatosBean> ListaTotalMotivos) {
        this.ListaTotalMotivos = ListaTotalMotivos;
    }
    
    

    public List<DatosBean> getListaTotalAudiencias() {
        return ListaTotalAudiencias;
    }

    public void setListaTotalAudiencias(List<DatosBean> ListaTotalAudiencias) {
        this.ListaTotalAudiencias = ListaTotalAudiencias;
    }
    

    public List<DatosBean> getListaMunicipios() {
        return ListaMunicipios;
    }

    public void setListaMunicipios(List<DatosBean> ListaMunicipios) {
        this.ListaMunicipios = ListaMunicipios;
    }

    public boolean isValida1() {
        return valida1;
    }

    public void setValida1(boolean valida1) {
        this.valida1 = valida1;
    }

    public boolean isValida2() {
        return valida2;
    }

    public void setValida2(boolean valida2) {
        this.valida2 = valida2;
    }

    public boolean isValida3() {
        return valida3;
    }

    public void setValida3(boolean valida3) {
        this.valida3 = valida3;
    }

    public boolean isValida4() {
        return valida4;
    }

    public void setValida4(boolean valida4) {
        this.valida4 = valida4;
    }
       
    public List<DatosBean> getListaVisitas() {
        return ListaVisitas;
    }

    public void setListaVisitas(List<DatosBean> ListaVisitas) {
        this.ListaVisitas = ListaVisitas;
    }
         
    public List<DatosBean> getListaSerPub() {
        return ListaSerPub;
    }

    public void setListaSerPub(List<DatosBean> ListaSerPub) {
        this.ListaSerPub = ListaSerPub;
    }
    public List<DatosBean> getListaConsultaCiudadano() {
        return ListaConsultaCiudadano;
    }

    public void setListaConsultaCiudadano(List<DatosBean> ListaConsultaCiudadano) {
        this.ListaConsultaCiudadano = ListaConsultaCiudadano;
    }

    public List<DatosBean> getListaMotivo() {
        return ListaMotivo;
    }

    public void setListaMotivo(List<DatosBean> ListaMotivo) {
        this.ListaMotivo = ListaMotivo;
    }
    
    public List<DatosBean> getListaCiudadanos() {
        return ListaCiudadanos;
    }

    public void setListaCiudadanos(List<DatosBean> ListaCiudadanos) {
        this.ListaCiudadanos = ListaCiudadanos;
    }

    public String getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(String nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

   
    public void setSession(Map session) {
        this.session = session;
    }

    public Map getSession() {
        return session;
    }
    //******************** TERMINA OBJETO DE NAVEGACIoN **********************************************
    
    //instancias para web service//
   
           

    public String RegresarIncio() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {

            //Se crea un nuevo objeto de acceco a Business
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }
    
    
    
    public String busquedaCiudadano() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {
            
            
            ConsultasBusiness con= new ConsultasBusiness();
           
            
               ListaMunicipios=con.listaMunicipios();
            
            
           ListaCiudadanos=con.consultaCiudadanos(datos);
            
        

            //Se crea un nuevo objeto de acceco a Business
            

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
        return "SUCCESS";
    }
     public String busquedaCiudadano4() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {
            
            
            ConsultasBusiness con= new ConsultasBusiness();
           
            
               ListaMunicipios=con.listaMunicipios();
            
            
           ListaCiudadanos=con.consultaCiudadanos(datos);
            
        

            //Se crea un nuevo objeto de acceco a Business
            

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
        return "SUCCESS";
    }
    
    public String busquedaCiudadanoGiras() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {
            
            
            ConsultasBusiness con= new ConsultasBusiness();
           
            
               ListaMunicipios=con.listaMunicipios();
            
            
           ListaCiudadanos=con.consultaCiudadanos(datos);
            
        

            //Se crea un nuevo objeto de acceco a Business
            

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
        return "SUCCESS";
    }
    
     public String nuevaAudiencia() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {
            
            
            ConsultasBusiness con= new ConsultasBusiness();
           
            
            
            ListaConsultaCiudadano=(ArrayList<DatosBean>)con.consultaDatosCiudadanos(datos);
            ListaSerPub=con.listaSerPub(datos);
            ListaMotivo=con.listaMotivo(datos);
            ListaVisitas=con.listaVisitas(datos);
            
            
            
            
            System.out.println("ID DE CIUDADANO" + datos.getID());
            
           
            
           
            
            
            
           
            
            

            //Se crea un nuevo objeto de acceco a Business
            

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
        return "SUCCESS";
    }
     
     
      public String nuevaAudienciaGiras() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {
            
            
            ConsultasBusiness con= new ConsultasBusiness();
           
            
            
            ListaConsultaCiudadano=(ArrayList<DatosBean>)con.consultaDatosCiudadanos(datos);
           
              ListaSerPub=con.listaSerPubGiras(datos);
            ListaMotivo=con.listaMotivo(datos);
            ListaVisitas=con.listaVisitas(datos);
            
            
            
            
            System.out.println("ID DE CIUDADANO" + datos.getID());
            
           
            
           
            
            
            
           
            
            

            //Se crea un nuevo objeto de acceco a Business
            

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
        return "SUCCESS";
    }
    
      public String consultaFolioActualiza() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {
            
            
            ConsultasBusiness con= new ConsultasBusiness();
           
            
            
           
            ListaSerPub=con.listaSerPub(datos);
            ListaMotivo=con.listaMotivo(datos);
            ListaVisitas=con.listaVisitas(datos);
            
            
            
            
           ListaFolioActualiza=(ArrayList<DatosBean>)con.consultaFolioActualiza(datos);
            
           Iterator LFA =ListaFolioActualiza.iterator();
           
           DatosBean obj;
           
            while (LFA.hasNext()) {
                obj = (DatosBean) LFA.next();
                
                datos.setID_SERPUB(obj.getID_SERPUB());
                 datos.setID_ATIENDE(obj.getID_ATIENDE());
                  datos.setID_MOTIVO(obj.getMOTIVO());
                  
                    datos.setASUNTO(obj.getASUNTO());
                 datos.setFOLIO_REFERENCIA(obj.getFOLIO_REFERENCIA());
                 datos.setPROCEDENCIA(obj.getPROCEDENCIA());
                 
            }
            
           
            
            
            
           
            
            

            //Se crea un nuevo objeto de acceco a Business
            

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
        return "SUCCESS";
    }
      
      public String consultaFolioActualizaGiras() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {
            
            
            ConsultasBusiness con= new ConsultasBusiness();
           
            
            
           
            ListaSerPub=con.listaSerPubGiras(datos);
            ListaMotivo=con.listaMotivo(datos);
            ListaVisitas=con.listaVisitas(datos);
            
            
            
            
           ListaFolioActualiza=(ArrayList<DatosBean>)con.consultaFolioActualizaGiras(datos);
            
           Iterator LFA =ListaFolioActualiza.iterator();
           
           DatosBean obj;
           
            while (LFA.hasNext()) {
                obj = (DatosBean) LFA.next();
                
                datos.setID_SERPUB(obj.getID_SERPUB());
                 datos.setID_ATIENDE(obj.getID_ATIENDE());
                  datos.setID_MOTIVO(obj.getMOTIVO());
                  
                    datos.setASUNTO(obj.getASUNTO());
                
                 datos.setOBSERVACIONES(obj.getOBSERVACIONES());
                  datos.setFECHA_EVENTO(obj.getFECHA_EVENTO());
                    datos.setLUGAR_EVENTO(obj.getLUGAR_EVENTO());
                
                         
            }
            
           
            
            
            
           
            
            

            //Se crea un nuevo objeto de acceco a Business
            

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
        return "SUCCESS";
    }
      
      public String actualizarAudiencia() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {
            
            
            ConsultasBusiness con= new ConsultasBusiness();
           
              
            ListaSerPub=con.listaSerPub(datos);
            ListaMotivo=con.listaMotivo(datos);
          
            
              valida1=false;
             valida2=false;
              valida3=false;
               valida4=false;
               
           
             
             if(datos.getID_SERPUB().length()>0){
                 valida1=true;
                 
             }
             else{
                  valida1=false;
                 addFieldError("SERPUB", "Elegir servidor Público");
                 
             }
             
              if(datos.getID_ATIENDE().length()>0){
                 valida2=true;
                 
             }
             else{
                   valida2=false;
                addFieldError("ATIENDE", "Elegir servidor Público");
                 
             }
               if(datos.getID_MOTIVO().length()>0){
                 valida3=true;
                 
             }
             else{
                   valida3=false;
                addFieldError("MOTIVO", "Elegir Motivo");
                 
             }
             if(datos.getASUNTO().length()>0){
                 datos.setASUNTO(quitaAcentos(datos.getASUNTO()));
                 valida4=true;
                 
             }
             else{
                 valida4=false;
                addFieldError("ASUNTO", "Capturar Asunto ");
                 
             }
            
            
            if(valida1 && valida2 && valida3 && valida4){
             
             
               
                 con.actualizarAudiencia(datos);
                 datos.setFOLIO("");
                     
             datos.setID_SERPUB("");            
             datos.setID_ATIENDE("");
              datos.setID_MOTIVO("");
               datos.setFOLIO_REFERENCIA("");
                datos.setASUNTO("");
                datos.setPROCEDENCIA("");
                
                
                mensajeActualiza=true;
             
             }
            
            
          
        
            
           
            
            
            
           
            
            

            //Se crea un nuevo objeto de acceco a Business
            

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
        return "SUCCESS";
    }
    
       public String actualizarAudienciaGiras() {

        if (cveusuario != null) {
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        } else if (session.get("cveUsuario") != null) {
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {
            
         
            ConsultasBusiness con= new ConsultasBusiness();
           
              
            ListaSerPub=con.listaSerPub(datos);
            ListaMotivo=con.listaMotivo(datos);
          
            
              valida1=false;
             valida2=false;
              valida3=false;
               valida4=false;
                valida5=false;
               valida6=false;
               
           
             
             if(datos.getID_SERPUB().length()>0){
                 valida1=true;
                 
             }
             else{
                  valida1=false;
                 addFieldError("SERPUB", "Elegir servidor Público");
                 
             }
             
              if(datos.getID_ATIENDE().length()>0){
                 valida2=true;
                 
             }
             else{
                   valida2=false;
                addFieldError("ATIENDE", "Elegir servidor Público");
                 
             }
               if(datos.getID_MOTIVO().length()>0){
                 valida3=true;
                 
             }
             else{
                   valida3=false;
                addFieldError("MOTIVO", "Elegir Motivo");
                 
             }
             if(datos.getASUNTO().length()>0){
                 datos.setASUNTO(quitaAcentos(datos.getASUNTO()));
                 valida4=true;
                 
             }
             else{
                 valida4=false;
                addFieldError("ASUNTO", "Capturar Asunto ");
                 
             }
             
               if(datos.getFECHA_EVENTO().length()>0){
                 valida5=true;
                 
             }
             else{
                   valida5=false;
                addFieldError("FECHA", "Elegir fecha");
                 
             }
             
             
             
             if(datos.getLUGAR_EVENTO().length()>0){
                 valida6=true;
                 
             }
             else{
                   valida6=false;
                addFieldError("LUGAR", "Lugar del evento");
                 
             }
            
            
            if(valida1 && valida2 && valida3 && valida4 && valida5 && valida6){
             
                
                  if (archiFileName != null) {
                    validate2();

                    if (banT == false) {

                        String Extension = "";

                        Extension = getExtension(archiFileName);

                        //System.out.println("esta es la extension del archivo: "+Extension);
                        archiFileName = datos.getFOLIO()+ "GIRAS" +  "." + Extension;

                        datos.setRUTA_DOC(archiFileName);
                        ruta = Constantes.rutaArch + archiFileName;

                        Constantes.enviaMensajeConsola(ruta);
                        File newarch = new File(ruta);

                        FileUtils.copyFile(archi, newarch);
                    }
                }
                 
                
                
                
                
                
                
                
                
                
                
               
                 con.actualizarAudienciaGiras(datos);
                 datos.setFOLIO("");
                     
             datos.setID_SERPUB("");            
             datos.setID_ATIENDE("");
              datos.setID_MOTIVO("");
               datos.setFOLIO_REFERENCIA("");
                datos.setASUNTO("");
                 datos.setOBSERVACIONES("");
                  datos.setFECHA_EVENTO("");
                 datos.setLUGAR_EVENTO("");
                mensajeActualiza=true;
                ListaVisitas=con.listaVisitas(datos);
             
             }
            
            
          
        
            
           
            
            
            
           
            
            

            //Se crea un nuevo objeto de acceco a Business
            

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
        return "SUCCESS";
    }

    public String guardaAudiencia() {

        
       

        try {
            
             ConsultasBusiness con= new ConsultasBusiness();
             
             //GUARDA AUDIENCIA
             
             String fecha="";
             int folio=0;
             int perfilH=0;
             String id_serpub ="";
             
            valida1=false;
             valida2=false;
              valida3=false;
               valida4=false;
               
               
             fecha=fecha();
              System.out.println("Feha"+fecha);
             folio=con.folio();
             System.out.println("folio"+folio);
             
             if(datos.getID_SERPUB().length()>0){
                 valida1=true;
                 
             }
             else{
                  valida1=false;
                 addFieldError("SERPUB", "Elegir servidor Público");
                 
             }
             
              if(datos.getID_ATIENDE().length()>0){
                 valida2=true;
                 
             }
             else{
                   valida2=false;
                addFieldError("ATIENDE", "Elegir servidor Público");
                 
             }
               if(datos.getID_MOTIVO().length()>0){
                 valida3=true;
                 
             }
             else{
                   valida3=false;
                addFieldError("MOTIVO", "Elegir Motivo");
                 
             }
             if(datos.getASUNTO().length()>0){
                 datos.setASUNTO(quitaAcentos(datos.getASUNTO()));
                 valida4=true;
                 
             }
             else{
                 valida4=false;
                addFieldError("ASUNTO", "Capturar Asunto ");
                 
             }
             
             datos.setFOLIO_REFERENCIA(quitaAcentos(datos.getFOLIO_REFERENCIA()));
             
             datos.setFECHA_AUDI(fecha);
             datos.setESTATUS("EN PROCESO");
             datos.setFOLIO(String.valueOf(folio+1));
             
             
             
             if(valida1 && valida2 && valida3 && valida4){
             
             id_serpub=datos.getID_ATIENDE();
             con.guardaAudiencia(datos);
               perfilH=con.perfil_h(id_serpub);
                 
               if(perfilH==2){
                     datos.setFECASI(fecha());
                     datos.setSEGUIMIENTO("AUDIENCIA CONCLUIDA");
                   con.guardaSeguimiento(datos);
                   
               }
               
               
            
             
             }
             nuevaAudiencia();
             
             datos.setID_SERPUB("");  
              datos.setID_ATIENDE("");   
             datos.setID_SOLICITA("");
              datos.setID_MOTIVO("");
               datos.setFOLIO_REFERENCIA("");
                datos.setASUNTO("");
                  datos.setPROCEDENCIA("");


             
        
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }
    
    
     public String guardaAudienciaGiras() {

         System.out.println("ENTR A GUARADR GIRA Y ");
       

        try {
            
             ConsultasBusiness con= new ConsultasBusiness();
             
             //GUARDA AUDIENCIA
             
             String fecha="";
             int folio=0;
             
             System.out.println("entre a guardae Giras");
             int perfilH=0;
             String id_serpub ="";
             
            valida1=false;
             valida2=false;
              valida3=false;
               valida4=false;
               valida5=false;
               valida6=false;
               
             fecha=fecha();
              System.out.println("Feha"+fecha);
             folio=con.folio();
             System.out.println("folio"+folio);
             
             if(datos.getID_SERPUB().length()>0){
                 valida1=true;
                 
             }
             else{
                  valida1=false;
                 addFieldError("SERPUB", "Elegir servidor Público");
                 
             }
             
              if(datos.getID_ATIENDE().length()>0){
                 valida2=true;
                 
             }
             else{
                   valida2=false;
                addFieldError("ATIENDE", "Elegir servidor Público");
                 
             }
               if(datos.getID_MOTIVO().length()>0){
                 valida3=true;
                 
             }
             else{
                   valida3=false;
                addFieldError("MOTIVO", "Elegir Motivo");
                 
             }
             if(datos.getASUNTO().length()>0){
                 datos.setASUNTO(quitaAcentos(datos.getASUNTO()));
                 valida4=true;
                 
             }
             else{
                 valida4=false;
                addFieldError("ASUNTO", "Capturar Asunto ");
                 
             }
             
             
             
             if(datos.getFECHA_EVENTO().length()>0){
                 valida5=true;
                 
             }
             else{
                   valida5=false;
                addFieldError("FECHA", "Elegir fecha");
                 
             }
             
             
             
             if(datos.getLUGAR_EVENTO().length()>0){
                 valida6=true;
                 
             }
             else{
                   valida6=false;
                addFieldError("LUGAR", "Lugar del evento");
                 
             }
             
           //  datos.setFOLIO_REFERENCIA(quitaAcentos(datos.getFOLIO_REFERENCIA()));
             
             datos.setFECHA_AUDI(fecha);
             datos.setESTATUS("EN PROCESO");
             datos.setFOLIO(String.valueOf(folio+1));
             
             
             
             if(valida1 && valida2 && valida3 && valida4 && valida5 && valida6 ){
                 
                 
                 
                   if (archiFileName != null) {
                    validate2();

                    if (banT == false) {

                        String Extension = "";

                        Extension = getExtension(archiFileName);

                        //System.out.println("esta es la extension del archivo: "+Extension);
                        archiFileName = datos.getFOLIO()+ "GIRAS" +  "." + Extension;

                        datos.setRUTA_DOC(archiFileName);
                        ruta = Constantes.rutaArch + archiFileName;

                        Constantes.enviaMensajeConsola(ruta);
                        File newarch = new File(ruta);

                        FileUtils.copyFile(archi, newarch);
                    }
                }
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
             
            
             con.guardaAudienciaGiras(datos);
              
                 
              
               
               
            
             
             }
             nuevaAudiencia();
               ListaSerPub=con.listaSerPubGiras(datos);
             
             datos.setID_SERPUB("");            
             datos.setID_SOLICITA("");
              datos.setID_MOTIVO("");
               datos.setFOLIO_REFERENCIA("");
                datos.setASUNTO("");
                 datos.setFOLIO("");
                 datos.setID_ATIENDE("");
                 datos.setOBSERVACIONES("");
                  datos.setFECHA_EVENTO("");
                   datos.setLUGAR_EVENTO("");


             
        
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }
    
     public String inicio() {

        
       

        try {
            
           
             
             
            
        
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }
     
      public String busquedaCiudadanoAsesor() {

        
       

        try {
            
           
             
             
            
        
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }
    public String NuevoCiudadano() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
            ListaMunicipios=con.listaMunicipios();
                    
            
        
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
    
      public String NuevoCiudadanoGiras() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
            ListaMunicipios=con.listaMunicipios();
                    
            
        
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
    
     public String agregarAudiencia() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
             
               
           nuevaAudiencia();
                    
            
        
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
     
     public String guardaCiudadano() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
           int id_ciudadano=0;
           
           boolean apaterno=false;
                      boolean amaterno=false;
                                 boolean nombres=false;
                                 boolean municipio=false;
                                 

             ListaMunicipios=con.listaMunicipios();
           
          
           
           if(datos.getAPATERNO().length()>0){
               apaterno=true;
               
           }
           else
           {
               addFieldError("APATERNO", "Capturar Apellido Paterno ");
             apaterno=false;
             
           }
           
             if(datos.getAMATERNO().length()>0){
               amaterno=true;
               
           }
           else
           {
               addFieldError("AMATERNO", "Capturar Apellido Materno ");
             amaterno=false;
             
           }
                    
             if(datos.getNOMBRES().length()>0){
               nombres=true;
               
           }
           else
           {
               addFieldError("NOMBRES", "Capturar Nombre(s) ");
             nombres=false;
             
           }
              if(datos.getMUNICIPIO().length()>0){
               municipio=true;
               
           }
           else
           {
               addFieldError("MUNICIPIO", "Capturar Municipio ");
             municipio=false;
             
           }
             
             
            if(amaterno && amaterno && nombres && municipio){
                
                
               datos.setAMATERNO(quitaAcentos(datos.getAMATERNO())); 
                               
                datos.setAPATERNO(quitaAcentos(datos.getAPATERNO())); 

                 datos.setNOMBRES(quitaAcentos(datos.getNOMBRES())); 
                 
                 
                datos.setNOMBRE_COMPLETO(datos.getNOMBRES()+" "+datos.getAPATERNO()+" "+datos.getAMATERNO());
                
                id_ciudadano=con.idCiudadano();
                datos.setID(String.valueOf(id_ciudadano+1));
           
                
               
               ListaCiudadanos=con.validaCiudadanos(datos);
               if(ListaCiudadanos.size()>0){
                   
                   Iterator lc=ListaCiudadanos.iterator();
                   DatosBean obj;
                   
                   while (lc.hasNext()) {
                       obj = (DatosBean) lc.next();
                       
                       datos.setID(obj.getID());
                       
                   }
                   
                   
                   addFieldError("EXISISTE", "El Ciudadano ya se encuentra registrado");
                    return "ERROR";
                   
               }
               else{
                   
                    
                    con.guardaCiudadano(datos);
                
                nuevaAudiencia();
                
                 return "SUCCESS";
                   
               }
               
               
               
               
               
            }
             
            
             
             
             
             
        
            
            return "ERROR";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
     
     
       public String guardaCiudadanoGiras() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
           int id_ciudadano=0;
           
           boolean apaterno=false;
                      boolean amaterno=false;
                                 boolean nombres=false;
                                 boolean municipio=false;
                                 

             ListaMunicipios=con.listaMunicipios();
           
          
           
           if(datos.getAPATERNO().length()>0){
               apaterno=true;
               
           }
           else
           {
               addFieldError("APATERNO", "Capturar Apellido Paterno ");
             apaterno=false;
             
           }
           
             if(datos.getAMATERNO().length()>0){
               amaterno=true;
               
           }
           else
           {
               addFieldError("AMATERNO", "Capturar Apellido Materno ");
             amaterno=false;
             
           }
                    
             if(datos.getNOMBRES().length()>0){
               nombres=true;
               
           }
           else
           {
               addFieldError("NOMBRES", "Capturar Nombre(s) ");
             nombres=false;
             
           }
              if(datos.getMUNICIPIO().length()>0){
               municipio=true;
               
           }
           else
           {
               addFieldError("MUNICIPIO", "Capturar Municipio ");
             municipio=false;
             
           }
             
             
            if(amaterno && amaterno && nombres && municipio){
                
                
                
                
                //////////////////7
                
                
               datos.setAMATERNO(quitaAcentos(datos.getAMATERNO())); 
                               
                datos.setAPATERNO(quitaAcentos(datos.getAPATERNO())); 

                 datos.setNOMBRES(quitaAcentos(datos.getNOMBRES())); 
                 
                 
                datos.setNOMBRE_COMPLETO(datos.getNOMBRES()+" "+datos.getAPATERNO()+" "+datos.getAMATERNO());
                
                id_ciudadano=con.idCiudadano();
                datos.setID(String.valueOf(id_ciudadano+1));
           
                
               
               ListaCiudadanos=con.validaCiudadanos(datos);
               if(ListaCiudadanos.size()>0){
                   
                   Iterator lc=ListaCiudadanos.iterator();
                   DatosBean obj;
                   
                   while (lc.hasNext()) {
                       obj = (DatosBean) lc.next();
                       
                       datos.setID(obj.getID());
                       
                   }
                   
                   
                   addFieldError("EXISISTE", "El Ciudadano ya se encuentra registrado");
                    return "ERROR";
                   
               }
               else{
                   
                    
                    con.guardaCiudadanoGiras(datos);
                
                nuevaAudiencia();
                
                 return "SUCCESS";
                   
               }
               
               
               
               
               
            }
             
            
             
             
             
             
        
            
            return "ERROR";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
       
       
       
        public void validate2() {

        try {
//agregando la validacion de tipo de archivo...
            if (archiFileName != null) {
//Constantes.enviaMensajeConsola("--EL ARCHIVO ES .... " + archiFileName);
//Constantes.enviaMensajeConsola("--entre a validar el tipo de arcivo.... " + sitio.getTIP_MSJ());
                if (!archiFileName.contains(".pdf")) {
                    archiFileName = "";
                    addFieldError("archi", "*** La extensión del archivo no es aceptada debe ser (pdf)***");
                    banT = true;

                }

                //if (archiFileName.length() > 2097152 ) 
                if (16777126 <= FileUtils.sizeOf(archi)) {
                    addFieldError("archi", "*** No se permiten archivos mayores a 15MB ***");

                    banT = true;

                }

            }
        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();

        }

    }
        
        public static String getExtension(String Archivo) {
        int index = Archivo.lastIndexOf('.');
        if (index == -1) {
            return "";
        } else {
            return Archivo.substring(index + 1);
        }
    }


     
     
     
     
      public String inicioDashboard() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
             
             String fecha=fecha();
             System.out.println(fecha);
             
             fecha=fecha.substring(3,8);
             banderafechas=true;
            
             
             datos.setFECHA_INICIO("01/12/18");
             datos.setFECHA_TERMINO(fecha());
            
             
              ListaTotalAudiencias=con.totalAudiencias(datos);
              
              Iterator LTA = ListaTotalAudiencias.iterator();
              DatosBean obj;
              
              while (LTA.hasNext()) {
                obj = (DatosBean) LTA.next();
                
                datos.setEN_PROCESO(obj.getEN_PROCESO());
                 datos.setCONCLUIDO(obj.getCONCLUIDO());
                  datos.setTOTAL_AUDIENCIAS(obj.getTOTAL_AUDIENCIAS());
                
            }
              
              
              ListaTotalMotivos=con.totalMotivos(datos);
         ListaAudienicasDia=con.audienciasDia(datos);
          ListaAudienicasPersona=con.audienciasPersona(datos);
          
         ListaConcluidas=con.listaConcluidas(datos);
             ListaEnProceso=con.listaEnProceso(datos);
          
            System.out.println("EN PROCESO++++++++++++++"+ListaEnProceso.size());
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
     
     
      public String inicioDashboardFechas() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
             
            banderafechas=true;
            
             
              ListaTotalAudiencias=con.totalAudiencias(datos);
              
              Iterator LTA = ListaTotalAudiencias.iterator();
              DatosBean obj;
              
              while (LTA.hasNext()) {
                obj = (DatosBean) LTA.next();
                
                datos.setEN_PROCESO(obj.getEN_PROCESO());
                 datos.setCONCLUIDO(obj.getCONCLUIDO());
                  datos.setTOTAL_AUDIENCIAS(obj.getTOTAL_AUDIENCIAS());
                
            }
              
              
              ListaTotalMotivos=con.totalMotivos(datos);
         ListaAudienicasDia=con.audienciasDia(datos);
          ListaAudienicasPersona=con.audienciasPersona(datos);
                    
             ListaConcluidas=con.listaConcluidas(datos);
             ListaEnProceso=con.listaEnProceso(datos);
         System.out.println("EN PROCESO++++++++++++++"+ListaEnProceso.size());
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
     
     public  List inicioAsesor(String filtro ) throws Exception {
         
         
             ConsultasBusiness con= new ConsultasBusiness();
         
         String fil=filtro;
         
      datos.setFILTRO(fil);
         System.out.println("valor de filtro +++++++"+datos.getFILTRO());
         
         ListaTextos=con.listaTextos();
         System.out.println("lista textos tamaño"+ ListaTextos.size());
         
         
         
         ListaAudienciasAsignadas=con.audienciasAsignadas(datos);
              SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");
        Iterator LAA = ListaAudienciasAsignadas.iterator();
        DatosBean obj;
         while (LAA.hasNext()) {
             obj = (DatosBean) LAA.next();
             
            obj.setFECHA_AUDI(obj.getFECHA_AUDI());
             
         }
         
         
         return ListaAudienciasAsignadas;
         
         
        
        

       
    } 
     
     
      public String guardaSeguimiento() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
              datos.setFECASI(fecha());
              
              if(datos.getSEGUIMIENTO().length()>0){
           
              con.guardaSeguimiento(datos);
               ListaAudienciasAsignadas=con.audienciasAsignadas(datos);
               datos.setSEGUIMIENTO("");
              }
              
              else {
                  ListaAudienciasAsignadas=con.audienciasAsignadas(datos);
                    addFieldError("seguimiento", "No se guardo el segimineto, dato requerido");
                  
              }
             
               ListaTextos=con.listaTextos();
               
               
            datos.setSEGUIMIENTO("");
            datos.setTEXTO("");
        
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
      
      
      
       public String reporteador() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
             
             String fecha=fecha();
             System.out.println(fecha);
             
             fecha=fecha.substring(3,8);
             banderafechas=false;
            
             
             datos.setFECHA_INICIO("01/"+fecha);
             datos.setFECHA_TERMINO(fecha());
             
              ListaSerPub=con.listaSerPub(datos);
            ListaMotivo=con.listaMotivo(datos);
            
             
             
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
      
       public String actualizarCiudadano() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
             
              int id_ciudadano=0;
           
           boolean apaterno=false;
                      boolean amaterno=false;
                                 boolean nombres=false;
                                 boolean municipio=false;
                                 

             ListaMunicipios=con.listaMunicipios();
          
            
            
            
             datos.setNOMBRE_COMPLETO(datos.getNOMBRES()+" "+datos.getAPATERNO()+" "+datos.getAMATERNO());
          
             
            
           
           if(datos.getAPATERNO().length()>0){
               apaterno=true;
               
           }
           else
           {
               addFieldError("APATERNO", "Capturar Apellido Paterno ");
             apaterno=false;
             
           }
           
             if(datos.getAMATERNO().length()>0){
               amaterno=true;
               
           }
           else
           {
               addFieldError("AMATERNO", "Capturar Apellido Materno ");
             amaterno=false;
             
           }
                    
             if(datos.getNOMBRES().length()>0){
               nombres=true;
               
           }
           else
           {
               addFieldError("NOMBRES", "Capturar Nombre(s) ");
             nombres=false;
             
           }
              if(datos.getMUNICIPIO().length()>0){
               municipio=true;
               
           }
           else
           {
               addFieldError("MUNICIPIO", "Capturar Municipio ");
             municipio=false;
             
           }
             
             
             
             
              if(amaterno && amaterno && nombres && municipio){
                  
                  
                  
                    con.actualizarCiudadano(datos);
                    busquedaCiudadano();
                  
              }
              
              else{
                  
               
                  
              }
             
             
             
             
             
             
             
             
             
             
          
            
            
             
             
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
       
      
      public String actualizarCiudadanoGiras() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
             
              int id_ciudadano=0;
           
           boolean apaterno=false;
                      boolean amaterno=false;
                                 boolean nombres=false;
                                 boolean municipio=false;
                                 

             ListaMunicipios=con.listaMunicipios();
          
            
            
            
             datos.setNOMBRE_COMPLETO(datos.getNOMBRES()+" "+datos.getAPATERNO()+" "+datos.getAMATERNO());
          
             
            
           
           if(datos.getAPATERNO().length()>0){
               apaterno=true;
               
           }
           else
           {
               addFieldError("APATERNO", "Capturar Apellido Paterno ");
             apaterno=false;
             
           }
           
             if(datos.getAMATERNO().length()>0){
               amaterno=true;
               
           }
           else
           {
               addFieldError("AMATERNO", "Capturar Apellido Materno ");
             amaterno=false;
             
           }
                    
             if(datos.getNOMBRES().length()>0){
               nombres=true;
               
           }
           else
           {
               addFieldError("NOMBRES", "Capturar Nombre(s) ");
             nombres=false;
             
           }
              if(datos.getMUNICIPIO().length()>0){
               municipio=true;
               
           }
           else
           {
               addFieldError("MUNICIPIO", "Capturar Municipio ");
             municipio=false;
             
           }
             
             
             
             
              if(amaterno && amaterno && nombres && municipio){
                  
                  
                  
                    con.actualizarCiudadanoGiras(datos);
                    busquedaCiudadano();
                  
              }
              
              else{
                  
               
                  
              }
             
             
             
             
             
             
             
             
             
             
          
            
            
             
             
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    } 
         
       
       
       
     public String genararReporte() {

        
       

        try {
            
           
             ConsultasBusiness con= new ConsultasBusiness();
             
             
             banderafechas=false;
            
             
            
             
              ListaSerPub=con.listaSerPub(datos);
            ListaMotivo=con.listaMotivo(datos);
            
            
            boolean ser_pub=false;
            boolean motivo= false;
            
            String consulta="";
            
            
            if(datos.getID_SERPUB().length()>0){
                
                ser_pub=true;
            }
            else{
                 ser_pub=false;
             }
            
            if(datos.getID_MOTIVO().length()>0){
                
                motivo=true;
            }
            else{
                 motivo=false;
             }
            
            
            
            // consulta de 
            if(ser_pub && motivo==false){
               
                
                consulta="WHERE ID_SERPUB='"+ datos.getID_SERPUB()+"' AND FECHA_AUDI<='"+datos.getFECHA_TERMINO()+"' AND FECHA_AUDI>='"+datos.getFECHA_INICIO()+"' AND ESTATUS='"+datos.getESTATUS()+"'   " ;
                System.out.println("CONDICIÓN SERPUB &&&////////"+consulta);
                 // LISRA DE REPORTES
                 ListaConcluidas=con.listaReportes(consulta);
                
                
            }
            
             if(motivo && ser_pub==false){
                 
                 consulta="WHERE FECHA_AUDI<='"+datos.getFECHA_TERMINO()+"' AND FECHA_AUDI>='"+datos.getFECHA_INICIO()+"' AND ID_MOTIVO='"+datos.getID_MOTIVO()+"' AND ESTATUS='"+datos.getESTATUS()+"'   " ;
                System.out.println("CONDICIÓN MOTIVO &&&////////"+consulta);
                 ListaConcluidas=con.listaReportes(consulta);
            }
              if(ser_pub && motivo){
                  
                    consulta="WHERE ID_SERPUB='"+ datos.getID_SERPUB()+"' AND FECHA_AUDI<='"+datos.getFECHA_TERMINO()+"' AND FECHA_AUDI>='"+datos.getFECHA_INICIO()+"' AND ESTATUS='"+datos.getESTATUS()+"' AND ID_MOTIVO='"+datos.getID_MOTIVO()+"'  " ;
                System.out.println("CONDICIÓN  AMBAS &&&////////"+consulta);
                 ListaConcluidas=con.listaReportes(consulta);
            }
             
              
               if(ser_pub==false && motivo==false){
                   
                   
                    consulta="WHERE  FECHA_AUDI<='"+datos.getFECHA_TERMINO()+"' AND FECHA_AUDI>='"+datos.getFECHA_INICIO()+"' AND ESTATUS='"+datos.getESTATUS()+"' " ;
                System.out.println("CONDICIÓN NINGUNA &&&////////"+consulta); 
                 ListaConcluidas=con.listaReportes(consulta);
            }
             
             if(datos.getESTATUS().equals("TODOS")){
                 
                 
                
            }    
            
            return "SUCCESS";

        } catch (Exception e) {
            TipoError = "SESSION";
            TipoException = e.getMessage();
            return "ERROR";
        }
    }  
      
      
     
   
         
         
    
     
     
     
     
     
     
     
     
     public static String quitaAcentos(String input) {
    // Cadena de caracteres original a sustituir.
    String original = "áàäéèëíìïóòöúùuÁÀÄÉÈËÍÌÏÓÒÖÚÙÜçÇ";
    // Cadena de caracteres ASCII que reemplazarán los originales.
    String ascii = "aaaeeeiiiooouuuAAAEEEIIIOOOUUUcC";
    String output = input;
    for (int i=0; i<original.length(); i++) {
        // Reemplazamos los caracteres especiales.
        output = output.replace(original.charAt(i), ascii.charAt(i)).trim().toUpperCase();
    }//for i
    return output;
}//remove1
     
     
     
     
    public  String fecha() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");
        return formateador.format(ahora);
    }
    
    
    
   
   

    public usuarioBean getUsuariocons() {
        return usuariocons;
    }

    public void setUsuariocons(usuarioBean usuariocons) {
        this.usuariocons = usuariocons;
    }

    public String getCveusuario() {
        return cveusuario;
    }

    public void setCveusuario(String cveusuario) {
        this.cveusuario = cveusuario;
    }

    public String getPasusuario() {
        return pasusuario;
    }

    public void setPasusuario(String pasusuario) {
        this.pasusuario = pasusuario;
    }

    public String getNomModulo() {
        return nomModulo;
    }

    public void setNomModulo(String nomModulo) {
        this.nomModulo = nomModulo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getTipoError() {
        return TipoError;
    }

    public void setTipoError(String tipoError) {
        TipoError = tipoError;
    }

    public String getTipoException() {
        return TipoException;
    }

    public void setTipoException(String tipoException) {
        TipoException = tipoException;
    }

    public List<moduloBean> getModulosAUX() {
        return modulosAUX;
    }

    public void setModulosAUX(List<moduloBean> modulosAUX) {
        this.modulosAUX = modulosAUX;
    }

    public List<moduloAuxBean> getModulosAUXP() {
        return modulosAUXP;
    }

    public void setModulosAUXP(List<moduloAuxBean> modulosAUXP) {
        this.modulosAUXP = modulosAUXP;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public boolean isBanInd() {
        return banInd;
    }

    public void setBanInd(boolean banInd) {
        this.banInd = banInd;
    }

    public boolean isBanForm() {
        return banForm;
    }

    public void setBanForm(boolean banForm) {
        this.banForm = banForm;
    }
    
    public DatosBean getDatos() {
        return datos;
    }

    public void setDatos(DatosBean datos) {
        this.datos = datos;
    }

    public ArrayList<DatosBean> getListaDatos() {
        return ListaDatos;
    }

    public void setListaDatos(ArrayList<DatosBean> ListaDatos) {
        this.ListaDatos = ListaDatos;
    }
    
    
    

}
