<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>




    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    
    
    
     
    
    
    

 <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
    <s:iterator value="ListaTotalMotivos" id="ListaTotalMotivos" status="stat">
            
    ['<s:property value="MOTIVO"/>',     <s:property value="TOTAL_MOTIVOS"/>],
            
    </s:iterator>
          
        ]);

       var options = {
                                title: 'Número de Escuelas del Municipio: Toluca',
                                backgroundColor: '#e7e6e6',
                                chartArea: {left: 20, top: 0, width: '85%', height: '100%'},
                                legend: {position: 'left', top: 20, width: '45%', textStyle: {fontSize: 13, color: 'black', fontName: 'Didactic'}},

                                colors: ['#eb5b74', '#25a1db', '#9dc325', '#fcce00', '#a29f9d', '#e1173e'],

                                textStyle: {

                                    fontSize: 16,

                                    // The color of the text.
                                    color: '#848484'
                                            // The color of the text outline.

                                            // The transparency of the text.

                                },
                                
                            






                            };
        

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        

        chart.draw(data, options);
        
        
         var counter = 0;

    var handler = setInterval(function(){ 
        counter = counter + 0.01
        options = {
                    
          slices: {                        
                    3: {offset: counter},
                    4: {offset: counter},                       
                    5: {offset: counter},                       
                    
          },
          
          
                                backgroundColor: '#e7e6e6',
                                            chartArea: {left: 20, top: 25, width: '85%', height: '80%'},
                                            legend: {position: 'left', top: 20, width: '45%', textStyle: {fontSize: 13, color: 'black', fontName: 'Didactic'}},

                                            colors: ['#eb5b74', '#25a1db', '#9dc325', '#fcce00', '#a29f9d', '#e1173e'],

                                            textStyle: {

                                                fontSize: 16,

                                                // The color of the text.
                                                color: '#848484'
                                                        // The color of the text outline.

                                                        // The transparency of the text.

                                            },

                                        };
                                        chart.draw(data, options);

                                        if (counter > 0.20)
                                            clearInterval(handler);
                                    }, 200);
        
        
        
        
      }
    </script>



<script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Element", "Density", { role: "style" } ],
<s:iterator value="ListaAudienicasDia" id="ListaAudienicasDia" begin="0" end="29" status="stat">
            ["<s:property value="FECHA_AUDI"/>", <s:property value="AUDIENCIAS_DIA"/>, "purple"],
</s:iterator>
        
        
        
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]); var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        
         backgroundColor: '#edecec',
          chartArea: {width: '90%'},
       
        bar: {groupWidth: "85%"},
        legend: { position: "none" },
          animation: {
                duration: 4500,
                startup: true //This is the new option
            },

            annotations: {
                textStyle: {

                    fontSize: 14,

                }
            },
        
        
        
        
        
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
  </script>


<script type="text/javascript">
    
    
    
    google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawBarColors);

