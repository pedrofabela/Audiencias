    <%--
    Author     : Esteban y yo
--%>
<%@page import="beans.moduloBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>

        

        <script type="text/javascript">

            function SeleccionMenu(accion) {
                if (accion == "accesoManual") {
                    document.formularioPrincipal.target = "_blank";
                    document.formularioPrincipal.action = accion;
                    document.formularioPrincipal.submit();
                } else {
                    document.formularioPrincipal.target = "_self";
                    document.formularioPrincipal.action = accion;
                    document.formularioPrincipal.submit();
                }
            }

        </script>
    </head>
    <body>

        <ul class="sidebar navbar-nav" style=" background:#e9ecef;">

            
            <s:form name="formularioPrincipal" method="post" id="formularioPrincipal">
                <li class="nav-item active" >
                    <a class="nav-link" style="color: black;" href="Javascript:SeleccionMenu('ReturnStar')">
                        
                    </a>
                </li>
                <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                    <s:if test='CVE_MODPADRE=="S"'>
                        <li class="nav-item dropdown">
                            
                            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                                <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">
                                    <s:if test='CVE_MODULO==MODPADRE'>
                                        <a class="dropdown-item" href="Javascript:SeleccionMenu('<s:property value="ACCION"/>')">
                                           
                                            <s:property value="MOD"/> <i class="fas fa-angle-right" style="color: #611a1e; font-size: 20px;"></i>
                                            <s:set var="myVar">
                                                <s:property value="MOD.length()" />
                                            </s:set>
                                            <s:if test='MOD.length()<40'>
                                                <c:forEach begin="${myVar}" end="40" varStatus="lp">
                                                    &nbsp;
                                                </c:forEach>
                                            </s:if>         
                                        </a>     
                                    </s:if>
                                </s:iterator>
                            </div>
                        </li> 
                            
                    </s:if>
                    <s:hidden name = "modulosAUX[%{#stat.index}].CVE_MODULO" id="CVE_MODULO"></s:hidden>
                    <s:hidden name = "modulosAUX[%{#stat.index}].CVE_MODPADRE" id="CVE_MODPADRE"></s:hidden>
                    <s:hidden name = "modulosAUX[%{#stat.index}].DESC_MOD" id="DESC_MOD"></s:hidden>
                    <%-- <s:hidden  name = "modulosAUX[%{#stat.index}].ACTION" id="ACTION"></s:hidden> --%>
                    <s:hidden name = "modulosAUX[%{#stat.index}].IMAGEN" id="IMAGEN"></s:hidden>
                    <s:hidden name = "modulosAUX[%{#stat.index}].NAMEUNIDAD" id="NAMEUNIDAD"></s:hidden>
                    <s:hidden name = "modulosAUX[%{#stat.index}].VALORU" id="VALORU"></s:hidden>
                </s:iterator>
                
                <s:if test="banderafechas">
               
                <li style=" margin-top: 50px;">
                    <div style="width: 100%; text-align: center; font-size: 14px;">Fecha Inicial </div>
                    <s:textfield name="datos.FECHA_INICIO" id="Fecha"  placeholder="Fecha de Inicial" required="true" readonly="true" cssClass="campoFormBusqueda"  cssStyle="margin-left:5px;  width:95%; text-align:center;" />

                                
                 </li>
                     <li style=" margin-top: 50px;">
                    <div style="width: 100%; text-align: center; font-size: 14px;">Fecha Final </div>
                    <s:textfield name="datos.FECHA_TERMINO" id="Fecha1"  placeholder="Fecha de Inicial" required="true" readonly="true" cssClass="campoFormBusqueda" cssStyle="margin-left:5px;  width:95%;  text-align:center;" />

                                
                 </li>
                    
                    <a href="Javascript:buscar('inicioDashboardFechas2')" ><div style="width: 80%; height: 35px; background: purple; margin: auto; margin-top: 40px; color: white; border-radius: 10px; text-align: center; padding: 5px;">Generar</div></a>
                </s:if>
                
                <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">                        
                    <s:hidden  name = "modulosAUXP[%{#stat.index}].MODULO" id="MODULO"></s:hidden>
                    <s:hidden  name = "modulosAUXP[%{#stat.index}].MODPADRE" id="MODPADRE"></s:hidden>
                    <s:hidden  name = "modulosAUXP[%{#stat.index}].MOD" id="MOD"></s:hidden>
                    <s:hidden  name = "modulosAUXP[%{#stat.index}].ACCION" id="ACCION"></s:hidden>
                    <s:hidden name =  "modulosAUXP[%{#stat.index}].CVE_ACCESO_AUX" id="CVE_ACCESO_AUX"></s:hidden>
                </s:iterator>
            </s:form>  
        </ul>
        
       


    </body>
</html>