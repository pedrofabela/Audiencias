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

          

        </script>
    </head>
    <body>

        <ul class="sidebar navbar-nav" style=" background:#e9ecef;">

            
            <s:form name="formularioPrincipal" method="post" id="formularioPrincipal">
                <li class="nav-item active" >
                    <a class="nav-link" style="color: black;" href="Javascript:SeleccionMenu('ReturnStar')">
                        <i class="fas fa-fw fa-home" style="color: #8181a4; font-size: 30px;"></i>
                        <span>Inicio</span>
                    </a>
                </li>
                <s:iterator value="modulosAUX" id="modulosAUX" status="stat">
                    <s:if test='CVE_MODPADRE=="S"'>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" style="color: black;" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-fw fa-plus-circle" style="color: #8181a4; font-size: 20px;"></i>
                                <span><s:property value="DESC_MOD"/></span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                                <s:iterator value="modulosAUXP" id="modulosAUXP" status="stat">
                                    <s:if test='CVE_MODULO==MODPADRE'>
                                        <a class="dropdown-item " href="Javascript:SeleccionMenu('<s:property value="ACCION"/>')">
                                           
                                            <s:property value="MOD"/> <i class="fas fa-angle-right" style="color: #8181a4; font-size: 20px;"></i>
                                            <s:set var="myVar">
                                                <s:property value="MOD.length()" />
                                            </s:set>
                                            <s:if test='MOD.length()<40'>
                                                <c:forEach begin="${myVar}" end="40" varStatus="lp" >
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