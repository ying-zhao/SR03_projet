<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Client"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert un client</title>
</head>
<body>
<h1>Insert un client</h1>


<form method="post" action="rest/users/addUser">
		<label for="Nom">Nom :</label>
		<input type="text" name="nom" id="nom" value="${uModif.nom}"/>
		<br />
		<label for="Prenom">Prenom :</label>
		<input type="text" name="prenom" id="prenom" value="${uModif.nom}"/>
		<br />
		<label for="Email">Email :</label>
		<input type="text" name="email" id="email" value="${uModif.nom}"/>
		<br />
		<label for="Tel">Tel :</label>
		<input type="text" name="tel" id="tel" value="${uModif.tel}"/>
		<br />
		<label for="Username">Username :</label>
		<input type="text" name="username" id="username" value="${uModif.username}"/>
		<br />
		<label for="Pwd">Password :</label>
		<input type="text" name="pwd" id="pwd" value="${uModif.pwd}"/>
		<br />
		<label for="date_naissance">Date de naissance :</label>
		<input type="date" name="date_naissance" id="date_naissance" value="${uModif.nom}"/>
		<br />
		<label for="adresse">Adresse :</label>
		<input type="text" name="adresse" id="adresse" value="${uModif.nom}"/>
		<br />
		<label for="pays">Pays :</label>
		<input type="text" name="pays" id="pays value="${uModif.nom}"/>
		<br />
		<label for="codePostal">Code Postal :</label>
		<input type="text" name="code_posatal" id="code_postal" value="${uModif.nom}"/>
		<br />
		<label for="ville">Ville :</label>
		<input type="text" name="ville" id="ville" value="${uModif.nom}"/>
		<br />
		<input type="hidden" name=id value="${uModif.id}"/>
		<input type="submit" value="Valider" />
	</form>

</body>
</html>