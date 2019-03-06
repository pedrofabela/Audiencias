<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">

    function buscar(accion) {

        document.formularioPrincipal.action = accion;
        document.formularioPrincipal.submit();
    }

    
    function Accion(accion) {

        document.formularioPrincipal.action = accion;
        document.formularioPrincipal.submit();
    }
     function Accion2(accion) {
         var correo=document.getElementById("CORREO").value;
         
         
          if(correo=="")
        {
       
           document.formularioPrincipal.action = accion;
            document.formularioPrincipal.submit();
        
        
        
        
        }
         
         
         
         
         else{
         
          expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
    if ( !expr.test(correo) ){
        alert("Error: La dirección de correo " + correo + " es incorrecta.");
       
        }
     
      else {
          
           document.formularioPrincipal.action = accion;
            document.formularioPrincipal.submit();
         
      }
     
    }
}
    
   function aMayusculas(obj,id){
    obj = obj.toUpperCase();
    document.getElementById(id).value = obj;
}
   
    //PARA REGRESAR EN DONDE SE QUEDO...........
   
   
</script>

<script>

function startTime() {
    var today = new Date();
    var hr = today.getHours();
    var min = today.getMinutes();
    var sec = today.getSeconds();
    ap = (hr < 12) ? "<span>am</span>" : "<span>pm</span>";
    hr = (hr == 0) ? 12 : hr;
    hr = (hr > 12) ? hr - 12 : hr;
    //Add a zero in front of numbers<10
    hr = checkTime(hr);
    min = checkTime(min);
    sec = checkTime(sec);
    document.getElementById("clock").innerHTML = hr + ":" + min + ":" + sec + " " + ap;
    
    var months = ['Enero', 'Febrero', 'Marzo', 'April', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
    var days = ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado'];
    var curWeekDay = days[today.getDay()];
    var curDay = today.getDate();
    var curMonth = months[today.getMonth()];
    var curYear = today.getFullYear();
    var date = curDay+" "+'de'+" "+curMonth;
    document.getElementById("date").innerHTML = date;
    
    var time = setTimeout(function(){ startTime() }, 500);
}
function checkTime(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}
</script>









<html lang="en">

    <head>
        
        
        

        <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <meta name="description" content="">
                        <meta name="author" content="">

                           <link rel="shortcut icon" href="images/portalSE.png" />
                            <title>SIAPRO</title>

                            <link href=" <s:url value="/vendor/bootstrap/css/bootstrap.min.css"/>" media="all" rel="stylesheet" type="text/css"/>
                            <!-- Custom fonts for this template-->
                            <link href=" <s:url value="/vendor/fontawesome-free/css/all.min.css"/>" media="all" rel="stylesheet" type="text/css"/>        
                            <!-- Page level plugin CSS-->
                            <link href=" <s:url value="/vendor/datatables/dataTables.bootstrap4.css"/>" media="all" rel="stylesheet" type="text/css"/>            
                            <!-- Custom styles for this template-->
                            <link href=" <s:url value="/css/sb-admin.css"/>" media="all" rel="stylesheet" type="text/css"/> 

                           

                            </head>

                            <body id="page-top" onload="startTime()">
                                <s:form name="formularioPrincipal" id="formularioPrincipal">

                                    <nav class="navbar navbar-expand navbar-dark " style="height: 90px; background: #611a1e; box-shadow: 2px 2px 10px #333  ; border-bottom: 15px solid #606060; ">


                                       
                                        <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                                            <img src="images/logos.png" style="min-width: 20%; max-width: 250px;"></img>
                                        </button>

                                        <!-- Navbar Search -->
                                        <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

                                        </div>

                                        <!-- Navbar -->
                                        <ul class="navbar-nav ml-auto ml-md-0">    
                                            <li class="nav-item dropdown no-arrow">
                                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <i class="fas fa-user-circle fa-fw" style="background: red; width: 40px; height: 40px; font-size: 40px; border-radius: 50%;"></i>
                                                </a>
                                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">                                           
                                                    <a class="dropdown-item" href="" data-toggle="modal" data-target="#logoutModal">Cerrar Sesion</a>
                                                </div>
                                            </li>
                                        </ul>

                                    </nav>

                                    <div id="wrapper">

                                        <!-- Sidebar -->
                                        <jsp:include page="/pages/menuB.jsp"/>

                                        <div id="content-wrapper">
                                             <div class="container-fluid">
                                                                                           
                                                   
                                                        <div  style="width:99%" >
                                                                     <div class="modal-content">
                                                                         
                                                                         
                                                                         
                                                                         
                                                                         
                                                                         
                                                                         
                                                                
                                                                         <div class="row" style="border-collapse: collapse;">

                                                                             <div class="form-group col-lg-4">
                                                                                 <div class="modal-header" style="margin-top: 0px;" >



                                                                                     <div style="text-align: center; margin-right: 30px; background:  #611a1e; margin-top: 10px; width: 170px; height: 90px; border-radius: 20px; color: white; font-size: 15px; margin: auto;  "> <h7><i class="fas fa-clock" style="font-size: 25px; margin-top: 8px;"></i><div id="date" style="margin-top: 5px;" ></div><div id="clock"></div> </h7>   </div> 


                                                                                 </div>
                                                                             </div>



                                                                             <div class="form-group col-lg-8">

                                                                                 <div style="width: 100%; height: auto; text-align: center;  font-family: 'Cabin Condensed', sans-serif; font-size: 18px; min-width: 200px;  max-width: 500px; margin: auto; margin-top: 10px; padding: 20px; background: #606060; color:white; border-radius: 25px;">Sistema Integral de Administración de Procesos de la Secretaría de Educación del Estado de México</div>

                                                                             </div>




                                                                         </div>
                                                                
                                                             
                                                                
                                                                
                                                                
                                                               

                                                               
                                                                
                                                                <br></br>
                                                                
                                                                
                                                                
                                                                <!--BUSQUEDA DE AUDIENCIA -->
                                                                
                                                               
                                                                
                                                                 
                                                                <div style="width:100%; height: 30px; background: #611a1e; text-align: center; color:white;   ">
                                                                            <h5 style="margin-top: 2px;">Nuevo ciudadano</h5> 
                                                                            <br/>
                                                                        </div>
                                                                
                                                                
                                                             
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                               
                                                             <!-- ++++++++++++++++++++++++++++++++++++++++++++++     -->
                                                             
                                                             
                                                             
                                                           
                                                                      <div class="row">
                                                                        
                                                                        
                                                                        
                                                                        
                                                                     
                                                                        
                                                                        
                                                                        <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Apellido Paterno</label>
                                                                        <div class="col-sm-auto  ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.APATERNO" id="datos.APATERNO"  maxlength="200" cssStyle=""></s:textfield>
                                                                            <s:fielderror fieldName="APATERNO" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  
                                                                        
                                                                    
                                                                        
                                                                    <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Apellido Materno</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.AMATERNO" id="datos.AMATERNO"  maxlength="200" cssStyle=""></s:textfield>
                                                                             <s:fielderror fieldName="AMATERNO" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>

                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  
                                                                        
                                                                          <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Nombre(s)</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.NOMBRES" id="datos.NOMBRES"  maxlength="200" cssStyle=""></s:textfield>

                                                                            <s:fielderror fieldName="NOMBRES" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        </div> 
                                                                        <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Ocupación</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.OCUPACION" id="datos.OCUPACION"  maxlength="200" cssStyle=""></s:textfield>
                                                                            
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  
                                                                            
                                                                            
                                                                       <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Municipio</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:select  name="datos.MUNICIPIO" id="datos.MUNICIPIO" list="ListaMunicipios"  listKey="ID"  listValue="MUNICIPIO"  headerKey="" headerValue="Municipio" cssClass="form-control "  ></s:select>
                                                             <s:fielderror fieldName="MUNICIPIO" cssClass="alert alert-danger" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>

                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  

                                                                            <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Teléfono</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.TELEFONO" id="datos.TELEFONO"  maxlength="200" cssStyle=""></s:textfield>
                                                                            
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>   
                                                                              <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Dirección</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.DIRECCION" id="datos.DIRECCION"  maxlength="200" cssStyle=""></s:textfield>
                                                                            
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>   
                                                                             <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Correo</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.CORREO" id="CORREO"  maxlength="200" cssStyle=""></s:textfield>
                                                                            
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>   
                                                                            
                                                                            
                                                                            
                                                                            <div class="row">
                                                                             <div class="form-group col-lg-12" style="margin-top: 15px;  margin: auto; margin-bottom: 30px; margin-top: 0px; margin: auto;">
                                                                            <label class="col-form-label" for="Apellido Paterno" ></label>
                                                                                <div class="col-sm-auto"  >
                                                                                    
                                                                            <s:fielderror fieldName="EXISISTE" cssClass="alert alert-danger" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>
 
                                                                                    
                                                                                    
                                                                              
                                                                                    
                                                                            <s:if test="ListaCiudadanos.size()<=0">
                                                                                    
                                                                            <div class="col-sm-auto " style="margin-top: 60px;" >
                                                                                    <a class="btn btn-primary btn-lg" href="Javascript:Accion2('guardaCiudadanoGiras')" style="background: green; margin-left: 0px;" ><i class="fa fa-user-plus"></i> Guardar y Agregar Audiencia </a>
                                                                            </div>    
                                                                              </s:if>
                                                                            <s:else>
                                                                                
                                                                                <div class="col-sm-auto " style="margin-top: 60px;" >
                                                                                    <a class="btn btn-primary btn-lg" href="Javascript:Accion2('agregarAudiencia')" style="background: green; margin-left: 0px;" ><i class="fa fa-user-plus"></i> Agregar Audiencia </a>
                                                                            </div> 
                                                                                
                                                                            </s:else>
                                                                                
                                                                              
                                                                            
                                                                            
                                                                                
                                                                        </div> 
                                                                            
                                                                          
                                                                    </div>  
                                                                      
                                                                    </div>
                                                                       
                                                                     </div>      
                                                                   
                                                                            
                                                                            
                                                                            
                                                                            
                                                                            
                                                                
                                                                        
                                                                <br/> 
                                                                 <br/> 
                                                               
                                                                
                                                
                                                            
                                                                
                                                                
                                                                <s:textfield name="datos.ID" id="ID" cssStyle="display:none;" />  
                                                             
                                                             
                                                                

                                                              
                                            </div>
                                        </div>
                                                                        
                                               </div>
                                        </div>    
                                                                        
                                                                        
                                                                        
                                               

                                                                  <!-- Campos de nombre-->

                                                                        
                                                                        
                                                           
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                        <!-- Sticky Footer -->
                                         <footer class="sticky-footer" style="width: 100%; background-color: #ced4da;  ">
                                            
                                            
                                              <div style="background: #606060; min-height: 220px; max-height: 600px; width: 100%; margin-top: 0px;  font-family: 'Cabin Condensed', sans-serif;">
                                        
                                        
                                        <div class="row" style="width: 100%; ">
                                            <div class="form-group col-lg-4"style="margin: auto; color:white; ; text-align: center; margin-top: 30px; ">
                                                 
                                                <div style="width: 100%; height: 25px; display: block; text-decoration: underline; ">Aviso de Privacidad</div>
                                         <div style="width: 80%; height: 25px; display: block; margin: auto; margin-top: 15px;">Consulta nuestro aviso de privacidad</div>

                                                
                                                
                                            </div>  
                                                
                                                 <div class="form-group col-lg-4"style="margin: auto; color:white;  text-align: center; margin-top: 30px;">
                                                 
                                              <div style="width: 100%; height: 25px; display: block; text-decoration: underline;">Enlaces de intéres</div>
                                            <div style="width: 80%; height: 25px; display: block; margin: auto; margin-top: 15px;">Gobierno del Estado de México</div>
                                             <div style="width: 80%; height: 25px; display: block; margin: auto;">Secretaría de Educación del Estado de México </div>

                                                
                                                
                                            </div>  
                                                
                                               <div class="form-group col-lg-4"style="margin: auto; color:white;  text-align: center; margin-top: 30px;">
                                                 
                                                 <div style="width: 100%; height: 25px; display: block;  text-decoration: underline;">Acerca del portal</div>
                                                 <div style="width: 80%; height: 25px; display: block; margin: auto; margin-top: 15px;">Unidad de Desarrollo Administrativa e Informática</div>
                                                
                                                
                                            </div>  
                                        
                                        </div>
                                            
                                            
                                            
                                            
                                                  <div style="width: 100%; text-align: center; z-index: 1; background: #611a1e; margin-top: 40px; color: white; font-size: 12px; height: 60px; padding: 20px; ">       <span>Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</span></div>
                                                  
                                              
                                          
                                            
                                            
                                            
                                        </footer>


                                        <!-- /.content-wrapper -->

                                    </div>
                                                                        
                            </div>
                            
                            
                           
                                
                                    <!-- /#wrapper -->

                                    <!-- Scroll to Top Button-->
                                    <a class="scroll-to-top rounded" href="#page-top">
                                        <i class="fas fa-angle-up"></i>
                                    </a>

                                    <!-- Logout Modal-->
                                    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Cerrar Sesión</h5>
                                                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true"></span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">Estas seguro que deseas cerrar sesión.</div>
                                                <div class="modal-footer">
                                                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                                    <a class="btn btn-primary" href="Javascript:Accion('CerrarSesion')">Aceptar</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Bootstrap core JavaScript-->
                                    <script src="vendor/jquery/jquery.min.js"></script>
                                    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                                    <!-- Core plugin JavaScript-->
                                    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

                                    <!-- Page level plugin JavaScript-->
                                    <script src="vendor/chart.js/Chart.min.js"></script>
                                    <script src="vendor/datatables/jquery.dataTables.js"></script>
                                    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

                                    <!-- Custom scripts for all pages-->
                                    <script src="js/sb-admin.min.js"></script>

                                    <!-- Demo scripts for this page-->
                                    <script src="js/demo/datatables-demo.js"></script>
                                    <script src="js/demo/chart-area-demo.js"></script>





                                  
                                    <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                                        <s:hidden  name = "modulosAUX[%{#stat.index}].CVE_MODULO" id="CVE_MODULO"></s:hidden>
                                        <s:hidden  name = "modulosAUX[%{#stat.index}].CVE_MODPADRE" id="CVE_MODPADRE"></s:hidden>
                                        <s:hidden  name = "modulosAUX[%{#stat.index}].DESC_MOD" id="DESC_MOD"></s:hidden>
                                        <s:hidden  name = "modulosAUX[%{#stat.index}].IMAGEN" id="IMAGEN"></s:hidden>
                                    </s:iterator>

                                    <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">                        
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].MODULO" id="MODULO"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].MODPADRE" id="MODPADRE"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].MOD" id="MOD"></s:hidden>
                                        <s:hidden  name = "modulosAUXP[%{#stat.index}].ACCION" id="ACCION"></s:hidden>
                                    </s:iterator>
                                    
                                    
                                     <s:iterator value="ListaSerPub" id="ListaSerPub" status="stat">                        
                                        <s:hidden  name = "ListaSerPub[%{#stat.index}].ID_SERPUB" id="ID_SERPUB"></s:hidden>
                                        <s:hidden  name = "ListaSerPub[%{#stat.index}].NOMBRE_SERPUB" id="NOMBRE_SERPUB"></s:hidden>
                                       
                                    </s:iterator>
                                    
                                      <s:iterator value="ListaMotivo" id="ListaMotivo" status="stat">                        
                                        <s:hidden  name = "ListaMotivo[%{#stat.index}].ID_MOTIVO" id="ID_MOTIVO"></s:hidden>
                                        <s:hidden  name = "ListaMotivo[%{#stat.index}].MOTIVO" id="MOTIVO"></s:hidden>
                                       
                                    </s:iterator>
                                    
                                      <s:iterator value="ListaVisitas" id="ListaVisitas" status="stat">                        
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].FOLIO" id="FOLIO"></s:hidden>
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].FECHA_AUDI" id="FECHA_AUDI"></s:hidden>
                                        
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].NOMBRE_SERPUB" id="NOMBRE_SERPUB"></s:hidden>
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].ASUNTO" id="ASUNTO"></s:hidden>
                                        
                                         <s:hidden  name = "ListaVisitas[%{#stat.index}].MOTIVO" id="MOTIVO"></s:hidden>
                                        <s:hidden  name = "ListaVisitas[%{#stat.index}].ESTATUS" id="ESTATUS"></s:hidden>
                                       
                                    </s:iterator>
                                    
                                     <s:iterator value="ListaMunicipios" id="ListaMunicipios" status="stat">                        
                                        <s:hidden  name = "ListaMunicipios[%{#stat.index}].ID" id="ID"></s:hidden>
                                        <s:hidden  name = "ListaMunicipios[%{#stat.index}].MUNICIPIO" id="MUNICIPIO"></s:hidden>
                                       
                                    </s:iterator>
                                    
                                    
                                    
                                    
                                    
                                    

                                </s:form>
                            </body>

                            </html>
