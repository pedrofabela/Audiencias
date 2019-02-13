package utilidades;

import java.io.Serializable;

public class Constantes implements Serializable {
	private static final long serialVersionUID = -3358884679090829992L;
	
     //GENERALES
	 public static final String tablaDual="dual";
	 public static final String nombreSistema = "SEGESCN";
	 public static String usuarioseg= "SEGESCN";
	 public static final String modulo0 = "0";
	 public static final String moduloSegEsc = "segesc";

	 
	
     //TABLAS
         public static final String TablaUsuarios="TBL_USUARIOS";
	 public static final String TablaModulosPerfiles="TBL_MODULOSPERFILES";
	 public static final String TablaModulos="TBL_MODULOS";
	 public static final String TablaCct= "CAT_CCTS";
         
	 
		/*/ **************DESARROLLO**********************************************************
	
		public static final boolean esDesarrollo = true;
		public static final String rutaProyectos = "http://172.20.2.110:8080/";	
		public static final String rutareportesjasper = "/home/pedro/Documentos/reportes/";		                                                  
		public static final String rutaArch = "/home/pedro/Documentos/folios/";  //cambair cuando els ervidor este activo
		public static final String rutaEstilos = "http://172.20.2.110:8080/estilosUDAI/" ;
		public static final String rutaManuales = "C:/manuales/permanecerEstudiando.pdf";
		public static final String rutaImages ="/home/pedro/Documentos/reportes/";		
		//*/
		
	 
		//******************* PRODUCCION*******************************************************
      
		public static final boolean esDesarrollo = false;		
		public static final String rutaProyectos =   "http://aplicaciones.edugem.gob.mx/";
		public static final String rutareportesjasper = "/apachetomcat/reportes/audiencias/";		                                                  
		public static final String rutaArch = "/apachetomcat/audienciasseduc/documentos/audiencias/";  				
		public static final String rutaEstilos = "http://aplicaciones.edugem.gob.mx/estilosUDAI/";		                                        
		public static final String rutaImages = "/apachetomcat/reportes/imagenes/audiencias/";
		public static final String rutaManuales = "http://aplicaciones.edugem.gob.mx/manuales/ManualUsuario3P.pdf";	
			
		//*/
	  

	  public static void enviaMensajeConsola(String cadena){
			if(Constantes.esDesarrollo){
				System.out.println("MENSAJE_DESARROLLO: "+cadena);
			}
		}
} 