function drawBarColors() {
      var data = google.visualization.arrayToDataTable([
        ['City', 'Audiencias', {role: 'annotation'}],
<s:iterator value="ListaAudienicasPersona" id="ListaAudienicasPersona" status="stat">
            
        
    ['<s:property value="NOMBRE_SERPUB"/>', <s:property value="AUDIENCIAS_PERSONA" />,  '<s:property value="AUDIENCIAS_PERSONA" />'],
    
</s:iterator>
       
      ]);

      var options = {
      
        chartArea: {width: '45%'},
        colors: ['#b0120a', '#ffab91'],
        hAxis: {
          title: 'Total de Audiencias',
          minValue: 0,
          textStyle: {
       fontSize: 8,
         maxTextLines: 8,
      }
      
      
   
          
        },
         backgroundColor: '#edecec',
           bar: {groupWidth: "85%"},
        vAxis: {
          title: 'Servidores Públicos',
          fontSize: 12,
        },
        
        animation: {
                duration: 4500,
                startup: true //This is the new option
            },

            annotations: {
                textStyle: {

                    fontSize: 12,

                }
            },
            
        
        

      };
      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
      chart.draw(data, options);
    }
    
    
    
    </script>






















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
   
    //imprimir reporte...........
   
   
   function imprSelec(wrapper2){
  var ficha=document.getElementById(wrapper2);
  var ventimp=window.open('printableArea');
  ventimp.document.write(ficha.innerHTML);
  ventimp.document.close();
  ventimp.print();
  ventimp.close();
  
  
  
  
  
  
  
  
  
}






   
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



 <script src="js/jquery-1.10.2.min.js"></script>



 

    <html >

        <head>

            <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="css/estilo.css"/>

                <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

                <script>
                 $.datepicker.regional['es'] = {
                 closeText: 'Cerrar',
                 prevText: '<Ant',
                 nextText: 'Sig>',
                 currentText: 'Hoy',
                 monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
                 monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
                 dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
                 dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
                 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
                 weekHeader: 'Sm',
                 dateFormat: 'dd/mm/yy',
                 changeMonth:true,
                 changeYear:true,
                 firstDay: 1,
                 isRTL: false,
                 showMonthAfterYear: false,
                 yearSuffix: ''
                 };
                 $.datepicker.setDefaults($.datepicker.regional['es']);
                $(function () {
    
                $("#Fecha").datepicker();

                    });

                    $(function () {
                        $("#Fecha1").datepicker();
                    });
                </script>
            
        


            <meta charset="utf-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                        <meta name="description" content="">
                            <meta name="author" content="">

                               <link rel="shortcut icon" href="images/portalSE.png" />
                            <title>SIAPRO</title>

                              
                                
                                 
                               <!-- Minified Bootstrap CSS -->

                                   
                                


                                </head>
                                


                                <body id="page-top" onload="startTime()"  >
                                    
                                   
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
                                            
                                           
                                            <link href=" <s:url value="/vendor/bootstrap/css/bootstrap.min.css"/>" media="all" rel="stylesheet" type="text/css"/>
        <!-- Custom fonts for this template-->
        <link href=" <s:url value="/vendor/fontawesome-free/css/all.min.css"/>" media="all" rel="stylesheet" type="text/css"/>       
        
        <!-- Page level plugin CSS-->
        <link href=" <s:url value="/vendor/datatables/dataTables.bootstrap4.css"/>" media="all" rel="stylesheet" type="text/css"/>            
        <!-- Custom styles for this template-->
        <link href=" <s:url value="/css/sb-admin.css"/>" media="all" rel="stylesheet" type="text/css"/> 
                                      
        <div id="wrapper2">
                                           
                                            

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
                                                                <h5 style="margin-top: 2px;">Tablero de Control</h5> 
                                                                
                                                                

                                                                <br/>
                                                            </div>











                                                            <!-- ++++++++++++++++++++++++++++++++++++++++++++++     -->




                                                            <div class="row">


                                                                <div class="form-group col-lg-6"  >


                                                                      <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Número de Audiencias atendidas en el periodo</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">
                                                                        <table style="width: 98%; text-align: center;  ">
                                                                            <tr style="background: #edecec;">

                                                                                <td style="width: 50%;" ><div style="width: 90%; height: 140px; background: #a2a3b8; color: white; margin: auto; border-radius: 10px; margin-top: 35px; margin-bottom: 25px; box-shadow: 5px 5px 10px #666; "><h1 style="padding: 40px; font-size: 50px;"><s:property value="datos.TOTAL_AUDIENCIAS"/></h1></div></td>
                                                                                <td style="width: 50%;"><a href="#popup" style="text-decoration: none;" > <div style="width: 90%; height: 65px; background: #9dc325; display: block; margin: auto;  margin-top: 5px; border-radius: 10px; box-shadow: 5px 5px 10px #666;"><div style="width: 100%; color: white ; margin-top: 10px; display: block;">Concluidos</div> <div style="width: 100%; color: white ; margin-top: 0px; display: block;"><h3><s:property value="datos.CONCLUIDO"/></h3><i class="material-icons" style="float: right; margin-top: -45px; margin-right: 15px; font-size: 25px; color: white;"></i> </div></div>  </a>                    <a href="#popup2" style="text-decoration: none;" >  <div style="width: 90%; height: 65px; background: #e1173e; display: block;  margin: auto; margin-top: 10px; border-radius: 10px; box-shadow: 5px 5px 10px #666;"><div style="width: 100%; color: white ; margin-top: 10px; display: block;">En proceso</div> <div style="width: 100%; color: white ; margin-top: 0px; display: block;"><h3><s:property value="datos.EN_PROCESO"/></h3><i class="fa fa-adjust" style="float: right; margin-top: -45px; margin-right: 15px; font-size: 25px; color: white;"></i></div></div> </a></td>
                                                                            </tr>
                                                                            <tr style="">

                                                                                <td style="width: 50%;" colspan="2" ><h4>Audiencias del periodo</h4></td>

                                                                            </tr>

                                                                        </table>
                                                                    </div> 

                                                                </div>  

                                                                <div class="form-group col-lg-6"  >


                                                                    <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Motivos de Audiencias en el periodo</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">


                                                                        <div id="piechart" style="width: 100%; height: 240px; margin: auto; margin-top: 0px; margin: auto;"></div>

                                                                    </div> 

                                                                </div>  


                                                                <div class="form-group col-lg-12"  >


                                                                    <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Audiencias atendidas por día</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">

                                                                        <div id="columnchart_values" style="width: 100%; height: 300px; margin: auto;"></div>

                                                                    </div> 

                                                                </div>  
                                                                
                                                                
                                                                
                                                                 <div class="form-group col-lg-12"  >


                                                                    <div style="width:100%; text-align: center; background: #606060; color: white; height: 35px; margin-top: 20px; border-radius: 8px 8px 0px 0px;  padding: 5px; ">Audiencias atendidas por Servidor Público</div>
                                                                    <div class="col-sm-auto  " style="background:  #edecec; margin-left: 00px;">

                                                                        <div id="chart_div" style="margin-bottom: 50px; height: 450px;"></div>
                                                                        
                                                                        
                                                                        
                                                                        
                                                            
                                                                    </div> 

                                                                </div>  
                                                                
                                                                
                                                                
                                                                
                                                                            <div style="margin: auto; width: 120px; background: green; color: white; text-align: center; margin-bottom: 20px; border-radius: 20px;"><a href="javascript:imprSelec('wrapper2')" style="text-decoration: none; color: white; text-align: center;">Imprimir</a></div>
                                                                
                                                                

                                                            </div> 
                                                                            
                                                                        

                                                        </div>  

                                                                            
                                                         


                                                        <s:textfield name="datos.ID" id="ID" cssStyle="display:none;" />  
                                                          
                                                       

                                                          





                                                    </div>
                                                </div>
                                            </div>






                                            <!-- Campos de nombre-->





                                             </div>



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
                                          


                                        <div class="modal-wrapper" id="popup">
                                                    <div class="popup-contenedor">
                                                        <h2  >Audienicas Concluidas</h2>

                                                        <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >
                                                            <div id="dvData">
                                                                 
                                                        <table id="customers" style="text-align: justify;">
                                                           
                                                            
                                                            <s:if test="ListaConcluidas.size()>0">
                                                            
                                                            
                                                                            <table id="customers" style=" font-size: 12px;">
                                                                                
                                                                                <tr>
                                                                                    <td colspan="7" align="center" style="background: green; color: white;" >Audiencias Concluidas</td>
                                                                                </tr>
                                                           
                                                                                 <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                                    <td style="width: 10%;">Folio</td>
                                                                                    <td style="width: 10%;">Fecha</td>
                                                                                    <td style="width: 15%;">Asignado a</td>
                                                                                    <td style="width: 30%;">Asunto</td>
                                                                                    <td style="width: 10%;">Motivo</td>
                                                                                    <td style="width: 10%;">Estatus</td>
                                                                                     <td style="width: 15%;">Ciudadano</td>
                                                                                    
                                                                                </tr>
                                                                                
                                                                                <s:iterator value="ListaConcluidas" id="ListaConcluidas" status="stat">
                                                                                    <tr style=" background: #efeaf0; font-size: 8px;">
                                                                                    <td style="width: 10%;"><s:property value="FOLIO"/></td>
                                                                                    <td style="width: 10%;"><s:property value="FECHA_AUDI"/></td>
                                                                                    <td style="width: 15%;"><s:property value="NOMBRE_SERPUB"/></td>
                                                                                    <td style="width: 30%;"><s:property value="ASUNTO" /></td>
                                                                                    <td style="width: 10%;"><s:property value="MOTIVO" /></td>
                                                                                    <td style="width: 10%;" align="center"><s:if test="ESTATUS=='CONCLUIDO'"><i class="fa fa-check-circle" style="font-size: 24px; color:green; text-align: center; margin-top: 10px; font-weight: bold; " ></s:if><s:if test="ESTATUS=='EN PROCESO'"></i> <i class="fa fa-ban" style="font-size: 24px; color:red; text-align: center; margin-top: 10px; font-weight: bold; "></i></s:if></td>
                                                                                    <td style="width: 15%;"><s:property value="NOMBRE_COMPLETO" /></td>

                                                                                </tr>
                                                                                </s:iterator>
                                                                            </s:if>
                                                                                
                                                                                <s:else>
                                                                                    
                                                                                    <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>
                                                                                    
                                                                                    
                                                                                </s:else>
                                                        </table>
                                                           
                                                        </table>
                                                                
                                                                
                                                                <s:if test="ListaConcluidas.size()>0">
                                                                
                                                                            <center>
                                                                               
                                                                                <input  align="top" type="image" id="btnExport"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />
                                                                                
                                                                                
                                                                            </center>
                                                                      
                                                                        <script>
                                                                       $("#btnExport").click(function(e) {
                                                                           window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData').html()));
                                                                           e.preventDefault();
                                                                       });
                                                                        </script>
                                                                
                                                              </s:if>
                                                                
                                                                
                                                                
                                                                
                                                            </div>
                                                             </div>
                                                            
                                                        <a class="popup-cerrar" href="#">X</a>
                                                    </div>
                                                </div>
                                                            
                                                            
                                                            
                                                            
                                                            
                                                             <div class="modal-wrapper" id="popup2">
                                                    <div class="popup2-contenedor">
                                                        <h2 style="color: #e1173e;" >Audiencias en Proceso</h2>

                                                        <div style="min-height:350px; max-height: 500px; overflow-y: scroll;" >
                                                            
                                                            
                                                           <div id="dvData2">  
                                                            
                                                            
                                                        <table id="customers" style=" font-size: 12px;">
                                                           
                                                                            
                                                            
                                                            <s:if test="ListaEnProceso.size()>0">
                                                            

                                                                <tr>
                                                                    <td colspan="7" align="center" style="background: red; color: white;" >Audiencias En Proceso</td>
                                                                </tr>


                                                                <tr style="color: #333; border-bottom: 2px solid  #999; pointer-events: none; border-top: 2px solid #999;">
                                                                    <td style="width: 10%;">Folio</td>
                                                                    <td style="width: 10%;">Fecha</td>
                                                                    <td style="width: 15%;">Asignado a</td>
                                                                    <td style="width: 30%;">Asunto</td>
                                                                    <td style="width: 10%;">Motivo</td>
                                                                    <td style="width: 10%;">Estatus</td>
                                                                    <td style="width: 15%;">Ciudadano</td>

                                                                </tr>

                                                                <s:iterator value="ListaEnProceso" id="ListaEnProceso" status="stat">
                                                                    <tr style=" background: #efeaf0; font-size: 8px;">
                                                                        <td style="width: 10%;"><s:property value="FOLIO"/></td>
                                                                        <td style="width: 10%;"><s:property value="FECHA_AUDI"/></td>
                                                                        <td style="width: 15%;"><s:property value="NOMBRE_SERPUB"/></td>
                                                                        <td style="width: 30%;"><s:property value="ASUNTO" /></td>
                                                                        <td style="width: 10%;"><s:property value="MOTIVO" /></td>
                                                                        <td style="width: 10%;" align="center"><s:if test="ESTATUS=='CONCLUIDO'"><i class="fa fa-check-circle" style="font-size: 24px; color:green; text-align: center; margin-top: 10px; font-weight: bold; " ></s:if><s:if test="ESTATUS=='EN PROCESO'"></i> <i class="fa fa-ban" style="font-size: 24px; color:red; text-align: center; margin-top: 10px; font-weight: bold; "></i></s:if></td>
                                                                        <td style="width: 10%;"><s:property value="NOMBRE_COMPLETO" /></td>

                                                                    </tr>
                                                                </s:iterator>
                                                                
                                                                </s:if>
                                                                
                                                                 <s:else>
                                                                                    
                                                                                    <div style="color: #e1173e; font-size: 12px; text-align: center;">No hay información para mostrar </div>
                                                                                    
                                                                                    
                                                                                </s:else>
                                                                
                                                        </table>
                                                               
                                                               <s:if test="ListaEnProceso.size()>0">
                                                               
                                                               <center>

                                                                   <input  align="top" type="image" id="btnExport2"  src="images/excel.png" style="width: 80px; margin-top: 20px;"  />


                                                               </center>

                                                               <script>
                                                              $("#btnExport2").click(function(e) {
                                                                  window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData2').html()));
                                                                  e.preventDefault();
                                                              });
                                                               </script>
                                                               
                                                               </s:if>
                                                               
                                                               
                                                               
                                                               
                                                            </div>
                                                        </div>
                                                            
                                                        <a class="popup2-cerrar" href="#">X</a>
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
