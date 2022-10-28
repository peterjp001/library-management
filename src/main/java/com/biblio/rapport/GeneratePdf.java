package com.biblio.rapport;
 
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.AdherentDao;
import com.biblio.dao.LivreDao;
import com.biblio.dao.PretDao;
import com.biblio.dao.ReservationDao;
import com.biblio.model.Adherent;
import com.biblio.model.Livre;
import com.biblio.model.PretAdherent;
import com.itextpdf.kernel.colors.WebColors;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;   


public class GeneratePdf extends HttpServlet{
	 
	private static final long serialVersionUID = 1L;
	private LivreDao livreDao = new LivreDao();
	private AdherentDao adherentDao = new AdherentDao();
	private PretDao pretDao = new PretDao();
	private ReservationDao resDao = new ReservationDao();
	
	
//	SETTING HEADEAR CONFIGURATION
	protected Document settingHeaders(HttpServletResponse response, String OutputfileName) throws IOException {
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDate = dFormat.format(new Date());		  
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachement; filename="+OutputfileName+"_"+currentDate+".pdf";
		response.setHeader(headerKey, headerValue);
		PdfDocument pdf = new PdfDocument (new PdfWriter (response.getOutputStream()));
		Document document = new Document (pdf, PageSize.A4); 
		return document;
	}
	
	
//	SETTING PDF HEADER
	protected Table pdfHeader() {
		Table table = new Table(new float[]{ 550f});
	    table.addCell(
	    			new Cell()
	    			.setPadding(0).setBorder(Border.NO_BORDER)
	    			.setTextAlignment(TextAlignment.CENTER)
	            	.add(new Paragraph("UNIVERSITE EPISCOPALE D'HAITI(UNEPH) "
	            			+ "\n 14 Rue Légitime. Champ-de-Mars "
	            			+ "\n HT-6120, Port-au-prince, Haiti "
	            			+ "\n Tels:(+509) 2227-7962 / 3129-8661 / 3312-7558 / 2226-8752 "
	            			+ "\n Emails: contact@uneph.org / unephhaiti@hotmail.com "
	            			+ "\n Website: www.uneph.edu.ht")
	            	.setMultipliedLeading(1.2f).setFontSize(9)
	            	));
	    return table;
	}
	
