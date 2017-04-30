package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Client;

//import beans.NameComp;
//import beans.UsernameComp;
import dao.ClientDao;


/**
 * Servlet implementation class GestionUsers
 */
@WebServlet("/GestionUsers")
public class GestionUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUsers() {
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("wwwwwwwwwwwwwwwwwwwwwww\n\n\n\n\n\n");
		List<Client> c = ClientDao.findAll();
		
		int id = 0;
		String action = request.getParameter("action");
		if (action != null) {
			String idCh = request.getParameter("id");
			if (idCh != null) {
				try {
					id = Integer.parseInt(idCh);
				} catch (Exception e) {

				}
			}

			if (action.equals("supprimer")) {
				ClientDao.delete(id);
			} else if (action.equals("modifier")) {
				request.setAttribute("uModif", ClientDao.find(id));
			} else if (action.equals("sort")) {
				// ordina la lista implicitamente utilizzando il metodo
				// compareTo dell'interfaccia Comparable (vedere la classe
				// Users)
				Collections.sort(c);
			}
		}

		// recuperer une liste d'utilisateurs

		request.setAttribute("listeC", c);

		// rediriger vers une page
		request.getRequestDispatcher("UsersList.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("wwwwwwwwwwwwwwwwwwwwwww\n\n\n\n\n\n");
		List<Client> listeC = ClientDao.findAll();
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("sort")) {
				String sortType = request.getParameter("sortType");
				/*if (sortType.equals("1"))
					Collections.sort(listeU, new NameComp());
				else if (sortType.equals("2"))
					Collections.sort(listeU, new UsernameComp());*/ // 
			}
		} else {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String startDateStr = request.getParameter("date_naissance");
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			Date date_naissance;
			String adresse = request.getParameter("adresse");
			String pays = request.getParameter("pays");
			String ville = request.getParameter("ville");
			String code_postal = request.getParameter("code_postal");
			String tel = request.getParameter("tel");
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			try {
				date_naissance = date.parse(startDateStr);
				Client c = new Client(0, nom, prenom, email, tel, username, pwd, date_naissance, adresse, pays, ville, code_postal);
				String idStr = request.getParameter("id");
				if (idStr != null && !idStr.trim().equals("")) {
					c.setId(Integer.parseInt(idStr));
					ClientDao.update(c);
				} else {
					
					ClientDao.insert(c);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			request.setAttribute("listeC", listeC);
			request.getRequestDispatcher("UsersList.jsp").forward(request, response);
			

			
			
		}
	}
}


