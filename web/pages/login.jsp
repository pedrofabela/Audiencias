<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<script>
var URLactual = window.location;
if(URLactual=="http://audienciasseduc.edugem.gob.mx/"){
    location.href ="https://audienciasseduc.edugem.gob.mx/";
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
                            <link href="https://fonts.googleapis.com/css?family=Cabin+Condensed" rel="stylesheet"> 

                            <script type="text/javascript">

                                function guarda(accion) {

                                    document.formularioPrincipal.action = accion;
                                    document.formularioPrincipal.submit();
                                }
                            </script>

                            </head>
                            
                          

                            <body style=" background: url(images/fond.png)">
                                
                                <s:form name="formularioPrincipal" id="formularioPrincipal">

                                    <nav class="navbar navbar-expand navbar-dark " style="height: 90px; background: #611a1e; box-shadow: 2px 2px 10px #333  ; border-bottom: 15px solid #606060;">
                                        
                                        <img src="images/logos.png" style="min-width: 250px; max-width: 350px;"></img>
                                        
                                      
                                             
                                                
                                          
                                        
                                        
                                    </nav>
                                    

                                    <div class="container" style="margin-top:10%; margin-bottom: 50px;" >
                                        <div class="card card-login mx-auto mt-5" style="box-shadow: 2px 2px 5px #999;">
                                            <div class="card-header" align="center" style="font-family: 'Cabin Condensed', sans-serif; font-size: 16px; background: #606060; color:white; height: 65px; ">Sistema Integral de Administración de Procesos de la Secretaría de Educación del Estado de México</div>
                                            <div class="card-body">

                                                <div class="form-group " style="margin-top: 15px;">
                                                        <s:textfield  cssClass="form-control" name="cveusuario" id="cveusuario" placeholder="Usuario"  autofocus="autofocus"></s:textfield>
                                                        <s:fielderror fieldName="ERRORUSU" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>
                                                    </div>
                                                    <div class="form-group ">
                                                        <s:password cssClass="form-control" name="pasusuario" id="pasusuario"  placeholder="Password" />  
                                                        <s:fielderror fieldName="ERRORPASS" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>
                                                </div>
                                                    
                                                <a class="btn btn-primary btn-block" style="background: #611a1e; border: 1px solid #8181a4; margin-top: 25px; " href="Javascript:guarda('verAcceso')">Ingresar</a>
                                                <s:fielderror fieldName="NO" cssClass="alert alert-danger" cssStyle="font-size: 12px;"/>
                                            </div>
                                                        
                                        </div>
                                    </div>



                                    <!-- /.container-fluid -->
                                    <!-- Sticky Footer -->
                                    <div style="background: #606060; min-height: 220px; max-height: 500px; width: 100%; margin-top: 150px;  font-family: 'Cabin Condensed', sans-serif;">
                                        
                                        
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
                                        
                                        
                                        
                                    </div>

                                    <footer class="sticky-footer" style="width: 100%; background-color: #611a1e; color: white; ">
                                        
                                       
                                        
                                        <div class="container my-auto" >
                                            <div class="copyright text-center my-auto">
                                                <span style="font-size: 10px;">Esta página esta diseñada para verse mejor en resolución 1200 X 840, Firefox & Chrome V30</span>
                                            </div>
                                        </div>
                                    </footer>


                                    <!-- /.content-wrapper -->


                                    <!-- /#wrapper -->

                                    <!-- Scroll to Top Button-->


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
