<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:form name="notesForm" modelAttribute="notesForm" id="notesForm" action="create.html" method="POST">
   
    <c:set var="notes" value="${notes}" scope="application"/>
	<display:table  class="list" name="${notes}" id="nodes" pagesize="100" requestURI="list">
		<display:column sortable="true" titleKey="name" property="name" sortName="name" ></display:column>
		<display:column sortable="true" titleKey="abbreviation" property="abbreviation" sortName="abbreviation" ></display:column>
		<display:column sortable="true" titleKey="description" property="description" sortName="description" ></display:column>
		<display:column><a href="javascript:editAction('${nodes.id}','${nodes.name}','${nodes.abbreviation}','${nodes.description}');" id="editButton" ><spring:message code="edit"/></a></display:column>
		<display:column><a href="javascript:deleteAction('${nodes.id}','${nodes.name}','delete');" id="deleteButton" ><spring:message code="vymaz"/></a></display:column>
	</display:table>

 	<p>
 	name : <form:input path="name"/><br>
 	shorcut: <form:input path="abbreviation"/><br>
 	description : <form:input path="description"/><br>
 	
 	
 	<br>
 	<p><input type="submit" value='<spring:message code="create"/>' />
 	<input type="button" value='<spring:message code="edit"/>' onclick="javascript:editSubmit('${id}','${name}','${abbreviation}','${description}', 'edit');" /></p>
 	
 	<form:hidden path="id"/>
 	
 	
</form:form>
<script type="text/javascript"  >
function editAction(id, text, abbreviation, description){
	  document.getElementById('id').value = id;
	  document.getElementById('name').value = text;
	  document.getElementById('abbreviation').value = abbreviation;
	  document.getElementById('description').value = description;
}

function editSubmit(id, text, abbreviation, description, formMethod){
  	  document.getElementById('notesForm').action=formMethod+'.html?'+formMethod+'&amp;id='+id+'&amp;name='+text+'';
	  window.location=formMethod+'.html?'+formMethod+'&amp;id='+id+'&amp;name='+text+'';
	  document.getElementById('notesForm').submit();	
}


function deleteAction(id, text, formMethod){
	  document.getElementById('id').value = id;
	  document.getElementById('name').value = text;
	  document.getElementById('notesForm').action=formMethod+'.html?'+formMethod+'&amp;id='+id+'&amp;name='+text+'';
	  window.location=formMethod+'.html?'+formMethod+'&amp;id='+id+'&amp;name='+text+'';
	  document.getElementById('notesForm').submit();	
}
  
</script>
