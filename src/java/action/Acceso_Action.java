package action;



//BEANS
import action.PrincipalAction;
import beans.DatosBean;
import beans.moduloBean;
import beans.moduloAuxBean;
import beans.usuarioBean;
import beans.Navegacion;
import business.AccesoBusiness;
import business.ConsultasBusiness;
//BUSINESS


//SESION
import java.util.*;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import utilidades.Constantes;

 
public class Acceso_Action extends ActionSupport implements SessionAware{
    
    //Uusario
    private usuarioBean usuariocons;
    private String cveusuario;
    private String pasusuario;
    private String nomModulo;
    private String modulo;
    private String nombreUsuario;
    
    //LISTAS PERSISTENTES DEL MENU
    public List <moduloBean> modulosAUX = new ArrayList<moduloBean>();
    public List <moduloAuxBean> modulosAUXP = new ArrayList<moduloAuxBean>();
     public List<DatosBean> ListaAudienciasAsignadas = new ArrayList<DatosBean>();
      public List<DatosBean> ListaTextos = new ArrayList<DatosBean>();
      public List<DatosBean> ListaMunicipios = new ArrayList<DatosBean>();
     
     DatosBean datos =new DatosBean();

	//SESSIN USUARIO	
   
   // private Map session  = ActionContext.getContext().getSession();
    private String nivelUsuario;	  

    //Exception
    private String TipoError;
    private String TipoException;



    //******************** PARA OBJETO DE NAVEGACIoN ***********************************************
    private Map session;

    public List<DatosBean> getListaMunicipios() {
        return ListaMunicipios;
    }

    public void setListaMunicipios(List<DatosBean> ListaMunicipios) {
        this.ListaMunicipios = ListaMunicipios;
    }
    

    public DatosBean getDatos() {
        return datos;
    }

    public void setDatos(DatosBean datos) {
        this.datos = datos;
    }

    public List<DatosBean> getListaTextos() {
        return ListaTextos;
    }

