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
    
   function aMayusculas(obj,id){
    obj = obj.toUpperCase();
    document.getElementById(id).value = obj;
}

 function idCiudadano(accion, valor) {
       
        
        document.formularioPrincipal.ID.value = valor;
        document.formularioPrincipal.action = accion;
        document.formularioPrincipal.target = "_self";
        document.formularioPrincipal.submit();
        
    }

function folio(valor) {
       
        
        document.formularioPrincipal.FOLIO.value = valor;
       
        
      
document.getElementById('oculto').style.display = 'block';
document.getElementById('resultado').innerHTML = valor;
        
    }
function rapido() {
      
        VALOR=document.getElementById('TEXTO').value;
        document.formularioPrincipal.SEGUIMIENTO.value = VALOR;
       
       
      
document.getElementById('oculto').style.display = 'block';
document.getElementById('resultado').innerHTML = valor;
        
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


<script>
    
    window.onload = function () {/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
          
            var pos = window.name || 0;
            window.scrollTo(0, pos);
            startTime();
        }

        window.onunload = function () {
            window.name = self.pageYOffset
                    || (document.documentElement.scrollTop + document.body.scrollTop);


        }
    
    
    </script>


<script type="text/javascript">
  
  
  
  
 var seconds = 180; //número de segundos a contar
function secondPassed() {

  var minutes = Math.round((seconds - 30)/60); //calcula el número de minutos
  var remainingSeconds = seconds % 60; //calcula los segundos
  //si los segundos usan sólo un dígito, añadimos un cero a la izq
  if (remainingSeconds < 10) { 
    remainingSeconds = "0" + remainingSeconds; 
  } 
  document.getElementById('countdown').innerHTML = minutes + ":" +     remainingSeconds; 
  if (seconds == 0) { 
    clearInterval(countdownTimer); 
  
    window.location.assign("https://audienciasseduc.edugem.gob.mx/verAcceso");
    // window.location.assign("http://localhost:8084/AudienciasSeduc/verAcceso");
  } else { 
    seconds--; 
  } 
} 

var countdownTimer = setInterval(secondPassed, 1000);
  
  
  
  
  
  
  
  
  
  
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

                            <body id="page-top"  >
                                <s:form name="formularioPrincipal" id="formularioPrincipal" enctype="multipart/form-data">

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
                                                                
                                                                
                                                                <!--BUSQUEDA DE AUDIENCIA -->
                                                                
                                                                
                                                                
                                                                <div style="width:100%; height: 40px; background: #611a1e; text-align: center; color:white;   ">
                                                                    <h3 style="margin-top: 2px; font-size: 20px;">Audiencias Asignadas <label id="countdown" style="float: right; margin-right: 40px; font-size: 20px;"></label></h3> 
                                                                    <br/>
                                                                </div>
                                                               
                                                                                      
                                                                                      
                                                               <!--++++++++++++++++++++++++++++++++++++++++++++++++++++++-->               
                                                                        
                                                                        <br></br>
                                                                        
                                                                       
                                                                        
                                                                        
                                                                        
                                                                        
                                                             <!--TABLA DE CIUDADANOS-->  
                                                             <div class="table-responsive" style="margin-top: 20px;">  
                                                            
                                                                 <div style="width: 100%; max-height: 450px; overflow-y: scroll;">
                                                                 <table class="table table-hover"  >
                                                                 <thead style="background: #606060; color: white;">
                                                                     
                                                                         <th style="width: 5%; ">Folio</th>
                                                                         <th style="width: 5%;">Fecha</th>
                                                                         <th style="width: 20%;">Nombre</th>
                                                                         <th style="width: 10%;">Motivo</th>
                                                                         <th style="width: 30%;">Asunto</th>
                                                                         <th style="width: 5%;">Petición por</th>
                                                                           <th style="width: 5%;">Ficha</th>
                                                                          <th style="width: 10%;">Documento</th>
                                                                         <th style="width: 10%;"></th>

                                                                     
                                                                     
                                                                 </thead>
                                                                 
                                                                 <s:iterator value="ListaAudienciasAsignadas" id="ListaAudienciasAsignadas" status="stat">
                                                                     <tr style="font-size: 12px;"  >
                                                                     <td style="width: 5%; "><s:property value="FOLIO"/> </td>
                                                                         <td style="width: 5%;"><s:property value="FECHA_AUDI"/></td>
                                                                         <td style="width: 20%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                         <td style="width: 10%;"><s:property value="MOTIVO"/></td>
                                                                         <td style="width: 30%;"><s:property value="ASUNTO"/></td>
                                                                          <td style="width: 10%;"><s:if test="GIRAS==1">GIRAS</s:if><s:else>AUDIENCIA</s:else></td>
                                                                          
                                                                           <s:if test="GIRAS==1">
                                                                                
                                                                                 <td style="width: 5%;" align="center">
                                                                                    <s:url action="GeneraPdf" id="myUrl" escapeAmp="false">
                                                                                        <s:param name="TipoReporte" value="'ReporteAudienciasGiras.jasper'"/>
                                                                                        <s:param name="folio" value="FOLIO"/>
                                                                                        <s:param name="esExcel" value="'false'"/>
                                                                                        <s:param name="esPDF" value="'true'"/>            

                                                                                    </s:url>  
                                                                                    <a href= "<s:property value="myUrl"/>" target="_blank"><img src="images/pdf.png" style="width: 25px; border-radius: 50%; margin-top: 5px;"></img>
                                                                                    </a>
                                                                                </td>
                                                                                
                                                                                </s:if>
                                                                                
                                                                                
                                                                                
                                                                                <s:else>
                                                                                
                                                                                
                                                                                
                                                                                <td style="width: 5%;" align="center">
                                                                                    <s:url action="GeneraPdf" id="myUrl" escapeAmp="false">
                                                                                        <s:param name="TipoReporte" value="'ReporteAudiencias.jasper'"/>
                                                                                        <s:param name="folio" value="FOLIO"/>
                                                                                        <s:param name="esExcel" value="'false'"/>
                                                                                        <s:param name="esPDF" value="'true'"/>            

                                                                                    </s:url>  
                                                                                    <a href= "<s:property value="myUrl"/>" target="_blank"><img src="images/pdf.png" style="width: 25px; border-radius: 50%; margin-top: 5px;"></img>
                                                                                    </a>
                                                                                </td>
                                                                                
                                                                                </s:else>
                                                                          
                                                                          
                                                                          
                                                                          
                                                                          
                                                                          <td style="width: 10%;"> <a target="black" href="https://audienciasseduc.edugem.gob.mx/documentos/audiencias/<s:property  value="RUTA_DOC"/> "><s:if test="RUTA_DOC.length()>0"><div style="width: 60%; margin: auto; "><img src="images/adjunto.png" style="width:30%; margin: auto;"></img></div></s:if></a></td>
                                                                         <td style="width: 10%;" align="center"><a href="Javascript:folio('<s:property value="FOLIO"/>')" ><i class="fa fa-edit" style="font-size: 20px; text-decoration: none; color: green;"></i></a> </td>
                                                                </tr>
                                                                 
                                                                    </s:iterator>
                                                                    <s:if test="ListaAudienciasAsignadas.size()<=0">
                                                                     <tr>
                                                                         <td align="center" colspan="6">No hay Audiencias asignadas</td>
                                                                     </tr>
                                                                 </s:if>
                                                                 
                                                             </table>
                                                                     

                                                                     </div>
                                                                 
                                                             </div>
                                                             
                                                             
                                                                                                                                                                                                      
                                              <s:fielderror fieldName="seguimiento" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>
                                               
                                              
                                              
                                                           
                                                             <div id='oculto' style='display:none;'>
                                                            <div style="width:100%; height: 40px; background: #a2a3b8; text-align: center; color:white; margin-top: 20px;   ">
                                                                    <h5 style="margin-top: 2px;">Registro de Seguiminento de Audiencia </h5> 
                                                                    <br/>
                                                                </div>
                                                             
                                                                 <div style="position: relative; margin-top: -40px; width: 120px; height: 40px; border-radius: 0px 50px 50px 0px; background: #571464; text-align: center; padding: 10px; color: white; box-shadow: 5px 5px 10px #666;"><strong style="font-size: 12px;">Folio:<div id="resultado" style="display: inline; "></div></strong></div> 
                                                                 
                                                             
                                                            
                                                                 
                                                                 
                                                                 <div class="row">
                                                                  
                                                                  
                                                                  
                                                                     
                                                                    
                                                                
                                                                            <div class="form-group col-lg-8">
                                                                                <label class="col-form-label" for="Apellido Paterno">Seguimiento</label>
                                                                                <div class="col-sm-auto">

                                                                                      <hr style="width: 99% ; margin: auto; height: 8px; box-shadow: 5px 5pc 15px #333;"/>
                                                                                      <s:select  name="datos.TEXTO" id="TEXTO" list="ListaTextos"  listKey="TEXTO"  listValue="TEXTO"  headerKey="" headerValue="Seleccionar Texto rápido" cssClass="form-control " onchange="javascript:rapido()"></s:select>

                                                                                <s:textarea  cssClass="form-control text-uppercase" name="datos.SEGUIMIENTO" id="SEGUIMIENTO" maxlength="500"  ></s:textarea>
                                                                        
                                                                        </div> 
                                                                          
                                                                    </div>  
                                                                        <div class="form-group col-lg-4" style="margin-top: 45px;">
                                                                                <label class="col-form-label" for="Apellido Paterno"></label>
                                                                                <div class="col-sm-auto">

                                                                                <div class="col-sm-auto " style="margin: auto;">
                                                                                    <a class="btn btn-primary btn-lg" href="Javascript:Accion('guardaSeguimiento')" style="background: green; " ><i class="fa fa-folder-open" ></i> Guardar Seguimiento </a>
                                                                        </div>    
                                                                                
                                                                        </div> 
                                                                          
                                                                    </div>  
                                                                           
                                                                       
                                                                        
                                                                    </div>
                                                          </div>
                                                       
                                                                                   

                                                                               
                                                                           <s:textfield name="datos.FOLIO" id="FOLIO" cssStyle="display:none;" />  
                                                                             <s:textfield name="datos.FILTRO" id="FILTRO" cssStyle="display:none;" />  
                                                             
                                                                

                                                              
                                            </div>
                                        </div>
                                                                        
                                               </div>
                                        </div>    
                                                                        
                                                                        
                                                                        
                                            

                                                                  <!-- Campos de nombre-->

                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                        <!-- Sticky Footer -->
                                        <footer class="sticky-footer" style="width: 100%; background-color: #ced4da; ">
                                            
                                            
                                              <div style="background: #606060; min-height: 220px; max-height: 500px; width: 100%; margin-top: 0px;  font-family: 'Cabin Condensed', sans-serif;">
                                        
                                        
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




                                    
                                    
                                    
                                    
                                    
                                        
                                    
                                    
                                    
                                    
                                    
                                    

                                </s:form>
                            </body>

                            </html>
