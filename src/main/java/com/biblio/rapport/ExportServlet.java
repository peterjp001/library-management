package com.biblio.rapport;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

/**
 * Servlet implementation class ExportServlet
 */
@WebServlet("/export")
public class ExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String rapport = request.getParameter("rapport"); 
		  GeneratePdf gen = new GeneratePdf();
		  switch(rapport) {
			 
			 case "listLivre":
				 gen.rapportLivre(response);
				 break;
			 
			 case "listAdherent":
				 gen.rapportAdherent(response);
				 break;
				 
			 case "listPret":
				 gen.rapportPret(response);
				 break;
			 case "listReservation":
				 gen.rapportReservation(response);
				 break;
			default:
				response.sendRedirect("/biblio/accueil"); 
				 
		  }
	 
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