    public void setListaTextos(List<DatosBean> ListaTextos) {
        this.ListaTextos = ListaTextos;
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

    public List<DatosBean> getListaAudienciasAsignadas() {
        return ListaAudienciasAsignadas;
    }

    public void setListaAudienciasAsignadas(List<DatosBean> ListaAudienciasAsignadas) {
        this.ListaAudienciasAsignadas = ListaAudienciasAsignadas;
    }

    

    
    //******************** TERMINA OBJETO DE NAVEGACIoN **********************************************

    
    public String MuestraMenuPrincipalUsuario() {

        if(cveusuario!=null){
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        }else if(session.get("cveUsuario")!=null){
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {

            //Se crea un nuevo objeto de acceco a Business
            AccesoBusiness acceso = new AccesoBusiness();
            usuariocons = acceso.consultaUsuario(cveusuario, pasusuario);
            
           
            
            
            
            System.out.println("esto llega de usuario: "+usuariocons);

            if(usuariocons!=null){
                
                session.put("usuario",usuariocons);

                //obteniendo el nombre del usuario
                nombreUsuario=  usuariocons.getNAMEUSUARIO();
                String Filtro=usuariocons.getFILTRO();
                PrincipalAction objeto =new PrincipalAction();
                ConsultasBusiness con= new ConsultasBusiness();
                
              
                
                

                modulosAUX = (ArrayList<moduloBean>) acceso.consultaModulosPerfilMenu(usuariocons.getPERFIL(), modulo);
                modulosAUXP = (ArrayList<moduloAuxBean>) acceso.consultaModulosHijosPerfilMenu(usuariocons.getPERFIL(), modulo);


                Constantes.enviaMensajeConsola("REGRESE-----------------------");
                Iterator iterG = modulosAUX.iterator();
                while(iterG.hasNext()){
                	moduloBean Concep = (moduloBean) iterG.next();
                	System.out.println("VALOR -->" + Concep.getCVE_MODPADRE());
                    System.out.println("VALOR -->" + Concep.getDESC_MOD());
                    System.out.println("VALOR -->" + Concep.getIMAGEN());
                    

                }

                if(modulosAUX == null){
                    addActionError("***** Ud. no tiene acceso a este modulo, favor de contacar al administrador del sistema ***** ");
                    return "ERROR";
                }
                Constantes.enviaMensajeConsola("voy a successs-----------------------");
                  System.out.println("PERFIL +++++++++++++++++++"+usuariocons.getPERFIL());
                  
                  if(usuariocons.getPERFIL()==2 || usuariocons.getPERFIL()== 3 ){
                       System.out.println("entre a return");
                       
                     datos.setFILTRO(usuariocons.getFILTRO());
                      
                      ListaAudienciasAsignadas =  objeto.inicioAsesor(Filtro);
                      ListaTextos=con.listaTextos();
                      ListaMunicipios=con.listaMunicipios();
                      
                      
                      
                       return "SUCCESS2";
                      
                  }
                  
                  if(usuariocons.getPERFIL()==5  ){
                       System.out.println("entre a return");
                       
                     datos.setFILTRO(usuariocons.getFILTRO());
                      
                      ListaAudienciasAsignadas =  objeto.inicioAsesor(Filtro);
                      ListaTextos=con.listaTextos();
                      ListaMunicipios=con.listaMunicipios();
                      
                      
                      
                       return "SUCCESS3";
                      
                  }
                  
                  
                 
                  
                  
                  
                  
                  else{
                return "SUCCESS";
                  }
            }
            
            
            
            else{
                addFieldError("NO", "Usuario y/o contraseña no validos");
                return "ERROR";
            }
         

        } catch (Exception e) {
            TipoError="SESSION";
            TipoException=e.getMessage();
            return "ERROR";
        }
    }

    
   
     public String MuestraMenuPrincipalUsuario2() {
         
         cveusuario="NAHIMA";
         pasusuario="NAAD2456";

        if(cveusuario!=null){
            session.put("cveUsuario", cveusuario);
            session.put("psw", pasusuario);
        }else if(session.get("cveUsuario")!=null){
            cveusuario = (String) session.get("cveUsuario");
            pasusuario = (String) session.get("psw");
        }

        try {

            //Se crea un nuevo objeto de acceco a Business
            AccesoBusiness acceso = new AccesoBusiness();
            usuariocons = acceso.consultaUsuario(cveusuario, pasusuario);
            
           
            
            
            
            System.out.println("esto llega de usuario: "+usuariocons);

            if(usuariocons!=null){
                
                session.put("usuario",usuariocons);

                //obteniendo el nombre del usuario
                nombreUsuario=  usuariocons.getNAMEUSUARIO();
                String Filtro=usuariocons.getFILTRO();
                PrincipalAction objeto =new PrincipalAction();
                ConsultasBusiness con= new ConsultasBusiness();
                
              
                
                

                modulosAUX = (ArrayList<moduloBean>) acceso.consultaModulosPerfilMenu(usuariocons.getPERFIL(), modulo);
                modulosAUXP = (ArrayList<moduloAuxBean>) acceso.consultaModulosHijosPerfilMenu(usuariocons.getPERFIL(), modulo);


                Constantes.enviaMensajeConsola("REGRESE-----------------------");
                Iterator iterG = modulosAUX.iterator();
                while(iterG.hasNext()){
                	moduloBean Concep = (moduloBean) iterG.next();
                	System.out.println("VALOR -->" + Concep.getCVE_MODPADRE());
                    System.out.println("VALOR -->" + Concep.getDESC_MOD());
                    System.out.println("VALOR -->" + Concep.getIMAGEN());
                    

                }

                if(modulosAUX == null){
                    addActionError("***** Ud. no tiene acceso a este modulo, favor de contacar al administrador del sistema ***** ");
                    return "ERROR";
                }
                Constantes.enviaMensajeConsola("voy a successs-----------------------");
                  System.out.println("PERFIL +++++++++++++++++++"+usuariocons.getPERFIL());
                  
                  if(usuariocons.getPERFIL()==2 || usuariocons.getPERFIL()== 3 ){
                       System.out.println("entre a return");
                       
                     datos.setFILTRO(usuariocons.getFILTRO());
                      
                      ListaAudienciasAsignadas =  objeto.inicioAsesor(Filtro);
                      ListaTextos=con.listaTextos();
                      ListaMunicipios=con.listaMunicipios();
                      
                      
                      
                       return "SUCCESS2";
                      
                  }
                  
                  if(usuariocons.getPERFIL()==5  ){
                       System.out.println("entre a return");
                       
                     datos.setFILTRO(usuariocons.getFILTRO());
                      
                      ListaAudienciasAsignadas =  objeto.inicioAsesor(Filtro);
                      ListaTextos=con.listaTextos();
                      ListaMunicipios=con.listaMunicipios();
                      
                      
                      
                       return "SUCCESS3";
                      
                  }
                  
                  
                 
                  
                  
                  
                  
                  else{
                return "SUCCESS";
                  }
            }
            
            
            
            else{
                addFieldError("NO", "Usuario y/o contraseña no validos");
                return "ERROR";
            }
         

        } catch (Exception e) {
            TipoError="SESSION";
            TipoException=e.getMessage();
            return "ERROR";
        }
    }

    
   
    
    
	public String verMevu(){
		  try {		
			  		     
			 //...retomando
			 
	     }catch (Exception e) {
				addActionError("Ocurrio un error: "+e );
				return "ERROR";
			}
			return "SUCCESS";
	}
	
    
    @SkipValidation
    public String cerrar(){
        if(session!=null){
            System.out.println("termino la session");
            session.clear();
        }
        return "SUCCESS";
    }


    //VALIDACIONES
    @Override
    public void validate() {

        try {

            if (cveusuario.length() == 0) {
                addFieldError("ERRORUSU", "Debe Capturar el Nombre de Usuario");
            }

            if (pasusuario.length() == 0) {
                addFieldError("ERRORPASS", "Debe Capturar la Contraseña de Usuario");
            }

        } catch (Exception ex) {
            TipoError="SESSION";
            TipoException=ex.getMessage();
        }
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
}