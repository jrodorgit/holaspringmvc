package net.rodor.springmvc;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooter extends PdfPageEventHelper {
	Phrase[] header = new Phrase[2];
	int pagenumber = 1;
	
	public void onOpenDocument(PdfWriter writer, Document document){
		header[0] = new Phrase("HEADER 0");
	}
	
	public void onChapter(PdfWriter writer, Document document, float paragraphposition, Paragraph title){
		header[1] = new Phrase("TITULO");
		//pagenumber = 2;
		/***
		ColumnText.showTextAligned(writer.getDirectContent(), 
						Element.ALIGN_RIGHT, header[1], 
						(100)/2, 50-18, 0);
						**/
		ColumnText.showTextAligned(writer.getDirectContent(), 
				Element.ALIGN_RIGHT, header[1], 
				(100)/2, 100, 0);
		/***
		// parrafo estatico
					Paragraph right = new Paragraph(
							"This is right, because we create a paragraph with an indentation to the left and as we are adding the paragraph in composite mode, all the properties of the paragraph are preserved.");
					right.setIndentationLeft(50);
					right.setIndentationRight(50);
					document.add(right);
		**/
	}
	public void onStartPage(PdfWriter writer, Document document){
		pagenumber++;
		
	}
	public void onEndPage(PdfWriter writer, Document document){
		//Rectangle rect = writer.getBoxSize("Cabecera");
		//ColumnText.showTextAligned(writer.getDirectContent(), 
		//		Element.ALIGN_RIGHT, new Phrase("esto es un pie?"), 
		//		500, 500, 0);
		/**
		Paragraph  imagenCabecera = new Paragraph ();
		try {
			Image img = Image.getInstance("C:/Users/52535465S/Desktop/temp/logo.gif");
			imagenCabecera.add(img);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ColumnText.showTextAligned(writer.getDirectContent(), 
				Element.ALIGN_LEFT, imagenCabecera, 
				document.leftMargin(),
	            document.top() + 100, 0);
	            **/
		Image img;
		try {
			img = Image.getInstance("C:/Users/52535465S/Desktop/temp/logo.gif");
			 img.scaleToFit(100,100);
			 img.setAbsolutePosition(70, (float) (PageSize.A4.getHeight() - 50.0));
		        img.setAlignment(Element.ALIGN_CENTER);          
		        writer.getDirectContent().addImage(img);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/***
		ColumnText.showTextAligned(writer.getDirectContent(), 
				Element.ALIGN_LEFT, new Phrase("TITULO DE LA PAGINA"), 
				document.leftMargin(),
	            document.top() + 10, 0);
		***/
		ColumnText.showTextAligned(writer.getDirectContent(), 
				Element.ALIGN_LEFT, new Phrase(String.format("Pagina %d", pagenumber)), 
				(document.right() - document.left()) / 2 + document.leftMargin(),
	            document.bottom() + 5, 0);
		
	}

}
