package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;
import dao.ProdottoDAO;
import model.Prodotto;

@WebServlet("/ProductDetailsServlet")

public class ServletProdottoDescrizione extends HttpServlet {
	private ProdottoDAO prodottoDAO;
    public void init() {
        // Initialize the UserDAO instance
    	
    	prodottoDAO = new ProdottoDAO(DBConnection.getDataSource()); // Replace 'dataSource' with your actual data source
    	
    }
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Recupera l'ID del prodotto dalla richiesta
    int prodottoID = Integer.parseInt(request.getParameter("id")) ;

    // Ottenere i dati del prodotto dal database o dal sistema
    // Esempio di dati di esempio
    Prodotto prodotto = null;
	try {
		prodotto = prodottoDAO.getProdottoById(prodottoID);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    // Salva il prodotto nella richiesta
    request.setAttribute("prodotto", prodotto);

    // Reindirizza alla pagina di descrizione del prodotto
    RequestDispatcher dispatcher = request.getRequestDispatcher("ProdottoDescrizione.jsp");
    dispatcher.forward(request, response);
  }


}