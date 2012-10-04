<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MELISA</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/stylesheet.css" type="text/css" />
    </head>
    
    <body class="verticalscroll" topmargin="0" leftmargin="0" marginwidth="0" marginheight="0" onload="load()">
        <f:view locale="#{FuelBean.locale}">	
            <f:loadBundle var="bundle" basename ="de.linogistix.mobile.processes.fuel.FuelBundle" /> 
            
            <h:form id="Form" styleClass="form" >

                <p id="pHeader" class="pageheader">
                	<h:outputText id="pagetitle" value="#{bundle.TitleEnterPump}" styleClass="pagetitle"/>
	                <h:graphicImage id="logo" url="/pics/logo.gif" styleClass="logo"/>
               	</p>
                
                <div class="space">
                    <h:messages id="messages"  styleClass="error"/> 
                    
                    <table  width="100%" border="0" cellspacing="0">
                    	<colgroup>
							<col width="20%"/>
							<col width="80%"/>
						</colgroup>
                    	
                        <tr>
                            <td nowrap="nowrap" style="padding-right:20px">
                            	<h:outputLabel id="paramItemData" value="#{bundle.LabelItemData}:" styleClass="param" />
                            </td> 
                            <td nowrap="nowrap">
                               	<h:outputLabel id="dataItemData" value="#{FuelBean.itemDataNumber}" styleClass="label" /> 
                            </td>
                        </tr>
                        <tr>
                            <td nowrap="nowrap" colspan="2" style="padding-right:20px; padding-left:20px; font-size:smaller;">
                               	<h:outputLabel id="itemDataName" value="#{FuelBean.itemDataName}" />
                            </td>
                        </tr>


                    	<tr>
                            <td nowrap="nowrap" style="padding-right:20px">
                            	<h:outputLabel id="paramAmount" value="#{bundle.LabelAmountStock}:" styleClass="param"/> 
                            </td>
                            <td nowrap="nowrap">
                              	<h:outputLabel id="dataAmount" value="#{FuelBean.amount}" styleClass="label" />
                            </td>
                        </tr>

                        
                  	</table>
                  	
                    <table  width="100%" border="0" cellspacing="0">

                        <tr><td>&#160;</td></tr>
                        <tr>
                            <td>
                                <h:outputLabel value="#{bundle.LabelChoosePump}" styleClass="label"/>
                            </td>
                        </tr><tr>
                            <td>
                                <h:selectOneMenu id="orderComboBox"
                                                 value="#{FuelBean.selectedPump}" style="width:100%;" >
                                    <f:selectItems value="#{FuelBean.pumpList}" />
                                </h:selectOneMenu>
                            </td>
                        </tr>
                        

                    </table>
                    
					<h:inputText value="IE-Dummy" style="display:none" />
                  	
                </div>
                
                <div class="buttonbar">  
	                 <h:commandButton id="forwardButton" 
	                 				 value="#{bundle.ButtonForward}" 
	                 				 action="#{FuelBean.processEnterPump}" 
	                 				 styleClass="commandButton"  />
	                 				 
	                 <h:commandButton id="backButton" 
	                 				 value="#{bundle.ButtonCancel}" 
	                 				 action="#{FuelBean.processEnterPumpCancel}" 
	                 				 styleClass="commandButton"  />
	                 				 

                </div>
                
            </h:form>
        </f:view> 
        <script type="text/javascript">
            
            function load() {            
                setFocus();    
            }    
            
            function setFocus() {
                document.getElementById('Form:input1').focus();
            }    
            
        </script>
        
    </body>
</html>