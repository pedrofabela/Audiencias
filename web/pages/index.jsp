<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>







                                    <!-- Custom scripts for all pages-->
                                    



<script type="text/javascript">

    function buscar(accion) {

var busqueda=document.getElementById("BUSQUEDA_NOMBRE").value;

    if(busqueda.length>=3){
         document.formularioPrincipal.action = accion;
        document.formularioPrincipal.submit();
    }
    
    else {
        
        alert("El criterio de busqueda debe incluir almenos 3 letras")
        
    }
       
        

       
    }

    
    function Accion(accion) {

        document.formularioPrincipal.action = accion;
        document.formularioPrincipal.submit();
    }
    
    
    function validacampos(accion) {

        
        document.formularioPrincipal.action = accion;
       
        
        var apaterno=document.getElementById("APATERNO").value;
        var amaterno=document.getElementById("AMATERNO").value;
        var nombres=document.getElementById("NOMBRES").value;
        var municipio=document.getElementById("MUNICIPIO").value;
        
        if (apaterno=="" || amaterno=="" ||nombres=="" || municipio=="" ){
            alert("Campos obligatorios, favor de introducirlos");
            
        }
        else{
            
            document.formularioPrincipal.submit();
            alert("Datos Actualizados");
        }
        
        
        
        
    }
    
    
    
    
   function aMayusculas(obj,id){
    obj = obj.toUpperCase();
    document.getElementById(id).value = obj;
}

 function idCiudadano(accion, valor) {
       
        
        document.formularioPrincipal.ID_2.value = valor;
        document.formularioPrincipal.action = accion;
        document.formularioPrincipal.target = "_self";
        document.formularioPrincipal.submit();
        
    }

