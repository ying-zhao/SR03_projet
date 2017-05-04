<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert une commande</title>
</head>
<body>
<h1>Inserte un commande</h1>


<form method="post" action="rest/commands/addCommand">
		<label for="id_client">ID client :</label>
		<input type="text" name="client_id" id="client_id" value="${uModif.nom}"/>
		<br />
		<label for="jeux_id1">ID Jeux 1 :</label>
		<input type="text" name="jeux_id1" id="jeux_id1" value="${uModif.nom}"/>
		<br />
		<label for="jeux_id2">ID Jeux 2 :</label>
		<input type="text" name="jeux_id2" id="jeux_id2" value="${uModif.tel}"/>
		<br />
		<label for="jeux_id3">ID Jeux 3 :</label>
		<input type="text" name="jeux_id3" id="jeux_id3" value="${uModif.username}"/>
		<input type="hidden" name=id value="${uModif.id}"/>
		<input type="submit" value="Valider" />
	</form>

</body>
</html>