	protected Table pdfHeading(String title) {
		Table table = new Table(new float[]{ 550f});
		table.addCell(new Cell()
    			.setPadding(0).setBorder(Border.NO_BORDER)
    			.setTextAlignment(TextAlignment.CENTER)
            	.add(new Paragraph("Bibliotheque De l'UNEPH \n"+title).setBold()
            	.setMultipliedLeading(1.2f).setFontSize(12)
            	)); 
		return table;
	}
 
	
	private Table th(float[] header,List<String> title)
	{
		Table table = new Table(header);
		for(int i = 0; i<title.size(); i++) {
			table.addCell(new Cell().add(new Paragraph(title.get(i)).setFontSize(9).setFontColor(WebColors.getRGBColor("white"))));
		}
		return table.setBackgroundColor(WebColors.getRGBColor("black"));
	}
	
	
	
	
//	**************************************************************** RAPPORT LIVRE PDF ********************************************************************
	
	
//	TABLE LIVRE DATA
	protected Table tbLivre() {
		List<Livre> listLivre =  livreDao.selectAllLivres();
		Table table = new Table(new float[]{ 90f,90f,90f,90f,90f,90f}); 
		for(Livre livre:listLivre) {
			
			table.addCell(new Cell().add(new Paragraph(livre.getTitre()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(livre.getAuteur()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(livre.getDate_parution()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(livre.getCategorie()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(livre.getQuantite()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(livre.getEtat()).setFontSize(9)));
		}
		return table;
	}

	
	
// GENERATING  LIVRE PDF 
	protected void rapportLivre( HttpServletResponse response) throws ServletException, IOException {	
		Document document =this.settingHeaders(response, "rapport_list_livre");
		document.add(this.pdfHeader());
		document.add(new Paragraph("\n\n"));
		document.add(this.pdfHeading("Rapport de la liste des livres"));
		document.add(new Paragraph("\n"));
		
		
		float header[] = new float[]{ 90f,90f,90f,90f,90f,90f};
		List<String> title =new ArrayList<>(List.of("TITRE","AUTEUR","DATE PARUTION","CATEGORIE","QUANTITE","ETAT"));
		document.add(this.th(header,title));
		
		
		document.add(this.tbLivre());
		document.close();
	}
	
//	**************************************************************** RAPPORT ADHERENT PDF ********************************************************************
	
	
//	TABLE ADHERENT DATA
	protected Table tbAdherent() {
		List<Adherent> listAdherent =  adherentDao.selectAllAdherents();
		Table table = new Table(new float[]{ 90f,90f,90f,90f,90f,90f}); 
		for(Adherent adherent:listAdherent) {
			
			table.addCell(new Cell().add(new Paragraph(adherent.getNom()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(adherent.getPrenom()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(adherent.getSexe()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(adherent.getAdresse()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(adherent.getEmail()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(adherent.getProfession()).setFontSize(9)));
		}
		return table;
	}

	
	
//	GENERATION ADHERENT PDF
	protected void rapportAdherent( HttpServletResponse response) throws ServletException, IOException {	
		Document document =this.settingHeaders(response, "rapport_list_adherent");
		document.add(this.pdfHeader());
		document.add(new Paragraph("\n\n"));
		document.add(this.pdfHeading("Rapport de la liste des Adherents"));
		document.add(new Paragraph("\n"));
		
		float header[] = new float[]{ 90f,90f,90f,90f,90f,90f};
		List<String> title =new ArrayList<>(List.of("NOM","PRENOM","SEXE","ADRESSE","EMAIL","PROFESSION"));
		document.add(this.th(header,title));
		document.add(this.tbAdherent());
		document.close();
	}
	
//	**************************************************************** RAPPORT PRET PDF ********************************************************************
	
	
//	TABLE PRET DATA
	protected Table tbPret() {
		List<PretAdherent> listPret =  pretDao.selectAllPret();
		Table table = new Table(new float[]{ 90f,90f,90f,90f,90f,90f}); 
		for(PretAdherent pret:listPret) {
			
			table.addCell(new Cell().add(new Paragraph(pret.getNom()+' '+pret.getPrenom()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(pret.gettelephone()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(pret.getTitre()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(pret.getAuteur()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(pret.getDate_pret().toString()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(pret.getDate_retour().toString()).setFontSize(9)));
		}
		return table;
	}

	
	
//	GENERATION PRET PDF
	protected void rapportPret( HttpServletResponse response) throws ServletException, IOException {	
		Document document =this.settingHeaders(response, "rapport_liste_pret");
		document.add(this.pdfHeader());
		document.add(new Paragraph("\n\n"));
		document.add(this.pdfHeading("Rapport de la liste des prets"));
		document.add(new Paragraph("\n"));
		
		float header[] = new float[]{ 90f,90f,90f,90f,90f,90f};
		List<String> title =new ArrayList<>(List.of("ADHERENT","TELEPHONE","LIVRE","AUTEUR","DATE PRET","DATE RETOUR"));
		document.add(this.th(header,title));
		document.add(this.tbPret());
		document.close();
	}
	
//	**************************************************************** RAPPORT RESERVATION PDF ********************************************************************
	
	
//	TABLE LIVRE DATA
	protected Table tbReservation() {
		List<PretAdherent> listRes =  resDao.selectAllRes();
		Table table = new Table(new float[]{ 110f,110f,110f,110f,110f}); 
		for(PretAdherent pret:listRes) {
			
			table.addCell(new Cell().add(new Paragraph(pret.getNom()+' '+pret.getPrenom()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(pret.gettelephone()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(pret.getAdresse()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(pret.getTitre()).setFontSize(9)));
			table.addCell(new Cell().add(new Paragraph(pret.getAuteur()).setFontSize(9))); 
		}
		return table;
	}

	
	
//	GENERATION ADHERENT PDF
	protected void rapportReservation( HttpServletResponse response) throws ServletException, IOException {	
		Document document =this.settingHeaders(response, "rapport_liste_reservation");
		document.add(this.pdfHeader());
		document.add(new Paragraph("\n\n"));
		document.add(this.pdfHeading("Rapport de la liste des reservations"));
		document.add(new Paragraph("\n"));
		
		float header[] = new float[]{ 110f,110f,110f,110f,110f};
		List<String> title =new ArrayList<>(List.of("ADHERENT","TELEPHONE","ADRESSE","LIVRE","AUTEUR"));
		document.add(this.th(header,title));
		document.add(this.tbReservation());
		document.close();
	}
	
	
}
