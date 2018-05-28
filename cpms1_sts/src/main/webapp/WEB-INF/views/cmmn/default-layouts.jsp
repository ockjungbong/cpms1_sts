<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
	<head>
  		<tiles:insertAttribute name="header"/>
  	</head>
  	<body>
  		<div class="wrapper">
	  		<tiles:insertAttribute name="left"/>
	  		<div class="main-panel">	
			  	
				<tiles:insertAttribute name="content"/>
				
			</div>
		</div>
  	</body>
  	
  
</html>