function popup(apaterno, amaterno, nombres, telefono, ocupacion, clamun,id) {
       
      location.href ="#popup";
     
        document.getElementById('APATERNO').value = apaterno;
        document.getElementById('AMATERNO').value = amaterno;
        document.getElementById('NOMBRES').value = nombres;
       
        document.getElementById('TELEFONO').value = telefono;
        document.getElementById('OCUPACION').value = ocupacion; 
         document.getElementById('MUNICIPIO').value = clamun; 
         document.formularioPrincipal.ID_2.value = id;
         
         
         
         
         
         
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
        
        
        

        <meta charset="utf-8" />
            <meta http-equiv="X-UA-Compatible" content="IE=edge"/> 
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                    <meta name="description" content="" />
                        <meta name="author" content="" />
                            <link rel="shortcut icon" href="images/portalSE.png" />
                            <title>SIAPRO</title>

                            <link href=" <s:url value="/vendor/bootstrap/css/bootstrap.min.css"/>" media="all" rel="stylesheet" type="text/css"/>
                            <!-- Custom fonts for this template-->
                            <link href=" <s:url value="/vendor/fontawesome-free/css/all.min.css"/>" media="all" rel="stylesheet" type="text/css"/>        
                            <!-- Page level plugin CSS-->
                                
                            <!-- Custom styles for this template-->
                            <link href=" <s:url value="/css/sb-admin.css"/>" media="all" rel="stylesheet" type="text/css"/> 
                           
                          
                            
                            <link rel="stylesheet" href="css/estilo.css"/>

                           

                            </head>

                            <body onload="startTime()">
                                
                                
          <script src="vendor/jquery/jquery.min.js"></script>
                                    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                                    <!-- Core plugin JavaScript-->
                                   
                                    <!-- Page level plugin JavaScript-->
                                  

                                    <!-- Custom scripts for all pages-->
                                    <script src="js/sb-admin.min.js"></script>
                                <s:form name="formularioPrincipal" id="formularioPrincipal" enctype="multipart/form-data">
                                    
                                    
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

                                    <nav class="navbar navbar-expand navbar-dark " style="height: 90px; background: #611a1e; box-shadow: 2px 2px 10px #333  ; border-bottom: 15px solid #606060; ">


                                    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                                            <img src="images/logos.png" style="min-width: 20%; max-width: 250px;"></img>
                                        </button>

                                       

                                        <!-- Navbar Search -->
                                        <div class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

                                        </div>

                                        <!-- Navbar -->
                                        <ul class="navbar-nav ml-auto ml-md-0" >    
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

                                                       









                                                   



                                                        <!--BUSQUEDA DE AUDIENCIA -->



                                                        <div style="width:100%; height: 40px; background: #606060; text-align: center; color:white;   ">
                                                            <h5 style="margin-top: 2px;">Busqueda de Ciudadanos</h5> 
                                                            <br/>
                                                        </div>
                                                        <div class="row">
                                                            
                                                             <div class="form-group col-lg-4">
                                                                 <div class="modal-header" style="margin-top: 20px;" >

                                                         

                                                            <div style="text-align: center; margin-right: 30px; background:  #611a1e; margin-top: 20px; width: 170px; height: 90px; border-radius: 20px; color: white; font-size: 15px; margin: auto; "> <h7><i class="fas fa-clock" style="font-size: 25px; margin-top: 8px;"></i><div id="date" style="margin-top: 5px;" ></div><div id="clock"></div> </h7>   </div> 


                                                        </div>
                                                            </div>
                                                            
                                                            
                                                            
                                                            <div class="form-group col-lg-4">
                                                               
                                                                <div class="col-sm-auto" style="margin-top: 30px;">
                                                                    <s:textfield  cssClass="form-control text-uppercase" name="datos.BUSQUEDA_NOMBRE" id="BUSQUEDA_NOMBRE"  placeholder="Nombre del solicitante" onblur="aMayusculas(this.value,this.id)"></s:textfield>
                                                                    <s:fielderror fieldName="ErrorCCTA" cssClass="alert alert-danger"/>
                                                                </div> 
                                                                
                                                                 <div class="" style="margin: auto; width: 100%; margin-top: 20px; ">
                                                                    <a class="btn btn-primary btn-lg" href="Javascript:buscar('busquedaCiudadano')" style="background: #611a1e; margin: auto; width:100%; border-radius: 30px; " >Buscar</a>
                                                                </div>
                                                            </div>
                                                                
                                                                
                                                                
                                                                 <div class="form-group col-lg-4">
                                                                
                                                                    <div style=" width: 100%; height: 10px;   margin: auto; text-align: center; margin-top: 20px;"><div style="width: 40%; min-width: 160px; margin: auto; border-radius: 30px;  color: #333;  height: 10px; padding: 5px;">Total de Registros</div></diV>

                                                                    
                                                                     <div style=" width: 100%; height: 60px;   margin: auto; text-align: center; margin-top: 25px; text-decoration: underline;"><div style="width: 25%; min-width: 70px; margin: auto; border-radius: 30px;  color: white; background: #611a1e; height: 60px; padding: 20px;"><s:property value="ListaCiudadanos.size()" /></div></diV>

                                                                     
                                                            </div>
                                                                

                                                        </div>




                                                        <!--++++++++++++++++++++++++++++++++++++++++++++++++++++++-->               

                                                    

                                                        <!--TABLA DE CIUDADANOS-->  
                                                        <div class="table-responsive" style="margin-top: 20px;">  
                                                            <table class="table table-hover">
                                                                <thead style="background: #606060; color: white;">
                                                                    <tr>
                                                                        <th style="width: 40%; ">Nombre</th>
                                                                        <th style="width: 20%;">Municipio</th>
                                                                        <th style="width: 20%;">Teléfono</th>
                                                                        <th style="width: 10%;">Nueva</th>
                                                                        <th style="width: 10%;">Modificar</th>

                                                                    </tr>
                                                                </thead>

                                                            </table>
                                                        </div>

                                                        <div style="width: 95%; margin: auto; margin-top: 30px; min-height: 500px; max-height: 800px; overflow-y: scroll; margin-bottom: 30px;">
                                                            <div class="table-responsive">  
                                                                <table class="table table-hover">

                                                                    <tbody>

                                                                        <s:iterator value="ListaCiudadanos" id="ListaCiudadanos" status="stat">
                                                                            <tr>
                                                                                <td style="width: 40%;"><s:property value="NOMBRE_COMPLETO"/></td>
                                                                                <td style="width: 20%;"><s:property value="MUNICIPIO"/></td>
                                                                                <td style="width: 20%;"><s:property value="TELEFONO"/></td>
                                                                                <td style="width: 10%;" align="center"><a href="Javascript:idCiudadano('nuevaAudiencia','<s:property value="ID" />')"><i class="fa fa-book" style="font-size: 25px; color: #339900;"></i></a></td>
                                                                                <td style="width: 10%; " align="center"><a href="Javascript:popup('<s:property value="APATERNO" />','<s:property value="AMATERNO" />','<s:property value="NOMBRES" />','<s:property value="TELEFONO" />','<s:property value="OCUPACION" />','<s:property value="CLAMUN" />','<s:property value="ID" />')"><i class="fa fa-pen" style="font-size: 25px; color: gray;"></i></a></td>
                                                                            </tr>
                                                                        </s:iterator>

                                                                    </tbody>
                                                                </table>

                                                            </div>   
                                                        </div> 
                                                        <!-- ++++++++++++++++++++++++++++++++++++++++++++++     -->


                                                        <s:textfield name="datos.ID" id="ID_2" cssStyle="display:none;" />  







                                                    </div>
                                                </div>

                                            </div>
                                        </div>    
                                                                        
                                                                        
                                                                        
                                            

                                                                  <!-- Campos de nombre-->

                                                                        
                                                                        
                                                                        
                                                                        
                                             <div class="modal-wrapper" id="popup">
                                                    <div class="popup-contenedor">
                                                        <h2  style="font-size: 16px;" >Actualización del Ciudadano </h2>

                                                        <div style="min-height:350px; max-height: 400px; overflow-y: scroll;" >
                                                            <div id="dvData">
                                                                 
                                                      
                                                           
                                                            
                                                        
                                                            
                                                            
                                                                           <div class="row">
                                                                        
                                                                        
                                                                        
                                                                        
                                                                     
                                                                        
                                                                        
                                                                        <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Apellido Paterno</label>
                                                                        <div class="col-sm-auto  ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.APATERNO" id="APATERNO"  maxlength="200" cssStyle=""></s:textfield>
                                                                            <s:fielderror fieldName="APATERNO" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  
                                                                        
                                                                    
                                                                        
                                                                    <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Apellido Materno</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.AMATERNO" id="AMATERNO"  maxlength="200" cssStyle=""></s:textfield>
                                                                             <s:fielderror fieldName="AMATERNO" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>

                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  
                                                                        
                                                                          <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Nombre(s)</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.NOMBRES" id="NOMBRES"  maxlength="200" cssStyle=""></s:textfield>

                                                                            <s:fielderror fieldName="NOMBRES" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        </div> 
                                                                        <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Ocupación</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.OCUPACION" id="OCUPACION"  maxlength="200" cssStyle=""></s:textfield>
                                                                            
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  
                                                                            
                                                                            
                                                                       <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Municipio</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:select  name="datos.MUNICIPIO" id="MUNICIPIO" list="ListaMunicipios"  listKey="ID"  listValue="MUNICIPIO"  headerKey="" headerValue="Municipio" cssClass="form-control "  ></s:select>
                                                            
     
                                                                            
                                                                            
                                                                                                                                                  
                                                                            
                                                                            <s:fielderror fieldName="MUNICIPIO" cssClass="alert alert-danger" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>

                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>  

                                                                            <div class="form-group col-lg-4">
                                                                        <label class="col-form-label " for="domicilio" >Teléfono</label>
                                                                        <div class="col-sm-auto ">
                                                                            <s:textfield  cssClass="form-control text-uppercase" name="datos.TELEFONO" id="TELEFONO"  maxlength="200" ></s:textfield>
                                                                            
                                                                        </div> 
                                                                        
                                                                        
                                                                        
                                                                        </div>   
                                                                            
                                                                            
                                                                             <div class="form-group col-lg-4" style="margin-top: 45px;  margin: auto; margin-bottom: 30px; margin-top: 20px;">
                                                                            <label class="col-form-label" for="Apellido Paterno" ></label>
                                                                                <div class="col-sm-auto"  >
                                                                                    
                                                                            <s:fielderror fieldName="EXISISTE" cssClass="alert alert-danger" cssStyle="font-size: 12px; margin-top: 00px; margin-botton:40px;"/>
 
                                                                                    
                                                                                    
                                                                              
                                                                                    
                                                                            <s:if test="ListaCiudadanos.size()<=0">
                                                                                    
                                                                            <div class="col-sm-auto " style="margin-top: 60px;" >
                                                                                    <a class="btn btn-primary btn-lg" href="Javascript:validacampos('actualizarCiudadano')" style="background: green; margin-left: 0px;" ><i class="fa fa-user-plus"></i> Actualizar </a>
                                                                            </div>    
                                                                              </s:if>
                                                                            <s:else>
                                                                                
                                                                                <div class="col-sm-auto " style="margin-top: 60px;" >
                                                                                    <a class="btn btn-primary btn-lg" href="Javascript:validacampos('actualizarCiudadano')" style="background: green; margin-left: 0px;" ><i class="fa fa-user-plus"></i> Actulizar </a>
                                                                            </div> 
                                                                                
                                                                            </s:else>
                                                                                
                                                                              
                                                                            
                                                                            
                                                                                
                                                                        </div> 
                                                                            
                                                                          
                                                                    </div>  
                                                                      
                                                                    </div>
                                                      
                                                                
                                                                
                                                               
                                                                
                                                                
                                                                
                                                                
                                                            </div>
                                                             </div>
                                                            
                                                        <a class="popup-cerrar" href="#">X</a>
                                                    </div>
                                                </div>                           
                                                                        
                                                                        
                                                
                                    <!-- Demo scripts for this page-->
                                                 
                                                                        
                                                
                                                                        
                                                      
                                                                        
                                                                        
                                                                        
                                                                        
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
                                   
                                    
                                    
                                    <!-- Bootstrap core JavaScript-->
                                  

                                    <!-- Demo scripts for this page-->
                                    
                                    
                                      
                                  
                                   
                                    
                                    

                                    
                                    
                                    
                                       <s:iterator value="ListaCiudadanos" id="ListaCiudadanos" status="stat">
                                        <s:hidden  name = "ListaCiudadanos[%{#stat.index}].NOMBRE_COMPLETO" id="NOMBRE_COMPLETO"></s:hidden>
                                        <s:hidden  name = "mListaCiudadanos[%{#stat.index}].MUNICIPIO" id="MUNICIPIO"></s:hidden>
                                        <s:hidden  name = "ListaCiudadanos[%{#stat.index}].TELEFONO" id="TELEFONO"></s:hidden>
                                        <s:hidden  name = "ListaCiudadanos[%{#stat.index}].APATERNO" id="APATERNO"></s:hidden>
                                 <s:hidden  name = "ListaCiudadanos[%{#stat.index}].AMATERNNO" id="AMATERNO"></s:hidden>
                                <s:hidden  name = "ListaCiudadanos[%{#stat.index}].APATERNO" id="APATERNO"></s:hidden>
                            <s:hidden  name = "ListaCiudadanos[%{#stat.index}].CLAMUN" id="CLAMUN"></s:hidden>
                                        <s:hidden  name = "ListaCiudadanos[%{#stat.index}].OCUPACION" id="OCUPACION"></s:hidden>
                                                                                <s:hidden  name = "ListaCiudadanos[%{#stat.index}].ID" id="ID"></s:hidden>



                                    </s:iterator>                    
                                                                        
                                                                        
                                                
                                    
                                        
                                    
                                    
                                    
                                    
                                    
                                    

                                </s:form>
                            </body>

                            </html>
